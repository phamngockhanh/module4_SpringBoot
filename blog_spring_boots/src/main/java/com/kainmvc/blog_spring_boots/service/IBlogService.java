package com.kainmvc.blog_spring_boots.service;

import com.kainmvc.blog_spring_boots.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Optional<Blog> findById(Integer id);
    void delete(Integer id);
    void update(Blog blog);
    Blog detail(Integer id);

}
