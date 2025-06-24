package com.kainmvc.demo1.service;

import com.kainmvc.demo1.entity.Product;
import com.kainmvc.demo1.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    @Override
    public void add(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productRepo.findProductByName(name);
    }

}
