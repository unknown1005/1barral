
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class product {
    String forname=  "com.mysql.jdbc.Driver";
   String driver = "jdbc:mysql://localhost/bsit23";
   String us = "root";
   String ps1 ="";
   String name;
   public void add(String p,int qty,float pr){
        try {
            Class.forName(forname);
      PreparedStatement ps = DriverManager.getConnection(driver,us,ps1).prepareStatement("insert into product values(null,?,?,?)");
      ps.setString(1, p);
      ps.setInt(2, qty);
      ps.setFloat(3, pr);
      ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
   public void delete(int id){
        try {
            Class.forName(forname);
            Connection con =DriverManager.getConnection(driver,us,ps1);
            PreparedStatement ps =con.prepareStatement("delete from product where prod_id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
   
   
   
    public void editproduct(int ID,String product,float price){
       try {
            Class.forName(forname);
            Connection con = DriverManager.getConnection(driver,us,ps1);
            PreparedStatement ps = con.prepareStatement("update product set prod_name = ?, prod_price =? where prod_id = ?");
            ps.setString(1, product);
            ps.setFloat(2, price);
            ps.setInt(3,ID);
            ps.executeUpdate();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
   }
    
    
    public void editqty(int id, int qty){
        try {
            Class.forName(forname);
            Connection con = DriverManager.getConnection(driver,us,ps1);
            PreparedStatement ps = con.prepareStatement("update product set prod_quantity = (quantity+?) where prod_id = ?");
            ps.setInt(1, qty);
            ps.setInt(2, id);
       
            ps.executeUpdate();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
   
   
   
   }
   
   

