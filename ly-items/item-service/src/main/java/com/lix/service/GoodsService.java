package com.lix.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lix.common.vo.PagingResult;
import com.lix.item.domain.Brand;
import com.lix.item.domain.Spu;
import com.lix.mapper.GoodsMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;


@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    public PagingResult<Spu> querySpuByPageAndSort(Integer page, Integer rows, Boolean saleable, String key) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNoneBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }
        if (saleable != null) {
            criteria.andEqualTo(saleable);
        }
        List<Spu> spus = goodsMapper.selectByExample(example);
        for (Spu spu : spus) {
            List<Long> longs = Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3());
            List<String> names = categoryService.queryCategoryByCid(longs);
            spu.setCname(StringUtils.join(names, "/"));
            spu.setBname(brandService.queryById(spu.getBrandId()).getName());
        }
        PageInfo<Spu> pageInfo = new PageInfo<>(spus);
        return new PagingResult<Spu>(spus,pageInfo.getTotal());


    }
}
