package com.hexaware.MLP335.factory;

import com.hexaware.MLP335.persistence.OrdersDAO;
import com.hexaware.MLP335.persistence.DbConnection;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.hexaware.MLP335.model.Orders;

public class OrdersFactory {
  
  protected OrdersFactory() {

  }

  
  private static OrdersDAO dao() {
    final DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

 
  public static Orders[] showOrders(final int cusId) {
    final List<Orders> orders = dao().show(cusId);
    return orders.toArray(new Orders[orders.size()]);
  }



  
  public static Orders gettOrdId(final int cId) {
    Orders i = dao().genOrdId(cId);
    return i;
  }

 
  public static int addOrders(final int ordId,final int cusId, final int quantity, final int afoodId, final Date d1) {
    int i = dao().addOrders(ordId,cusId, quantity, afoodId, d1);
    return i;
  }

 
  public static int updateStatus( final int oid,final String status) {
    int i = dao().orderStatus(status,oid);
    return i;
  }
  

  
  public static Orders[] showFullOrders() {
    final List<Orders> orders = dao().showFullOrders();
    return orders.toArray(new Orders[orders.size()]);
  }

}


