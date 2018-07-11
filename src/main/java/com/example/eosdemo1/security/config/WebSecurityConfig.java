/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.security.config;

//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 *
 * @author eithn
 */
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////public class WebSecurityConfig implements WebMvcConfigurer {
//
////    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/signup", "/index.html").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
////                .loginPage("/customLogin.html")
//                .defaultSuccessUrl("/index.html", true)
//                .permitAll();
//        ;
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        InMemoryUserDetailsManager manager
////                = new InMemoryUserDetailsManager();
////        manager.createUser(User.withDefaultPasswordEncoder()
////                .username("jack")
////                .password("password")
////                .authorities("USER")
////                .build());
////        return manager;
////    }
//
//    @Bean
//    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//        manager.setDataSource(dataSource);
//        return manager;
//    }
//
//@Bean
//public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//}
//}
