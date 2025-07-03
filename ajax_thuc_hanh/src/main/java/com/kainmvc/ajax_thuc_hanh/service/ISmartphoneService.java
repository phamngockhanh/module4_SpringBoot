package com.kainmvc.ajax_thuc_hanh.service;

import com.kainmvc.ajax_thuc_hanh.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    Smartphone save(Smartphone smartphone);
    void remove(Long id);
}
