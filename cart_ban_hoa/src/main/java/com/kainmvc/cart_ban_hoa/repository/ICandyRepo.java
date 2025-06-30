package com.kainmvc.cart_ban_hoa.repository;

import com.kainmvc.cart_ban_hoa.entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandyRepo extends JpaRepository<Candy,Long> {
}
