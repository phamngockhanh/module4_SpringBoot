package com.kainmvc.demo_spring_security_db.service;

import com.kainmvc.demo_spring_security_db.entity.Blog;
import com.kainmvc.demo_spring_security_db.repository.IBlogRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public Page<Blog> search(String title, Pageable pageable) {
        return blogRepo.findByTitleContaining(title,pageable);
    }

    @Override
    public Page<Blog> search(String title, int categoryId, Pageable pageable) {
        return blogRepo.searchByTitleAndCategory(title,categoryId,pageable);
    }
}
