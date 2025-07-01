package com.kainmvc.bai_tap_blog_api.service;

import com.kainmvc.bai_tap_blog_api.entity.Writer;

import java.util.List;

public interface IWriterService {
    List<Writer> findAll();
}
