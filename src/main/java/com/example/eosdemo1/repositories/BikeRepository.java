/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.repositories;

import com.example.eosdemo1.models.Bike;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eithn
 */
public interface BikeRepository extends JpaRepository<Bike, Long>{
    
    List<Bike> findByName(String name);

}
