// menu 


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import static oto.DersIslemleri.dersGuncelle;


/**
 *
 * @author ibrahim
 */
public class Oto extends giris {

    
    public static void main(String[] args) {
        
        notgorme n=new notgorme();
        giris g=new giris();
        guncelle gncl=new guncelle();
        ogrıslerı ogrisleri=new ogrıslerı();
        ogrlistesi list=new ogrlistesi();
        dersEkle ekle=new dersEkle();
        ogrKayit kayit=new ogrKayit();
        
        Scanner al= new Scanner(System.in);
        try{
        String host = "jdbc:derby://localhost:1527/oto";
        String uName = "admin";
        String uPass= "admin";  
        Connection con = DriverManager.getConnection( host, uName, uPass );
        
      
       Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String SQL = "SELECT * FROM APP.OGRBILGILERI";
        ResultSet rs = stmt.executeQuery( SQL );
       
          
        System.out.println("ogrenci girisi icin  1 seciniz");
        System.out.println("ögrenci isleri girisi icin 2 seciniz");
        int secim=al.nextInt();
        switch(secim){
            case 1:
                //ogrenci işleri 
                  int dogrulama=g.giris();
                  if(dogrulama==1){
                    System.out.println("bilgilerinizi guncellemek icin 1 ");
                     System.out.println("notlarinizi gormek icin 2 yi seciniz ");
                     int ogrsecim=al.nextInt();
                      switch(ogrsecim){
                          case 1:
                              gncl.guncelle();
                              break;
                          case 2:
                              
                              n.notgor();
                              break;
                      }
                  }
                break;
            case 2: 
                //öğrenci işlerinin yetkisi için burası(for admins )
                int dogrulama2=ogrisleri.ogrgiris();
                 if(dogrulama2==1){
                     System.out.println("kayitli ogrenci bilgilerini görmek icin 1");
                     System.out.println("ders notu eklemek icin 2 ");
                     System.out.println("ogrenci kayit icin 3 ");
                     int secim2=al.nextInt();
                     switch(secim2){
                         case 1:
                             list.listele();
                             break;
                         case 2:
                             ekle.dersEkle();
                             break;
                         case 3:
                             kayit.ogrkayit();
                     }
                     
                 }
                break;
        }
        
        
        }catch(SQLException err){
            System.out.println( err.getMessage( ) );
            
        }
        
    }
    
}


