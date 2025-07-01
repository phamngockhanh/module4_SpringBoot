package com.kainmvc.bai_tap_blog_api.service;

import com.kainmvc.bai_tap_blog_api.entity.Writer;
import com.kainmvc.bai_tap_blog_api.repository.IWriterRepo;
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
