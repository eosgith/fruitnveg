/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.security.config;

import com.example.eosdemo1.services.UserInfoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 * Code copy taken from "Soni, Ravi Kant. Full Stack AngularJS for Java Developers: 
 * Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2145-2157). Apress. Kindle Edition."
 * 
 * I added in the method passwordEncoder() as there was no encryption of password in database in the copied code and .csrf disable option in configure() method.
 * I changed .antMatchers to fit my app.
 */

@Configuration 
@EnableWebSecurity 
//@EnableGlobalMethodSecurity(prePostEnabled = true)



public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter { 
    @Autowired 
    private UserInfoDetailsService userInfoDetailsService;
    
    @Override 
    protected void configure( AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        System.out.println("\nin authenticationMge configure\n");
        authenticationManagerBuilder.userDetailsService(userInfoDetailsService);
    } 
    
    @Override 
    protected void configure(HttpSecurity http) throws Exception {
        
        System.out.println("\nin security configure\n");
        http.sessionManagement() 
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
                
                .and() 
                .authorizeRequests() 
                    
//                .antMatchers(HttpMethod.GET, "/api/produceItem") 
//                    .hasRole("USER") 
                
                
//                    .antMatchers("/login.html","/login", "/home.html", "/", "/user", "/index.html").permitAll()  
                    
///****              
//                    .antMatchers(HttpMethod.GET,"/fruitnvegAPI/produceTypes**").permitAll()
//                    .antMatchers("/fruitnvegAPI/produceTypes**").hasRole("ADMIN")
//                    .antMatchers("/fruitnvegAPI/produceTypes/**").hasRole("ADMIN")
///****                

                    .antMatchers("/fruitnvegAPI/produceItems", "/fruitnvegAPI/produceItems)", "/fruitnvegAPI/orderrecords")
                    .authenticated()
//                    .antMatchers("/api/orderrecords")
//                  .antMatchers(HttpMethod.PUT, "/api/produceTypes/**")                          
//                   .hasRole("ADMIN") 
//                .antMatchers(HttpMethod.DELETE, "/api/user/**") 
//                    .hasRole("ADMIN")

 
//                    .antMatchers("/api/produceItems/**") 
                     
//.and()
//                .formLogin()
//                 .failureUrl("/login.html?error=true")
//                .defaultSuccessUrl("/index.html", true)
//                      .permitAll()
                .and() 
                .httpBasic() 
                .realmName("Local Fruit N Veg System") 
                .and() 
                .csrf() 
                    .disable();
    } 
    
    @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

}

//Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2174-2188). Apress. Kindle Edition. 
