
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class LogIn {
    String forname=  "com.mysql.jdbc.Driver";
   String driver = "jdbc:mysql://localhost/bsit23";
   String us = "root";
   String ps1 ="";
   String name;
   
   public int Enter(String uname, String pword){int x=0;
       try {
           Class.forName(forname);
           Connection con = DriverManager.getConnection(driver,us,ps1);
           PreparedStatement pss = con.prepareStatement("Select * from user where username = ? and password = md5(?)");
           pss.setString(1, uname);
           pss.setString(2,pword );
           ResultSet rs = pss.executeQuery();
           if(rs.next()){
               x=1;
               name = rs.getString("first_name")+" "+rs.getString("last_name");
           }else{
               x=-1;
           }
           
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(register_class.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(register_class.class.getName()).log(Level.SEVERE, null, ex);
       }return x;
   }
}
