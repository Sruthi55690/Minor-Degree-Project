package com.hexaware.MLP335.model;

import org.junit.Test;
import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;

import com.hexaware.MLP335.factory.MenuFactory;
import com.hexaware.MLP335.model.Menu;

import com.hexaware.MLP335.persistence.MenuDAO;
import com.hexaware.MLP335.persistence.DbConnection;

public class MenuTest {
    private static DbConnection db;
    private MenuDAO menuDAO;

    @BeforeClass
    public static void setup(){
        db = new DbConnection();
    }
    @Test
    public void testInsert(){
        menuDAO = db.getConnect().onDemand(MenuDAO.class);
        
         int foodId=8;
         String foodName="idly";
         int foodCost=100;
         int availQuantity=200;
  
        Menu men = new Menu(foodId,foodName,foodCost,availQuantity);

        int msg=MenuFactory.insertMenu(foodId,foodName,foodCost,availQuantity);
        int k=1;
        assertEquals(msg,k);
    }


    @Test
    public void testUpdate(){
        menuDAO = db.getConnect().onDemand(MenuDAO.class);
        
         int foodId=2;
    String foodName="sandwich";
  int foodCost=200;
   int availQuantity=200;
  
        Menu men = new Menu(foodId,foodName,foodCost,availQuantity);

        int msg=MenuFactory.updateMenu(foodCost,foodId);
        int k=1;
        assertEquals(msg,k);
    }

   @AfterClass
    public static void tearDown(){
        DbConnection db = new DbConnection();
    }    
}