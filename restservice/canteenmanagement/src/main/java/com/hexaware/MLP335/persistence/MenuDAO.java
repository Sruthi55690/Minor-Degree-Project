package com.hexaware.MLP335.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
//import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.util.List;

//import com.hexaware.MLP335.factory.MenuFactory;
import com.hexaware.MLP335.model.Menu;


public interface MenuDAO {
  
  @SqlQuery("Select * from Menu")
  @Mapper(MenuMapper.class)
  List<Menu> show();

  
  @SqlQuery("Select * from Menu where FOOD_ID = :argId")
  @Mapper(MenuMapper.class)
    Menu selectMenu(@Bind("argId") int argId);

  
  @SqlUpdate("INSERT INTO Menu(FOOD_ID, FOOD_NAME, FOOD_COST,AVAIL_QUANTITY)" + " VALUES (:fId, :fName, :fCost,:fquantity)")
    int insertMenu(@Bind("fId") int fId, @Bind("fName") String fName, @Bind("fCost") int fCost, @Bind("fquantity") int fquantity);


 
  @SqlUpdate("Update Menu set FOOD_COST = :cos where FOOD_ID = :id")
   int updateMenu(@Bind("cos") int cos, @Bind("id") int id);


 
  @SqlUpdate("update MENU set AVAIL_QUANTITY = (AVAIL_QUANTITY - :quan) where FOOD_ID = :fid")
   int updateQuantity(@Bind("quan") int quan, @Bind("fid") int fid);


}

