package com.kainmvc.quan_ly_heo_spring_framework.service;

import com.kainmvc.quan_ly_heo_spring_framework.entity.Origin;
import com.kainmvc.quan_ly_heo_spring_framework.repository.IOriginRepository;
import com.kainmvc.quan_ly_heo_spring_framework.service.impl.IOriginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService implements IOriginService {
    private final IOriginRepository originRepository;

    public OriginService(IOriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    @Override
    public List<Origin> findAll() {
        return originRepository.findAll();
    }
}
