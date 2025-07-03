package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Blog;
import com.kainmvc.blog_ajax.entity.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);
}
