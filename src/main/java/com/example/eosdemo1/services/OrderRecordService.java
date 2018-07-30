/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.services;

import com.example.eosdemo1.models.OrderRecord;
import com.example.eosdemo1.models.ProduceItem;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eosdemo1.repositories.OrderRecordRepository;
import com.example.eosdemo1.repositories.UserInfoJpaRepository;

/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 */

@Service("orderRecordService")
public class OrderRecordService {

    @Autowired
    private OrderRecordRepository orderRecordRepository;
    //private ProduceItemRepository produceItemRepository;
    
    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository; 

    public List<OrderRecord> findAllOrderRecords() {
        System.out.println("\n**** In findAllOrderRecords OrderRecordService method **** \n");

        return orderRecordRepository.findAll();
    }

    public OrderRecord createOrderRecord(OrderRecord orderRecord) {

        System.out.println("\n**** In createPI OrderRecordService method **** \n");
        //System.out.println(orderRecord);
//        UserInfo user = userInfoJpaRepository.findByUsername(orderRecord.getUsername()); 
//        
//        System.out.println("\nin userinfo \n" + user);
//        
//        orderRecord.setUserId(user);
        
        OrderRecord or = orderRecordRepository.saveAndFlush(orderRecord);
        
//        or.setUserId(null);
        return or;

    }

    public OrderRecord findById(Long id) {
        System.out.println("\n**** In findByID OrderRecords OrderRecordService method **** \n");

        return orderRecordRepository.getOne(id);
    }
    
    public List<OrderRecord> findByUsername(String username) {
        System.out.println("\n**** In findByusername OrderRecords OrderRecordService method **** \n");

        return orderRecordRepository.findByUsername(username);
    }

    public OrderRecord updateOrderRecord(OrderRecord orderRecord, Long id) {

        System.out.println("\n**** In updateOrderRecord OrderRecordService method **** \n");
        
        System.out.println(orderRecord);
        OrderRecord existingOrderRecord = orderRecordRepository.getOne(id);
        BeanUtils.copyProperties(orderRecord, existingOrderRecord);
        System.out.println(existingOrderRecord);
        return orderRecordRepository.saveAndFlush(existingOrderRecord);

    }
    
        public void delete(OrderRecord orderRecord) {

        System.out.println("\n**** In delete OrderRecordService method **** \n");
        //System.out.println(orderRecord);
        orderRecordRepository.delete(orderRecord);
    }
    
    public OrderRecord deleteById(Long id) {

        System.out.println("\n**** In delete OrderRecordService method **** \n");
        //System.out.println(orderRecord);
        OrderRecord existingOrderRecord = orderRecordRepository.getOne(id);
        orderRecordRepository.delete(existingOrderRecord);
        return existingOrderRecord;
    }
    
    public ProduceItem getProduceItem(Long orderId){
        
        OrderRecord or = orderRecordRepository.getOne(orderId); 
        
        return or.getProduceItem();
    }
}
