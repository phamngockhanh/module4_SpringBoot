package com.kainmvc.demo_spring_security_db.repository;

import com.kainmvc.demo_spring_security_db.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWriterRepo extends JpaRepository<Writer,Integer> {
}
