/*
new student insertion
 */
package oto;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author ibrahim
 */
public class ogrKayit {
    public  void ogrkayit(){
        Scanner al=new Scanner(System.in);
          try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
        String sql = "INSERT INTO APP.OGRBILGILERI (NUMARA, AD, SOYAD, MAIL,TEL,SIFRE) VALUES (?, ?, ?, ?,?,?)";
        System.out.println("numara ad soy ad mail telefon sifre giriniz");
        
        System.out.println("soyad: ");
        String soyad=al.nextLine();
        
        System.out.println("mail: ");
        String mail=al.nextLine();
        
        System.out.println("ad: ");
        String ad=al.nextLine();
        
        System.out.println("numara: ");
        int num=al.nextInt();
          
     
        
         System.out.println("telefon: ");
        int tel=al.nextInt();
        
       
        System.out.println("sifre: ");
        int sif=al.nextInt();
        
     
        
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, num);
        statement.setString(2, ad);
        statement.setString(3, soyad);
        statement.setString(4, mail);
        statement.setInt(5, tel);
        statement.setInt(6, sif);
 
int rowsInserted = statement.executeUpdate();
if (rowsInserted > 0) {
    System.out.println("ogrenci ekleme basarili");
}
        
        
          }catch(SQLException err){
            System.out.println( err.getMessage( ) );
      }
    }
}
