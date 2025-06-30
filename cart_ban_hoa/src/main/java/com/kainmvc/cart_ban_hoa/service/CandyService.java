package com.kainmvc.cart_ban_hoa.service;

import com.kainmvc.cart_ban_hoa.entity.Candy;
import com.kainmvc.cart_ban_hoa.repository.ICandyRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandyService implements ICandyService{
    private final ICandyRepo iCandyRepo;

    public CandyService(ICandyRepo iCandyRepo) {
        this.iCandyRepo = iCandyRepo;
    }


    @Override
    public Iterable<Candy> findAll() {
        return iCandyRepo.findAll();
    }

    @Override
    public Optional<Candy> findById(Long id) {
        return iCandyRepo.findById(id);
    }
}
