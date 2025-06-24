package com.kainmvc.blog_spring_boots.repository;

import com.kainmvc.blog_spring_boots.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {

}
