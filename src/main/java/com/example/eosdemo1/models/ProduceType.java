package com.example.eosdemo1.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity     // indicate to be converted to JPA
public class ProduceType {

    @Id     // tell JTPA what field is primary key field 
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //JPA entity annotation : database will auto generate primary key of id

    // @javax.persistence.Id
    Long id;
    String prodType;
    String description;
    String photoLink;

    @OneToMany(mappedBy = "producetype")   // "producetype" is name of java field in java class of ProduceItem. IN @JOIN_TO field, same attribute field is refereed to using SQL file field name: "TYPE_ID". Name use in to classes must be different though referring to the same attribute field/column in ProduceItem table/class
    private Set<ProduceItem> prodItems = new HashSet<ProduceItem>();
    
    public ProduceType() {
    }

    public ProduceType(Long id, String prodType, String description, String photoLink) {
        this.id = id;
        this.prodType = prodType;
        this.description = description;
        this.photoLink = photoLink;
    }
   
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public Set<ProduceItem> getProdItems() {
        return prodItems;
    }

    public void setProdItems(Set<ProduceItem> prodItems) {
        this.prodItems = prodItems;
    }

    public void addProdItem(ProduceItem produceItem){
        this.prodItems.add(produceItem);
    }
    @Override
    public String toString() {
        return "ProduceType{" + "id=" + id + ", produceType=" + prodType + ", description=" + description + ", photoLink=" + photoLink + '}';
    }

    
    
}
