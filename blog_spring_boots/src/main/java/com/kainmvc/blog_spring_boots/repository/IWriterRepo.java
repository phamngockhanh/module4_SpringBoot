package com.kainmvc.blog_spring_boots.repository;

import com.kainmvc.blog_spring_boots.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWriterRepo extends JpaRepository<Writer,Integer> {
}
