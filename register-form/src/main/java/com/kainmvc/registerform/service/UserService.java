package com.kainmvc.registerform.service;

import com.kainmvc.registerform.entity.User;
import com.kainmvc.registerform.repository.IUserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final IUserRepo iUserRepo;

    public UserService(IUserRepo iUserRepo) {
        this.iUserRepo = iUserRepo;
    }

    @Override
    public void add(User user) {
        iUserRepo.save(user);
    }
}
