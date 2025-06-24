package com.kainmvc.demo1.repository;

import com.kainmvc.demo1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findProductByName(String name);
}
