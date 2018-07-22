/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  eithn
 * Created: 05-Jun-2018
 */


-- CREATE TABLE BIKE(
-- ID INT AUTO_INCREMENT,
-- NAME VARCHAR NOT NULL UNIQUE,
-- EMAIL VARCHAR,
-- MODEL VARCHAR,
-- PHONE VARCHAR,
-- SERIAL_NUMBER VARCHAR,
-- purchase_price DECIMAL,
-- purchase_date DATETIME,
-- CONTACT BOOLEAN
-- );

CREATE TABLE PRODUCE_TYPE(
ID INT AUTO_INCREMENT,
-- ID INT AUTO_INCREMENT,
PROD_TYPE VARCHAR(30),
DESCRIPTION VARCHAR(200),
photo_Link VARCHAR(30),
);

CREATE TABLE PRODUCE_ITEM(
ID INT AUTO_INCREMENT,
NAME VARCHAR(50),
DESCRIPTION VARCHAR(200),
-- PRODUCETYPE VARCHAR(30),
TYPE_ID INT REFERENCES PRODUCE_TYPE (ID),
-- TYPE_ID INT ,
QUANTITY INT,
WEIGHT DOUBLE,
END_OF_SALE_DATE DATETIME,
SELLER_NAME VARCHAR(60),
SELLER_ADDRESS VARCHAR(100),
EMAIL VARCHAR(60),
CONTACT_NO VARCHAR(20),
-- KEY `produce_type_fk` (`type_id`),
-- INDEX (produce_type_type_id),
-- FOREIGN KEY (type_id)
--     REFERENCES produce_type(type_id)
--   CONSTRAINT `produce_type_fk` FOREIGN KEY (`prod_type_id`) REFERENCES `produce_type` (`prod_type_id`)
);

CREATE TABLE users (
  
  username VARCHAR(256) PRIMARY KEY,
  password VARCHAR(256),
  enabled  BOOLEAN
);

CREATE TABLE authorities (
  
  username  VARCHAR(256) REFERENCES users (username),
  authority VARCHAR(256)
);

INSERT INTO users VALUES ('jill', '$2a$04$qUlqAEEYF1YvrpJMosodoewgL6aO.qgHytl2k5L7kdXEWnJsFdxvq',TRUE);
INSERT INTO authorities VALUES ('jill', 'USERS');

INSERT INTO users VALUES ('eithne', '$2a$04$qUlqAEEYF1YvrpJMosodoewgL6aO.qgHytl2k5L7kdXEWnJsFdxvq',TRUE);
INSERT INTO authorities VALUES ('eithne', 'USERS');

