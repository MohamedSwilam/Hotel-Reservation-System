
package Manager;

import hotel.code.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.DataOutputStream;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchReceptionist extends JFrame{
    private JLabel jlid=new JLabel("Enter receptionist ID");
    private JTextField jtid=new JTextField("Type ID");
    private JButton jbgetdata=new JButton("Get data");
    private JButton jbgoback=new JButton("BACK");
    public SearchReceptionist(){
    setTitle("Searching Receptionist's Data");
    setSize(500, 550);
    setLayout(null);
    
     setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\salk_institute_fisheye-wallpaper-960x600.jpg")));
        
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
    Container cp=getContentPane();
    cp.setBackground(Color.lightGray);
    
    jlid.setBounds(150, 50, 200, 50);
    jtid.setBounds(jlid.getX(), jlid.getY()+50, jlid.getWidth(), jlid.getHeight()-10);
    
    jbgetdata.setBounds(300,450,175, 50);
    jbgoback.setBounds(10, 450, 175, 50);
    
    jbgetdata.setBackground(Color.darkGray);
    jbgetdata.setForeground(Color.white);
    jbgoback.setBackground(Color.darkGray);
    jbgoback.setForeground(Color.white);
    
    
    this.add(jlid);
    this.add(jtid);
    this.add(jbgetdata);
    this.add(jbgoback);
    
    jbgetdata.addActionListener(handler);
    jtid.addMouseListener(mw);
    jbgoback.addActionListener(handler);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            ManagerMenu Third=new ManagerMenu();
            if(x.equals(jbgoback)){
                Third.setVisible(true);
                dispose();    
                 }
            try {
                Manger M1=new Manger();
                 if(x.equals(jbgetdata)){
                      int id=Integer.parseInt(jtid.getText());
                      ReceptionistData Seventh=new ReceptionistData(id);
                if(M1.check_id(id)==true){
                    Seventh.setVisible(true);
                    dispose();
                }
                else{
                JOptionPane.showMessageDialog(null, "ID Not Found!");
                }
            }
           
            } catch (IOException ex) {
                Logger.getLogger(SearchReceptionist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SearchReceptionist.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
     }
     private class mousewatch extends MouseMotionAdapter implements MouseListener
            {
        public void mouseClicked(MouseEvent e)
        {
            Object o =e.getSource();
            if( o.equals(jtid)){
            jtid.setText("");
            }
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){  }
        public void mouseDragged(MouseEvent e){  }
   
    }
}
