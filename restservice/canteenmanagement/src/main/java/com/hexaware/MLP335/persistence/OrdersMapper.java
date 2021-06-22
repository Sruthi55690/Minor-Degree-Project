package com.hexaware.MLP335.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP335.model.Orders;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class OrdersMapper implements ResultSetMapper<Orders> {
    
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
     
    return new Orders(rs.getInt("ORD_ID"), rs.getDate("ORD_DATE"),
     rs.getInt("FOOD_ID"), rs.getInt("QUANTITY"), rs.getInt("CUS_ID"),
     rs.getString("ORD_STATUS"));
  }
}



