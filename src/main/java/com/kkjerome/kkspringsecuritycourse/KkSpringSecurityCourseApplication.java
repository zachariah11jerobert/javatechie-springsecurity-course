package com.kkjerome.kkspringsecuritycourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class KkSpringSecurityCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkSpringSecurityCourseApplication.class, args);
    }

}
