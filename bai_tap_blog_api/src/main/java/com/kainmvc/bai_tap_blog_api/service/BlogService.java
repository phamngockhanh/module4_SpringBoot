package com.kainmvc.bai_tap_blog_api.service;

import com.kainmvc.bai_tap_blog_api.entity.Blog;
import com.kainmvc.bai_tap_blog_api.entity.Category;
import com.kainmvc.bai_tap_blog_api.repository.IBlogRepo;
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
    public Blog update(Blog blog) {
       return blogRepo.save(blog);
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

    @Override
    public Page<Blog> search(Integer categoryId, Pageable pageable) {
        return blogRepo.searchByCategory(categoryId,pageable);
    }

    @Override
    public List<Blog> findByCategoryId(Category category) {
        return blogRepo.findBlogByCategory(category);
    }
}
