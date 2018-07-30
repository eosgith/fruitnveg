/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author eithn
 */
@Entity     // indicate to be converted to JPA
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ordertable")
public class OrderRecord {
    // @Id     // tell JTPA what field is primary key field 

    private Long id;
    private ProduceItem produceItem;
    private float itemPrice;
    private float totalOrderCost;
    private String username;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy")
    Date orderDate;
//    private UserInfo userId;
    private String userId;
    private String orderStatus;      // "pending"; "complete"
    private boolean emailSent;
    private Date timestamp;

    public OrderRecord() {
        this.orderStatus = "SUBMITTED";
        System.out.println("in 0 param constructor for orderrec");
    }

//    public OrderRecord(Long id, ProduceItem produceItem, float itemPrice, float totalOrderCost, UserInfo userId) {
    public OrderRecord(Long id, ProduceItem produceItem, float itemPrice, float totalOrderCost, String username, String userId) {
        this.id = id;
        this.produceItem = produceItem;
        this.itemPrice = itemPrice;
        this.totalOrderCost = totalOrderCost;
        this.username = username;
//        this.userId = userId;
        this.orderStatus = "SUBMITTED";
        this.emailSent = false;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //JPA entity annotation : database will auto generate primary key of id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDEREDITEM_ID")
    // "producetype" is name of java field in java class of ProduceItem. IN @JOIN_TO field, same attribute field is refereed to using SQL file field name: "TYPE_ID". Name use in to classes must be different though referring to the same attribute field/column in ProduceItem table/class. Sucess in getting server to run.

    public ProduceItem getProduceItem() {
        return produceItem;
    }

    public void setProduceItem(ProduceItem produceItem) {
        this.produceItem = produceItem;
    
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public float getTotalOrderCost() {
        return totalOrderCost;
    }

    public void setTotalOrderCost(float totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//        @OneToOne
//    @JoinColumn(name="USER_ID")
//    // "USER_ID" is name of java field in java class of ProduceItem. IN @JOIN_TO field, same attribute field is refereed to using SQL file field name: "USER_ID". Name use in to classes must be different though referring to the same attribute field/column in ProduceItem table/class. Sucess in getting server to run.
////    @JsonBackReference
//    public UserInfo getUserId() {
    public String getUserId() {
        return userId;
    }
//
//    public void setUserId(UserInfo userId) {
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }

//    public UserInfo getUserId() {
//        return userId;
//    }
//
//    public void setUserId(UserInfo userId) {
//        this.userId = userId;
//    }

    @Column(name = "timestamp")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "OrderRecord{" + "id=" + id + ", produceItem=" + produceItem + ", itemPrice=" + itemPrice + ", totalOrderCost=" + totalOrderCost + ", username=" + username + ", orderDate=" + orderDate + ", userId=" + userId + ", orderStatus=" + orderStatus + ", emailSent=" + emailSent + ", timestamp=" + timestamp + '}';
    }

}
