/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eosdemo1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private ProduceItem produceitem;
    private float itemPrice;
    private float orderTotal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy")
    Date orderDate;
//    private User userId;
    private String userId;
    private String orderStatus;      // "pending"; "complete"
    private boolean emailSent;

    public OrderRecord() {
    }

//    public OrderRecord(Long id, ProduceItem produceitem, float itemPrice, float orderTotal, User userId) {
    public OrderRecord(Long id, ProduceItem produceitem, float itemPrice, float orderTotal, String userId) {
        this.id = id;
        this.produceitem = produceitem;
        this.itemPrice = itemPrice;
        this.orderTotal = orderTotal;
        this.userId = userId;
        this.orderStatus = "pending";
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
    
    public ProduceItem getProduceitem() {
        return produceitem;
    }

    public void setProduceitem(ProduceItem produceitem) {
        this.produceitem = produceitem;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

//    @OneToOne
//    @JoinColumn(name="USER_ID")
    // "USER_ID" is name of java field in java class of ProduceItem. IN @JOIN_TO field, same attribute field is refereed to using SQL file field name: "USER_ID". Name use in to classes must be different though referring to the same attribute field/column in ProduceItem table/class. Sucess in getting server to run.
//    @JsonBackReference
//    public User getUserId() {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
//    public void setUserId(User userId) {
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

    @Override
    public String toString() {
        return "OrderRecord{" + "id=" + id + ", produceitem=" + produceitem + ", itemPrice=" + itemPrice + ", orderTotal=" + orderTotal + ", orderDate=" + orderDate + ", userId=" + userId + ", orderStatus=" + orderStatus + ", emailSent=" + emailSent + '}';
    }

}
