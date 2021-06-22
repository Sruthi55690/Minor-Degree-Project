package com.hexaware.MLP335.model;

import org.junit.Test;
import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;

import com.hexaware.MLP335.factory.CustomerFactory;
import com.hexaware.MLP335.model.Customer;

import com.hexaware.MLP335.persistence.CustomerDAO;
import com.hexaware.MLP335.persistence.DbConnection;

public class CustomerTest {
    private static DbConnection db;
    private CustomerDAO customerDAO;

    @BeforeClass
    public static void setup(){
        db = new DbConnection();
    }
    @Test
    public void testInsert(){
        customerDAO = db.getConnect().onDemand(CustomerDAO.class);
        
        int cusId=8;
        String cusName="Dileep";
        long cusPhone=901025;
        String cusEmail="dileep@gmail.com";
        int currAmt=2000;
        String password="Password";
        Customer cus = new Customer(cusId,cusName,cusPhone,cusEmail,currAmt,password);

        int msg=CustomerFactory.addCustomer(cusId,cusName,cusPhone,cusEmail,currAmt,password);
        int k=1;
        assertEquals(msg,k);
    }
    @Test
    public void testUpdate(){
        customerDAO = db.getConnect().onDemand(CustomerDAO.class);
        
        int cusId=1;
        String cusName="john";
        long cusPhone=123456;
        String cusEmail="john@gmail.com";
        int currAmt=1000;
        String password="NewPassword";
        Customer cus = new Customer(cusId,cusName,cusPhone,cusEmail,currAmt,password);

        int msg=CustomerFactory.updateCustomer(password,cusId);
        int k=1;
        assertEquals(msg,k);
    }
    @Test
    public void testCheck(){
        customerDAO = db.getConnect().onDemand(CustomerDAO.class);
        
        int cusId=2;
        String cusName="joseph";
        long cusPhone=189123;
        String cusEmail="joseph@gmail.com";
        int currAmt=1000;
        String password="def";
        Customer cus = new Customer(cusId,cusName,cusPhone,cusEmail,currAmt,password);

        Customer msg=CustomerFactory.check(cusEmail,password);
        
        assertEquals(msg.getCusId(),cusId);
    }

    @Test
    public void testDisplay(){
        customerDAO = db.getConnect().onDemand(CustomerDAO.class);
        
        int cusId=2;
        String cusName="joseph";
        long cusPhone=189123;
        String cusEmail="joseph@gmail.com";
        int currAmt=1000;
        String password="def";
        Customer cus = new Customer(cusId,cusName,cusPhone,cusEmail,currAmt,password);

        Customer msg=CustomerFactory.displayDetails(cusEmail);
        
        assertEquals(msg.getCusEmail(),cusEmail);
    }
    @Test
    public void testAddMoney(){
        customerDAO = db.getConnect().onDemand(CustomerDAO.class);
        
        int cusId=2;
        String cusName="joseph";
        long cusPhone=189123;
        String cusEmail="joseph@gmail.com";
        int currAmt=1000;
        String password="def";
        Customer cus = new Customer(cusId,cusName,cusPhone,cusEmail,currAmt,password);

        int msg=CustomerFactory.addMoney(200,cusId);
        int k=1;
        assertEquals(msg,k);
    }
    @Test
    public void testDeductMoney(){
        customerDAO = db.getConnect().onDemand(CustomerDAO.class);
        
        int cusId=3;
        String cusName="mike";
        long cusPhone=864233;
        String cusEmail="mike@gmail.com";
        int currAmt=1000;
        String password="xyz";
        Customer cus = new Customer(cusId,cusName,cusPhone,cusEmail,currAmt,password);

        int msg=CustomerFactory.deductAmount(cusId,100);
        int k=1;
        assertEquals(msg,k);
    }

    
   @AfterClass
    public static void tearDown(){
        DbConnection db = new DbConnection();
    }    
}