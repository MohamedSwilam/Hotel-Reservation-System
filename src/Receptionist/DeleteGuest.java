
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class DeleteGuest extends JFrame{
   private JLabel jlid=new JLabel("Enter receptionist ID");
    private JTextField jtid=new JTextField("Type ID");
    private JButton jbdelete=new JButton("Delete account");
    private JButton jbgoback=new JButton("GO BACK");
    public DeleteGuest(){
    setTitle("Deleting guest's Data");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
    
    Container cp=getContentPane();
    cp.setBackground(Color.cyan);
    
   
     setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\mount_fuji_autumn_maple_japan-1280x800.jpg")));
     
    jlid.setBounds(150, 100, 175, 50);
    jtid.setBounds(jlid.getX(), jlid.getY()+50, jlid.getWidth(), jlid.getHeight()-20);
    jbdelete.setBounds(300,350,175, 50);
    jbgoback.setBounds(100, 350, 175, 50);
    
    
    jbdelete.setBackground(Color.darkGray);
    jbdelete.setForeground(Color.white);
    jbgoback.setBackground(Color.darkGray);
    jbgoback.setForeground(Color.white);
    
    
    this.add(jlid);
    this.add(jtid);
    this.add(jbdelete);
    this.add(jbgoback);
    
    
    jbdelete.addActionListener(handler);
    jbgoback.addActionListener(handler);
    jtid.addMouseListener(mw);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }
    
    
     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            Object x=e.getSource();
            Receptionist R1=new Receptionist();
            ReceptionistMenu Tenth=new ReceptionistMenu();
            
            if(x.equals(jbdelete)){
                int id=Integer.parseInt(jtid.getText());
                try {
                    if(R1.check_id(id)==true){
                        if(R1.check_payment(id)==true){
                        if(R1.Delete_Account(id)==true){
                            JOptionPane.showMessageDialog(null, "Succesfully deleted");
                            Tenth.setVisible(true);
                            dispose();
                        }
                    }
                        else
                            JOptionPane.showMessageDialog(null, "Can't delete the guest..Confirm the payment first!");
                }
                    else{
                        JOptionPane.showMessageDialog(null, "ID Not Found!");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DeleteGuest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DeleteGuest.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if(x.equals(jbgoback)){
                Tenth.setVisible(true);
                dispose();
                
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
