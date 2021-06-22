package com.hexaware.MLP335.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP335.model.Vendor;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

public class VendorMapper implements ResultSetMapper<Vendor> {
    
  public final Vendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      
    return new Vendor(rs.getLong("VEN_ID"), rs.getString("VEN_NAME"), rs.getString("VEN_PASS"),
     rs.getInt("CUS_ID"));
  }
}
