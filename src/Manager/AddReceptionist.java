
package Manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import hotel.code.*;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class AddReceptionist extends JFrame{
    private JLabel jlname=new JLabel("Enter your name");
    private JLabel jlpass=new JLabel("Password");
    private JLabel jltel=new JLabel("Telephone Number");
    private JLabel jlage=new JLabel("Age");
    private JComboBox jcbage=new JComboBox(new String[]{"--Select your age--"});
    private JLabel jlemail=new JLabel("E-mail Address");
    private JLabel jlcountry=new JLabel("Country");
    private JTextField jtname=new JTextField("Type your name",20);
    private JTextField jtpass=new JTextField("Type your password",15);
    private JTextField jttel=new JTextField("Type your telephone number");
    private JTextField jtemail=new JTextField("Type your E-mail address",30);
    private JTextField jtcountry=new JTextField("Type your country");
    private JButton jbsubmit=new JButton("Submit");
    private JButton jbback=new JButton("GO BACK");
    
    public AddReceptionist()
    {
        
    setTitle("Entering The Receptionist's Data");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
     setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\on_the_couch-wallpaper-1280x800 (Custom).jpg")));
        
    Container cp=getContentPane();
    cp.setBackground(Color.LIGHT_GRAY);
    
    
    for(int i=0;i<83;i++){
       jcbage.addItem(18+i);
    }
    
    
    jlname.setBounds(10, 5, 175, 50);
    jtname.setBounds(125, 15, 300,30);
    
    jlpass.setBounds(10, 60, 175,30); 
    jtpass.setBounds(125, 60, 300, jtname.getHeight());
    
    jltel.setBounds(10, 105, jlname.getWidth(), jtname.getHeight());
    jttel.setBounds(125,105 , jlname.getWidth(), jtname.getHeight());
    
    jlage.setBounds(10, jttel.getY()+45, jlname.getWidth(), jtname.getHeight());
    jcbage.setBounds(125, jttel.getY()+45, jlname.getWidth(), jtname.getHeight());
    
    jlemail.setBounds(10, jlage.getY()+35, jlname.getWidth(), jtname.getHeight());
    jtemail.setBounds(125, jcbage.getY()+45, jlname.getWidth(), jtname.getHeight());
    
    jlcountry.setBounds(10, jlemail.getY()+45, jlname.getWidth(), jtname.getHeight());
    jtcountry.setBounds(125, jtemail.getY()+45, jlname.getWidth(), jtname.getHeight());
    
    jbsubmit.setBounds(300, 440, 175,50);
    jbback.setBounds(10,440,175,50);
    
    jlname.setForeground(Color.WHITE);
    jlpass.setForeground(Color.WHITE);
    jltel.setForeground(Color.WHITE);
    jlage.setForeground(Color.WHITE);
    jlemail.setForeground(Color.WHITE);
    jlcountry.setForeground(Color.WHITE);
    
    jbsubmit.setBackground(Color.WHITE);
    jbsubmit.setForeground(Color.BLACK);
    jbback.setBackground(Color.WHITE);
    jbback.setForeground(Color.BLACK);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    
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
    this.add(jbback);
    
    jbsubmit.addActionListener(handler);
    jbback.addActionListener(handler);
    this.jtname.addMouseListener(mw);
    this.jtpass.addMouseListener(mw);
    this.jttel.addMouseListener(mw);
    this.jtemail.addMouseListener(mw);
    this.jtcountry.addMouseListener(mw);
    
    }
    
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            try {
                Manger M1=new Manger();
                Receptionist R1=new Receptionist();
                ManagerMenu Third=new ManagerMenu();
            if(x.equals(jbsubmit)){
                String name=jtname.getText();
                String password=jtpass.getText();
                String tel=jttel.getText();
                int age=(int)jcbage.getSelectedItem();
                String email=jtemail.getText();
                String country=jtcountry.getText();
                if( M1.Add_Account(name,password,tel,age,email,country)==true){
                    JOptionPane.showMessageDialog(null, "Receptionist added..ID is: "+(R1.receptionistId()-1)+", Username is: "+name+(R1.receptionistId()-1));
                    Third.setVisible(true);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Receptionist Not Added");
                }
                
            }
            else if(x.equals(jbback)){
                Third.setVisible(true);
                dispose();    
            }
            } catch (IOException ex) {
                Logger.getLogger(AddReceptionist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddReceptionist.class.getName()).log(Level.SEVERE, null, ex);
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
        public void mouseReleased(MouseEvent e){
        
        
        }
        public void mousePressed(MouseEvent e){  }
        public void mouseDragged(MouseEvent e){  }
   
    }
}