package com.kainmvc.blog_spring_boots.controller;

import com.kainmvc.blog_spring_boots.entity.Category;
import com.kainmvc.blog_spring_boots.repository.ICategoryRepo;
import com.kainmvc.blog_spring_boots.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService iCategoryService;

    public CategoryController(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }


    @GetMapping("")
    public String listCategory(Model model){
        List<Category> categories = iCategoryService.findAll();
        model.addAttribute("categories",categories);
        return "category/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(Category category){
        iCategoryService.add(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public String update (@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/update")
    public String update(Category category){
        iCategoryService.add(category);
        return "redirect:/categories";
    }
}
