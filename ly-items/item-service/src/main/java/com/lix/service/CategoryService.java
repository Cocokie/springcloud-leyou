package com.lix.service;

import com.lix.item.domain.Category;
import com.lix.mapper.CategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> queryByParentId(Long id) {
        Category category = new Category();
        category.setParentId(id);
        return categoryMapper.select(category);
    }

    public List<String> queryCategoryByCid(List<Long> longs) {
        List<String> names  = new ArrayList<>();
        List<Category> categories = categoryMapper.selectByIdList(longs);
        for (Category category : categories) {
            names.add(category.getName());
        }
        return names;
    }
}
