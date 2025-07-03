package com.kainmvc.blog_ajax.repository;

import com.kainmvc.blog_ajax.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
