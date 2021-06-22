
package com.hexaware.MLP335.util;

import java.util.Scanner;

import com.hexaware.MLP335.factory.MenuFactory;
import com.hexaware.MLP335.factory.OrdersFactory;
import com.hexaware.MLP335.factory.VendorFactory;
import com.hexaware.MLP335.model.Orders;
import com.hexaware.MLP335.model.Vendor;



public class VendorUtil {

  private long vid;
  

  private final Scanner option = new Scanner(System.in, "UTF-8");
  //private LocalDate datetoday = LocalDate.now();
  
  public final void enterPageven() {
    String spagevenname;
    long spagevenid;
    String spagevenpass;
    String spagevenpasscon;
    //int spagecusamt;

    System.out.println("       ======================");
    System.out.println("          Welcome to Canteen");
    System.out.println("          \nVendor Version");
    System.out.println("           1.Signup");
    System.out.println("           2.login");
    System.out.println("           3.Exit");
    System.out.println(" \n(Please Signup if you are New Vendor)");
    System.out.println(" \n\nEnter the choice: ");
    int pageoption = option.nextInt();
    switch (pageoption) {
      case 1:
        System.out.println("\n\nEnter ur Name :");
        spagevenname = option.next();
        System.out.println("\n\nEnter ur Phone Number (phone num will be your vendor id ): ");
        spagevenid = option.nextLong();
        System.out.println("\nEnter ur NEW Password: ");
        spagevenpass = option.next();
        System.out.println("\nConfirm ur NEW Password: ");
        spagevenpasscon = option.next();
        if (spagevenpass.equals(spagevenpasscon)) {
          VendorFactory.addVendor(spagevenname, spagevenid, spagevenpasscon);
        }
        System.out.println("\nSignup is Successful");
        System.out.println("\nPlz login to Continue");
        enterPageven();
        break;
      case 2:
        System.out.println("\nEnter user venid: ");
        long lpagevenid = option.nextLong();
        System.out.println("\nEnter the Password: ");
        String lpagevenpass = option.next();
        Vendor v = VendorFactory.check(lpagevenid, lpagevenpass);
        if (v.getVenId() == lpagevenid && v.getvenPassword().equals(lpagevenpass)) {
          System.out.println("Hello " + lpagevenid);
          System.out.println("\nGreat to see you \n");
          vid = v.getVenId();
          showFullVendor();
        }
        break;
      case 3:
        Runtime.getRuntime().halt(0);
      default :
        System.out.println("Enter correct choice");
        break;
    }
  }
  private void showFullVendor() {
    //long venId;
    //String venName;
    String venPa;
    System.out.println("1.Update VendorPassword");
    System.out.println("2.Menu");
    System.out.println("3.Vendor Details");
    System.out.println("4.Show Orders");
    System.out.println("5.Exit");
    System.out.print("Enter the your choice: ");
    final int sfmchoice = option.nextInt();
    switch (sfmchoice) {
      case 1:
        System.out.println("Enter VendorPassword: ");
        venPa = option.next();
        final int k = VendorFactory.updateVendorr(venPa, vid);
        if (k > 0) {
          System.out.println("Updated Successfully");
        }
        showFullVendor();
        break;
      case 2:
        vendorMenu();
        break;
      case 3:
        final Vendor[] vendor = VendorFactory.showVendor();
        System.out.print("cus_Id" + "\t");
        
        System.out.print("Ven_Id" + "\t");
       
        System.out.println("Ven_Name" + "\t");
        for (final Vendor v : vendor) {
          System.out.print(v.getCusId() + "\t");
          
          System.out.print(v.getVenId() + "\t");
          
          System.out.println(v.getVenName() + "\t" + "\t");

        }
        showFullVendor();
        break;
      case 4:
        Orders[] ord = OrdersFactory.showFullOrders();
        System.out.print("OrderId" + "\t");
        System.out.print("FoodId" + "\t");
        
        System.out.print("quantity" + "\t");
        System.out.print("cusId" + "\t");
        System.out.print("DATE" + "\t");
        System.out.println("STATUS" + "\t");
        
        for (Orders fo : ord) {
          System.out.print(fo.getOrdId() + "\t");
          System.out.print(fo.getFoodId() + "\t");
          
          System.out.print(fo.getQuantity() + "\t" + "\t");
          System.out.print(fo.getCusId() + "\t");
          System.out.print(fo.getOrdDate() + "\t");
          System.out.println(fo.getOrdStatus() + "\t");
        }
        break;
          
      case 5:
        Runtime.getRuntime().halt(0);

      default:
        System.out.println("");
        break;
    }

  }
  private void vendorMenu() {
    int foodId;
    String foodNam;
    int foodCos;
    int i;
    CustomerUtil cusUtil = new CustomerUtil();
    System.out.println("1.Add Menu");
    System.out.println("2.Display Menu");
    System.out.println("3.Update Menu");
    System.out.print("Enter the your choice: ");
    final int sfmchoice = option.nextInt();
    switch (sfmchoice) {
      case 1:
        System.out.println("Enter FoodId: ");
        foodId = option.nextInt();
        System.out.println("Enter FoodName: ");
        foodNam = option.next();
        System.out.println("Enter FoodCost: ");
        foodCos = option.nextInt();
        System.out.println("Enter food quantity: ");
        int foodquan = option.nextInt();
        i = MenuFactory.insertMenu(foodId, foodNam, foodCos, foodquan);
        if (i > 0) {
          System.out.println("inserted..");
        } else {
          System.out.println("not inserted...");
        }
        showFullVendor();
        break;
      case 2:
        cusUtil.choiceMenu();
        showFullVendor();
        break;
      case 3:
        System.out.println("Enter FoodId: ");
        foodId = option.nextInt();
        System.out.println("Enter FoodCost: ");
        foodCos = option.nextInt();
        i = MenuFactory.updateMenu(foodCos, foodId);
        if (i > 0) {
          System.out.println("updated..");
        } else {
          System.out.println("not updated...");
        }
        showFullVendor();
        break;
      default:
        break;
    }

  }
}
