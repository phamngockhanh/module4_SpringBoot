package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Blog;
import com.kainmvc.blog_ajax.repository.IBlogRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
@Service
public class BlogService implements IBlogService{

    private final IBlogRepository iBlogRepository;

    public BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }
    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        iBlogRepository.deleteById(id);
    }
}
