/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.repositories;

import com.example.eosdemo1.models.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eithne O'Sullivan (student ID: 17132185)
 * @date 18Jul18
 */
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Long> {
    //List<ProduceItem> findByName(String name);
}
