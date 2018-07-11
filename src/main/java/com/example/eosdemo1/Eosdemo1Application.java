package com.example.eosdemo1;

import com.example.eosdemo1.models.ProduceItem;
import com.example.eosdemo1.models.ProduceType;
import com.example.eosdemo1.services.ProduceItemService;
import com.example.eosdemo1.services.ProduceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// created with SPRING INITIALIZER and
//  -  Full stack web with TOMCAT and SPRING MVC,
//  - SPRING SECURITY
//  - SQL - MYSQL
//  - SQL - H2 database
//  - SPRING DEVTOOLS
//  - FLYWAY
//  - MAVEN
//  - JAVA
//  - SPRING SESSION (?WHAT GIVE, NEED?)
//    JPA

@SpringBootApplication
public class Eosdemo1Application {

    @Autowired
    private ProduceItemService produceItemService;
    
    @Autowired
    private ProduceTypeService produceTypeService;
    
	public static void main(String[] args) {
		SpringApplication.run(Eosdemo1Application.class, args);
	}
        
        
        
    public void run(String... strings) {

        
        
       
        ProduceType prodty = new ProduceType(null, "peas", "peas vegtable", null);
        
        ProduceItem item = new ProduceItem();
        
        item.setName("peas");
        item.setProducetype(prodty);
        
        produceItemService.createProduceItem(item);
       
        
        System.out.println(item.getProducetype());
    }
//        @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }

}
