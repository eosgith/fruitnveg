/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.services;

import com.example.eosdemo1.models.OrderRecord;
import com.example.eosdemo1.models.UserInfo;
import com.example.eosdemo1.repositories.UserInfoJpaRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 * Code copy taken from Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2145-2157). Apress. Kindle Edition. 
 */

@Service 
public class UserInfoDetailsService implements UserDetailsService { 
    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository; 
    
    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserInfo user = userInfoJpaRepository.findByUsername(username); 
        System.out.println("\nin loadUserByUsername\n");
        if (user == null) {
           
            throw new UsernameNotFoundException( "Opps! user not found with user-name: " + username);
        }
        org.springframework.security.core.userdetails.User  us = new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), getAuthorities(user)); 
        System.out.println("\nin loadUserByUsername \n" + us);
        return us;
        //return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), getAuthorities(user)); 
    }
    
    private Collection<GrantedAuthority> getAuthorities(UserInfo user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities = AuthorityUtils.createAuthorityList(user.getRole()); 
        System.out.println("\nin getAuthorities \n" + authorities);
        return authorities;
    } 

//     public List<OrderRecord> getOrders(UserInfo user){
//         
//     }

}

// Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2145-2157). Apress. Kindle Edition. 
