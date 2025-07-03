package com.kainmvc.ajax_thuc_hanh.service;

import com.kainmvc.ajax_thuc_hanh.model.Smartphone;
import com.kainmvc.ajax_thuc_hanh.repository.ISmartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneService implements ISmartphoneService{
    private final ISmartRepository iSmartRepository;

    public SmartphoneService(ISmartRepository iSmartRepository) {
        this.iSmartRepository = iSmartRepository;
    }

    @Override
    public Iterable<Smartphone> findAll() {
        return iSmartRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return iSmartRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return iSmartRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        iSmartRepository.deleteById(id);
    }
}
