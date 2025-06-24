package com.kainmvc.blog_spring_boots.service;

import com.kainmvc.blog_spring_boots.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
