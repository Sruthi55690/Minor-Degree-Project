package com.hexaware.MLP335.model;



public class Vendor {
  
  public Vendor() {
  }
  private long venId;
  private String venName;
  private String venPassword;
  
  private int cusId;
  

  
  public Vendor(final long argvenId, final String argvenName, final String argvenPassword, final int argcusId) {
    this.venId = argvenId;
    this.venName = argvenName;
    this.venPassword = argvenPassword;
    
    this.cusId = argcusId;
    
  }

  public final long getVenId() {
    return venId;
  }

 
  public final void setVenId(final Long argvenId) {
    this.venId = argvenId;
  }

 
  public final String getVenName() {
    return venName;
  }


  public final void setVenName(final String argvenName) {
    this.venName = argvenName;
  }

 
  public final String getvenPassword() {
    return venPassword;
  }

  public final void setVenPassword(final String argvenPassword) {
    this.venPassword = argvenPassword;
  }

  
 
  public final int getCusId() {
    return cusId;
  }

  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }


  
  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + cusId;
    
   // result = prime * result + ((venName == null) ? 0 : venName.hashCode());
    //result = prime * result + ((venPassword == null) ? 0 : venPassword.hashCode());
    //result = prime * result + ((venStatus == null) ? 0 : venStatus.hashCode());
    
    return result;
  }

  

  @Override
  public final String toString() {
    return "Vendor [cusId=" + cusId + ", venId=" + venId + ", venName=" + venName + ", venPassword=" + venPassword
        + "]";
  }

}
