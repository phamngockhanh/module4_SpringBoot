package com.kainmvc.bai_tap_blog_api.service;

import com.kainmvc.bai_tap_blog_api.entity.Category;
import com.kainmvc.bai_tap_blog_api.repository.ICategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final ICategoryRepo categoryRepo;

    public CategoryService(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void add(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }
}
