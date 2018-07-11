/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import com.example.eosdemo1.models.Bike;
import com.example.eosdemo1.repositories.BikeRepository;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eithn
 */

// rest api endpoints built around 1 resource model. plural case Bikes as controller all the Bike objects
@RestController
@RequestMapping("/api/bikes")
public class BikesController {
    // when GET HTTP issued on above class annotaion api will invoke this method
    @Autowired
    private BikeRepository bikeRepository;

      
        
    @GetMapping
    public List<Bike> list() {
        //List<Bike> bikes = new ArrayList<>();
        return bikeRepository.findAll();
    }
    
    // create new Bike data object from input form
    @PostMapping
//    @ResponseStatus(HttpStatus.OK)     // Return OK status 200
    public void create(@RequestBody Bike bike){
        System.out.println("\n**** In create create bike method **** \n");
        System.out.println(bike);
        bikeRepository.save(bike);
    }
    
    // get method to get 1 particular Bike with id
    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id){
        System.out.println("\n**** In get by id bike method **** \n");
        Bike bk = bikeRepository.getOne(id);
        System.out.println("bike returned " + bk);
        //return bikeRepository.getOne(id);
        return bk;
        //return new Bike();
    }
    
        // delete Bike data object using bike object passed in request
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)     // Return OK status 200
    public void delete(@RequestBody Bike bike){
       
        System.out.println("\n**** In delete create bike method **** \n");
        System.out.println(bike);
        bikeRepository.delete(bike);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)     // Return OK status 200
    public void deleteByID(@PathVariable("id") long id){
       
        System.out.println("\n**** In delete by ID bike method **** \n");
        
        bikeRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)     // Return OK status 200  
        public void update(@PathVariable("id") long id, @RequestBody Bike bike){
       
        Bike existingBike = bikeRepository.getOne(id);
        BeanUtils.copyProperties(bike, existingBike);
        System.out.println("\n**** In update bike method **** \n");
        System.out.println(existingBike);
        bikeRepository.save(existingBike);
    }
        
        // get method to get 1 particular Bike using request parameter of name
        // /api/bikes/byname?name=John Smith
    @RequestMapping("/byname")
    public List<Bike> findByName(@RequestParam(value="name", defaultValue="World") String name){
        System.out.println("\n**** In get by id bike method **** \n");
        List<Bike> bk = bikeRepository.findByName(name);
        System.out.println("bike returned " + bk);
       
        return bk;
        
    }
}
