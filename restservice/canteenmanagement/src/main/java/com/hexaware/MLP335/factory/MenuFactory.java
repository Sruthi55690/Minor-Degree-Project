package com.hexaware.MLP335.factory;

import com.hexaware.MLP335.persistence.MenuDAO;
import com.hexaware.MLP335.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP335.model.Menu;

public class MenuFactory {
  
  protected MenuFactory() {

  }
  
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  
  public static Menu[] showMenu() {
    List<Menu> me = dao().show();
    return me.toArray(new Menu[me.size()]);
  }
  
  public static Menu selectMenu(final int foodId) {
    Menu menu = dao().selectMenu(foodId);
    //System.out.println(menu.getFoodName());
    return menu;
  }
  
  //Scanner sc=new Scanner(System.in);
  public static int insertMenu(final int fid, final String fname, final int fcost, final int fquantity) {

    int i = dao().insertMenu(fid, fname, fcost, fquantity);
    return i;
  }
  
  public static int updateMenu(final int fcost, final int fid) {
    int i = dao().updateMenu(fcost, fid);
    return i;
  }


  



  
  public static int updateQuantity(final int quan, final int fid) {
    int i = dao().updateQuantity(quan, fid);
    return i;
  }
 
  public static int selectMenuprice(final int foodId) {
    Menu u = dao().selectMenu(foodId);
    int i = u.getFoodCost();
    return i;
  }
}
