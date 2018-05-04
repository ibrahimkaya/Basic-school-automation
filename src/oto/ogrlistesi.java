/*
 student list 
 */
package oto;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author ibrahim
 */
public class ogrlistesi {
    public  void listele(){
        Scanner al= new Scanner(System.in);
        try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
       
       Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM APP.OGRBILGILERI";
        ResultSet rs = stmt.executeQuery( SQL );
        while(rs.next()){
        int numaratutucu = rs.getInt("NUMARA");
        String first_name = rs.getString("AD");
        String soy_isim=rs.getString("SOYAD");
        System.out.println( numaratutucu + " " + first_name + " " + soy_isim );
        }
        }catch(SQLException err){
            System.out.println( err.getMessage( ) );
      }
    }
}

