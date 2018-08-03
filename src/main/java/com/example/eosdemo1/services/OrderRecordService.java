/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.services;

import com.example.eosdemo1.email.EmailServiceImpl;
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
    
    @Autowired
    private EmailServiceImpl emailservice;
    
    private final String FROMEMAIL = "fnvdapp@gmail.com";

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

            //System.out.println("emailservice:" + emailservice );
        
        sendEmailToSeller(or);
        sendEmailToBuyer(or);
        
        or.setUserId(null);
        return or;

    }
    
    private void sendEmailToSeller(OrderRecord or){
        
        String to = or.getProduceItem().getEmail();
        String subject = "Order made on Local Fruit 'N Veg Direct: ORDER NO. " + or.getId();
        String msgBody = "Dear " + or.getProduceItem().getSellerName() + ",\n\n" 
                + "The following order has been made for your garden produce: \n\n"
                + "Order no.:\t\t\t\t" + or.getId()+ "\n" 
                + "Produce Name:    \t\t  " + or.getProduceItem().getName() + "\n" 
                + "Produce Description:\t\t " + or.getProduceItem().getDescription() + "\n"
                + "Total cost of order:\t\t     €" + or.getTotalOrderCost()+ "\n"
                + "Buyer:\t\t\t\t\t  " + or.getUsername() + "\n"
                + "\n\n"
                + "Regards" + "\n"
                + "Local Fruit 'N Veg Direct";
        
          emailservice.sendSimpleMessage(FROMEMAIL, to, subject, msgBody);
        
    }
    
    private void sendEmailToBuyer(OrderRecord or){
        
        String to = or.getProduceItem().getEmail();
        String subject = "Order made on Local Fruit 'N Veg Direct: ORDER NO. " + or.getId();
        String msgBody = "Dear " + or.getUsername() + ",\n\n" 
                + "Your order as follows has been submitted to the seller for garden produce: \n\n"
                + "Order no.:\t\t\t\t" + or.getId()+ "\n" 
                + "Produce Name:    \t\t  " + or.getProduceItem().getName() + "\n" 
                + "Produce Description:\t\t " + or.getProduceItem().getDescription() + "\n"
                + "Total cost of order:\t\t     €" + or.getTotalOrderCost()+ "\n"
                + "Buyer:\t\t\t\t\t  " + or.getUsername() + "\n"
                + "Seller:\t\t\t\t\t   " + or.getProduceItem().getSellerName() + "\n"
                + "\n"
                + "Please make arrangements with the seller for collection or delivery and for payment at handover of goods using the following contact details \n\n"
                + "Email address:\t\t\t\t" + or.getProduceItem().getEmail()
                + "\n\n"
                + "Regards" + "\n"
                + "Local Fruit 'N Veg Direct";
        
          emailservice.sendSimpleMessage(FROMEMAIL, to, subject, msgBody);
        
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

    public ProduceItem getProduceItem(Long orderId) {

        OrderRecord or = orderRecordRepository.getOne(orderId);

        return or.getProduceItem();
    }

//    public ProduceItem getItemOrderedMax() {
//
//        List<OrderRecord> or = orderRecordRepository.findMaxOrderedItem();
//
//        return or.get(0).getProduceItem();
//    }
}
