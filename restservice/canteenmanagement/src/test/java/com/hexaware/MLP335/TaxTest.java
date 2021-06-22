package com.hexaware.MLP335.model;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;

import com.hexaware.MLP335.factory.TaxFactory;
import com.hexaware.MLP335.model.Tax;

import com.hexaware.MLP335.persistence.TaxDao;
import com.hexaware.MLP335.util.VendorUtil;
import com.hexaware.MLP335.persistence.DbConnection;

public class TaxTest {
    private static DbConnection db;
    private TaxDao TaxDao;

    @BeforeClass
    public static void setup(){
        db = new DbConnection();
    }

    @Ignore
    public void testInsert(){
        TaxDao = db.getConnect().onDemand(TaxDao.class);
        
         int venId = 2;
         int venWallet = 1000;
         int taxTotal = 50;
  
    Tax men = new Tax(venId,venWallet,taxTotal);

        int msg= TaxFactory.insertTax(venId,venWallet,taxTotal);
        int k=1;
        assertEquals(msg,k);
    }


    @Ignore
    public void testUpdate(){
        TaxDao = db.getConnect().onDemand(TaxDao.class);

        int venId = 1;
         int venWallet = 100;
         int taxTotal = 5;

  
    Tax men = new Tax(venId,venWallet,taxTotal);

        int msg = TaxFactory.updateTax(venId,venWallet,taxTotal);
        int k=1;
        assertEquals(msg,k);
    }
    

    @Ignore
    public void testDisplay(){
        TaxDao = db.getConnect().onDemand(TaxDao.class);
        
        int venId = 1;
         int venWallet = 1000;
         int taxTotal = 50;

        Tax men = new Tax(venId,venWallet,taxTotal);

        Tax msg = TaxFactory.showTaxdetails(venId);
        assertEquals(msg.getvenId(),venId);
    }
      

    
   @AfterClass
    public static void tearDown(){
        DbConnection db = new DbConnection();
    }    
}