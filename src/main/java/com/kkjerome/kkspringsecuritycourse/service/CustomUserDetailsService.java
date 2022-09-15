package com.kkjerome.kkspringsecuritycourse.service;

import com.kkjerome.kkspringsecuritycourse.model.User;
import com.kkjerome.kkspringsecuritycourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repository.findByUsername(username);
        CustomerUserDetails userDetails=null;
        if(user !=null){
            userDetails=new CustomerUserDetails();
            userDetails.setUser(user);
        }else{
            throw new UsernameNotFoundException("User not exist with name : "+username);
        }

        return userDetails;
    }
}
