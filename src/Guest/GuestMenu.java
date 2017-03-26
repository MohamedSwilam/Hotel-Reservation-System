
package Guest;

import hotel.code.*;
import hotel.gui.HomeScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuestMenu extends JFrame{
    
    private JButton jbreserver =new JButton("Reserve Room");
    private JButton jbreserves =new JButton("Reserve Service");
    private JButton jbreceipt =new JButton("View Receipt");
    private JButton jbcheckout =new JButton("Check-Out");
    private JButton jbsignout =new JButton("For Signout");
    private JButton jbgoback=new JButton("BACK");
    private JButton jbcheckout2=new JButton("Check-Out");
    private JButton jbreserve=new JButton("Reserve");
    private JButton jbgoback2=new JButton("BACK");
    private JButton jbgym=new JButton("GYM");
    private JButton jbsafari=new JButton("Safari"); 
    private JButton jbglassboat=new JButton("Glass boat");
    private JButton jbsubmit=new JButton("Submit");
    private JButton jbcancel=new JButton("Cancel");
    private JButton jbgoback3=new JButton("BACK");
    private JButton jbgoback4=new JButton("BACK");
    private JButton jbreservesafari=new JButton("Reserve");
    private JButton jbresrveglassboat=new JButton("Reserve");
    private JLabel jlroomno=new JLabel("Room Number:");
    private JLabel jltitle=new JLabel("GYM");
    private JLabel jlmonths=new JLabel("Number Of Months:");
    private JLabel jlrooms=new JLabel("Rooms Reserved:");
    private JLabel jlreceipt=new JLabel("Your Total Price Is:");
    private JLabel jlgym=new JLabel("Number of months in GYM:");
    private JTextField jtgym=new JTextField();
    private JTextField jtrooms=new JTextField();
    private JTextField jtprice=new JTextField();
    private JTextField jtTest=new JTextField();
    private JTextField jtnights=new JTextField("Enter number of nights");
    private JTextField jtest=new JTextField();
    private JTextField jtickets=new JTextField("Enter Number of Tickets");
    private JTextField jtickets2=new JTextField("Enter Number of Tickets");
    private JTextField jtroomno=new JTextField();
    private JComboBox jcbview=new JComboBox(new String[]{"--VIEW--"});
    private JComboBox jcbtype=new JComboBox(new String[]{"--TYPE--"});
    private JComboBox jcbmonths=new JComboBox(new String[]{"--Select Number Of Months--"});
    private JComboBox jcbsafari=new JComboBox(new String[]{"--Select Safari Trip--"});
    private JComboBox jcbglassboat=new JComboBox(new String[]{"--Select Safari Trip--"});
    
    public GuestMenu(String Username){
    setTitle("Guest Menu");
    setSize(550,550);
    setLayout(null);
    jtTest.setText(Username);
    jcbview.addItem("pool");
    jcbview.addItem("beach");
    jcbtype.addItem("single");
    jcbtype.addItem("double");
    jcbtype.addItem("suite");
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\modern_hotel_room-wallpaper-1280x800 (Custom).jpg")));
   
    for(int i=0;i<48;i++){
       jcbmonths.addItem(i+1);
    } 
    Safari s1=new Safari();
    s1.ReadFile();
    for(int i=0;i<s1.safariList.size();i++){
       jcbsafari.addItem("ID: "+s1.safariList.get(i).Get_id()+" | Date: "+s1.safariList.get(i).Get_Start_Date()+" | From: "+s1.safariList.get(i).Get_StartTime()+" | To: "+s1.safariList.get(i).Get_EndTime()+" | Price: "+s1.safariList.get(i).Get_price()+" | Tickets available: "+s1.safariList.get(i).Get_noOfTickets());
    } 
    GlassBoat g1=new GlassBoat();
    g1.ReadFile();
    for(int i=0;i<g1.glassBoatList.size();i++){
       jcbglassboat.addItem("ID: "+g1.glassBoatList.get(i).Get_id()+" | Date: "+g1.glassBoatList.get(i).Get_Start_Date()+" | From: "+g1.glassBoatList.get(i).Get_StartTime()+" | To: "+g1.glassBoatList.get(i).Get_EndTime()+" | Price: "+g1.glassBoatList.get(i).Get_price()+" | Tickets available: "+g1.glassBoatList.get(i).Get_noOfTickets());
    } 
    myHandler handler=new myHandler();
    
     Container cp=getContentPane();
     cp.setBackground(Color.pink);
    
    jbreserver.setBounds(150,75,175,50);
    jbreserves.setBounds(jbreserver.getX(), jbreserver.getY()+75, jbreserver.getWidth(),jbreserver.getHeight());
    jbreceipt.setBounds(jbreserver.getX(), jbreserves.getY()+75, jbreserver.getWidth(),jbreserver.getHeight());
    jbcheckout.setBounds(jbreserver.getX(), jbreceipt.getY()+75, jbreserver.getWidth(),jbreserver.getHeight());
    jbsignout.setBounds(jbreserver.getX(), jbcheckout.getY()+75, jbreserver.getWidth(),jbreserver.getHeight());
    jlreceipt.setBounds(10,360,150,30);
    jtprice.setBounds(160,360,250,30);
    jlreceipt.setForeground(Color.WHITE);
    jlrooms.setBounds(10,50,150,30);    
    jtrooms.setBounds(160,50,250,30);
    jlgym.setBounds(10, 150, 150, 30);
    jtgym.setBounds(160,150,250,30);
    jbgoback.setBounds(180, 450, 175, 50);
    jbcheckout2.setBounds(250, 400, 175, 50);
    jlroomno.setBounds(jbreserver.getX()-100, 30, jbreserver.getWidth(), jbreserver.getHeight());
    jtroomno.setBounds(jlreceipt.getX()+80, jlreceipt.getY()+150, jlreceipt.getWidth(), jlreceipt.getHeight());
    jcbtype.setBounds(150, 60, 175, 35);
    jcbview.setBounds(150, 100, 175, 35);
    jtnights.setBounds(jcbview.getX(), jcbview.getY()+100, jcbview.getWidth(), 50);
    jbgoback2.setBounds(75, 400, 175, 50);
    jbreserve.setBounds(75+180,400,175,50);
    jbgym.setBounds(150,100,175,50);
    jbsafari.setBounds(150, 200, 175, 50);
    jbglassboat.setBounds(150, 300, 175, 50);
    jbgoback3.setBounds(150, 400, 175, 50);
    jltitle.setBounds(170,30,150,50);
    jlmonths.setBounds(90, 180, 175, 50);
    jcbmonths.setBounds(210, 225, 200, 30);
    jcbmonths.setBounds(210, 225, 200, 30);
    jcbsafari.setBounds(10, 10, 520, 30);
    jcbglassboat.setBounds(10, 10, 520, 30);
    jbsubmit.setBounds(300, 400, 175, 50);
    jbcancel.setBounds(50, 400, 175, 50);
    jbreservesafari.setBounds(300, 400, 175, 50);
    jbresrveglassboat.setBounds(300, 400, 175, 50);
    jbgoback4.setBounds(300-180, 400, 175, 50);
    jtickets.setBounds(225, 225, 175, 50);
    jtickets2.setBounds(225, 225, 175, 50);
    
    jbreserver.setBackground(Color.white);
    jbreserves.setBackground(Color.white);
    jbreceipt.setBackground(Color.white);
    jbcheckout.setBackground(Color.white);
    jbsignout.setBackground(Color.white);
    jbgoback.setBackground(Color.WHITE);
    jbcheckout2.setBackground(Color.white);
    jcbview.setBackground(Color.WHITE);
    jcbtype.setBackground(Color.WHITE);
    jbreserve.setBackground(Color.WHITE);
    jbgoback2.setBackground(Color.WHITE);
    jtnights.setBackground(Color.WHITE);
    jbgym.setBackground(Color.WHITE);
    jbsafari.setBackground(Color.WHITE);
    jbglassboat.setBackground(Color.WHITE);
    jbcancel.setBackground(Color.WHITE);
    jcbmonths.setBackground(Color.white);
    jcbsafari.setBackground(Color.white);
    jcbglassboat.setBackground(Color.white);
    jbsubmit.setBackground(Color.WHITE);
    jbgoback3.setBackground(Color.WHITE);
    jbreservesafari.setBackground(Color.WHITE);
    jbresrveglassboat.setBackground(Color.WHITE);
    jbgoback4.setBackground(Color.WHITE);
    
    
    jtprice.setEditable(false);
    jtrooms.setEditable(false);
    jtgym.setEditable(false);
    jlgym.setVisible(false);
    jbgoback.setVisible(false);
    jbcheckout2.setVisible(false);
    jtprice.setVisible(false);
    jtrooms.setVisible(false);
    jtgym.setVisible(false);
    jlreceipt.setVisible(false);
    jlrooms.setVisible(false);
    jlroomno.setVisible(false);
    jtroomno.setVisible(false);
    jbreserver.setVisible(true);
    jbreserves.setVisible(true);
    jbreceipt.setVisible(true);
    jbcheckout.setVisible(true);
    jbsignout.setVisible(true);
    jcbview.setVisible(false);
    jcbtype.setVisible(false);
    jbreserve.setVisible(false);
    jtnights.setVisible(false);
    jbgoback2.setVisible(false);
    jltitle.setVisible(false);
    jlmonths.setVisible(false);
    jcbmonths.setVisible(false);
    jcbsafari.setVisible(false);
    jcbglassboat.setVisible(false);
    jbsubmit.setVisible(false);
    jbgoback3.setVisible(false);
    jbcancel.setVisible(false);
    jbgym.setVisible(false);
    jbsafari.setVisible(false);
    jbglassboat.setVisible(false);
    jbgoback.setVisible(false);
    jbreservesafari.setVisible(false);
    jbresrveglassboat.setVisible(false);
    jbgoback4.setVisible(false);
    jtickets.setVisible(false);
    jtickets2.setVisible(false);
    
    this.add(jbreserver);
    this.add(jbreserves);
    this.add(jbreceipt);
    this.add(jbcheckout);
    this.add(jbsignout);
    this.add(jlreceipt);
    this.add(jlrooms);
    this.add(jtprice);
    this.add(jtrooms);
    this.add(jtgym);
    this.add(jlroomno);
    this.add(jtroomno);
    this.add(jbgoback);
    this.add(jbcheckout2);
    this.add(jbreserve);
    this.add(jcbview);
    this.add(jcbtype);
    this.add(jbgoback2);
    this.add(jtnights);
    this.add(jlgym);
    this.add(jbgym);
    this.add(jbsafari);
    this.add(jbglassboat);
    this.add(jltitle);
    this.add(jlmonths);
    this.add(jcbmonths);
    this.add(jcbsafari);
    this.add(jcbglassboat);
    this.add(jbsubmit);
    this.add(jbgoback3);
    this.add(jbcancel);
    this.add(jbreservesafari);
    this.add(jbresrveglassboat);
    this.add(jbgoback4);
    this.add(jtickets);
    this.add(jtickets2);
    
    jbreserver.addActionListener(handler);
    jbreserves.addActionListener(handler);
    jbreceipt.addActionListener(handler);
    jbcheckout.addActionListener(handler);
    jbsignout.addActionListener(handler);
    jbgoback.addActionListener(handler);
    jbcheckout2.addActionListener(handler);
    jbreserve.addActionListener(handler);
    jbgoback2.addActionListener(handler);
    jbgym.addActionListener(handler);
    jbsafari.addActionListener(handler);
    jbglassboat.addActionListener(handler);
    jbsubmit.addActionListener(handler);
    jbcancel.addActionListener(handler);
    jbgoback3.addActionListener(handler);
    jbreservesafari.addActionListener(handler);
    jbresrveglassboat.addActionListener(handler);
    jbgoback4.addActionListener(handler);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            String username=jtTest.getText();
            HomeScreen First=new HomeScreen();
            Reservation res=new Reservation();
            Receptionist R1=new Receptionist();
            GuestMenu gm=new GuestMenu(jtTest.getText());
                    if(x.equals(jbreserver)){
                        jbreserver.setVisible(false);
                        jbreserves.setVisible(false);
                        jbreceipt.setVisible(false);
                        jbcheckout.setVisible(false);
                        jbsignout.setVisible(false);
                        jcbview.setVisible(true);
                        jcbtype.setVisible(true);
                        jbgoback2.setVisible(true);
                        jbreserve.setVisible(true);
                        jtnights.setVisible(true);
                    }
                    else if(x.equals(jbreserves)){
                        jbreserver.setVisible(false);
                        jbreserves.setVisible(false);
                        jbreceipt.setVisible(false);
                        jbcheckout.setVisible(false);
                        jbsignout.setVisible(false);
                        jbgym.setVisible(true);
                        jbsafari.setVisible(true);
                        jbglassboat.setVisible(true);
                        jbgoback3.setVisible(true);
                    }
                    else if(x.equals(jbreceipt)){
                       jtprice.setText(Double.toString(res.get_total_price(R1.save_id(username)))+" L.E");
                       jtrooms.setText(res.get_reserved_rooms(R1.save_id(username)));
                       jtgym.setText(Integer.toString(res.get_reserved_gym(R1.save_id(username))));
                       
                       jbreserver.setVisible(false);
                       jbreserves.setVisible(false);
                       jbreceipt.setVisible(false);
                       jbcheckout.setVisible(false);
                       jbsignout.setVisible(false);
                       jlreceipt.setVisible(true);
                        jlgym.setVisible(true);

                       jlrooms.setVisible(true);
                       jtprice.setVisible(true);
                       jtrooms.setVisible(true);
                       jtgym.setVisible(true);
                       jbgoback.setVisible(true);
                    }
                    else if(x.equals(jbcheckout)){
                       jbreserver.setVisible(false);
                       jbreserves.setVisible(false);
                       jbreceipt.setVisible(false);
                       jbcheckout.setVisible(false);
                       jbsignout.setVisible(false);
                       jlroomno.setVisible(true);
                       jtroomno.setVisible(true);
                       jbgoback.setVisible(true);
                       jbcheckout2.setVisible(true);
                    }
                    else if(x.equals(jbsignout)){
                       First.setVisible(true);
                       dispose();
                    }
                    /************************************************************************************************/
                    if(x.equals(jbcheckout2)){
                        int roomNo=Integer.parseInt(jtroomno.getText());
                      if(res.checkRoomNo(roomNo)==true){
                          if(R1.check_payment(R1.save_id(jtTest.getText()))==true){
                              if(res.checkout(roomNo)==true){
                              JOptionPane.showMessageDialog(null, "GOOD BYE!");
                              }
                              else
                                  JOptionPane.showMessageDialog(null, "Room is empty!");
                          }
                          else
                               JOptionPane.showMessageDialog(null, "Please, Confirm payment first!");
                        }
                      else
                          JOptionPane.showMessageDialog(null, "invalid room number");
                    }
                    else if(x.equals(jbgoback)){
                        gm.setVisible(true);
                        dispose();
                    }
                    /*******************************************************************************************/
                    Room r1=new Room();
                        int roomNo;
                        String type = (String)jcbtype.getSelectedItem();
                        String view=(String)jcbview.getSelectedItem();
                        if(x.equals(jbreserve)){
                         int nights=Integer.parseInt(jtnights.getText());
                         roomNo=r1.get_empty_room(type ,view);
                         if(r1.get_empty_room(type ,view)!=-1){
                         if(res.ReserveRoom(roomNo,nights,R1.save_id(username))==true){
                             JOptionPane.showMessageDialog(null, "Room Reserved, Your Room Number is "+roomNo);
                         }
                         else
                           JOptionPane.showMessageDialog(null, "Room is already reserved!");
                         }else
                         JOptionPane.showMessageDialog(null, "All "+ type +" rooms are full!");
                         
                         gm.setVisible(true);
                         dispose();
                       }
                       else if(x.equals(jbgoback2)){
                       gm.setVisible(true);
                       dispose();
                       }
                        /***********************************************************************************************/
                        if(x.equals(jbgym)){
                            setTitle("Welcome");
                            jbgym.setVisible(false);
                            jbsafari.setVisible(false);
                            jbglassboat.setVisible(false);
                            jbgoback3.setVisible(false);
                            jltitle.setVisible(true);
                            jlmonths.setVisible(true);
                            jcbmonths.setVisible(true);
                            jbsubmit.setVisible(true);
                            jbcancel.setVisible(true);
                        }
                        else if(x.equals(jbsafari)){
                            jbgym.setVisible(false);
                            jbsafari.setVisible(false);
                            jbglassboat.setVisible(false);
                            jbgoback3.setVisible(false);
                            jcbsafari.setVisible(true);
                            jtickets.setVisible(true);
                            jbreservesafari.setVisible(true);
                            jbgoback4.setVisible(true);
                        }
                        else if(x.equals(jbglassboat)){
                            jbgym.setVisible(false);
                            jbsafari.setVisible(false);
                            jbglassboat.setVisible(false);
                            jbgoback3.setVisible(false);
                            jcbglassboat.setVisible(true);
                            jtickets2.setVisible(true);
                            jbresrveglassboat.setVisible(true);
                            jbgoback4.setVisible(true);
                        }
                        else if(x.equals(jbgoback3)){
                        gm.setVisible(true);
                        dispose();
                        }
                        if(x.equals(jbsubmit)){
                            int months = (int)jcbmonths.getSelectedItem();
                             if(res.ResrveGym(months,R1.save_id(username))==true){
                                 JOptionPane.showMessageDialog(null, "GYM reserved");
                             }
                             else
                                 JOptionPane.showMessageDialog(null, "GYM is already reserved!");
                        }
                        else if(x.equals(jbcancel)){
                            gm.setVisible(true);
                            dispose();
                        }
                        /************************************************************************************/
                        if(x.equals(jbreservesafari)){
                            int safariId=jcbsafari.getSelectedIndex();
                            int ticketsNum=Integer.parseInt(jtickets.getText());
                try {
                    if(res.checkAvilableSafariTickets(ticketsNum,safariId)==true){
                        if(res.ReserveSafari(safariId, R1.save_id(username),ticketsNum)==true){
                            JOptionPane.showMessageDialog(null, "Safari trip reserved");
                        }
                    }
                    else
                       JOptionPane.showMessageDialog(null, "Number of tickets entered not valid!");
                } catch (IOException ex) {
                    Logger.getLogger(GuestMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GuestMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                        }
                        else if(x.equals(jbgoback4)){
                            gm.setVisible(true);
                            dispose();
                        }
                        
                        if(x.equals(jbresrveglassboat)){
                            int safariId=jcbglassboat.getSelectedIndex();
                            int ticketsNum=Integer.parseInt(jtickets2.getText());
                        if(res.ReserveGlassBoat(safariId, R1.save_id(username),ticketsNum)==true){
                            JOptionPane.showMessageDialog(null, "Glass Boat trip reserved");
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Failed to reserve!");
                        }
                        else if(x.equals(jbgoback4)){
                            gm.setVisible(true);
                            dispose();
                        }
        }
}
}