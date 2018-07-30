/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.repositories;

import com.example.eosdemo1.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 * Code copy taken from Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2145-2157). Apress. Kindle Edition. 
 */

@Repository 
public interface UserInfoJpaRepository extends JpaRepository<UserInfo, Long> { 
    
    public UserInfo findByUsername(String username);
    
}

//Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2124-2126). Apress. Kindle Edition. 
