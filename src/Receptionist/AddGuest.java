
package Receptionist;

import hotel.code.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
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

class AddGuest extends JFrame{ 
    private JLabel jlname=new JLabel("Enter Guest name");
    private JLabel jlpass=new JLabel("Password");
    private JLabel jltel=new JLabel("Telephone Number");
    private JLabel jlage=new JLabel("Age");
    private JComboBox jcbage=new JComboBox(new String[]{"--Select guest age--"});
    private JLabel jlemail=new JLabel("E-mail Address");
    private JLabel jlcountry=new JLabel("Country");
    private JTextField jtname=new JTextField("Type name",20);
    private JTextField jtpass=new JTextField("Type password",15);
    private JTextField jttel=new JTextField("Type telephone number");
    private JTextField jtemail=new JTextField("Type E-mail address",30);
    private JTextField jtcountry=new JTextField("Type country");
    private JButton jbsubmit=new JButton("Submit");
    private JButton jbgoback=new JButton("GO BACK");
    
    public AddGuest(){
        
    setTitle("Entering The Guest's Data");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
     setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\luxury_house_2-wallpaper-1280x800 (Custom).jpg")));
    
    Container cp=getContentPane();
    cp.setBackground(Color.cyan);
  
    
    for(int i=0;i<83;i++){
       jcbage.addItem(18+i);
    }
    
    
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
    
    jbsubmit.setBackground(Color.darkGray);
    jbsubmit.setForeground(Color.white);
    jbgoback.setBackground(Color.darkGray);
    jbgoback.setForeground(Color.white);
  
    
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
    
    jbsubmit.addActionListener(handler);
    jbgoback.addActionListener(handler);
    this.jtname.addMouseListener(mw);
    this.jtpass.addMouseListener(mw);
    this.jttel.addMouseListener(mw);
    this.jtemail.addMouseListener(mw);
    this.jtcountry.addMouseListener(mw);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    
     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
            Object x=e.getSource();
            Receptionist R1=new Receptionist();
            Guest G1=new Guest();
            ReceptionistMenu Tenth=new ReceptionistMenu();
                    if(x.equals(jbsubmit)){
                        String name=jtname.getText();
                        String password=jtpass.getText();
                        String tel=jttel.getText();
                        int age=(int)jcbage.getSelectedItem();
                        String email=jtemail.getText();
                        String country=jtcountry.getText();
                        if(tel.length()!=11&&tel.length()!=8){
                        throw new OurException();
                        }
                    if( R1.Add_Account(name,password,tel,age,email,country)==true){
                        JOptionPane.showMessageDialog(null, "Guest Added.. ID is: "+(G1.guestId()-1)+" and username is: "+name+(G1.guestId()-1));
                        Tenth.setVisible(true);
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Guest Not Added");
                    }
                    else if(x.equals(jbgoback)){
                        Tenth.setVisible(true);
                        dispose();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
                }
                    catch(OurException ex){
                            JOptionPane.showMessageDialog(null, "please enter a right telephone number");
                                    }
                    }
                    
                    
        }
     
   private class mousewatch extends MouseMotionAdapter implements MouseListener
            {
        public void mouseClicked(MouseEvent e)
        {
            Object o =e.getSource();
            if( o.equals(jtname)){
            jtname.setText("");
            }
            else if(o.equals(jtpass)){
                jtpass.setText("");
            }
            else if(o.equals(jttel)){ 
             jttel.setText("");
            }
            else if(o.equals(jtemail)){
             jtemail.setText("");
            }
            else if(o.equals(jtcountry)){
             jtcountry.setText("");
            }
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){  }
        public void mouseDragged(MouseEvent e){  }
   
    }
}
