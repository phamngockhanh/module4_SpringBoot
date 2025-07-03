package com.kainmvc.blog_ajax.service;

import com.kainmvc.blog_ajax.entity.Writer;
import com.kainmvc.blog_ajax.repository.IWriterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WriterService implements IWriterService{
    private final IWriterRepository iWriterRepository;

    public WriterService(IWriterRepository iWriterRepository) {
        this.iWriterRepository = iWriterRepository;
    }

    @Override
    public Iterable<Writer> findAll() {
        return iWriterRepository.findAll();
    }

    @Override
    public Optional<Writer> findById(Long id) {
        return iWriterRepository.findById(id);
    }
}
