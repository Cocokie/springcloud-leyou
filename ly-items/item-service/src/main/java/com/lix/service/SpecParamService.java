package com.lix.service;


import com.lix.common.advice.LyException;
import com.lix.common.lyenum.ExceptionEnum;
import com.lix.item.domain.SpecParam;
import com.lix.mapper.SpecParamMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SpecParamService {
    @Autowired
    SpecParamMapper specParamMapper;
    public List<SpecParam> findByGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        List<SpecParam> select = specParamMapper.select(specParam);
        if(CollectionUtils.isEmpty(select)){
            throw new LyException(ExceptionEnum.NOT_FOUND);
        }
        return select;
    }
}
