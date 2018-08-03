/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import com.example.eosdemo1.models.OrderRecord;
import com.example.eosdemo1.models.ProduceItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.eosdemo1.repositories.OrderRecordRepository;
import com.example.eosdemo1.services.OrderRecordService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 */

@RestController
@RequestMapping("fruitnvegAPI/orderrecords")
public class OrderRecordController {

    @Autowired
    private OrderRecordRepository orderRecordRepository;

    @Autowired
    private OrderRecordService orderRecordService;

    @GetMapping
    public List<OrderRecord> list(@RequestParam(value = "username", required = false) String username) {
        //    return OrderRecordStub.list();
        System.out.println("\n**** In list OrderRecord method **** \n");
        
        if (username != null){
            List<OrderRecord> or = orderRecordService.findByUsername(username);
            System.out.println("EOS my test 1: " + or + "\n");
            return or;
        }
        else {
                    
            return orderRecordService.findAllOrderRecords();
       }
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

    @GetMapping("/{id}")
    public OrderRecord getByID(@PathVariable("id") Long id) {
        
        System.out.println("\n**** In get by id OrderRecord method. ID = " + id + " **** \n");


        OrderRecord or = orderRecordService.findById(id);
      
        return or;
//            return orderRecordService.findById(id);

    }

    @PutMapping("/{id}")
    //@RequestMapping(value = "orders/{id}", method = RequestMethod.PUT)
    public OrderRecord update(@PathVariable("id") long id, @RequestBody OrderRecord order) {
//        OrderRecord existingOrderRecord = orderRepository.getOne(id);
//        BeanUtils.copyProperties(order, existingOrderRecord);

        return orderRecordService.updateOrderRecord(order, id);
        //return orderRepository.saveAndFlush(existingOrderRecord);
        //return OrderRecordStub.update(id, order);
    }

    @DeleteMapping("/{id}")
    public OrderRecord deleteByID(@PathVariable("id") long id) {
        //return OrderRecordStub.delete(id);
//        OrderRecord existingOrderRecord = orderRepository.getOne(id);
//        orderRepository.delete(existingOrderRecord);

        return orderRecordService.deleteById(id);
    }

    // delete OrderRecord data object using OrderRecord object passed in request
    @DeleteMapping
    public void delete(@RequestBody OrderRecord order) {

        System.out.println("\n**** In delete create bike method **** \n");
        //System.out.println(bike);

        orderRecordService.delete(order);
        // orderRepository.delete(order);
    }

//    @RequestMapping("/maxordereditem")
//    public ProduceItem getMaxOrdered(){
//        System.out.println("\n**** In getLast produceItem method **** \n");
//               
//        return orderRecordService.getItemOrderedMax() ;
//        
//    }
}
