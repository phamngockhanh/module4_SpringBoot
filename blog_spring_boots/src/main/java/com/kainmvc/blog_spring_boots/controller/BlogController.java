package com.kainmvc.blog_spring_boots.controller;

import com.kainmvc.blog_spring_boots.entity.Blog;

import com.kainmvc.blog_spring_boots.entity.Category;
import com.kainmvc.blog_spring_boots.entity.Writer;
import com.kainmvc.blog_spring_boots.service.IBlogService;
import com.kainmvc.blog_spring_boots.service.ICategoryService;
import com.kainmvc.blog_spring_boots.service.IWriterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class    BlogController {
    private final IBlogService iBlogService;
    private final ICategoryService iCategoryService;
    private final IWriterService iWriterService;

    @ModelAttribute("categories")
    public List<Category> findAll(){
        return iCategoryService.findAll();
    }

    @ModelAttribute("sizeList")
    public List<Integer> sizeList(){
        return Arrays.asList(1,3,5,7,10);
    }




    public BlogController(IBlogService iBlogService, ICategoryService iCategoryService, IWriterService iWriterService) {
        this.iBlogService = iBlogService;
        this.iCategoryService = iCategoryService;
        this.iWriterService = iWriterService;
    }

//    @GetMapping("")
//    public String index(@PageableDefault(size = 2, page = 0) Pageable pageable, Model model) {
//        Page<Blog> blogs = iBlogService.findAll(pageable);
//        model.addAttribute("blogs", blogs);
//        return "blog/index";
//    }

//    @GetMapping("")
//    public String index(
//            @RequestParam(required = false, defaultValue = "2") int size,
//            @RequestParam(required = false, defaultValue = "0") int page,
//            @RequestParam(required = false, defaultValue = "") String title,
//            Model model) {
//        Sort sort = Sort.by(Sort.Direction.ASC,"title").and(Sort.by(Sort.Direction.ASC,"category"));
//        Pageable pageable = PageRequest.of(page,size,sort);
//        Page<Blog> blogs = iBlogService.search(title,pageable);
//        model.addAttribute("title",title);
//        model.addAttribute("blogs", blogs);
//        return "blog/index";
//    }

    @GetMapping("")
    public String index(
            @RequestParam(required = false, defaultValue = "1") int size,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "") String title,
            @RequestParam(required = false, defaultValue = "0") Integer categoryId,
            @RequestParam(required = false, defaultValue = "false") Boolean sortedDate,
            Model model) {
        Sort sort ;
        if(sortedDate){
            sort=Sort.by(Sort.Direction.ASC,"published_date");
        }else{
            sort=Sort.by(Sort.Direction.DESC,"published_date");
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Blog> blogs = iBlogService.search(title,categoryId,pageable);
        model.addAttribute("title",title);
        model.addAttribute("categoryId",categoryId);
        model.addAttribute("blogs", blogs);
        model.addAttribute("size", size);
        model.addAttribute("sortedDate", sortedDate);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Writer> writers = iWriterService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("writers", writers);
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        iBlogService.update(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model) {
        List<Writer> writers = iWriterService.findAll();
        model.addAttribute("blog", iBlogService.findById(id).get());
        model.addAttribute("writers", writers);
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.update(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        iBlogService.delete(id);
        return "redirect:/blogs";
    }


    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id).get());
        return "blog/view";
    }
}
