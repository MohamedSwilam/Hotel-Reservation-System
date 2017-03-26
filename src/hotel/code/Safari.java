package hotel.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Safari extends Servises implements ifile, Serializable{

    private int id;
    
 static public ArrayList<Safari> safariList=new ArrayList<Safari>(); 

    public Safari() {
        
    }
    
    public Safari(String Start_Date,String start_time,String End_time,double price,int num) {
        Set_StartDate(Start_Date);
        Set_StartTime(start_time);
        Set_EndTime(End_time);
        Set_price(price);
        Set_id();
        Set_noOfTickets(num);
    }

    
    
    public ArrayList<Safari> ReadFile(){
         
        try{
            
            ObjectInputStream inp=new ObjectInputStream(new FileInputStream("SafariTrips.bin"));
            safariList =(ArrayList<Safari>)inp.readObject();
             
        }
        catch(Exception e){
         
        }
     return safariList;
    }
    
    public void WriteFile(ArrayList s){
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("SafariTrips.bin"));
        bin.writeObject(s);
        bin.close();
        }
        catch(Exception e){
            
        }
    }

    public void Set_id(){
        try{
        ReadFile();
        id=safariList.size()+1;
        }catch(Exception e){
            
        }
    }
    
     public int Get_id(){
        return id;
    }
}
