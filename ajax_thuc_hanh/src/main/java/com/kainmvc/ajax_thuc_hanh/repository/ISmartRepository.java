package com.kainmvc.ajax_thuc_hanh.repository;

import com.kainmvc.ajax_thuc_hanh.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartRepository extends JpaRepository<Smartphone,Long> {
}
