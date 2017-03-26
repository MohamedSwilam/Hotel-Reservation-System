
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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


class DeleteReceptionist extends JFrame{ 
    private JLabel jlid=new JLabel("Enter receptionist ID");
    private JTextField jtid=new JTextField("Type ID");
    private JButton jbdelete=new JButton("Delete account");
    private JButton jbgoback=new JButton("GO BACK");
    public  DeleteReceptionist(){
    setTitle("Deleting  Receptionist's Data");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    mousewatch mw=new mousewatch();
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\on_the_couch-wallpaper-1280x800 (Custom).jpg")));
        
    Container cp=getContentPane();
    cp.setBackground(Color.LIGHT_GRAY);
    
    jlid.setBounds(150, 100, 175, 50);
    jtid.setBounds(jlid.getX(), jlid.getY()+50, jlid.getWidth(), jlid.getHeight()-20);
    
    jbdelete.setBounds(300,450,175, 50);
    jbgoback.setBounds(10, 450, 175, 50); 
     
    jbdelete.setBackground(Color.darkGray);
    jbdelete.setForeground(Color.white);
    jbgoback.setBackground(Color.darkGray);
    jbgoback.setForeground(Color.white);
    
    this.add(jlid);
    this.add(jbdelete);
    this.add(jbgoback);
    this.add(jtid);
    
    jbdelete.addActionListener(handler);
    jbgoback.addActionListener(handler);
    jtid.addMouseListener(mw);
    
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
            if(x.equals(jbdelete)){
                Manger M1=new Manger();
                int id=Integer.parseInt(jtid.getText());
                if(M1.check_id(id)==true){
                    if(M1.Delete_Account(id)==true){
                    JOptionPane.showMessageDialog(null, "Succesfully deleted");
                    Third.setVisible(true);
                    dispose();
                    }
                }
                else
                JOptionPane.showMessageDialog(null, "ID Not Found!");
            }
             
            } catch (IOException ex) {
                Logger.getLogger(DeleteReceptionist.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DeleteReceptionist.class.getName()).log(Level.SEVERE, null, ex);
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
