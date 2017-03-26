
package Receptionist;

import hotel.code.Guest;
import hotel.code.Receptionist;
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


class EditGuest extends JFrame{
    
     private JLabel jlname=new JLabel("Enter Guest name");
    private JLabel jlpass=new JLabel("Password");
    private JLabel jltel=new JLabel("Telephone Number");
    private JLabel jlage=new JLabel("Age");
    private JTextField jcbage=new JTextField();
    private JLabel jlemail=new JLabel("E-mail Address");
    private JLabel jlcountry=new JLabel("Country");
    private JTextField jtname=new JTextField(20);
    private JTextField jtpass=new JTextField(15);
    private JTextField jttel=new JTextField();
    private JTextField jtemail=new JTextField(30);
    private JTextField jtcountry=new JTextField();
    private JButton jbsubmit=new JButton("Submit");
    private JButton jbgoback=new JButton("GO BACK");
    private JLabel jlid=new JLabel("Guest ID: ");
    private JButton jbsubmit1=new JButton("Submit");
    private JTextField jtid=new JTextField();
    
    public EditGuest(){
        
    setTitle("Modifying Guest's Data");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\modern_hotel_room-wallpaper-1280x800 (Custom).jpg")));
     
    Container cp=getContentPane();
    cp.setBackground(Color.cyan);
  
    
    
    
    
    jlname.setBounds(10, 5, 175, 50);
    jtname.setBounds(jlname.getX(), jlname.getY()+35, jlname.getWidth(), jlname.getHeight()-20);
    jlpass.setBounds(jlname.getX(), jtname.getY()+30, jlname.getWidth(), jlname.getHeight()); 
    jtpass.setBounds(jlname.getX(), jlpass.getY()+35, jtname.getWidth(), jtname.getHeight());
    jltel.setBounds(jlname.getX(), jtpass.getY()+30, jlname.getWidth(), jtname.getHeight());
    jttel.setBounds(jlname.getX(), jltel.getY()+35, jlname.getWidth(), jtname.getHeight());
    jlage.setBounds(jlname.getX(), jttel.getY()+30, jlname.getWidth(), jtname.getHeight());
    jcbage.setBounds(jlname.getX(), jlage.getY()+35, jlname.getWidth(), jtname.getHeight());
    jlemail.setBounds(jlname.getX(), jcbage.getY()+35, jlname.getWidth(), jtname.getHeight());
    jtemail.setBounds(jlname.getX(), jlemail.getY()+35, jlname.getWidth(), jtname.getHeight());
    jlcountry.setBounds(jlname.getX(), jtemail.getY()+30, jlname.getWidth(), jtname.getHeight());
    jtcountry.setBounds(jlname.getX(), jlcountry.getY()+35, jlname.getWidth(), jtname.getHeight());
    
     jbsubmit.setBounds(300, 450, 175,50);
     jbgoback.setBounds(10, 450, 175, 50);
     
    jlid.setBounds(10, 5, 175, 50);
     jtid.setBounds(jlid.getX(), jlid.getY()+35, jlid.getWidth(), jlid.getHeight()-20);
    jbsubmit1.setBounds(250, 450, 175,50);
    
   
  
    
    this.add(jlname);
    this.add(jlpass);
    this.add(jtname);
    this.add(jtpass);
    this.add(jltel);
    this.add(jttel);
    this.add(jlage);
    this.add(jlemail);
    this.add(jtemail);
    this.add(jlcountry);
    this.add(jtcountry);
    this.add(jcbage);
    this.add(jbsubmit);
    this.add(jbgoback);
     this.add(jlid);
    this.add(jtid);
    this.add(jbsubmit1);
    
    
    jlname.setVisible(false);
    jlpass.setVisible(false);
    jtname.setVisible(false);
    jtpass.setVisible(false);
    jltel.setVisible(false);
    jttel.setVisible(false);
    jlage.setVisible(false);
    jlemail.setVisible(false);
    jtemail.setVisible(false);
    jlcountry.setVisible(false);
    jtcountry.setVisible(false);
    jcbage.setVisible(false);
    jbgoback.setVisible(true);
    jbsubmit.setVisible(true);
    jlid.setVisible(true);
    jtid.setVisible(true);
    jbsubmit1.setVisible(false);
    
    
    jbsubmit.addActionListener(handler);
    jbsubmit1.addActionListener(handler);
    jbgoback.addActionListener(handler);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    
     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Receptionist R1=new Receptionist();
            
            Object x=e.getSource();
            ReceptionistMenu Tenth=new ReceptionistMenu();
                    if(x.equals(jbsubmit)){
                        int id=Integer.parseInt(jtid.getText());
                        try {
                if(R1.check_id(id)==true){
                    jtname.setText(R1.Search_Account(id).Get_Name());
                    jtpass.setText(R1.Search_Account(id).Get_Password());
                    jttel.setText(R1.Search_Account(id).Get_PhoneNumber());
                    jcbage.setText(Integer.toString(R1.Search_Account(id).Get_Age()));
                    jtemail.setText(R1.Search_Account(id).Get_EmailAddress());
                    jtcountry.setText(R1.Search_Account(id).Get_Country());
                       jlname.setVisible(true);
                       jlpass.setVisible(true);
                       jtname.setVisible(true);
                       jtpass.setVisible(true);
                       jltel.setVisible(true);
                       jttel.setVisible(true);
                       jlage.setVisible(true);
                       jlemail.setVisible(true);
                       jtemail.setVisible(true);
                       jlcountry.setVisible(true);
                       jtcountry.setVisible(true);
                       jcbage.setVisible(true);
                       jbgoback.setVisible(true);
                       jlid.setVisible(false);
                       jtid.setVisible(false);
                       jbsubmit1.setVisible(true);
                       jbsubmit.setVisible(false);
                }
            } catch (IOException ex) {
                Logger.getLogger(EditGuest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditGuest.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                    }
                    
                    if(x.equals(jbsubmit1)){
                        int id=Integer.parseInt(jtid.getText());
                       String name=jtname.getText();
                       String pass=jtpass.getText();
                       String tel=jttel.getText();
                       int age=Integer.parseInt(jcbage.getText());
                       String email=jtemail.getText();
                       String country=jtcountry.getText();
                        try {
                            Guest G1=new Guest();
                            if(R1.Update_Account(id,name,pass,tel,age,email,country)==true){
                                JOptionPane.showMessageDialog(null, "Guest Updated, Your ID is: "+(G1.guestId()-1));
                                Tenth.setVisible(true);
                                dispose();
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Guest Not Updated!");
                        } catch (IOException ex) {
                            Logger.getLogger(EditGuest.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(EditGuest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                       }
                    
                    else if(x.equals(jbgoback)){
                        Tenth.setVisible(true);
                        dispose();
                    }
        }
     }
}
   
