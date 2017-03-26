
package Receptionist;

import Receptionist.*;
import hotel.code.Manger;
import hotel.code.Receptionist;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class GuestData extends JFrame{
    private JButton jbgoback=new JButton("BACK");
    public GuestData(int id) throws IOException, ClassNotFoundException{
        
    setTitle("Guest's Data");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    
    Container cp=getContentPane();
    cp.setBackground(Color.cyan);
    
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\luxury_house_2-wallpaper-1280x800 (Custom).jpg")));
    
    JLabel jlname=new JLabel("Name: ");
    JLabel jlpass=new JLabel("Password: ");
    JLabel jlID=new JLabel("ID: ");
    JLabel jlage=new JLabel("Age: ");
    JLabel jlemail=new JLabel("E-mail Address: ");
    JLabel jltele=new JLabel("Telephone Number: ");
    JLabel jlcountry=new JLabel("Country: ");
    
    
    Receptionist R1=new Receptionist();
    int thisid=id;
    JTextField jtname=new JTextField(R1.Search_Account(thisid).Get_Name());
    JTextField jtpass=new JTextField(R1.Search_Account(thisid).Get_Password());
    JTextField jtID=new JTextField(Integer.toString(R1.Search_Account(thisid).Get_ID()));
    JTextField jtage=new JTextField(Integer.toString(R1.Search_Account(thisid).Get_Age()));
    JTextField jtemail=new JTextField(R1.Search_Account(thisid).Get_EmailAddress());
    JTextField jttele=new JTextField(R1.Search_Account(thisid).Get_PhoneNumber());
    JTextField jtcountry=new JTextField(R1.Search_Account(thisid).Get_Country());
    
    
    jtname.setEditable(false);
    jtpass.setEditable(false);
    jtID.setEditable(false);
    jtage.setEditable(false);
    jtemail.setEditable(false);
    jttele.setEditable(false);
    jtcountry.setEditable(false);
    
    
     jlname.setBounds(10, 5, 175, 50);
    jlpass.setBounds(jlname.getX(), jlname.getY()+60, jlname.getWidth(), jlname.getHeight()); 
    jlID.setBounds(jlname.getX(), jlpass.getY()+60, jlname.getWidth(), jlname.getHeight());
    jltele.setBounds(jlname.getX(), jlID.getY()+60, jlname.getWidth(), jlname.getHeight());  
    jlage.setBounds(jlname.getX(), jltele.getY()+60, jlname.getWidth(), jlname.getHeight());
    jlemail.setBounds(jlname.getX(), jlage.getY()+60, jlname.getWidth(), jlname.getHeight());
    jlcountry.setBounds(jlname.getX(), jlemail.getY()+60, jlname.getWidth(), jlname.getHeight());
    jtname.setBounds(90, 18, 175, 25);
    jtpass.setBounds(jtname.getX()+10, jtname.getY()+60, jtname.getWidth(), jtname.getHeight()); 
    jtID.setBounds(jtname.getX()-20, jtpass.getY()+60, jtname.getWidth(), jtname.getHeight());
    jttele.setBounds(jtname.getX()+35, jtID.getY()+60, jtname.getWidth(), jtname.getHeight());  
    jtage.setBounds(jtname.getX()-20, jttele.getY()+60, jtname.getWidth(), jtname.getHeight());
    jtemail.setBounds(jtname.getX()+20, jtage.getY()+60, jtname.getWidth(), jtname.getHeight());
    jtcountry.setBounds(jtname.getX(), jtemail.getY()+60, jtname.getWidth(), jtname.getHeight());
    jbgoback.setBounds(10, 440, 175,50);
    
    
    jbgoback.setBackground(Color.darkGray);
    jbgoback.setForeground(Color.white);
   
 
                
    this.add(jlname);
    this.add(jlpass);
    this.add(jlID);
    this.add(jlage);
    this.add(jlemail);
    this.add(jltele);
    this.add(jlcountry);
    this.add(jbgoback);
    this.add(jtname);
    this.add(jtpass);
    this.add(jtID);
    this.add(jtage);
    this.add(jtemail);
    this.add(jttele);
    this.add(jtcountry);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    jbgoback.addActionListener(handler);
    }
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            ReceptionistMenu Tenth=new ReceptionistMenu();
            if(x.equals(jbgoback)){
                Tenth.setVisible(true);
                dispose();
            }
        }
    }
}
