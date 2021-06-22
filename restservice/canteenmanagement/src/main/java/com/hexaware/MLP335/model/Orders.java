package com.hexaware.MLP335.model;

import java.util.Date;


public class Orders {
  
  private int ordId;
  private Date ordDate;
  private int foodId;
  private int quantity;
  
  private int cusId;
  
  private String ordStatus;
  
  public Orders() {

  }


  public Orders(final int argOrdId, final Date argOrdDate, final int argFoodId, final int argQuantity,
       final int argCusId, final String argOrdStatus) {
    this.ordId = argOrdId;
    this.ordDate = new Date(argOrdDate.getTime());
    this.foodId = argFoodId;
    this.quantity = argQuantity;
    
    this.cusId = argCusId;
    this.ordStatus = argOrdStatus;
    
  }
  
  
  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + quantity;
    
    return result;
  }
  
  public final int getOrdId() {
    return ordId;
  }
  

  public final void setOrdId(final int argordId) {
    this.ordId = argordId;
  }
   
  public final Date getOrdDate() {
    return new Date(ordDate.getTime());
  }
   
  public final void setOrdDate(final Date argordDate) {
    this.ordDate = new Date(argordDate.getTime());
  }
   
  public final int getFoodId() {
    return foodId;
  }
   

  public final void setFoodId(final int argfoodId) {
    this.foodId = argfoodId;
  }
   
  public final int getQuantity() {
    return quantity;
  }
   

  public final void setQuantity(final int argquantity) {
    this.quantity = argquantity;
  }
   
 
  public final int getCusId() {
    return cusId;
  }
   

  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }
   
  
   
  public final String getOrdStatus() {
    return ordStatus;
  }
  
  public final void setOrdStatus(final String argordStatus) {
    this.ordStatus = argordStatus;
  }


  @Override
  public final String toString() {
    return "Orders [cusId=" + cusId + ", foodId=" + foodId + ", ordDate=" + ordDate
        + ", ordId=" + ordId + ", ordStatus=" + ordStatus + ", quantity=" + quantity + "]";
  }
}






