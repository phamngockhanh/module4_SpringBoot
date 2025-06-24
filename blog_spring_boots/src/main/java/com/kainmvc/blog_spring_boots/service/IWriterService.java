package com.kainmvc.blog_spring_boots.service;

import com.kainmvc.blog_spring_boots.entity.Writer;

import java.util.List;

public interface IWriterService {
    List<Writer> findAll();
}
