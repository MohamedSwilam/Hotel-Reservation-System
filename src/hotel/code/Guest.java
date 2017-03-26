package hotel.code;


import static hotel.code.HotelCode.menu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guest extends Human implements iPay, iLoger, Serializable {

    private double FinalPrice=0;
    private boolean Gym=false;
    private boolean safariTrip=false;
    private String reservedRooms="";
    private int reserved_gym=0;
    public Guest() {}
   Guest(String name,String password,String tele,int age,String email,String country) {
       Set_ID(guestId());
       Set_Name(name);
       Set_password(password);
       Set_TeleNO(tele);
       Set_Age(age);
       Set_EmailAddress(email);
       Set_Country(country);
       Set_finalPrice(Get_finalPrice());
       Set_gym_service(Get_gym_service());
       Set_safari_service(Get_safari_service());
       Set_userName(name,guestId());
       Set_reservedrooms(Get_reservedrooms());
       Set_reserved_gym(Get_reserved_gym());
    }
   
    public int guestId(){
        try {
            Receptionist r1=new Receptionist();
            r1.ReadFile();
            int maxId=0;
            for(int i=0;i<r1.guests.size();i++){
                if(r1.guests.get(i).Get_ID()>maxId){
                    maxId=r1.guests.get(i).Get_ID();
                }
            }
            return maxId+1;
        } catch (Exception e) {
            
        }
        return -1;
    }
  
    public boolean SignIn(String name,String password){
        Receptionist r=new Receptionist();
        r.ReadFile2();
        if(password.equals(r.user2.get(name).Get_Password())){
            return true;
        }
         
         return false;
    }
   
    public void SignOut(){
        try {
            menu();
        } catch (IOException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* ****************************************************************************** */
    
    public void Set_finalPrice(double x) {
        FinalPrice += x;
    }

    public double Get_finalPrice() {
        return FinalPrice;
    }
    
    public void Set_reservedrooms(String roomId){
        reservedRooms+=roomId+" ";
    }
    
    public String Get_reservedrooms(){
        return reservedRooms;
    }

    public void Set_gym_service(boolean x) {
        Gym = x;
    }

    public boolean Get_gym_service() {
        return Gym;
    }
    public void Set_safari_service(boolean x) {
        safariTrip = x;
    }

    public boolean Get_safari_service() {
        return safariTrip;
    }
    
    public void Set_reserved_gym(int x) {
        reserved_gym += x;
    }

    public int Get_reserved_gym() {
        return reserved_gym;
    }

   
    public void creditcard(int id,double price) {
        Receptionist r1=new Receptionist();
        r1.guests.get(id).Set_finalPrice(-price);
         r1.WriteFile(r1.guests);
    }

  
    public void cash(int id,double price) {
        Receptionist r1=new Receptionist();
        r1.guests.get(id).Set_finalPrice(-price);
        r1. WriteFile(r1.guests);
    }

   
    public void cheque(int id,double price) {
        Receptionist r1=new Receptionist();
        r1.guests.get(id).Set_finalPrice(-price);
        r1.WriteFile(r1.guests);
    }
}
