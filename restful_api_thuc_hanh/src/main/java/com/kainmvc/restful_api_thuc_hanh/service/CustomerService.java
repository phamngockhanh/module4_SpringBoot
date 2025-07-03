package com.kainmvc.restful_api_thuc_hanh.service;

import com.kainmvc.restful_api_thuc_hanh.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kainmvc.restful_api_thuc_hanh.repository.ICustomerRepository;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }
}
