package com.kainmvc.demo_spring_security_db.service;

import com.kainmvc.demo_spring_security_db.entity.Writer;
import com.kainmvc.demo_spring_security_db.repository.IWriterRepo;
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
