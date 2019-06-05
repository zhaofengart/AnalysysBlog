package com.analysys.blog.service.impl;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.entity.Category;
import com.analysys.blog.repository.CategoryMapper;
import com.analysys.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhaofeng
 * @date 2019/6/5
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public JsonResult getAllCategory() {
        List<Category> categoryList = categoryMapper.selectAllCategory();
        return new JsonResult(categoryList);
    }
}
