/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.contollers;

import com.example.eosdemo1.models.ProduceItem;
import com.example.eosdemo1.repositories.ProduceItemRepository;
import com.example.eosdemo1.services.ProduceItemService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eithn
 */
@RestController
@RequestMapping("api/produceItems")
public class ProduceItemController {
    @Autowired
    private ProduceItemRepository produceItemRepository;
    
    @Autowired
    private ProduceItemService produceItemService;
    
    @GetMapping
    public List<ProduceItem> list(){
    //    return ProduceItemStub.list();
    System.out.println("\n**** In list ProduceItem method **** \n");
        return produceItemService.findAllProduceItems();
//        return produceItemRepository.findAll();
    }
    
    //@RequestMapping(value = "produceItems", method = RequestMethod.POST)
   //     @PostMapping
//    @ResponseStatus(HttpStatus.OK)     // Return OK status 200

    @PostMapping
    public ProduceItem create(@RequestBody ProduceItem produceItem){
        //return ProduceItemStub.create(produceItem);
        // produceItem argument below comes from browser and saVEIT AND RETURN THE SAVED COPY
        System.out.println("\n**** In create ProduceItem method **** \n");
        System.out.println(produceItem);
        return produceItemService.createProduceItem(produceItem);
        // return produceItemRepository.saveAndFlush(produceItem);
    
    }
    
    @GetMapping("/{id}")
    public ProduceItem getByID(@PathVariable ("id") Long id){
        // return ProduceItemStub.get(id);
         System.out.println("\n**** In get by id ProduceItem method. ID = " +id +" **** \n");
         
//         ProduceItem sw = produceItemRepository.getOne(id);
//         System.out.println("sw = " + sw +"\n");
        return produceItemService.findById(id);
//         return sw;
        // return produceItemRepository.getOne(id);
    }
    
    @PutMapping("/{id}")
    //@RequestMapping(value = "produceItems/{id}", method = RequestMethod.PUT)
    public ProduceItem update(@PathVariable("id") long id, @RequestBody ProduceItem produceItem){
//        ProduceItem existingProduceItem = produceItemRepository.getOne(id);
//        BeanUtils.copyProperties(produceItem, existingProduceItem);
        
        
        return produceItemService.updateProduceItem(produceItem, id);
        //return produceItemRepository.saveAndFlush(existingProduceItem);
        //return ProduceItemStub.update(id, produceItem);
    }
    
    @DeleteMapping("/{id}")
    public ProduceItem deleteByID(@PathVariable("id") long id){
        //return ProduceItemStub.delete(id);
//        ProduceItem existingProduceItem = produceItemRepository.getOne(id);
//        produceItemRepository.delete(existingProduceItem);

        return produceItemService.deleteById(id);
    }
    
            // delete ProduceItem data object using produceItem object passed in request
    @DeleteMapping
    public void delete(@RequestBody ProduceItem produceItem){
       
        System.out.println("\n**** In delete create produceItem method **** \n");
        //System.out.println(produceItem);
        
        produceItemService.delete(produceItem);
        // produceItemRepository.delete(produceItem);
    }
    
            // get method to get 1 particular ProduceItem using request parameter of name
        // /api/produceItems/byname?name=John Smith
    @RequestMapping("/byname")
    public List<ProduceItem> getByName(@RequestParam(value="name", defaultValue="World") String name){
        System.out.println("\n**** In get by id produceItem method **** \n");
        
       
        return produceItemService.getByName(name);
        
    }
  
    
}
