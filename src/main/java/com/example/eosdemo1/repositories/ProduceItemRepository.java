/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.repositories;

import com.example.eosdemo1.models.ProduceItem;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eithn
 */
public interface ProduceItemRepository extends JpaRepository<ProduceItem, Long> {
    List<ProduceItem> findByName(String name);
    
    List<ProduceItem> findBySellerName(String sellername);
    
    List<ProduceItem> findByEndOfSaleDateAfter(Date todaysDate);
    
}
