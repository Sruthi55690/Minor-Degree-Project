package com.hexaware.MLP335.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP335.model.Menu;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class MenuMapper implements ResultSetMapper<Menu> {
   
  public final Menu map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      
    return new Menu(rs.getInt("FOOD_ID"), rs.getString("FOOD_NAME"),
    rs.getInt("FOOD_COST"), rs.getInt("AVAIL_QUANTITY"));
  }
}
