/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 * Code copy taken from Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2145-2157). Apress. Kindle Edition. 
 */

@Entity 
@Table(name = "users") 
public class UserInfo {
    @Id @GeneratedValue 
   
    @Column(name = "userid") 
    private Long id; 
    @Column(name = "username") 
    private String username;
    @Column(name = "password") 
    private String password; 
    @Column(name = "enabled") 
    private boolean isEnabled; 
    @Column(name = "role") 
    private String role;
//    private List<OrderRecord> orders;

    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<OrderRecord> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<OrderRecord> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return "UserInfo{" + "id=" + id + ", username=" + username + ", password=" + password + ", isEnabled=" + isEnabled + ", role=" + role + '}';
    }

}

//Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2101-2107). Apress. Kindle Edition. 
