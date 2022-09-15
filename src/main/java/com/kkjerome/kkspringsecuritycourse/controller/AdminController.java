package com.kkjerome.kkspringsecuritycourse.controller;

import com.kkjerome.kkspringsecuritycourse.model.User;
import com.kkjerome.kkspringsecuritycourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/admin/add")
    public String addUserByAdmin(@RequestBody User user){
        String pwd=user.getPassword();
        String encryptPwd=user.getPassword();
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "user added successfully...";
    }
}
