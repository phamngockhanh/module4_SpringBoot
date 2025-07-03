package com.kainmvc.restful_api_thuc_hanh.repository;

import com.kainmvc.restful_api_thuc_hanh.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
