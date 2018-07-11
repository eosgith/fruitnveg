/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.repositories;

import com.example.eosdemo1.models.ProduceType;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eithn
 */
public interface ProduceTypeRepository extends JpaRepository<ProduceType, Long> {
    
}
