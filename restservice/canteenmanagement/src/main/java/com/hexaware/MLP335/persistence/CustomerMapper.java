package com.hexaware.MLP335.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP335.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class CustomerMapper implements ResultSetMapper<Customer> {
    
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
     
    return new Customer(rs.getInt("CUS_ID"), rs.getString("CUS_NAME"),
     rs.getLong("CUS_PHONE"), rs.getString("CUS_EMAIL"),
    rs.getInt("CURR_AMT"), rs.getString("CURR_PASS"));
  }
}

