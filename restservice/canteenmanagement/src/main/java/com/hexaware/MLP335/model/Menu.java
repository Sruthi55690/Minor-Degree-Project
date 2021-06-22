package com.hexaware.MLP335.model;


public class Menu {
  private int foodId;
  private  String foodName;
  private int foodCost;
  private int availQuantity;
  

  public Menu() {
  }
  
  public Menu(final int argfoodId, final String argfoodName, final int argfoodCost, final int argquantity) {
    this.foodId = argfoodId;
    this.foodName = argfoodName;
    this.foodCost = argfoodCost;
    this.availQuantity = argquantity;
    
  }
  
  public final int getFoodId() {
    return foodId;
  }

  public final void setFoodId(final int argfoodId) {
    this.foodId = argfoodId;
  }

  public final String getFoodName() {
    return foodName;
  }

  public final void setFoodName(final String argfoodName) {
    this.foodName = argfoodName;
  }

  public final int getFoodCost() {
    return foodCost;
  }

  public final void setFoodCost(final int argfoodCost) {
    this.foodCost = argfoodCost;
  }

  
   
  public final int getAvailQuantity() {
    return availQuantity;
  }
  
  public final void setAvailQuantity(final int argquantity) {
    this.availQuantity = argquantity;
  }



  

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + availQuantity;
    result = prime * result + foodCost;
    return result;
  }

  @Override
  public final String toString() {
    return "Menu [availQuantity=" + availQuantity + ", foodCost=" + foodCost + ", foodId=" + foodId + ", foodName="
        + foodName  + "]";
  }

}

