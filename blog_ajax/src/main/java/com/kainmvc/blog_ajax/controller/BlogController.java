package com.kainmvc.blog_ajax.controller;


import com.kainmvc.blog_ajax.entity.Blog;
import com.kainmvc.blog_ajax.entity.Category;
import com.kainmvc.blog_ajax.entity.Writer;
import com.kainmvc.blog_ajax.service.IBlogService;
import com.kainmvc.blog_ajax.service.ICategoryService;
import com.kainmvc.blog_ajax.service.IWriterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private final IBlogService iBlogService;
    private final ICategoryService iCategoryService;
    private final IWriterService iWriterService;

    public BlogController(IBlogService iBlogService, ICategoryService iCategoryService, IWriterService iWriterService) {
        this.iBlogService = iBlogService;
        this.iCategoryService = iCategoryService;
        this.iWriterService = iWriterService;
    }

    @GetMapping
    public ResponseEntity<Page<Blog>> findAll( @RequestParam(required = false, defaultValue = "2") int size,
                                               @RequestParam(required = false, defaultValue = "0") int page,
                                               @RequestParam(required = false, defaultValue = "") String title,
                                               @RequestParam(required = false, defaultValue = "0") Integer categoryId){
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogs = iBlogService.search(title,categoryId,pageable);
        if(blogs.getContent().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Blog>> findById(@PathVariable Long id){
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if(blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
        Long categoryId = blog.getCategory().getId();
        Long writerId = blog.getWriter().getId();
        Category category = iCategoryService.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Writer writer = iWriterService.findById(writerId)
                .orElseThrow(() -> new RuntimeException("Writer not found"));

        blog.setCategory(category);
        blog.setWriter(writer);
        return new ResponseEntity<>(iBlogService.save(blog),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog blog){
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if(blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(iBlogService.save(blog),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id){
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.delete(id);
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.NO_CONTENT);
    }
}
