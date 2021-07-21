# ManageClient
 :::: correr este codigo en tu base de datos MYSQL

    CREATE DATABASE EMPLOYEE;
        USE EMPLOYEE;
        CREATE TABLE CLIENTS (
            ID INT NOT NULL AUTO_INCREMENT, 
            C_NAME VARCHAR(100),
            C_TYPE_NIF VARCHAR(30),
            C_NIF VARCHAR(15),
            C_PHONE VARCHAR(15),
            C_MOBILE VARCHAR(15),
            C_CREATE_DATE DATE,
            C_ID_ADDRESS INT,
            PRIMARY KEY ( ID ));
            
    CREATE TABLE ADDRESS (
            ID INT NOT NULL AUTO_INCREMENT, 
            A_STREET VARCHAR(100),
            A_STREET2 VARCHAR(50),
            A_CITY VARCHAR(15),
            A_STATE VARCHAR(15),
            A_COUNTRY VARCHAR(15),
            A_TYPE_ADDRESS VARCHAR(15),
            A_ID_CLIENT INT,
            PRIMARY KEY ( ID ));
 