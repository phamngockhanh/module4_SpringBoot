package com.kainmvc.blog_ajax.controller;

import com.kainmvc.blog_ajax.entity.Writer;
import com.kainmvc.blog_ajax.service.IWriterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/writers")
public class WriterController {
    private final IWriterService iWriterService;

    public WriterController(IWriterService iWriterService) {
        this.iWriterService = iWriterService;
    }

    @GetMapping
    public ResponseEntity<List<Writer>> findAll(){
        List<Writer> writerList = (List<Writer>) iWriterService.findAll();
        if(writerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(writerList,HttpStatus.OK);
    }
}
