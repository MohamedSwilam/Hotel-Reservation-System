
package hotel.code;
import hotel.gui.*;

import java.io.IOException;
import java.io.Serializable;
import javax.swing.JFrame;


public class HotelCode implements Serializable{

    public static void menu()  throws IOException, ClassNotFoundException, InterruptedException
    {
        HomeScreen First=new HomeScreen();
        First.setVisible(true);
        First.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myserver s1=new myserver();
        s1.run();
        /*
        Receptionist R1=new Receptionist();
        Guest G1=new Guest();
        Manger M1=new Manger();
        Room r1=new Room();
        Reservation res=new Reservation();
        Safari s1=new Safari();
        GlassBoat g1=new GlassBoat();
        Scanner input = new Scanner(System.in);
        System.out.println("1.Login as manager \n2.Login as receptionest \n3.Login as guest \n");
        int x = input.nextInt();
        if (x==1){
            System.out.println("Please enter the name");
            String namex = input.next();
            System.out.println("Please enter the password");
            String passx=input.next();
            
            if(M1.SignIn(namex,passx)==true){
            System.out.println("1.Add receptionest \n2.Edit receptionest \n3.Delete receptionest \n4.Search receptionest \n5.Add service \n6.Generate/reset rooms file \n7.Sign-out");
            int y = input.nextInt();
            switch (y){
                case 1:
                System.out.println("Please enter the name");
                String name = input.next();
                System.out.println("Please enter the password");
                String pass=input.next();
                System.out.println("Please enter Telephone Number");
                int tele = input.nextInt();
                System.out.println("Please enter Age");
                int age = input.nextInt();
                System.out.println("Please enter Email");
                String email = input.next();
                System.out.println("Please enter country");
                String country=input.next();
                if( M1.Add_Account(name,pass,tele,age,email,country)==true){
                    System.out.println("Receptionist added..ID is: "+(R1.receptionistId()-1)+" and Username is: "+name+(R1.receptionistId()-1));
                 System.out.println("");
                }
                else{
                 System.out.println("Receptionist Not Added");
                }
                break;
            case 2:
                System.out.println("Please enter ID");
                int id2 = input.nextInt();
                if(M1.check_id(id2)==true){
                System.out.println("Please enter the name");
                String name2 = input.next();
                System.out.println("Please enter the password");
                String pass2=input.next();
                System.out.println("Please enter Telephone Number");
                int tele2 = input.nextInt();
                System.out.println("Please enter Age");
                int age2 = input.nextInt();
                System.out.println("Please enter Email");
                String email2 = input.next();
                System.out.println("Please enter country");
                String country2=input.next();
                if(M1.Update_Account(id2,name2,pass2,tele2,age2,email2,country2)==true)
                    System.out.println("Receptionist Updated");
                else
                 System.out.println("Receptionist Not Updated");
                }
                else
                    System.out.println("ID not Found!");
                break;
            case 3:
                System.out.println("Please enter ID");
                int id5 = input.nextInt();
                if(M1.check_id(id5)==true){
                if(M1.Delete_Account(id5)==true){
                    System.out.println("Deleted");
                }
                else
                    System.out.println("Failed to delete!");
                }
                else
                    System.out.println("ID not Found!");
                break;
            case 4:
                System.out.println("Please enter ID");
                int id4 = input.nextInt();
                if(M1.check_id(id4)==true){
                     System.out.println("ID       : "+ M1.Search_Account(id4).Get_ID());
                     System.out.println("Name     : "+ M1.Search_Account(id4).Get_Name());
                     System.out.println("Password : "+ M1.Search_Account(id4).Get_Password());
                     System.out.println("Age      : "+ M1.Search_Account(id4).Get_Age());
                     System.out.println("Email    : "+ M1.Search_Account(id4).Get_EmailAddress());
                     System.out.println("Mobile   : "+ M1.Search_Account(id4).Get_PhoneNumber());
                     System.out.println("country  : "+ M1.Search_Account(id4).Get_Country());
                }
                else
                    System.out.println("ID not Found!");
                break;
            case 5:
                System.out.println("1.Add Safari trip \n2.Add Glass boat trip");
                int as = input.nextInt();
                switch(as){
                    case 1:
                        System.out.println("Please enter Start date: ");
                        String SD = input.next();
                        System.out.println("Please enter Start time: ");
                        String ST = input.next();
                        System.out.println("Please enter end time: ");
                        String ET = input.next();
                        System.out.println("Please enter the price: ");
                        double price=input.nextDouble();
                        System.out.println("Please enter number of tickets: ");
                        int num=input.nextInt();
                        if(M1.add_safari(SD,ST,ET, price,num)==true){
                            System.out.println("Safari Trip added");
                        }
                        else{
                             System.out.println("Failed!");
                        }
                        break;
                    case 2:
                        System.out.println("Please enter Start date:");
                        String SD2 = input.next();
                        System.out.println("Please enter Start time:");
                        String ST2 = input.next();
                        System.out.println("Please enter end time: ");
                        String ET2 = input.next();
                        System.out.println("Please enter the price");
                        double price2=input.nextDouble();
                        System.out.println("Please enter number of tickets: ");
                        int num2=input.nextInt();
                        if(M1.add_glassboat(SD2,ST2,ET2,price2,num2)==true){
                            System.out.println("Glassboat Trip added");
                        }
                        else{
                             System.out.println("Failed!");
                        }
                        break;
                }
                
                break;
            case 6:
                r1.hotel_rooms();
                break;
            case 7:
                M1.SignOut();
                break;
            default:
                System.err.println("You have entered the wrong number");
                menu();
        }
            
            }
            else{
                System.err.println("Wrong name or password!");
                    }
        }
        else if(x==2){
            System.out.println("Please enter the username");
            String namex = input.next();
            System.out.println("Please enter the password");
            String passx=input.next();
            
            if(R1.SignIn(namex,passx)==true){
            System.out.println("1.Add Guest \n2.Edit Guest \n3.Delete Guest \n4.Search Guest \n5.Receive payment \n6.Sign-out");
            int y = input.nextInt();
            switch (y){
                case 1:
                System.out.println("Please enter the name");
                String name = input.next();
                System.out.println("Please enter the password");
                String pass=input.next();
                System.out.println("Please enter Telephone Number");
                int tele = input.nextInt();
                System.out.println("Please enter Age");
                int age = input.nextInt();
                System.out.println("Please enter Email");
                String email = input.next();
                System.out.println("Please enter country");
                String country=input.next();
                if( R1.Add_Account(name,pass,tele,age,email,country)==true){
                 System.out.println("Guest Added.. ID is: "+(G1.guestId()-1)+" and username is: "+name+(G1.guestId()-1));
                }
                else{
                 System.out.println("Guest Not Added");
                }
                break;
            case 2:
                System.out.println("Please enter ID");
                int id2 = input.nextInt();
                if(R1.check_id(id2)==true){
                System.out.println("Please enter ID");
                int id3 = input.nextInt();
                System.out.println("Please enter the name");
                String name2 = input.next();
                System.out.println("Please enter the password");
                String pass2=input.next();
                System.out.println("Please enter Telephone Number");
                int tele2 = input.nextInt();
                System.out.println("Please enter Age");
                int age2 = input.nextInt();
                System.out.println("Please enter Email");
                String email2 = input.next();
                System.out.println("Please enter country");
                String country2=input.next();
                if(R1.Update_Account(id3,name2,pass2,tele2,age2,email2,country2)==true)
                    System.out.println("Guest Updated");
                else
                 System.err.println("Guest Not Updated");
                }
                else
                    System.err.println("ID not Found!");
                break;
            case 3:
                System.out.println("Please enter ID");
                int id5 = input.nextInt();
                if(R1.check_id(id5)==true){
                    if(R1.check_payment(id5)==true){
                        if(R1.Delete_Account(id5)==true){
                            System.out.println("Deleted");
                        }
                        else
                            System.err.println("Failed to delete!");
                    }
                    else{
                        System.err.println("Can't delete the guest..Confirm the payment first!");
                    }
                }
            
                else
                    System.err.println("ID not Found!");
                break;
            case 4:
                System.out.println("Please enter guest ID: ");
                int id4 = input.nextInt();
                if(R1.check_id(id4)==true){
                     System.out.println("ID       : "+ R1.Search_Account(id4).Get_ID());
                     System.out.println("Name     : "+ R1.Search_Account(id4).Get_Name());
                     System.out.println("Password : "+ R1.Search_Account(id4).Get_Password());
                     System.out.println("Age      : "+ R1.Search_Account(id4).Get_Age());
                     System.out.println("Email    : "+ R1.Search_Account(id4).Get_EmailAddress());
                     System.out.println("Mobile   : "+ R1.Search_Account(id4).Get_PhoneNumber());
                     System.out.println("Country  : "+ R1.Search_Account(id4).Get_Country());
                }
                else
                    System.err.println("ID not Found!");
                break;
            case 5:
               System.out.println("Please enter guest id: ");
               int id7 = input.nextInt();
               if(R1.check_id(id7)==true){
                  System.out.println("Name     : "+ R1.Search_Account(id7).Get_Name());
                  System.out.println("Total    : "+ res.get_total_price(R1.save_id(namex))+" L.E");
                  System.out.println("payment method: \n 1.Cash \n 2.Cheque \n 3.Creditcard");
                  int method = input.nextInt();
                  System.out.println("Guest amount to pay: ");
                  double pay = input.nextDouble();
                  if(R1.payment(id7,pay)==true){
                      System.out.println("Payment Succeeded");
                  }
                  else{
                      System.err.println("invalid value");
                  }
               }
               else
                    System.err.println("ID not Found!");
                break;
                
            case 6:
                R1.SignOut();
                break;
            default:
                System.err.println("You have entered the wrong number");
                menu();
        }
            }
            else{
                System.err.println("Wrong name or password!");
                    }
                }
        else if(x==3){
             System.out.println("Please enter the username");
            String username = input.next();
            System.out.println("Please enter the password");
            String passx=input.next();
            if(G1.SignIn(username, passx)==true){
                 System.out.println("1.Reserve room \n2.Reserve service \n3.View reset \n4.Give feedback \n5.Check-out \n6.Sign-out");
                    int k = input.nextInt();
                    switch(k){
                        case 1:
                            System.out.println("1.Single room \n2.Double room \n3.Suite");
                            int roomno;
                            int ch2 = input.nextInt();
                            switch(ch2){
                                case 1:
                                    System.out.println("1.Beach view \n2.Pool view");
                                    int ch3 = input.nextInt();
                                    switch(ch3){
                                        case 1:
                                            if(r1.get_empty_room("single" ,"beach")!=-1){
                                                System.out.println("Please enter number of nights: ");
                                                int NoOfNights = input.nextInt();
                                                roomno=r1.get_empty_room("single" ,"beach");
                                                if(res.ReserveRoom(roomno,NoOfNights,R1.save_id(username))==true){
                                                System.out.println("Room reserved");
                                                System.out.println("Your room number is: "+roomno);
                                                   }
                                                  else
                                                System.err.println("Room is already reserved!");
                                                            }
                                            else{
                                                        System.err.println("All single rooms are full!");
                                            }
                                            break;
                                        case 2:
                                            if(r1.get_empty_room("single" ,"pool")!=-1){
                                                System.out.println("Please enter number of nights: ");
                                                int NoOfNights = input.nextInt();
                                                roomno=r1.get_empty_room("single" ,"pool");
                                                if(res.ReserveRoom(roomno,NoOfNights,R1.save_id(username))==true){
                                                System.out.println("Room reserved");
                                                System.out.println("Your room number is: "+roomno);
                                                   }
                                                  else
                                                System.err.println("Room is already reserved!");
                                                            }
                                            else{
                                                        System.err.println("All single rooms are full!");
                                            }
                                            break;
                                            default:
                                            System.err.println("You have entered the wrong number");
                                            menu(); 
                                    }
                                    break;
                                case 2:
                                    System.out.println("1.Beach view \n2.Pool view");
                                    int ch4 = input.nextInt();
                                    switch(ch4){
                                        case 1:
                                            if(r1.get_empty_room("double" ,"beach")!=-1){
                                                System.out.println("Please enter number of nights: ");
                                                int NoOfNights = input.nextInt();
                                                roomno=r1.get_empty_room("double" ,"beach");
                                                if(res.ReserveRoom(roomno,NoOfNights,R1.save_id(username))==true){
                                                System.out.println("Room reserved");
                                                System.out.println("Your room number is: "+roomno);
                                                   }
                                                  else
                                                System.err.println("Room is already reserved!");
                                                            }
                                            else{
                                                        System.err.println("All double rooms are full!");
                                            }
                                            break;
                                        case 2:
                                            if(r1.get_empty_room("double" ,"pool")!=-1){
                                                System.out.println("Please enter number of nights: ");
                                                int NoOfNights = input.nextInt();
                                                roomno=r1.get_empty_room("double" ,"pool");
                                                if(res.ReserveRoom(roomno,NoOfNights,R1.save_id(username))==true){
                                                System.out.println("Room reserved");
                                                System.out.println("Your room number is: "+roomno);
                                                   }
                                                  else
                                                System.err.println("Room is already reserved!");
                                                            }
                                            else{
                                                        System.err.println("All double rooms are full!");
                                            }
                                            break;
                                            default:
                                            System.err.println("You have entered the wrong number");
                                            menu(); 
                                    }
                                    break;
                                case 3:
                                    System.out.println("1.Beach view \n2.Pool view");
                                    int ch5 = input.nextInt();
                                    switch(ch5){
                                        case 1:
                                            if(r1.get_empty_room("suite" ,"beach")!=-1){
                                                System.out.println("Please enter number of nights: ");
                                                int NoOfNights = input.nextInt();
                                                 roomno=r1.get_empty_room("suite" ,"beach");
                                                if(res.ReserveRoom(roomno,NoOfNights,R1.save_id(username))==true){
                                                System.out.println("Room reserved");
                                               System.out.println("Your room number is: "+roomno);
                                                   }
                                                  else
                                                System.err.println("Room is already reserved!");
                                                            }
                                            else{
                                                        System.err.println("All suite rooms are full!");
                                            }
                                            break;
                                        case 2:
                                            if(r1.get_empty_room("suite" ,"pool")!=-1){
                                                System.out.println("Please enter number of nights: ");
                                                int NoOfNights = input.nextInt();
                                                 roomno=r1.get_empty_room("suite" ,"pool");
                                                if(res.ReserveRoom(r1.get_empty_room("suite" ,"pool"),NoOfNights,R1.save_id(username))==true){
                                                System.out.println("Room reserved");
                                                System.out.println("Your room number is: "+roomno);
                                                   }
                                                  else
                                                System.err.println("Room is already reserved!");
                                                }
                                            else{
                                                        System.err.println("All suite rooms are full!");
                                            }
                                             break;
                                            default:
                                            System.err.println("You have entered the wrong number");
                                            menu(); 
                                    }
                                    break;
                                default:
                                    System.err.println("You have entered the wrong number");
                                    menu();  
                                    
                            }
                            break;
                        case 2:
                             System.out.println("1.GYM \n2.SAFARI \n3.GLASS BOAT");
                             int ch = input.nextInt();
                             switch(ch){
                                 case 1:
                                     System.out.println("Please enter number of months: ");
                                     int NoOfmonths = input.nextInt();
                                     if(res.ResrveGym(NoOfmonths,R1.save_id(username))==true){
                                         System.out.println("GYM reserved");
                                     }
                                     else
                                         System.err.println("GYM is alreday reserved!");
                                     break;
                                 case 2:
                                     s1.ReadFile();
                                     System.out.println("Number of trips: "+s1.safariList.size());
                                     System.out.println("   ID        Date         From        To        Price         Available tickets");
                                     for(int i=0;i<s1.safariList.size();i++){
                                     System.out.println("   "+s1.safariList.get(i).Get_id()+"       "+s1.safariList.get(i).Get_Start_Date()+"    "+s1.safariList.get(i).Get_StartTime()+"     "+s1.safariList.get(i).Get_EndTime()+"      "+s1.safariList.get(i).Get_price()+"                  "+s1.safariList.get(i).Get_noOfTickets());
                                     }
                                     System.out.println("Enter trip number: ");
                                      int safariId = input.nextInt();
                                      System.out.println("Enter number of tickets: ");
                                      int noOfTickets = input.nextInt();
                                      if(res.checkAvilableSafariTickets(noOfTickets,safariId)==true){
                                      if(res.ReserveSafari(safariId, R1.save_id(username),noOfTickets)==true){
                                          System.out.println("Safari trip reserved");
                                      }
                                      else
                                          System.err.println("Failed to reserve!");
                                      }
                                      else
                                          System.err.println("Number of tickets entered not valid!");
                                     break;
                                 case 3:
                                     g1.ReadFile();
                                     System.out.println("Number of trips: "+g1.glassBoatList.size());
                                     System.out.println("   ID        Date         From        To        Price         Available tickets");
                                     for(int i=0;i<g1.glassBoatList.size();i++){
                                     System.out.println("   "+g1.glassBoatList.get(i).Get_id()+"       "+g1.glassBoatList.get(i).Get_Start_Date()+"    "+g1.glassBoatList.get(i).Get_StartTime()+"     "+g1.glassBoatList.get(i).Get_EndTime()+"     "+g1.glassBoatList.get(i).Get_price()+"                "+g1.glassBoatList.get(i).Get_noOfTickets());
                                     }
                                     System.out.println("Enter trip number: ");
                                      int GlassBoatId = input.nextInt();
                                      System.out.println("Enter number of tickets: ");
                                      int noOfTickets2 = input.nextInt();
                                      if(res.ReserveGlassBoat(GlassBoatId, R1.save_id(username),noOfTickets2)==true){
                                          System.out.println("Glass boat trip reserved");
                                      }
                                      else
                                          System.err.println("Failed to reserve!");
                                     break;
                                 default:
                                     System.err.println("You have entered the wrong number");
                                     menu();       
                             }
                            break;
                        case 3:
                            System.out.println("Your total price is: "+ res.get_total_price(R1.save_id(username))+" L.E");
                            
                            break;
                        case 5:
                            System.out.println("Please enter room number: ");
                            int roomNo2 = input.nextInt();
                             if(res.checkRoomNo(roomNo2)==true){
                                 if(R1.check_payment(R1.save_id(username))==true){
                                    if(res.checkout(roomNo2)==true){
                                        System.out.println("GOOD BYE!");
                                    }
                                    else
                                        System.err.println("Room is empty!"); 
                                 }
                                 else
                                        System.err.println("Please, Confirm payment first!");
                            }
                            else
                            System.err.println("invalid room number");
                             break;
                        case 6:
                            G1.SignOut();
                        default:
                            System.err.println("You have entered the wrong number");
                            menu(); 
                 
                    }

            }
            else{
                System.err.println("Wrong name or password!");
            }
        }
        
        menu();
        */
    }
    
    /*************************************************************************************************************************/

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        menu();
        // 5476 lines of code;
                }
        };