package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Blog;
import com.kainmvc.blog_ajax.repository.IBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<Blog> search(String title, int categoryId, Pageable pageable) {
        return iBlogRepository.searchByTitleAndCategory(title,categoryId,pageable);
    }
}
