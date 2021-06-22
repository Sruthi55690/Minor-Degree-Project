package com.hexaware.MLP335.model;


import java.util.Date;


public class Customer {

  private int cusId;
  private String cusName;
  private long cusPhone;
  private String cusEmail;
  private int currAmt;
  private String password;
  

  public Customer() {
  }
  
  public Customer(final int argcusId, final String argcusName,
      final long argcusPhone,  final String argcusEmail, final int argcurrAmt,
      final String argpassword) {
    this.cusId = argcusId;
    this.cusName = argcusName;
    this.cusPhone = argcusPhone;
    this.cusEmail = argcusEmail;
    this.currAmt = argcurrAmt;
    this.password = argpassword;
  }
  
  @Override
    public final int hashCode() {
    final int prime = 31;
    long result = 1;
    //result = prime * result + ((cusAddr == null) ? 0 : cusAddr.hashCode());
    //result = prime * result + ((cusEmail == null) ? 0 : cusEmail.hashCode());
    //result = prime * result + ((cusId == null) ? 0 : cusId.hashCode());
    //result = prime * result + ((cusName == null) ? 0 : cusName.hashCode());
    result = prime * result + cusPhone;
    return (int) result;
  }

  public final int getCusId() {
    return cusId;
  }

  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }

  public final String getCusName() {
    return cusName;
  }

  public final void setCusName(final String argcusName) {
    this.cusName = argcusName;
  }

  public final long getcusPhone() {
    return cusPhone;
  }
  

  public final void setCusPhone(final Long argcusPhone) {
    this.cusPhone = argcusPhone;
  }

  
  
 
  
  public final String getCusEmail() {
    return cusEmail;
  }

  public final void setCusEmail(final String argcusEmail) {
    this.cusEmail = argcusEmail;
  }
  
  public final int getCurrAmt() {
    return currAmt;
  }

  public final void setCurrAmt(final int argcurrAmt) {
    this.currAmt = argcurrAmt;
  }
  
  public final String getpassword() {
    return password;
  }

  public final void setpassword(final String argpassword) {
    this.password = argpassword;
  }
 
}

