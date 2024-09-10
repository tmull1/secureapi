// Commenting out the entire OAuth2Config class so JWT can work

// package com.example.secureapi;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// @Order(2)  // Setting order to 2 to apply after SecurityConfig
// public class OAuth2Config extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .oauth2Login()
//             .and()
//             .authorizeRequests()
//             .anyRequest().authenticated();
//     }
// }



