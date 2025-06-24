package com.kainmvc.blog_spring_boots.service;

import com.kainmvc.blog_spring_boots.entity.Writer;
import com.kainmvc.blog_spring_boots.repository.IWriterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService implements IWriterService{
    private final IWriterRepo writerRepo;

    public WriterService(IWriterRepo writerRepo) {
        this.writerRepo = writerRepo;
    }

    @Override
    public List<Writer> findAll() {
        return writerRepo.findAll();
    }
}
