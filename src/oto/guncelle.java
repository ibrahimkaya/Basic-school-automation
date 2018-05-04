/*
updating exam grade 
 */
package oto;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author ibrahim
 */
public class guncelle {
    public  void guncelle(){
                Scanner al= new Scanner(System.in);
                int secim;
        try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
           System.out.println("ogrenci numaranızı giriniz: ");
        int ogrno=al.nextInt();
       String sql = "UPDATE APP.OGRBILGILERI SET SIFRE=? where NUMARA="+ogrno;
 
PreparedStatement statement = con.prepareStatement(sql);
         
       
        
        System.out.println("mail icin 1 , telefon no icin 2 ,sifre icin 3 giriniz");
        secim=al.nextInt();
        switch(secim){
            case 1:
              mail(ogrno);
                break;
            case 2:
                tel(ogrno);
                
                break; 
            case 3:
                System.out.println("yeni sifrenizi giriniz: ");
                int sifre;
                sifre = al.nextInt();
                statement.setInt(1,sifre);
                break;
        }
        
        int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("guncelleme basarili");
}
        
        }catch(SQLException err){
            System.out.println( err.getMessage( ) );
      }
        
        
        
    }
    
    static void  tel(int ogrno){
        
                   Scanner al= new Scanner(System.in);
                
        try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
          
       String sql = "UPDATE APP.OGRBILGILERI SET TEL=? where NUMARA="+ogrno;
 
PreparedStatement statement = con.prepareStatement(sql);

System.out.println("yeni telefon no: ");
                int telno=al.nextInt();
                statement.setInt(1,telno);
    int rowsUpdated = statement.executeUpdate();
    }catch(SQLException err){
            System.out.println( err.getMessage( ) );
}
        
    }
    
    static void  mail(int ogrno){
        
                   Scanner al= new Scanner(System.in);
                
        try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
          
       String sql = "UPDATE APP.OGRBILGILERI SET MAIL=? where NUMARA="+ogrno;
 
PreparedStatement statement = con.prepareStatement(sql);

System.out.println("yeni mail: ");
                String mail=al.nextLine();
                statement.setString(1,mail);
int rowsUpdated = statement.executeUpdate();
    }catch(SQLException err){
            System.out.println( err.getMessage( ) );
}
        
    }
    
}
//there are various glitch