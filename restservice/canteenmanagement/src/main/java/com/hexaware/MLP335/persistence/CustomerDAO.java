package com.hexaware.MLP335.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP335.model.Customer;


public interface CustomerDAO {
  
  @SqlQuery("Select * from Customer")
  @Mapper(CustomerMapper.class)
  List<Customer> show();

  
  @SqlUpdate("Insert into Customer (CUS_ID,CUS_NAME, CUS_PHONE, CUS_EMAIL, CURR_AMT,CURR_PASS)"
      + "value(:id, :name, :phno,  :email, :amt, :passcon)")
  int addCustomer(@Bind("id") int id,@Bind("name") String name, @Bind("phno") Long phno,
      @Bind("email") String email, @Bind("amt") int amt, @Bind("passcon") String passcon);


  @SqlUpdate("update Customer set CURR_PASS = (:uppass) WHERE CUS_ID = (:upid)")
  int updateCustomer(@Bind("uppass")String uppass, @Bind("upid")int upid);
  
  @SqlQuery("Select * from CUSTOMER Where CUS_EMAIL= :cusemail and CURR_PASS= :cuspass")
  @Mapper(CustomerMapper.class)
    Customer checkCustomer(@Bind("cusemail") String cusemail, @Bind("cuspass") String cuspass);


  @SqlQuery("Select * from CUSTOMER Where CUS_EMAIL= :email")
  @Mapper(CustomerMapper.class)
    Customer customerDetails(@Bind("email") String email);


  @SqlUpdate("update CUSTOMER set CURR_AMT = (CURR_AMT + :money) where CUS_ID = :cusid")
    int addMoney(@Bind("money") int money, @Bind("cusid") int cusid);

  

  @SqlUpdate("update CUSTOMER set CURR_AMT = :finalprice where CUS_ID = :cid")
    int updateWallet(@Bind("finalprice") int finalprice, @Bind("cid") int cid);


}
