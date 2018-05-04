/*
 updating grades for some lecture ,need improvments 
 just update lecture that was already created in data base 
 */
package oto;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author ibrahim
 */
public class DersIslemleri {
    public static void  dersGuncelle(){
        Scanner al=new Scanner(System.in);
        
        try{
            
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
        
        System.out.println("notunu güncellemek istediginiz ogrenci numarasini giriniz");
        int girilenNo=al.nextInt();
        System.out.println("nyp vize 1 final 2 , lojik vize 3 final 4 giriniz");
        int x=al.nextInt();
        switch(x){
            case 1:
                System.out.println("nyp vize notunu giriniz: ");
                int fv=al.nextInt();
                
                String  sql   = "update APP.DERS set NYPVIZE='"+fv+"' where NUMARA="+girilenNo;
       int rowsAffected  = stmt.executeUpdate(sql);
                
                break;
            case 2:
                String sin="insert INTO APP.DERS "+"VALUES ("+girilenNo+" ,'','','','') ";
                stmt.executeUpdate(sin);
                break;
        }
    }
    catch(SQLException er){
            System.out.println( er.getMessage( ) );
            
        }
}
}