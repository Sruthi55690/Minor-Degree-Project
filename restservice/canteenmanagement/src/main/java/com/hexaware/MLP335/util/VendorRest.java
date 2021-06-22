package com.hexaware.MLP335.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP335.factory.VendorFactory;
import com.hexaware.MLP335.model.Vendor;



/**
 * displaying vendor details.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns Vendor details.
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] listVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }

    /**
   * Returns Customer details.
   * @return the Customer details
   * @param phno vendor
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/vendetails/{phno}")
  public final Vendor displayVenDetails(@PathParam("phno") final long phno) {
    final Vendor vendor = VendorFactory.displayVendorDetails(phno);
    return vendor;
  }

  /**
   * @param newVendor new vendor
   * @return status.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addVendor")
  public final String addVendor(final Vendor newVendor) {
    String comment = "";
    final int venadd = VendorFactory.addVendor(newVendor.getVenName(), newVendor.getVenId(), newVendor.getvenPassword());
    if (venadd > 0) {
      comment = "{\" value \" : \" Vendor added successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not added  \"}";
    }
    return comment;

  }
  /**
   * @param newVendor new vendor
   * @return vendor
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateVendor")
  public final String updateVendor(final Vendor newVendor) {
    String comment = "";
    //final int carIns = CarFactory.insertCar(newCar);
    final int vendUpdate = VendorFactory.updateVendorr(newVendor.getvenPassword(), newVendor.getVenId());
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" Vendor updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not updated  \"}";
    }
    return comment;

  }




  /**
   * @param venId Vendor details.
   * @param password password
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/checkVendor/{venId}/{password}")
  public final Vendor check(@PathParam("venId") final long venId, @PathParam("password") final String password) {
    final Vendor vendor = VendorFactory.check(venId, password);
    return vendor;
  }
 


}
