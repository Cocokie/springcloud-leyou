package com.lix.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lix.common.advice.LyException;
import com.lix.common.lyenum.ExceptionEnum;
import com.lix.common.vo.PagingResult;
import com.lix.item.domain.Brand;
import com.lix.item.domain.Paging;
import com.lix.mapper.BrandMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandMapper brandMapper;

    public PagingResult<Brand> findBrandList(Paging paging) {
        PageHelper.startPage(paging.getPage(), paging.getRows());
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(paging.getKey())) {
            example.createCriteria().orLike("name", "%" + paging.getKey() + "%").orEqualTo("letter", paging.getKey().toUpperCase());
        }
        if (StringUtils.isNoneBlank(paging.getSortBy())) {
            String orderByClauser = paging.getSortBy() + (paging.getDesc() ? " desc" : " asc");
            example.setOrderByClause(orderByClauser);
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brands)) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        PageInfo<Brand> info = new PageInfo<>(brands);
        return new PagingResult<Brand>(info.getList(), info.getTotal());
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        int insert = brandMapper.insert(brand);
        if (insert <= 0) {
            throw new LyException(ExceptionEnum.SAVE_BRAND_FAILED);
        }
        for (Long cid : cids) {
            int i = brandMapper.saveCids(cid, brand.getId());
            if (i <= 0) {
                throw new LyException(ExceptionEnum.SAVE_BRAND_FAILED);
            }
        }
    }

    public Brand queryById(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    public List<Brand> queryByCid(Long cid) {
        return brandMapper.queryBrandByCid(cid);
    }
}
