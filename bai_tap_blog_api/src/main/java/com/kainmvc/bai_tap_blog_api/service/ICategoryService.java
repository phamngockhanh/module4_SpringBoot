package com.kainmvc.bai_tap_blog_api.service;

import com.kainmvc.bai_tap_blog_api.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void add(Category category);
    Category findById(Integer id);
}
