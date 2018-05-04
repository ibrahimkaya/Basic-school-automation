/*
just update lecture that was already created in data base 
 */
package oto;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author ibrahim
 */
public class dersEkle {
    public  void dersEkle(){
         Scanner al=new Scanner(System.in);
          try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
        String sql = "INSERT INTO APP.DERS (NUMARA, NYPVIZE,NYPFINAL,LOJIKVIZE,LOJIKFINAL) VALUES (?, ?, ?, ?,?)";
        
        System.out.println("ogrenci numarasi: ");
        int num=al.nextInt();
        System.out.println("not: ogrencinin o derse ait aldıgı notu yok ise bos giriniz.");
        System.out.println("nesneye yonelik programlama vize notu: ");
        int nypv=al.nextInt();
        System.out.println("nesneye yonelik programlama final notu: ");
        int nypf=al.nextInt();
        System.out.println("lojik devre tasarimi vize notu: ");
        int ldtv=al.nextInt();
        System.out.println("lojik devre tasrimi final notu: ");
        int ldtf=al.nextInt(); 
        
          PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, num);
        statement.setInt(2, nypv);
        statement.setInt(3, nypf);
        statement.setInt(4, ldtv);
        statement.setInt(5, ldtf);
        
 
int rowsInserted = statement.executeUpdate();
if (rowsInserted > 0) {
    System.out.println("islem basarili");
}
        
          }catch(SQLException err){
            System.out.println( err.getMessage( ) );
    }
}
}
