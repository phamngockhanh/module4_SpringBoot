package com.kainmvc.thuc_hanh_cart.service;
import com.kainmvc.thuc_hanh_cart.model.Product;
import com.kainmvc.thuc_hanh_cart.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private  final IProductRepository iProductRepository;

    public ProductService( IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }


    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }
}
