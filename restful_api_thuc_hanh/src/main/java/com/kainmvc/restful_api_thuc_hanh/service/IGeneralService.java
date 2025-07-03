package com.kainmvc.restful_api_thuc_hanh.service;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();

    Optional<E> findById(Long id);

    E save (E e);

    void remove(Long id);
}
