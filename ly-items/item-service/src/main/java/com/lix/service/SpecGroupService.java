package com.lix.service;

import com.lix.common.advice.LyException;
import com.lix.common.lyenum.ExceptionEnum;
import com.lix.item.domain.SpecGroup;
import com.lix.mapper.SpecGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SpecGroupService {
    @Autowired
    SpecGroupMapper specGroupMapper;
    public List<SpecGroup> findByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> select = specGroupMapper.select(specGroup);
        if(CollectionUtils.isEmpty(select)){
            throw new LyException(ExceptionEnum.NOT_FOUND);
        }
        return select;
    }
}
