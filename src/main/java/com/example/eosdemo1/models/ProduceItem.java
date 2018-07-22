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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity     // indicate to be converted to JPA
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProduceItem{

    //@javax.persistence.Id
    private Long id;
    private String name;
    private String description;

    
    private ProduceType producetype;
//    private String producetype;
    private Integer quantity;
    private Double weight;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private Date endOfSaleDate;
    private String sellerName;
    private String email;
    private String sellerAddress;
    private String contactNo;

    public ProduceItem() {
    }

    public ProduceItem(Long id, String name, String description, ProduceType producetype, Integer quantity, Double weight, Date endOfSaleDate, String sellerName, String email, String sellerAddress, String contactNo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.producetype = producetype;
        this.quantity = quantity;
        this.weight = weight;
        this.endOfSaleDate = endOfSaleDate;

        this.sellerName = sellerName;
        this.email = email;
        this.sellerAddress = sellerAddress;
        this.contactNo = contactNo;
    }
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="TYPE_ID")
    // "producetype" is name of java field in java class of ProduceItem. IN @JOIN_TO field, same attribute field is refereed to using SQL file field name: "TYPE_ID". Name use in to classes must be different though referring to the same attribute field/column in ProduceItem table/class. Sucess in getting server to run.
   
    public ProduceType getProducetype() {
        return producetype;
    }

    public void setProducetype(ProduceType producetype) {
        this.producetype = producetype;
    }

   
//    public String getProducetype() {
//        return producetype;
//    }
//
//    public void setProducetype(String producetype) {
//        this.producetype = producetype;
//    }
    
    
 
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getEndOfSaleDate() {
        return endOfSaleDate;
    }

    public void setEndOfSaleDate(Date endOfSaleDate) {
        this.endOfSaleDate = endOfSaleDate;
    }

     public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

       @Override
    public String toString() {
        return "ProduceItem{" + "id=" + id + ", name=" + name + ", description=" + description + ", producetype=" + producetype + ", quantity=" + quantity + ", weight=" + weight + ", endOfSaleDate=" + endOfSaleDate + ", sellerName=" + sellerName + ", email=" + email + ", sellerAddress=" + sellerAddress + ", contactNo=" + contactNo + '}';
    }
    



    

    
    
}
