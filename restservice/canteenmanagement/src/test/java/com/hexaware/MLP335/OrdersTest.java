package com.hexaware.MLP335.model;

import org.junit.Test;
import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;

import com.hexaware.MLP335.factory.OrdersFactory;
import com.hexaware.MLP335.model.Orders;

import com.hexaware.MLP335.persistence.OrdersDAO;
import com.hexaware.MLP335.persistence.DbConnection;
import java.util.Date;


public class OrdersTest {
    private static DbConnection db;
    private OrdersDAO ordersDAO;
    private Date d1 = new Date();
    @BeforeClass
    public static void setup(){
        db = new DbConnection();
    }
    @Test
    public void testInsert(){
        ordersDAO = db.getConnect().onDemand(OrdersDAO.class);
        int ordId=5;
        Date ordDate=d1;
        int foodId=1;
        int quantity=20;
        int cusId=3;
        String ordStatus="Accepted";
  
        Orders men = new Orders(ordId,ordDate,foodId,quantity,cusId,ordStatus);

        int msg=OrdersFactory.addOrders(ordId,cusId, quantity,foodId,ordDate);
        int k=1;
        assertEquals(msg,k);
    }


    @Test
    public void testUpdate(){
        ordersDAO = db.getConnect().onDemand(OrdersDAO.class);
        int ordId=1;
        Date ordDate=d1;
        int foodId=1;
        int quantity=10;
        int cusId=7;
        String ordStatus="Rejected";
        
        Orders men = new Orders(ordId,ordDate,foodId,quantity,cusId,ordStatus);
        int msg=OrdersFactory.updateStatus(ordId,ordStatus);
        int k=1;
        assertEquals(msg,k);
    }

   @AfterClass
    public static void tearDown(){
        DbConnection db = new DbConnection();
    }    
}