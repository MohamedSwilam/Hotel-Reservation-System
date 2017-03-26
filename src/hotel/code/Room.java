package hotel.code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements ifile,Serializable{

    private int Room_NO;

    private double Price;
    
    private boolean Reserved;

    private double Size;

    private String Room_View;

    static ArrayList<Room> rooms=new ArrayList<Room>(500);
    
    public Room() {
       
    }
    
    public void hotel_rooms(){
         for(int i=0;i<30;i++){
        Room r=new Room(i+1,2000,350,"beach",false);
        rooms.add(r);
        WriteFile(rooms);
        }
        for(int i=30;i<50;i++){
        Room r=new Room(i+1,1550,350,"pool",false);
        rooms.add(r);
        WriteFile(rooms);
        }
        for(int i=50;i<125;i++){
        Room r=new Room(1+i,1100,240,"beach",false);
        rooms.add(r);
        WriteFile(rooms);
        }
        for(int i=125;i<200;i++){
        Room r=new Room(1+i,800,240,"pool",false);
        rooms.add(r);
        WriteFile(rooms);
        }
        for(int i=200;i<350;i++){
        Room r=new Room(1+i,600,150,"pool",false);
        rooms.add(r);
        WriteFile(rooms);
        }
        for(int i=350;i<500;i++){
        Room r=new Room(1+i,400,150,"beach",false);
        rooms.add(r);
        WriteFile(rooms);
        }
    }
    
    public int get_empty_room(String type,String view){
        ReadFile();
        if(view.equals("pool")){
            if(type.equals("single")){
            for(int i=200;i<350;i++){
                if(rooms.get(i).Get_reserved()==false){
                    return rooms.get(i).Get_Room_NO();
                }
            }
            }
            else if(type.equals("double")){
            for(int i=125;i<200;i++){
                if(rooms.get(i).Get_reserved()==false){
                    return rooms.get(i).Get_Room_NO();
                }
            }
            }
            else if(type.equals("suite")){
            for(int i=30;i<50;i++){
                if(rooms.get(i).Get_reserved()==false){
                    return rooms.get(i).Get_Room_NO();
                }
            }
            }
        }
        else if(view.equals("beach")){
            if(type.equals("single")){
            for(int i=350;i<500;i++){
                if(rooms.get(i).Get_reserved()==false){
                    return rooms.get(i).Get_Room_NO();
                }
            }
            }
            else if(type.equals("double")){
             for(int i=50;i<125;i++){
                if(rooms.get(i).Get_reserved()==false){
                    return rooms.get(i).Get_Room_NO();
                }
            }
            }
            else if(type.equals("suite")){
            for(int i=0;i<30;i++){
                if(rooms.get(i).Get_reserved()==false){
                    return rooms.get(i).Get_Room_NO();
                }
            }
            }
        }
    return -1;
    }
     
    public Room(int no,double price,double size, String view,boolean reserved) {
        Set_Room_No(no);
        Set_Price(price);
        Set_Size(size);
        Set_Room_view(view);
        Set_reserved(reserved);
    }
    
    public void WriteFile(ArrayList arr) {
        try{
        ObjectOutputStream bin =new ObjectOutputStream(new FileOutputStream("room.bin"));
        bin.writeObject(arr);
        bin.close();
        }
        catch(Exception e){
            
        }
        }
    
    public ArrayList<Room> ReadFile(){
    try{
        ObjectInputStream inp=new ObjectInputStream(new FileInputStream("room.bin"));
        rooms =(ArrayList<Room>)inp.readObject();
        }
        catch(Exception e){
        
        }
        return rooms;
    }
    
    public int rooms_statistics(){
        int ctr=0;
        
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).Get_reserved()==true){
                ctr++;
            }
            
        }
    return ctr;
    }
    
      /* ************************************************* */

    public void Set_Room_No(int Room_NO) {
        this.Room_NO=Room_NO;
    }

    public void Set_Price(double Price) {
        this.Price=Price;
    }

    public void Set_Size(double Size) {
        this.Size=Size;
    }

    public void Set_Room_view(String view) {
        this.Room_View=view;
    }
    
    public void Set_reserved(boolean Reserved) {
        this.Reserved=Reserved;
    }

    public int Get_Room_NO() {
       return Room_NO;
    }

    public double Get_Price() {
       return Price;
    }

    public double Get_Size() {
        return Size;
    }  

    public String Get_Room_View() {
        return Room_View;
    }
    
    public boolean Get_reserved(){
        return Reserved;
    }
}
