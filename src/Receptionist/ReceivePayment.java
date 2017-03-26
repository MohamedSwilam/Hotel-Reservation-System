
package Receptionist;

import Receptionist.ReceptionistMenu;
import hotel.code.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReceivePayment extends JFrame{
    private JLabel jlguestid=new JLabel("Guest ID:");
    private JTextField jtguestid=new JTextField("Type Guest ID");
    private JButton jbsubmit=new JButton("Submit");
    private JLabel jlname=new JLabel("Name:");
    private JLabel jltotal=new JLabel("Total:");
    private JLabel jlamounttopay=new JLabel("Guest Amount To Pay:");
    private JTextField jtname=new JTextField();
    private JTextField jttotal=new JTextField();
    private JTextField jtamounttopay=new JTextField("Amount To Pay");
    private JButton jbconfirmpay=new JButton("Confirm Payment");
    private JButton jbgoback=new JButton("GO BACK");
    public ReceivePayment(){
    setTitle("Receive Payment");
    setSize(500,550);
    
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
    Container cp=getContentPane();
    cp.setBackground(Color.ORANGE);
    setLayout(null);
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\beautiful_house-wallpaper-1280x800 (Custom).jpg")));
        
    jlguestid.setBounds(10, 20, 175, 40);
    jtguestid.setBounds(jlguestid.getX()+75, jlguestid.getY(), jlguestid.getWidth(),jlguestid.getHeight());
    jbsubmit.setBounds(jtguestid.getX()+200, jlguestid.getY(), jlguestid.getWidth()-75,jlguestid.getHeight());
    jlname.setBounds(10, 200, 175, 40); 
    jtname.setBounds(jlname.getX()+150, jlname.getY(), jlname.getWidth(), jlname.getHeight()-10);
    jltotal.setBounds(jlname.getX(), jtname.getY()+75, jtname.getWidth(), jtname.getHeight());
    jttotal.setBounds(jltotal.getX()+150, jltotal.getY(), jltotal.getWidth(), jltotal.getHeight());
    jlamounttopay.setBounds(jltotal.getX(), jttotal.getY()+75, jttotal.getWidth(), jttotal.getHeight());
    jtamounttopay.setBounds(jlamounttopay.getX()+150, jlamounttopay.getY(), jlamounttopay.getWidth(), jlamounttopay.getHeight());
    jbgoback.setBounds(10, 450, 175, 40);
    jbconfirmpay.setBounds(300, 450, 175, 40);
    
   
    this.add(jlguestid);
    this.add(jtguestid);
    this.add(jbsubmit);
    this.add(jlname);
    this.add(jtname);
    this.add(jltotal);
    this.add(jttotal);
    this.add(jlamounttopay);
    this.add(jtamounttopay);
    this.add(jbgoback);
    this.add(jbconfirmpay);
    
    
    jlname.setVisible(false);
    jtname.setVisible(false);
    jltotal.setVisible(false);
    jttotal.setVisible(false);
    jlamounttopay.setVisible(false);
    jtamounttopay.setVisible(false);
    
    
    jtname.setEditable(false);
    jttotal.setEditable(false);
    
    
    
    jbsubmit.addActionListener(handler);
    jbgoback.addActionListener(handler);
    jbconfirmpay.addActionListener(handler);
    jtguestid.addMouseListener(mw);
    jtname.addMouseListener(mw);
    jttotal.addMouseListener(mw);
    jtamounttopay.addMouseListener(mw);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            Receptionist R1=new Receptionist();
            Reservation res=new Reservation();
            ReceptionistMenu Tenth=new ReceptionistMenu();
            if(x.equals(jbsubmit)){
                int id=Integer.parseInt(jtguestid.getText());
                try {
                    if(R1.check_id(id)==true){
                        jtname.setText(R1.Search_Account(id).Get_Name());
                        jttotal.setText(Double.toString(res.get_total_price(id)));
                        jlname.setVisible(true);
                        jtname.setVisible(true);
                        jltotal.setVisible(true);
                        jttotal.setVisible(true);
                        jlamounttopay.setVisible(true);
                        jtamounttopay.setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "ID Not Found!");
                }
                catch (IOException ex) {
                    Logger.getLogger(ReceivePayment.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ReceivePayment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        if(x.equals(jbconfirmpay)){
                             double pay=Double.parseDouble(jtamounttopay.getText());
                             int id=Integer.parseInt(jtguestid.getText());
                            if(R1.payment(id,pay)==true){
                            JOptionPane.showMessageDialog(null, "Payment Succeded");
                            Tenth.setVisible(true);
                            dispose();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "invalid value!");
                        }
                    
                    
                
                
                
            
             if(x.equals(jbgoback)){
            Tenth.setVisible(true);
            dispose();
            }
           
        }
    
}
     private class mousewatch extends MouseMotionAdapter implements MouseListener
            {
        public void mouseClicked(MouseEvent e)
        {
            Object o=e.getSource();
            if(o.equals(jtguestid)){ 
            jtguestid.setText("");
            }
            else if(o.equals(jtamounttopay)){
            jtamounttopay.setText("");
            }
            
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseDragged(MouseEvent e){}
   
    }
}
