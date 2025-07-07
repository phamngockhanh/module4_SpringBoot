package com.kainmvc.demo_spring_security_db.repository;

import com.kainmvc.demo_spring_security_db.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
}
