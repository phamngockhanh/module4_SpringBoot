package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Blog;
import com.kainmvc.blog_ajax.entity.Writer;

import java.util.Optional;

public interface IWriterService {

    Iterable<Writer> findAll();
    Optional<Writer> findById(Long id);

}
