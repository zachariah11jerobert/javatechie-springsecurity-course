package com.kkjerome.kkspringsecuritycourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("testadmin").password("test123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("testuser").password("test123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // This authenticates for all end points
        //http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();

        // security based on URL
        http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();

        // security based on ROLE
        http.authorizeRequests().antMatchers("/rest/**").
                hasAnyRole("ADMIN").
                anyRequest().fullyAuthenticated().
                and().httpBasic();
    }

    // not to expect password in encrypted format we use this
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
