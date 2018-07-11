/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.services;

import com.example.eosdemo1.models.ProduceType;
import com.example.eosdemo1.repositories.ProduceTypeRepository;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eithn
 */
@Service("produceTypeService")
public class ProduceTypeService {

    @Autowired
    private ProduceTypeRepository produceTypeRepository;

    public List<ProduceType> findAllProduceTypes() {
        System.out.println("\n**** In findAllProduceTypes ProduceTypeService method **** \n");

        return produceTypeRepository.findAll();
    }

    public ProduceType createProduceType(ProduceType produceType) {

        System.out.println("\n**** In createPI ProduceTypeService method **** \n");
        //System.out.println(produceType);
        return produceTypeRepository.saveAndFlush(produceType);

    }

    public ProduceType findById(Long id) {
        System.out.println("\n**** In findByID ProduceTypes ProduceTypeService method **** \n");

        return produceTypeRepository.getOne(id);
    }

    public ProduceType updateProduceType(ProduceType produceType, Long id) {

        System.out.println("\n**** In updateProduceType ProduceTypeService method **** \n");
        
        System.out.println(produceType);
        ProduceType existingProduceType = produceTypeRepository.getOne(id);
        BeanUtils.copyProperties(produceType, existingProduceType);
        System.out.println(existingProduceType);
        return produceTypeRepository.saveAndFlush(existingProduceType);

    }
    
        public void delete(ProduceType produceType) {

        System.out.println("\n**** In delete ProduceTypeService method **** \n");
        //System.out.println(produceType);
        produceTypeRepository.delete(produceType);
    }
    
    public ProduceType deleteById(Long id) {

        System.out.println("\n**** In delete ProduceTypeService method **** \n");
        //System.out.println(produceType);
        ProduceType existingProduceType = produceTypeRepository.getOne(id);
        produceTypeRepository.delete(existingProduceType);
        return existingProduceType;
    }
}
