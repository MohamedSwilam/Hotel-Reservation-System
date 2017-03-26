package hotel.code;

import static hotel.code.HotelCode.menu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Manger  extends Staff implements ifile, imodify, iLoger, Serializable {
    
    static ArrayList<Receptionist> receptionists=new ArrayList<Receptionist>();

    HashMap<String,Receptionist> user=new HashMap<String,Receptionist>();
     
    public Manger() throws IOException, ClassNotFoundException  {}
    
    public boolean Add_Account(String name,String pass,String tele,int age,String email,String country) throws IOException, ClassNotFoundException{
        ReadFile();
        ReadFile2();
        Receptionist r1=new Receptionist();
        String userName=name+Integer.toString(r1.receptionistId());
        Receptionist r=new Receptionist(name,pass,tele,age,email,country);
        user.put(userName, r);
        receptionists.add(r);
        WriteFile(receptionists);
        WriteFile2(user);
        return true;
    }
    
    public boolean add_safari(String Start_Date,String Start_time,String End_time,double price,int numOfTickets) throws IOException, ClassNotFoundException{
        Safari s1=new Safari();
        s1.ReadFile();
        Safari s=new Safari(Start_Date,Start_time,End_time,price,numOfTickets);
        s1.safariList.add(s);
        s1.WriteFile(s1.safariList);
        return true;
    }
    
    public boolean add_glassboat(String Start_Date,String Start_time,String End_time,double price,int numOfTickets){
       GlassBoat g1=new GlassBoat();
        g1.ReadFile();
        GlassBoat s=new GlassBoat(Start_Date,Start_time,End_time,price,numOfTickets);
        g1.glassBoatList.add(s);
        g1.WriteFile(g1.glassBoatList);
        return true;
    }
    
    public void WriteFile(ArrayList arr2) {
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("Receptionist.bin"));
        bin.writeObject(arr2);
        bin.close();
        }
        catch(Exception e){
            
        }
        }
    
    public void WriteFile2(HashMap user){
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("user.bin"));
        bin.writeObject(user);
        bin.close();
        }
        catch(Exception e){
            
        }
    }
    
    public HashMap ReadFile2(){
        try{
        ObjectInputStream inp=new ObjectInputStream(new FileInputStream("user.bin"));
        user =(HashMap)inp.readObject();
        }
        catch(Exception e){
        }
        return user;
    }
    
    public ArrayList<Receptionist> ReadFile() {
        try{
        ObjectInputStream inp=new ObjectInputStream(new FileInputStream("Receptionist.bin"));
        receptionists =(ArrayList<Receptionist>)inp.readObject();
        
        }
        catch(Exception e){
        
        }
        return receptionists;
    }
    
    public boolean check_id(int id) throws IOException, ClassNotFoundException{
        ReadFile();
        for(int i=0;i<receptionists.size();i++){
            if(id==receptionists.get(i).Get_ID()){
                return true;
            }
        }
        return false;
    }

    public boolean Update_Account(int id,String name,String pass,String tele,int age,String email,String country) throws IOException, ClassNotFoundException{
        Receptionist r=new Receptionist(name,pass,tele,age,email,country);
        ReadFile();
        ReadFile2();
        for(int i=0;i<receptionists.size();i++){
            if(id==receptionists.get(i).Get_ID()){
                user.remove(name);
                user.put(name, r);
                receptionists.set(i, r);
                WriteFile2(user);
                WriteFile(receptionists);
                return true;
            }
        }
        return false;
    }

    public Receptionist Search_Account(int id) throws IOException, ClassNotFoundException{
        Receptionist x=new Receptionist() ;
        ReadFile();
        for(int i=0;i<receptionists.size();i++){
            if(id==receptionists.get(i).Get_ID()){
                return receptionists.get(i);
            }
        }
       return x;
    }
    
    public boolean Delete_Account(int id) throws IOException, ClassNotFoundException{
        ReadFile();
        ReadFile2();
        for(int i=0;i<receptionists.size();i++){
            if(id==receptionists.get(i).Get_ID()){
                user.remove(receptionists.get(i).Get_Name());
                receptionists.remove(i);
                WriteFile(receptionists);
                WriteFile2(user);
                return true;
            }
        }
        return false;
    }
  
    public boolean SignIn(String name,String password){
        String username="manager" ;
        String password2="manager123";
        
            if(name.equals(username)&&password.equals(password2)){
                return true;
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
            Logger.getLogger(Manger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
