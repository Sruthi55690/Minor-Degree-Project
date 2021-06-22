package com.hexaware.MLP335.model;

import org.junit.Test;
import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.List;

import com.hexaware.MLP335.factory.VendorFactory;
import com.hexaware.MLP335.model.Vendor;

import com.hexaware.MLP335.persistence.VendorDAO;
import com.hexaware.MLP335.persistence.DbConnection;

public class VendorTest {
    private static DbConnection db;
    private VendorDAO vendorDAO;

    @BeforeClass
    public static void setup(){
        db = new DbConnection();
    }
    @Test
    public void testInsert(){
        vendorDAO = db.getConnect().onDemand(VendorDAO.class);
        
        long venId=1;
        String venName="Sruthi";
        String venPassword="PassSruthi";
        int cusId=1;
  
    Vendor men = new Vendor(venId,venName,venPassword,cusId);

        int msg= VendorFactory.addVendor(venName,venId,venPassword);
        int k=1;
        assertEquals(msg,k);
    }


    @Test
    public void testUpdate(){
    vendorDAO = db.getConnect().onDemand(VendorDAO.class);

    long venId=6;
    String venName="abc";
    String venPassword="NewPassword";
    int cusId=2;

  
    Vendor men = new Vendor(venId,venName,venPassword,cusId);

        int msg = VendorFactory.updateVendorr(venPassword,venId);
        int k=1;
        assertEquals(msg,k);
    }

    @Test
    public void testCheck(){
    vendorDAO = db.getConnect().onDemand(VendorDAO.class);

    long venId=7;
    String venName="def";
    String venPassword="HelloWorld";
    int cusId=5;

  
    Vendor men = new Vendor(venId,venName,venPassword,cusId);

        Vendor msg = VendorFactory.check(venId,venPassword);
        
        assertEquals(msg.getvenPassword(),venPassword);
    }

    @Test
    public void testDisplay(){
    vendorDAO = db.getConnect().onDemand(VendorDAO.class);

    long venId=8;
    String venName="ghi";
    String venPassword="Pass456";
    int cusId=1;

  
    Vendor men = new Vendor(venId,venName,venPassword,cusId);

        Vendor msg = VendorFactory.displayVendorDetails(venId);
        
        assertEquals(msg.getVenId(),venId);
    }


   @AfterClass
    public static void tearDown(){
        DbConnection db = new DbConnection();
    }    
}