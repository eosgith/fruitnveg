/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

/**
 *
 * @author eithn
 */

 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/index")
public class IndexController {
 
      @RequestMapping(method = RequestMethod.GET)
        public String getIndexPage() {
            System.out.println("in getIndexPage");
            return "index.html";
        }
 
}
