package com.kainmvc.registerform.repository;

import com.kainmvc.registerform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
}
