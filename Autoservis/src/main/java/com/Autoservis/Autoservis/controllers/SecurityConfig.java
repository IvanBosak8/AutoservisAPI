package com.Autoservis.Autoservis.controllers;

import com.Autoservis.Autoservis.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig  {


    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().anyRequest();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();/*.authorizeRequests()
                .antMatchers("/user").permitAll()
                .antMatchers("/user/{id}").permitAll()
                .antMatchers("/user/add").permitAll()
                .antMatchers("/posaljilozinku").permitAll()
                .and().logout().logoutUrl("/logout");*/
        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();

    }


}