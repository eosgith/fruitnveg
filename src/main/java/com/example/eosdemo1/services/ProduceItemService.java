/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.services;

import com.example.eosdemo1.models.ProduceItem;
import com.example.eosdemo1.repositories.ProduceItemRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eithn
 */
@Service("produceItemService")
public class ProduceItemService {

    @Autowired
    private ProduceItemRepository produceItemRepository;

    public List<ProduceItem> findAllProduceItems() {
        System.out.println("\n**** In findAllProduceItems ProduceItemService method **** \n");

        return produceItemRepository.findAll();
    }

    public ProduceItem createProduceItem(ProduceItem produceItem) {

        System.out.println("\n**** In createPI ProduceItemService method **** \n");
        //System.out.println(produceItem);
        return produceItemRepository.saveAndFlush(produceItem);

    }

    public ProduceItem findById(Long id) {
        System.out.println("\n**** In findByID ProduceItems ProduceItemService method **** \n");

        return produceItemRepository.getOne(id);
    }

    public ProduceItem updateProduceItem(ProduceItem produceItem, Long id) {

        System.out.println("\n**** In updateProduceItem ProduceItemService method **** \n");
        
        System.out.println(produceItem);
        ProduceItem existingProduceItem = produceItemRepository.getOne(id);
        BeanUtils.copyProperties(produceItem, existingProduceItem);
        System.out.println(existingProduceItem);
        return produceItemRepository.saveAndFlush(existingProduceItem);

    }
    
    public void delete(ProduceItem produceItem) {

        System.out.println("\n**** In delete ProduceItemService method **** \n");
        //System.out.println(produceItem);
        produceItemRepository.delete(produceItem);
    }
    
    public ProduceItem deleteById(Long id) {

        System.out.println("\n**** In delete ProduceItemService method **** \n");
        //System.out.println(produceItem);
        ProduceItem existingProduceItem = produceItemRepository.getOne(id);
        produceItemRepository.delete(existingProduceItem);
        return existingProduceItem;
    }
    
            // get method to get 1 particular ProduceItem using request parameter of name
        // /api/produceItems/byname?name=John Smith
  
    public List<ProduceItem> getByName(String name){
        System.out.println("\n**** In get by id produceItem method **** \n");
        List<ProduceItem> pi = produceItemRepository.findByName(name);
        System.out.println("produceItem returned " + pi);
        return pi;
        
    }
    
        public List<ProduceItem> findBySellername(String sellername) {
        System.out.println("\n**** In findBysellername ProduceItems ProduceItemService method **** \n");

        return produceItemRepository.findBySellerName(sellername);
    }
}
