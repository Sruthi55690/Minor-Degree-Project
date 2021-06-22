package com.hexaware.MLP335.factory;

import com.hexaware.MLP335.persistence.VendorDAO;
import com.hexaware.MLP335.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP335.model.Vendor;

public class VendorFactory {
  
  protected VendorFactory() {

  }
  
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }

  
  public static int addVendor(final String name, final long id, final String pass) {
    int i = dao().addVend(name, id, pass);
    return i;
  }


  
  public static int updateVendorr(final String pass, final long id) {
    int k = dao().updateVend(pass, id);
    return k;
  }
  
  public static Vendor check(final long lpagevenid, final String lpagevenpass) {
    Vendor v = dao().checkvendor(lpagevenid, lpagevenpass);
    return v;
  }
  
  public static Vendor displayVendorDetails(final long phno) {
    Vendor v = dao().vendetails(phno);
    return v;
  }
   
  


}
