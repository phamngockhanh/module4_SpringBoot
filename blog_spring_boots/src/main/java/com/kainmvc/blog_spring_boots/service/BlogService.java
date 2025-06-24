package com.kainmvc.blog_spring_boots.service;

import com.kainmvc.blog_spring_boots.entity.Blog;
import com.kainmvc.blog_spring_boots.repository.IBlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    private final IBlogRepo blogRepo;

    public BlogService(IBlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepo.findById(id);
    }

    @Override
    public void delete(Integer id) {
        blogRepo.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog detail(Integer id) {
        return blogRepo.findById(id).orElse(null);
    }
}
