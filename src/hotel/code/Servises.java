package hotel.code;

import java.io.Serializable;

public abstract class Servises implements Serializable{

    private String Name;

    private int Tele_No;
    
    private String Start_Date;
    
    private String Start_time;

    private String End_time;
    
    private double price;
    
    private int NO_OF_TICKETS=0;

    public Servises() {
    }

    public void set_Name(String name) {
        Name=name;
    }

    public void Set_Tele_NO(int Tele) {
        Tele_No=Tele;
    }
    
    public void Set_StartDate(String date) {
        Start_Date=date;
    }
    
    public void Set_price(double cost){
        price=cost;
    }

    public void Set_EndTime(String time) {
        End_time=time;
    }
    
    public void Set_StartTime(String time) {
        Start_time=time;
    }
    
    
    
    public void Set_noOfTickets(int num){
        NO_OF_TICKETS+=num;
    }

    public String Get_Name() {
        return Name;
    }

    public int Get_Tele_NO() {
        return Tele_No;
    }
    
    public String Get_Start_Date() {
        return Start_Date;
    }

    public String Get_EndTime() {
        return End_time;
    }
    
     public String Get_StartTime() {
        return Start_time;
    }
     
     public int Get_noOfTickets(){
        return NO_OF_TICKETS;
    }
    
    public double Get_price(){
        return price;
    }
}
