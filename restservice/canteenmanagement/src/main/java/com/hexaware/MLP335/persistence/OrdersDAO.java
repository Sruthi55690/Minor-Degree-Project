package com.hexaware.MLP335.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP335.model.Customer;
import com.hexaware.MLP335.model.Orders;


public interface OrdersDAO {

  
  @SqlQuery("Select * from Orders where CUS_ID = :cusId")
   @Mapper(OrdersMapper.class)
   List<Orders> show(@Bind("cusId") int cusId);

   
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> showFullOrders();

   
  @SqlQuery("select * from ORDERS where ORD_DATE = (SELECT max(ORD_DATE) FROM ORDERS WHERE CUS_ID = :cusId)")
   @Mapper(OrdersMapper.class)
   Orders genOrdId(@Bind("cusId") int cusId);


   
  @SqlUpdate("insert into ORDERS(ORD_ID,CUS_ID, QUANTITY, FOOD_ID, ORD_DATE) values(:ordId,:cusId, :quantity, :foodId, :orddate)")
   int addOrders(@Bind("ordId") int ordId,@Bind("cusId") int cusId, @Bind("quantity") int quantity, @Bind("foodId") int foodId,
         @Bind("orddate") Date d1);



  
  @SqlQuery("select * from CUSTOMER where CUS_ID =:cid")
  @Mapper(CustomerMapper.class)
    Customer getAmount(@Bind("cid") int cid);

  

  
  @SqlUpdate("Update ORDERS set ORD_STATUS = :ordStatus where ORD_ID = :ordid")
    int orderStatus(@Bind("ordStatus") String ordStatus, @Bind("ordid") int ordid);



}






