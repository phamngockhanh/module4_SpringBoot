package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();
    Blog save(Blog blog);
    Optional<Blog> findById(Long id);
    void delete(Long id);
}
