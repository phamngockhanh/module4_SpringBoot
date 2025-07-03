package com.kainmvc.thuc_hanh_cart.repository;

import com.kainmvc.thuc_hanh_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
