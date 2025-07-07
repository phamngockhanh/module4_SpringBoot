package com.kainmvc.demo_spring_security_db.service;

import com.kainmvc.demo_spring_security_db.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void add(Category category);
    Category findById(Integer id);
}
