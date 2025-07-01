package com.kainmvc.bai_tap_blog_api.repository;

import com.kainmvc.bai_tap_blog_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
