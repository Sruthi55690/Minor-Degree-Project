package com.hexaware.MLP335.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

import com.hexaware.MLP335.model.Vendor;

public interface VendorDAO {
   
  @SqlQuery("Select * from vendors")
    @Mapper(VendorMapper.class)
    List<Vendor> show();

    
  @SqlUpdate("Insert into vendors(VEN_ID, VEN_NAME, VEN_PASS)" + "values (:id, :name, :pass)")
    int addVend(@Bind("name") String name, @Bind("id") long id, @Bind("pass") String pass);


  
  @SqlUpdate("update vendors set VEN_PASS = (:pass) where VEN_ID = (:id)")
     int updateVend(@Bind("pass") String pass, @Bind("id") long id);
    
  @SqlQuery("Select * from VENDORS Where VEN_ID= :lpagevenid and VEN_PASS= :lpagevenpass")
  @Mapper(VendorMapper.class)
      Vendor checkvendor(@Bind("lpagevenid") long lpagevenid, @Bind("lpagevenpass") String lpagevenpass);



  @SqlQuery("Select * from VENDORS Where VEN_ID= :phno")
  @Mapper(VendorMapper.class)
    Vendor vendetails(@Bind("phno") long phno);



  


}
