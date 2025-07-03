package com.kainmvc.blog_ajax.repository;

import com.kainmvc.blog_ajax.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWriterRepository extends JpaRepository<Writer,Long> {
}
