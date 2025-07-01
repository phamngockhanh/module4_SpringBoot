package com.kainmvc.bai_tap_blog_api.common;

import com.kainmvc.bai_tap_blog_api.entity.Blog;

import java.util.HashMap;
import java.util.Map;

public class BlogValidator {
    public static Map<String, String> validate(Blog blog){
        Map<String,String> errors = new HashMap<>();
        if(blog.getTitle()==null){
            errors.put("title","title không được để trống");
        }
        return errors;
    }
}
