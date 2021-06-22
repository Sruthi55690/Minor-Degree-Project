package com.hexaware.MLP335.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
//import java.util.Random;
import java.util.Scanner;

import com.hexaware.MLP335.factory.CustomerFactory;

import com.hexaware.MLP335.factory.MenuFactory;
import com.hexaware.MLP335.factory.OrdersFactory;
import com.hexaware.MLP335.factory.VendorFactory;
import com.hexaware.MLP335.model.Customer;
import com.hexaware.MLP335.model.Menu;
import com.hexaware.MLP335.model.Orders;


public class CustomerUtil {

  //private long vid;
  private Date d1;
  private int amount;
  private static int cid=0;
  private static int oid = 1;
  private final Scanner option = new Scanner(System.in, "UTF-8");
  //private LocalDate datetoday = LocalDate.now();
  private String lpagecusemail;
  
  public final void enterPagecus() {
    String spagecusname;
    //String spagedob;
    String spagepass;
    String spagepasscon;
    int spagecusamt;
    String spagecusemail;
    long spagecusphno;
    
    System.out.println("       ======================");
    System.out.println("          Welcome to our Canteen");
    System.out.println("        \nCustomer Version");
    System.out.println("           1.Signup");
    System.out.println("           2.login");
    System.out.println(" \n(Please Signup if you are First time Customer)");
    System.out.println(" \n\nEnter the choice: ");
    int pageoption = option.nextInt();
    switch (pageoption) {
      case 1:
        Customer cus[] = CustomerFactory.showCustomer();
        for (Customer customer : cus) {
          cid = customer.getCusId();

        }
        cid += 1;

        System.out.println("\n\nEnter your  Name: ");
        spagecusname = option.next();
        System.out.println("\nEnter your phone Number: ");
        spagecusphno = option.nextLong();
        
        System.out.println("\nEnter your Email: ");
        spagecusemail = option.next();
        
        System.out.println("\nEnter your current amount: ");
        spagecusamt = option.nextInt();
        System.out.println("\nEnter your NEW Password: ");
        spagepass = option.next();
        System.out.println("\nConfirm your NEW Password: ");
        spagepasscon = option.next();
        System.out.println("\n Your customer id is:"+cid);
        //cid=option.nextInt();
        
      CustomerFactory.addCustomer(cid,spagecusname, spagecusphno, spagecusemail, spagecusamt, spagepasscon);
            System.out.println("\nSignup is Successful");
            System.out.println("\nPlz login to Continue");
            enterPagecus();
         
      break;
      case 2:
        System.out.println("\nEnter user email: ");
        lpagecusemail = option.next();
        System.out.println("\nEnter the Password: ");
        String lpagecuspass = option.next();
        Customer c = CustomerFactory.check(lpagecusemail, lpagecuspass);
        cid = c.getCusId();
        amount = c.getCurrAmt();
        if (c.getCusEmail().equals(lpagecusemail) && c.getpassword().equals(lpagecuspass)) {
          System.out.println("\n\nHello " + lpagecusemail);
          System.out.println("\nStart Ordering your foods");
          cusSettings();
        }
      default:
        System.out.println("");
        break;
    }
  }
  private void cusSettings() {
    System.out.println("-----------------------");
    System.out.println("1. Personel Details");
    System.out.println("2. Wallet Details");
    System.out.println("3. Menu");
    System.out.println("4. Order");
    System.out.println("5. OrderHistory");
    System.out.println("6. Exit");
    cusDetails();
  }
        
