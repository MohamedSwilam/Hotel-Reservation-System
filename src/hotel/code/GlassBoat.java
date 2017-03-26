package hotel.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GlassBoat extends Servises implements ifile,Serializable{

    int id;
    
    static public ArrayList<GlassBoat> glassBoatList=new ArrayList<GlassBoat>(); 

    public GlassBoat() {
    }
    
     public GlassBoat(String Start_Date,String start_time,String End_time,double price,int num) {
        Set_StartDate(Start_Date);
        Set_StartTime(start_time);
        Set_EndTime(End_time);
        Set_price(price);
        Set_id();
        Set_noOfTickets(num);
    }
     
    
     public void Set_id(){
        try{
        ReadFile();
        id=glassBoatList.size()+1;
        }catch(Exception e){
            
        }
    }
    
     public ArrayList<GlassBoat> ReadFile(){
        try{
           
        ObjectInputStream inp=new ObjectInputStream(new FileInputStream("glassBoat.bin"));
        glassBoatList =(ArrayList<GlassBoat>)inp.readObject();
        
        }
        catch(Exception e){
        
        }
        return glassBoatList;
    }
    
     public void WriteFile(ArrayList s){
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("glassBoat.bin"));
        bin.writeObject(s);
        bin.close();
        }
        catch(Exception e){
            
        }
    }
    
     public int Get_id(){
        return id;
    }

     
}

