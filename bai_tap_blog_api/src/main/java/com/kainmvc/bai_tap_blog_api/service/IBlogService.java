package com.kainmvc.bai_tap_blog_api.service;

import com.kainmvc.bai_tap_blog_api.entity.Blog;
import com.kainmvc.bai_tap_blog_api.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Optional<Blog> findById(Integer id);
    void delete(Integer id);
    Blog update(Blog blog);
    Blog detail(Integer id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> search(String title, Pageable pageable);
    Page<Blog> search(String title,int categoryId, Pageable pageable);
    Page<Blog> search(Integer categoryId, Pageable pageable);
    List<Blog> findByCategoryId(Category category);


}
