
package com.hexaware.MLP335.factory;

import com.hexaware.MLP335.persistence.CustomerDAO;
import com.hexaware.MLP335.persistence.DbConnection;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP335.model.Customer;

public class CustomerFactory {
 
  protected CustomerFactory() {

  }
  
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }
  
  public static int addCustomer(final int id,final String name, final Long phno, final String email, final int amt, final String passcon) {
    int i =  dao().addCustomer(id,name, phno, email, amt, passcon);
    return i;
  }
  
  public static int updateCustomer(final String uppass, final int upid) {
    int i = dao().updateCustomer(uppass, upid);
    return i;
  }
  
  public static Customer check(final String lpagecusemail, final String lpagecuspass) {
    Customer c = dao().checkCustomer(lpagecusemail, lpagecuspass);
    return c;
  }

  
  public static Customer displayDetails(final String email) {
    Customer d = dao().customerDetails(email);
    return d;
  }


   
  public static int addMoney(final int money, final int cusId) {
    int i = dao().addMoney(money, cusId);
    return i;
  }
  
  
 
  public static int deductAmount(final int cid, final int finalprice) {
    int i = dao().updateWallet(finalprice,cid);
    return i;
  }




}








