package com.kainmvc.demo_spring_security_db.repository;

import com.kainmvc.demo_spring_security_db.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
