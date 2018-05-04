/*
authorized person login page
 */
package oto;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author ibrahim
 */
public class ogrıslerı {
    public  int ogrgiris(){
         int girilenNumara,girilenSifre,tempNum=0;
          int dogruSifre=0;
      Scanner al=new Scanner(System.in);
      System.out.println("numara ");
      girilenNumara=al.nextInt();
     
      System.out.println("sifre: ");
      girilenSifre=al.nextInt();
      
      try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
      
       Statement stmt = con.createStatement( );
      String sorgu="SELECT * FROM APP.OGRISLERI";
      ResultSet sf=stmt.executeQuery(sorgu);
      sf.next();
      
      while(girilenNumara!=sf.getInt("NUMARA")){
          
          sf.next();
      }
      
      System.out.println(tempNum+girilenNumara);
       dogruSifre=sf.getInt("SIFRE");
     
   
    
      }catch(SQLException err){
            System.out.println( err.getMessage( ) );
      }
        
          if(dogruSifre==girilenSifre)
      {
          System.out.println("giris basarili");
          return 1;
      }else{
          System.out.println("sifre yanlis tekrar giriniz");
          return 0;
      }
        
    }
    
}
