/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eithn
 */
package com.example.eosdemo1.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eithn
 */
//@RestController
public class HelloController {

//    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
