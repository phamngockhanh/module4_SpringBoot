package com.kainmvc.blog_spring_boots.repository;

import com.kainmvc.blog_spring_boots.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
