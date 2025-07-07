package com.kainmvc.demo_spring_security_db.service;

import com.kainmvc.demo_spring_security_db.entity.MyRole;
import com.kainmvc.demo_spring_security_db.entity.MyUser;
import com.kainmvc.demo_spring_security_db.repository.IMyUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MyUserDetailService implements UserDetailsService {

    private final IMyUserRepository myUserRepository;

    public MyUserDetailService(IMyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = Optional.ofNullable(myUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found")));

        if(user.isPresent()){
        List<GrantedAuthority> authorities = user.get().getRoles().stream()
                .map(myRole -> new SimpleGrantedAuthority(myRole.getName()))
                .collect(Collectors.toList());


        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                authorities
        );
        }
        return null;
    }

    public String[] getRoles(MyUser user){
        return user.getRoles().stream()
                .map(MyRole::getName)
                .toArray(String[]::new);
    }
}
