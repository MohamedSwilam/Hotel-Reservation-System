package hotel.code;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable{
    
    ArrayList<Room> arr2=new ArrayList<Room>();
    

    public Reservation() {}
    
    public boolean checkRoomNo(int roomNo){
       if(roomNo>=1&&roomNo<=500){
           return true;
       }
       return false;
   }
    
    public boolean checkout(int roomNo){
        Room r1=new Room();
       if(roomNo>=1&&roomNo<=30){
          r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==true){
              r1.Set_reserved(false);
              r1.Set_Room_No(roomNo);
              r1.Set_Price(2000);
              r1.Set_Size(r1.rooms.get(roomNo-1).Get_Size());
              r1.Set_Room_view(r1.rooms.get(roomNo-1).Get_Room_View());
              r1.rooms.set(roomNo-1, r1);
              r1.WriteFile(r1.rooms);
              return true;
          }
       }
       if(roomNo>=31&&roomNo<=50){
          r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==true){
              r1.Set_reserved(false);
              r1.Set_Room_No(roomNo);
              r1.Set_Price(1550);
              r1.Set_Size(r1.rooms.get(roomNo-1).Get_Size());
              r1.Set_Room_view(r1.rooms.get(roomNo-1).Get_Room_View());
              r1.rooms.set(roomNo-1, r1);
              r1.WriteFile(r1.rooms);
              return true;
          }
       }
       if(roomNo>=51&&roomNo<=125){
          r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==true){
              r1.Set_reserved(false);
              r1.Set_Room_No(roomNo);
              r1.Set_Price(1100);
              r1.Set_Size(r1.rooms.get(roomNo-1).Get_Size());
              r1.Set_Room_view(r1.rooms.get(roomNo-1).Get_Room_View());
              r1.rooms.set(roomNo-1, r1);
              r1.WriteFile(r1.rooms);
              return true;
          }
       }
       if(roomNo>=126&&roomNo<=200){
          r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==true){
              r1.Set_reserved(false);
              r1.Set_Room_No(roomNo);
              r1.Set_Price(800);
              r1.Set_Size(r1.rooms.get(roomNo-1).Get_Size());
              r1.Set_Room_view(r1.rooms.get(roomNo-1).Get_Room_View());
              r1.rooms.set(roomNo-1, r1);
              r1.WriteFile(r1.rooms);
              return true;
          }
       }
       if(roomNo>=201&&roomNo<=350){
          r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==true){
              r1.Set_reserved(false);
              r1.Set_Room_No(roomNo);
              r1.Set_Price(600);
              r1.Set_Size(r1.rooms.get(roomNo-1).Get_Size());
              r1.Set_Room_view(r1.rooms.get(roomNo-1).Get_Room_View());
              r1.rooms.set(roomNo-1, r1);
              r1.WriteFile(r1.rooms);
              return true;
          }
       }
       if(roomNo>=351&&roomNo<=500){
          r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==true){
              r1.Set_reserved(false);
              r1.Set_Room_No(roomNo);
              r1.Set_Price(400);
              r1.Set_Size(r1.rooms.get(roomNo-1).Get_Size());
              r1.Set_Room_view(r1.rooms.get(roomNo-1).Get_Room_View());
              r1.rooms.set(roomNo-1, r1);
              r1.WriteFile(r1.rooms);
              return true;
          }
       }
       return false;
    }
    
    public boolean checkAvilableSafariTickets(int numOfTickets,int SafariId) throws IOException, ClassNotFoundException{
        Safari s1=new Safari();
        s1.ReadFile();
        for(int i=0;i<s1.safariList.size();i++){
            if(s1.safariList.get(i).Get_id()==SafariId){
                if(s1.safariList.get(i).Get_noOfTickets()>=numOfTickets){
                return true;
            }
            }
        }
    return false;
    }
    
    public boolean checkAvilableGlassboatTickets(int numOfTickets,int GlassboatId) throws IOException, ClassNotFoundException{
        GlassBoat g1=new GlassBoat();
        g1.ReadFile();
        for(int i=0;i<g1.glassBoatList.size();i++){
            if(g1.glassBoatList.get(i).Get_id()==GlassboatId){
                if(g1.glassBoatList.get(i).Get_noOfTickets()>=numOfTickets){
                return true;
            }
            }
        }
    return false;
    }
    
    public boolean ReserveRoom(int roomNo,int no_of_nights,int guestId){
       Room r1=new Room();
       boolean found=false;
       Receptionist res=new Receptionist();
       res.ReadFile();
       r1.ReadFile();
          if(r1.rooms.get(roomNo-1).Get_reserved()==false){
              for(int i=0;i<res.guests.size();i++){
                  if(guestId==res.guests.get(i).Get_ID()){
                      res.guests.get(i).Set_finalPrice(r1.rooms.get(roomNo-1).Get_Price()*no_of_nights);
                      res.guests.get(i).Set_reservedrooms(Integer.toString(roomNo));
                      found=true;
                      break;
                    }
               }
              if(found==true){
                  r1.Set_reserved(true);
                  r1.rooms.set(roomNo-1, r1);
                  r1.WriteFile(r1.rooms);
                  res.WriteFile(res.guests);
                  return true;
              }
              else
                  return false;
          }
          else 
              return false;
   }
    
    public boolean ResrveGym(int no_of_months,int guestid){
        Receptionist r1=new Receptionist();
        Gym s1=new Gym();
        r1.ReadFile();
        for(int i=0;i<r1.guests.size();i++){
                  if(guestid==r1.guests.get(i).Get_ID()){
                      if(r1.guests.get(i).Get_gym_service()==false){
                      r1.guests.get(i).Set_gym_service(true);
                      r1.guests.get(i).Set_finalPrice(s1.get_price()*no_of_months);
                      r1.guests.get(i).Set_reserved_gym(no_of_months);
                      r1.WriteFile(r1.guests);
                      return true;
                      }
            }
        }
        return false;
    }
    
    public boolean ReserveSafari(int SafariId,int guestId,int noOfTickets){
        try{
            Receptionist r1=new Receptionist();
            Safari s1=new Safari();
            s1.ReadFile();
            r1.ReadFile();
            for(int i=0;i<s1.safariList.size();i++){
                if(s1.safariList.get(i).Get_id()==SafariId){
                    if(s1.safariList.get(i).Get_noOfTickets()>=noOfTickets){
                    for(int j=0;j<r1.guests.size();j++){
                        if(guestId==r1.guests.get(j).Get_ID()){
                            s1.safariList.get(i).Set_noOfTickets(-noOfTickets);
                            r1.guests.get(j).Set_safari_service(true);
                            r1.guests.get(j).Set_finalPrice(s1.safariList.get(i).Get_price()*noOfTickets);
                            r1.WriteFile(r1.guests);
                            s1.WriteFile(s1.safariList);
                            return true;
                        }
                    }
                }
                }
            }
        }catch(Exception e){
          return false;  
        }
        return false;
    }
    
    public boolean ReserveGlassBoat(int GlassBoatId,int guestId,int noOfTickets){
        try{
            GlassBoat g1=new GlassBoat();
            Receptionist r1=new Receptionist();
            g1.ReadFile();
            r1.ReadFile();
            for(int i=0;i<g1.glassBoatList.size();i++){
                if(g1.glassBoatList.get(i).Get_id()==GlassBoatId){
                    if(g1.glassBoatList.get(i).Get_noOfTickets()>=noOfTickets){
                    for(int j=0;j<r1.guests.size();j++){
                        if(guestId==r1.guests.get(j).Get_ID()){
                            g1.glassBoatList.get(i).Set_noOfTickets(-noOfTickets);
                            r1.guests.get(j).Set_safari_service(true);
                            r1.guests.get(j).Set_finalPrice(g1.glassBoatList.get(i).Get_price()*noOfTickets);
                            r1.WriteFile(r1.guests);
                            g1.WriteFile(g1.glassBoatList);
                            return true;
                        }
                    }
                }
                }
            }
        }catch(Exception e){
          return false;  
        }
        return false;
    }
    
    public double get_total_price(int id){
        Receptionist r=new Receptionist();
        r.ReadFile();
        for(int i=0;i<r.guests.size();i++){
            if(id==r.guests.get(i).Get_ID()){
                return r.guests.get(i).Get_finalPrice();
            }
        }
        return -1;
    }
    
    public String get_reserved_rooms(int id){
        Receptionist r=new Receptionist();
        r.ReadFile();
        for(int i=0;i<r.guests.size();i++){
            if(id==r.guests.get(i).Get_ID()){
                return r.guests.get(i).Get_reservedrooms();
            }
        }
        return "Failed!";
    }
    
    public int get_reserved_gym(int id){
        Receptionist r=new Receptionist();
        r.ReadFile();
        for(int i=0;i<r.guests.size();i++){
            if(id==r.guests.get(i).Get_ID()){
                return r.guests.get(i).Get_reserved_gym();
            }
        }
        return -1;
    }
}
