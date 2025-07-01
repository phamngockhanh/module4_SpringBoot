package com.kainmvc.bai_tap_blog_api.repository;

import com.kainmvc.bai_tap_blog_api.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWriterRepo extends JpaRepository<Writer,Integer> {
}
