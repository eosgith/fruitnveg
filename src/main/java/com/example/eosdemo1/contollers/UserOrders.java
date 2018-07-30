/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import com.example.eosdemo1.models.OrderRecord;
import com.example.eosdemo1.repositories.OrderRecordRepository;
import com.example.eosdemo1.services.OrderRecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eithn
 */
@RestController
@RequestMapping("fruitnvegAPI/userinfo")
public class UserOrders {
    

    @Autowired
    private OrderRecordRepository orderRecordRepository;

    @Autowired
    private OrderRecordService orderRecordService;

    @GetMapping
    public List<OrderRecord> list() {
        //    return OrderRecordStub.list();
        System.out.println("\n**** In list OrderRecord method **** \n");
        return orderRecordService.findAllOrderRecords();
//        return orderRepository.findAll();
    }

    //@RequestMapping(value = "orders", method = RequestMethod.POST)
    //     @PostMapping
//    @ResponseStatus(HttpStatus.OK)     // Return OK status 200
    @PostMapping
    public OrderRecord create(@RequestBody OrderRecord order) {
        //return OrderRecordStub.create(order);
        // order argument below comes from browser and saVEIT AND RETURN THE SAVED COPY
        System.out.println("\n**** In create OrderRecord method **** \n");
        System.out.println(order);
        return orderRecordService.createOrderRecord(order);
        // return orderRepository.saveAndFlush(order);

    }

        @GetMapping("/orders")
    public List<OrderRecord> getOrdersByUsername(@RequestParam(value = "username", required = false) String username) {
        
        System.out.println("\n**** In get by username OrderRecord method. ID = " + username + " **** \n");

        if (username != null){
        List<OrderRecord> or = orderRecordService.findByUsername(username);
        System.out.println("EOS my test 1: " + or + "\n");
        return or;
        }
        else {
             return orderRecordService.findAllOrderRecords();   
                }

//            return orderRecordService.findById(id);

    }
    
    @GetMapping("/{id}")
    public OrderRecord getByID(@PathVariable("id") Long id) {
        
        System.out.println("\n**** In get by id OrderRecord method. ID = " + id + " **** \n");


        OrderRecord or = orderRecordService.findById(id);
        System.out.println("EOS my test: " + or + "\n");
        return or;
//            return orderRecordService.findById(id);

    }
    
    
    
    
}

