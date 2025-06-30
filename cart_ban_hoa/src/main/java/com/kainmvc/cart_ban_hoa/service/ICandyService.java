package com.kainmvc.cart_ban_hoa.service;

import com.kainmvc.cart_ban_hoa.entity.Candy;

import java.util.Optional;

public interface ICandyService {
    Iterable<Candy> findAll();
    Optional<Candy> findById(Long id);
}