  private void cusDetails() {
    try {
      System.out.println("Enter your choice:");
      final int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullDetails();
          break;
        case 2:
          Customer wall = CustomerFactory.displayDetails(lpagecusemail);
          int walletamount = wall.getCurrAmt();
          System.out.println("Current Amount is: " + walletamount);
          System.out.println("Do u want to recharge : (y/n)");
          String opt = option.next();
          if (opt.equals("y") || opt.equals("Y")) {
            System.out.println("Enter the amount you want to add :");
            int answ = option.nextInt();
            CustomerFactory.addMoney(answ, cid);
          }
          break;
        case 3:
          choiceMenu();
          break;
        case 4:
          showFullPlaceorder();
          break;
        case 5:
          showOrdersHistory();
           break;
        case 6:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose any option");
          break;
      }
    } catch (final Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    cusSettings();
  }
  private void showFullPlaceorder() {
    int ofooId;
    int oqua;
    System.out.println("1.Place Order 2.Exit \nEnter the your choice: ");
    final int sfochoice = option.nextInt();
    
    switch (sfochoice) {
      case 1: //for placing order
        Menu[] menu = MenuFactory.showMenu();
        System.out.println("Food_Id" + "\t" + "food_name" + "\t" + "food_Cost");
        for (Menu m : menu) {
          System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getFoodCost());
        }
        System.out.println("\n\n *_* CHOOSE FROM THE ABOVE MENU *_*");
        System.out.println("Enter FoodId: ");
        ofooId = option.nextInt();
        System.out.println("Enter Quantity: ");
        oqua = option.nextInt();
        System.out.println(" Your orderId:"+oid);
        oid +=1;
        //int oid=option.nextInt();

        d1 = new Date();
        OrdersFactory.addOrders(oid,cid, oqua, ofooId, d1);
        
        
        Menu me = MenuFactory.selectMenu(ofooId);
        int finalprice=me.getFoodCost();
        Customer custom = CustomerFactory.displayDetails(lpagecusemail);
        
        amount = custom.getCurrAmt();
        if (oqua <=  me.getAvailQuantity() && amount>finalprice) {
          System.out.println("\nYour Order is Placed... :-)");
          int amountpass = amount - finalprice;
          System.out.println(CustomerFactory.deductAmount(cid, amountpass));
          System.out.println("\nAmmount Left:"+amountpass);
          MenuFactory.updateQuantity(oqua,ofooId);
          OrdersFactory.updateStatus(oid,"Accepted");
         
        }
        else{
          System.out.println("\nYour Order is not Placed... :-)");
          OrdersFactory.updateStatus(oid,"Rejected");
        }

        break;
                
      case 2:
         Runtime.getRuntime().halt(0);
      default:
        System.out.println("Enter a valid option");
        break;
    }
  }

  public final void showOrdersHistory(){
    System.out.println("Order history of customer id:"+cid);
    Orders[] orders = OrdersFactory.showOrders(cid);
    System.out.print("OrderId" + "\t");
    System.out.print("FoodId" + "\t");
    System.out.print("DATE" + "\t");
    System.out.println("STATUS" + "\t");
    for (Orders m : orders) {
      if(m.getCusId()==cid){
        System.out.print(m.getOrdId() + "\t");
        System.out.print(m.getFoodId() + "\t");
        System.out.print(m.getOrdDate() + "\t");
        System.out.println(m.getOrdStatus() + "\t");

      }
    }
  }
    

  // showFullDetails is to display details
  private void showFullDetails() {
    System.out.println("1. display Details");
    System.out.println("2.Update Details");
    System.out.print("Enter the your choice: ");
    final int sgochoice = option.nextInt();
    switch (sgochoice) {
      case 1:

        //final int lpagecusemail = option.nextInt();
        final Customer d = CustomerFactory.displayDetails(lpagecusemail);
        System.out.print("CustomerId" + "\t");
        System.out.print("CustomerName" + "\t");
        System.out.print("CustomerPhoneNumber" + "\t");
        System.out.print("Customeremail" + "\t");
        System.out.println("Amount" + "\t");
        System.out.print(d.getCusId() + "\t");
        System.out.print(d.getCusName() + "\t");
        System.out.print(d.getcusPhone() + "\t");
        System.out.print(d.getCusEmail() + "\t");
        System.out.println(d.getCurrAmt() + "\t");
        break;
      case 2:
        System.out.println("update your PassWord: ");
        String cusPass = option.next();
        CustomerFactory.updateCustomer(cusPass, cid);
        System.out.println("/nUr password has been updated/n");
        break;
      default:
         System.out.println("Enter either 1 or 2");
        break;
    }
  }


  public final void choiceMenu() {
    String ans;
    do {
      System.out.println("** MENU OF OUR CANTEEN**");
      Menu[] me = MenuFactory.showMenu();
          System.out.print("Food_Id" + "\t");
          System.out.print("food_name" + "\t");
          System.out.println("food_Cost" + "\t");
          
          for (Menu m : me) {
            System.out.print(m.getFoodId() + "\t");
            System.out.print(m.getFoodName() + "\t");
            System.out.println(m.getFoodCost() + "\t" + "\t");
            
          }
      
      System.out.println("\nNOT YET DECIDED..?\nWANT TO VIEW MENU AGAIN ? \n \nENTER Y FOR yes & N FOR no :");
      ans = option.next();
    } while (ans.equals("y") || ans.equals("Y"));
  }

  
  
  
}