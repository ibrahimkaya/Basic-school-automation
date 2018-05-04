/*
exam note viewing 
 */
package oto;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author ibrahim
 */
public class notgorme {
    public  void notgor(){
        Scanner al= new Scanner(System.in);
        try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        Statement stmt = con.createStatement( );
        String SQL = "SELECT * FROM APP.DERS";
        ResultSet rs = stmt.executeQuery( SQL );
       //sırası ile not tblosundan notları çekip buray yazıcm sonra gönder 
        System.out.println("numara: ");
        int girilenNumara=al.nextInt();
              rs.next();
      
      while(girilenNumara!=rs.getInt("NUMARA")){
          
          rs.next();
      }
      int nypVize=rs.getInt("NYPVIZE");
      int nypFinal=rs.getInt("NYPFINAL");
      int lojikVize=rs.getInt("NYPFINAL");
      int lojikFinal=rs.getInt("LOJIKFINAL");
      System.out.println("nesneye yönelik programlama vize notu: "+nypVize);
      System.out.println("nesneye yönelik programlama final notu: "+nypFinal);
      System.out.println("lojik devre tasarimi vize notu: "+lojikVize);
      System.out.println("lojik devre tasarimi final notu: "+lojikFinal);
        
       }catch(SQLException err){
            System.out.println( err.getMessage( ) );
      }
    }
}
