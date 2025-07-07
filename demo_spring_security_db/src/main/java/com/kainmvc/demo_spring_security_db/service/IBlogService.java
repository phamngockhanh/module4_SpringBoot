package com.kainmvc.demo_spring_security_db.service;

import com.kainmvc.demo_spring_security_db.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Optional<Blog> findById(Integer id);
    void delete(Integer id);
    void update(Blog blog);
    Blog detail(Integer id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> search(String title, Pageable pageable);
    Page<Blog> search(String title,int categoryId, Pageable pageable);


}
