package hotel.code;

import static hotel.code.HotelCode.menu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receptionist extends Staff implements ifile, iLoger ,imodify, Serializable  {

    
    private String Book_Room;
    private String GeterateBill;
    private String Login;
    private boolean Accept_Customer_FeedBack;
    
    static ArrayList<Guest> guests=new ArrayList<Guest>();
    
     HashMap<String,Guest> user2=new HashMap<String,Guest>();
/*******************************************************************************/
   Receptionist(String name,String password,String tele,int age,String email,String country) {
       Set_ID(receptionistId());
       Set_Name(name);
       Set_password(password);
       Set_TeleNO(tele);
       Set_Age(age);
       Set_EmailAddress(email);
       Set_Country(country);
       Set_userName(name,receptionistId());
    }

   public Receptionist() {
        
    }
    public int receptionistId(){
        
        try {
            Manger m1=new Manger();
            m1.ReadFile();
            int maxId=0;
            for(int i=0;i<m1.receptionists.size();i++){
                if(m1.receptionists.get(i).Get_ID()>maxId){
                    maxId=m1.receptionists.get(i).Get_ID();
                }
            }
            return maxId+1;
        } catch (Exception e) {
            
        }
        return -1;
    }
    
    public boolean Add_Account(String name,String pass,String tele,int age,String email,String country) throws IOException, ClassNotFoundException{
        ReadFile();
        ReadFile2();
        Guest g1=new Guest();
        String userName=name+Integer.toString(g1.guestId());
        Guest g=new Guest(name,pass,tele,age,email,country);
        user2.put(userName, g);
        guests.add(g);
        WriteFile2(user2);
        WriteFile(guests);
        return true;
    }
    
    public void WriteFile(ArrayList arr) {
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("Guest.bin"));
        bin.writeObject(arr);
        bin.close();
        }
        catch(Exception e){
            
        }
        }
    
    public void WriteFile2(HashMap user){
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("user2.bin"));
        bin.writeObject(user);
        bin.close();
        }
        catch(Exception e){
            
        }
    }
    
    public HashMap ReadFile2(){
        try{
        ObjectInputStream inp=new ObjectInputStream(new FileInputStream("user2.bin"));
        user2 =(HashMap)inp.readObject();
        }
        catch(Exception e){
        }
        return user2;
    }
    
    public ArrayList<Guest> ReadFile() {
        try{
        ObjectInputStream inp=new ObjectInputStream(new FileInputStream("Guest.bin"));
        guests =(ArrayList<Guest>)inp.readObject();
        }
        catch(Exception e){
        
        }
        return guests;
    }
    
    public boolean check_id(int id) throws IOException, ClassNotFoundException{
        ReadFile();
        for(int i=0;i<guests.size();i++){
            if(id==guests.get(i).Get_ID()){
                return true;
            }
        }
        return false;
    }
    
    public boolean Update_Account(int id,String name,String pass,String tele,int age,String email,String country) throws IOException, ClassNotFoundException{
        Guest g=new Guest(name,pass,tele,age,email,country);
        ReadFile();
        ReadFile2();
        for(int i=0;i<guests.size();i++){
            if(id==guests.get(i).Get_ID()){
                user2.remove(name);
                user2.put(name, g);
                guests.set(i, g);
                WriteFile2(user2);
                WriteFile(guests);
                return true;
            }
        }
        return false;
    }
    
    public int save_id(String username){
        ReadFile();
        for(int i=0;i<guests.size();i++){
            if(username.equals(guests.get(i).Get_userName())){
                return guests.get(i).Get_ID();
            }
        }
        return -1;
    }
    
    public boolean payment(int guestId,double payment){
        ReadFile();
        for(int i=0;i<guests.size();i++){
            if(guests.get(i).Get_ID()==guestId){
                if(payment>guests.get(i).Get_finalPrice()){
                    return false;
                }
                else{
                    guests.get(i).Set_finalPrice(-payment);
                    WriteFile(guests);
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public boolean check_payment(int guestId){
        ReadFile();
        for(int i=0;i<guests.size();i++){
            if(guests.get(i).Get_ID()==guestId){
                if(guests.get(i).Get_finalPrice()>0){
                    return false;
                }
                else
                    return true; 
            }
        }
        return false;
    }
    
    public Guest Search_Account(int id) throws IOException, ClassNotFoundException{
        Guest g=new Guest() ;
        ReadFile();
        for(int i=0;i<guests.size();i++){
            if(id==guests.get(i).Get_ID()){
                return guests.get(i);
            }
        }
       return g;
    }
    
    public boolean Delete_Account(int id) throws IOException, ClassNotFoundException{
        ReadFile();
        ReadFile2();
        for(int i=0;i<guests.size();i++){
            if(id==guests.get(i).Get_ID()){
                if(guests.get(i).Get_finalPrice()==0.0){
                user2.remove(guests.get(i).Get_Name());
                guests.remove(i);
                WriteFile(guests);
                WriteFile2(user2);
                return true;
            }
        }
        }
        return false;
    }
    
    public boolean SignIn(String name,String password){
        try {
            Manger x=new Manger();
            x.ReadFile2();
             if(password.equals(x.user.get(name).Get_Password())){
                 return true;
             }
        } catch (IOException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
     }
     
    public void SignOut(){
        try {
            menu();
        } catch (IOException ex) {
            Logger.getLogger(Manger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Receptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

    
}
