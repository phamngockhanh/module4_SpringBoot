package com.kainmvc.bai_tap_blog_api.controller;

import com.kainmvc.bai_tap_blog_api.common.BlogValidator;
import com.kainmvc.bai_tap_blog_api.entity.Blog;
import com.kainmvc.bai_tap_blog_api.entity.Category;
import com.kainmvc.bai_tap_blog_api.service.BlogService;
import com.kainmvc.bai_tap_blog_api.service.IBlogService;
import com.kainmvc.bai_tap_blog_api.service.ICategoryService;
import com.kainmvc.bai_tap_blog_api.service.IWriterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private final IBlogService iBlogService;
    private final ICategoryService iCategoryService;
    private final IWriterService iWriterService;

    @ModelAttribute("sizeList")
    public List<Integer> sizeList(){
        return Arrays.asList(1,3,5,7,10);
    }


    public BlogController(IBlogService iBlogService, ICategoryService iCategoryService, IWriterService iWriterService) {
        this.iBlogService = iBlogService;
        this.iCategoryService = iCategoryService;
        this.iWriterService = iWriterService;
    }


    @GetMapping
    public  ResponseEntity<List<Blog>> findAll(  @RequestParam(required = false, defaultValue = "2") int size,
                                                 @RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "") String searchName,
                                                 @RequestParam(required = false, defaultValue = "0") Integer categoryId){
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogList = iBlogService.search(searchName,categoryId,pageable);
        if(blogList.getContent().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList.getContent(),HttpStatus.OK);
    }

    @GetMapping("/{id}/category")
    public ResponseEntity<List<Blog>> findBlogByCategoryId(@PathVariable Integer id){
        Category category = iCategoryService.findById(id);
        List<Blog> listBlog = iBlogService.findByCategoryId(category);
        if(listBlog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBlog,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody Blog blog){
        Map<String,String> errors= BlogValidator.validate(blog);
        if (errors.isEmpty()){
            return new ResponseEntity<>(iBlogService.update(blog),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id,@RequestBody Blog blog){
        Optional<Blog> blogOptional = iBlogService.findById(id);

        if(blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(iBlogService.update(blog),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
        Optional<Blog> blogOptional  = iBlogService.findById(id);
        if(blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }



}
