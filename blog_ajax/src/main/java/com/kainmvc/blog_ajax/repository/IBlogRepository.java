package com.kainmvc.blog_ajax.repository;

import com.kainmvc.blog_ajax.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
}
