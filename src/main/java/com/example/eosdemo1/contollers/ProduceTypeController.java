/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import com.example.eosdemo1.models.ProduceType;
import com.example.eosdemo1.repositories.ProduceTypeRepository;
import com.example.eosdemo1.services.ProduceTypeService;
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

/**
 *
 * @author eithn
 */
@RestController
@RequestMapping("fruitnvegAPI/produceTypes")
public class ProduceTypeController {

    @Autowired
    private ProduceTypeRepository produceTypeRepository;

    @Autowired
    private ProduceTypeService produceTypeService;

    @GetMapping
    public List<ProduceType> list() {
        //    return ProduceTypeStub.list();
        System.out.println("\n**** In list ProduceType method **** \n");
        return produceTypeService.findAllProduceTypes();
//        return produceTypeRepository.findAll();
    }

    //@RequestMapping(value = "produceTypes", method = RequestMethod.POST)
    //     @PostMapping
//    @ResponseStatus(HttpStatus.OK)     // Return OK status 200
    @PostMapping
    public ProduceType create(@RequestBody ProduceType produceType) {
        //return ProduceTypeStub.create(produceType);
        // produceType argument below comes from browser and saVEIT AND RETURN THE SAVED COPY
        System.out.println("\n**** In create ProduceType method **** \n");
        System.out.println(produceType);
        return produceTypeService.createProduceType(produceType);
        // return produceTypeRepository.saveAndFlush(produceType);

    }

    @GetMapping("/{id}")
    public ProduceType getByID(@PathVariable("id") Long id) {
        // return ProduceTypeStub.get(id);
        System.out.println("\n**** In get by id ProduceType method. ID = " + id + " **** \n");

//         ProduceType sw = produceTypeRepository.getOne(id);
//         System.out.println("sw = " + sw +"\n");
        return produceTypeService.findById(id);
//         return sw;
        // return produceTypeRepository.getOne(id);
    }

    @PutMapping("/{id}")
    //@RequestMapping(value = "produceTypes/{id}", method = RequestMethod.PUT)
    public ProduceType update(@PathVariable("id") long id, @RequestBody ProduceType produceType) {
//        ProduceType existingProduceType = produceTypeRepository.getOne(id);
//        BeanUtils.copyProperties(produceType, existingProduceType);

        return produceTypeService.updateProduceType(produceType, id);
        //return produceTypeRepository.saveAndFlush(existingProduceType);
        //return ProduceTypeStub.update(id, produceType);
    }

    @DeleteMapping("/{id}")
    public ProduceType deleteByID(@PathVariable("id") long id) {
        //return ProduceTypeStub.delete(id);
//        ProduceType existingProduceType = produceTypeRepository.getOne(id);
//        produceTypeRepository.delete(existingProduceType);

        return produceTypeService.deleteById(id);
    }

    // delete ProduceType data object using ProduceType object passed in request
    @DeleteMapping
    public void delete(@RequestBody ProduceType produceType) {

        System.out.println("\n**** In delete create bike method **** \n");
        //System.out.println(bike);

        produceTypeService.delete(produceType);
        // produceTypeRepository.delete(produceType);
    }

}
