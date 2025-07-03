package com.kainmvc.thuc_hanh_cart.service;

import com.kainmvc.thuc_hanh_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
