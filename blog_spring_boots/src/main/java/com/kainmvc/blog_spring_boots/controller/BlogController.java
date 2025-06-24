package com.kainmvc.blog_spring_boots.controller;

import com.kainmvc.blog_spring_boots.entity.Blog;

import com.kainmvc.blog_spring_boots.entity.Category;
import com.kainmvc.blog_spring_boots.entity.Writer;
import com.kainmvc.blog_spring_boots.service.IBlogService;
import com.kainmvc.blog_spring_boots.service.ICategoryService;
import com.kainmvc.blog_spring_boots.service.IWriterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService iBlogService;
    private final ICategoryService iCategoryService;
    private final IWriterService iWriterService;

    public BlogController(IBlogService iBlogService, ICategoryService iCategoryService, IWriterService iWriterService) {
        this.iBlogService = iBlogService;
        this.iCategoryService = iCategoryService;
        this.iWriterService = iWriterService;
    }

    @GetMapping("")
    public String index(Model model){
        List<Blog> blogs = iBlogService.findAll();
        model.addAttribute("blogs",blogs);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        List<Category> categories = iCategoryService.findAll();
        List<Writer> writers = iWriterService.findAll();
        model.addAttribute("blog",new Blog());
        model.addAttribute("writers",writers);
        model.addAttribute("categories",categories);
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog){
        iBlogService.update(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model){
        List<Category> categories = iCategoryService.findAll();
        List<Writer> writers = iWriterService.findAll();
        model.addAttribute("blog",iBlogService.findById(id).get());
        model.addAttribute("categories",categories);
        model.addAttribute("writers",writers);
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(Blog blog){
        iBlogService.update(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        iBlogService.delete(id);
        return "redirect:/blogs";
    }


    @GetMapping("/{id}/view")
    public String view (@PathVariable int id,Model model){
        model.addAttribute("blog",iBlogService.findById(id).get());
        return "blog/view";
    }
}
