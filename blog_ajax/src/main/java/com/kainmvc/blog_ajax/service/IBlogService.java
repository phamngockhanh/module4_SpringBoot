package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();
    Blog save(Blog blog);
    Optional<Blog> findById(Long id);
    void delete(Long id);
    Page<Blog> search(String title, int categoryId, Pageable pageable);
}
