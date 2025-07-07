package com.kainmvc.demo_spring_security_db.service;

import com.kainmvc.demo_spring_security_db.entity.Writer;

import java.util.List;

public interface IWriterService {
    List<Writer> findAll();
}
