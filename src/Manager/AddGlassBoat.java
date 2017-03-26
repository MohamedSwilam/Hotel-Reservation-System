
package Manager;

import Manager.AddSafari;
import hotel.code.Manger;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddGlassBoat extends JFrame{
    private JLabel jlsd=new JLabel("Start Date:");
    private JLabel jlst=new JLabel("Start Time:");
    private JLabel jled=new JLabel("End Time:");
    private JLabel jlprice=new JLabel("Price:");
    private JLabel jlnum=new JLabel("Tickets:");
    private JTextField jtsd=new JTextField("Type Start Date");
    private JTextField jtst=new JTextField("Type Start Time");
    private JTextField jtet=new JTextField("Type End Date");
    private JTextField jtprice=new JTextField("Enter Price");
    private JTextField jtnum=new JTextField("Enter Number Of Tickets");
    private JButton jbsubmit=new JButton("Submit");
    private JButton jbgoback=new JButton("GO BACK");
    public AddGlassBoat(){
    setTitle("Add Glassboat");
    setSize(500,550);
    
   myHandler handler=new myHandler();
   mousewatch mw=new mousewatch();
    
    
    setLayout(null);
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\underwater_bedroom-wallpaper-1280x800 (Custom).jpg")));
      
    Container cp=getContentPane();
    cp.setBackground(Color.CYAN);
    
    
    jlsd.setBounds(75, 75, 150, 30);
    jtsd.setBounds(jlsd.getX()+75, jlsd.getY(), jlsd.getWidth(), jlsd.getHeight());
    jlst.setBounds(jlsd.getX(), jlsd.getY()+75, jlsd.getWidth(), jlsd.getHeight());
    jtst.setBounds(jlst.getX()+75, jlst.getY(), jlsd.getWidth(), jlsd.getHeight());
    jled.setBounds(jlsd.getX(), jlst.getY()+75, jlsd.getWidth(), jlsd.getHeight());
    jtet.setBounds(jled.getX()+75, jled.getY(),jlsd.getWidth(), jlsd.getHeight());
    jlprice.setBounds(jled.getX(), jled.getY()+75,jlsd.getWidth(), jlsd.getHeight());
    jtprice.setBounds(jlprice.getX()+75, jlprice.getY(),jlsd.getWidth(), jlsd.getHeight());
    jlnum.setBounds(jlprice.getX(), jlprice.getY()+75,jlsd.getWidth(), jlsd.getHeight());
    jtnum.setBounds(jlnum.getX()+75, jlnum.getY(), jlsd.getWidth(), jlsd.getHeight());
    jbsubmit.setBounds(250, 430, 185, 45);
    jbgoback.setBounds(50, 430, 185, 45);
    
   jlsd.setForeground(Color.WHITE);
   jlst.setForeground(Color.WHITE);
   jled.setForeground(Color.WHITE);
   jlprice.setForeground(Color.WHITE);
   jlnum.setForeground(Color.WHITE);
   
    
    this.add(jlsd);
    this.add(jlst);
    this.add(jled);
    this.add(jtsd);
    this.add(jtst);
    this.add(jtet);
    this.add(jlprice);
    this.add(jtprice);
    this.add(jlnum);
    this.add(jtnum);
    this.add(jbsubmit);
    this.add(jbgoback);
    
    jbsubmit.addActionListener(handler);
    jbgoback.addActionListener(handler);
    jtsd.addMouseListener(mw);
    jtst.addMouseListener(mw);
    jtet.addMouseListener(mw);
    jtprice.addMouseListener(mw);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    AddService service=new AddService();
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource(); 
            try {
                Manger M1=new Manger();
                if(x.equals(jbsubmit)){
                String SD=jtsd.getText();
                String ST=jtst.getText();
                String ET=jtet.getText();
                double price=Double.parseDouble(jtprice.getText());
                int num=Integer.parseInt(jtnum.getText());
                if(M1.add_glassboat(SD,ST,ET, price,num)==true){
                    JOptionPane.showMessageDialog(null, "Glass Boat Trip added");
                }
                else
                     JOptionPane.showMessageDialog(null, "Failed");
                        
            }
            else if(x.equals(jbgoback)){
                service.setVisible(true);
                dispose();
            }
            } catch (IOException ex) {
                Logger.getLogger(AddSafari.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddSafari.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
     private class mousewatch extends MouseMotionAdapter implements MouseListener
            {
        public void mouseClicked(MouseEvent e)
        {
            Object o=e.getSource();
            if(o.equals(jtsd)){
            jtsd.setText("");
            }
            else if(o.equals(jtst)){
            jtst.setText("");
            }
            else if(o.equals(jtet)){
            jtet.setText("");
            }
             else if(o.equals(jtprice)){
            jtprice.setText("");
            }
             else if(o.equals(jtnum)){
            jtnum.setText("");
            }
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseDragged(MouseEvent e){}
   
    }
    
}
