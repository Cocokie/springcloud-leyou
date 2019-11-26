package com.lix.controller;

import com.lix.common.advice.LyException;
import com.lix.common.lyenum.ExceptionEnum;
import com.lix.item.domain.Category;
import com.lix.service.CategoryService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam(name = "pid",defaultValue = "0") Long id) {
        List<Category> category = categoryService.queryByParentId(id);

        if(CollectionUtils.isEmpty(category)){
            log.debug(category.toString());
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }
}
