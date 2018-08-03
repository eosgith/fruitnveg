/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ServiceAuthenticate { 
    @RequestMapping("/user") 
    public Principal user(Principal user) {
        System.out.println("in user method in ServiceAuthenticate");
        return user;
    }
}

//Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2539-2542). Apress. Kindle Edition. 
