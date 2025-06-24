package com.kainmvc.blog_spring_boots.service;

import com.kainmvc.blog_spring_boots.entity.Category;
import com.kainmvc.blog_spring_boots.repository.ICategoryRepo;
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
}
