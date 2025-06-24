package com.kainmvc.demo1.service;

import com.kainmvc.demo1.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add (Product product);
    Product findById(int id);
    void delete(int id);
    List<Product> findProductByName(String name);
}
