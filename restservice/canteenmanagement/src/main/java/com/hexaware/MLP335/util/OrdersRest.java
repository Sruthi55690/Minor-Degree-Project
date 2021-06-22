package com.hexaware.MLP335.util;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP335.model.Orders;


import com.hexaware.MLP335.factory.OrdersFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orders")
public class OrdersRest {
  /**
   * Returns order details.
   * @return the order details.
   * @param cusid for.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/listorders/{cusid}")
  public final Orders[] listOrders(@PathParam("cusid") final int cusid) {
    final Orders[] orders = OrdersFactory.showOrders(cusid);
    return orders;
  }

    /**
   * Returns order details.
   * @return the order details.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/fullorders")
  public final Orders[] listFullOrders() {
    final Orders[] orders = OrdersFactory.showFullOrders();
    return orders;
  }
 /**
   * Returns order details.
   * @return the order details
   * @param newOrders orders are return.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/placeOrder")
  public final String insertOrders(final Orders newOrders) {
    String comment = "";
    final int ordIns = OrdersFactory.addOrders(newOrders.getOrdId(),newOrders.getCusId(),newOrders.getQuantity(),newOrders.getFoodId(),newOrders.getOrdDate());
    if (ordIns > 0) {
      comment = "{\" value \" : \" Order added successfully \"}";
    }
      else {
      comment = "{\" value \" : \" Order not added  \"}";
      
    }
    return comment;

  }
  
  /**
   * Returns order details.
   * @return the order details.
   * @param cusid for orders.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getordid/{cusid}")
  public final Orders  gettOrdId(@PathParam("cusid") final int cusid) {
    final Orders i = OrdersFactory.gettOrdId(cusid);
    return i;
  }

   
    /**
   * Returns order details.
   * @return the order details
   * @param status order.
   * @param ordId order id.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatestatus/{status}/{ordId}")
  public final String  updateStatus(@PathParam("status") final String status, @PathParam("ordId") final int ordId) {
    String comment = "";
    final int updatestatus = OrdersFactory.updateStatus(ordId,status);
    if (updatestatus > 0) {
      comment = "{\" value \" : \"  updated status  successfully \"}";
    } else {
      comment = "{\" value \" : \" status not updated  \"}";
    }

    return comment;

  }
  


}
