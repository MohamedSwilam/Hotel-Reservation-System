
package Manager;

import Manager.ManagerMenu;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import hotel.code.*;
import hotel.gui.HomeScreen;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoginAsManager extends JFrame{
    
    private JButton jbsign=new JButton("LOGIN");
    private JLabel jlname=new JLabel("Enter your username");
    private JLabel jlpass=new JLabel("Password");
    private JTextField jtname=new JTextField("Type your username");
    private JTextField jtpass=new JTextField("Type your password");
    private JButton jbback=new JButton("BACK");
    public LoginAsManager(){
    setTitle("Login as manager");
    setSize(500, 550);
    setLayout(null);
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\on_the_couch-wallpaper-1280x800 (Custom).jpg")));
        
    myHandler hanlder=new myHandler();
    mousewatch mw=new mousewatch();
    Container cp=getContentPane();
    
    
   
    jlname.setBounds(150, 50, 175, 50);
    jtname.setBounds(150, jlname.getY()+50, 200, jlname.getHeight()-20);
    jlpass.setBounds(150, jtname.getY()+50, jlname.getWidth(), jlname.getHeight()); 
    jtpass.setBounds(150, jlpass.getY()+50, jtname.getWidth(), jtname.getHeight());
    jbsign.setBounds(300,450,175, 50);
    jbback.setBounds(10,450,175, 50);
    
    jbsign.setBackground(Color.darkGray);
    jbsign.setForeground(Color.white);
    jbback.setBackground(Color.darkGray);
    jbback.setForeground(Color.white);
    
    this.add(jlname);
    this.add(jlpass);
    this.add(jtname);
    this.add(jtpass);
    this.add(jbsign);
    this.add(jbback);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    jbsign.addActionListener(hanlder);
    jtname.addMouseListener(mw);
    jtpass.addMouseListener(mw);
    jbback.addActionListener(hanlder);
    }
    
      
    
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource(); 
            Manger M1;
            try {
                M1 = new Manger();
                ManagerMenu Third=new ManagerMenu();
                HomeScreen home=new HomeScreen();
                    if(x.equals(jbsign)){
                        String name=jtname.getText();
                        String password=jtpass.getText();
                        if(M1.SignIn(name,password)==true){
                            Third.setVisible(true);
                            dispose();
                        }
                        else{
                         JOptionPane.showMessageDialog(null, "Wrong username or Password!");
                        }
                    }
                    else if(x.equals(jbback)){
                        home.setVisible(true);
                        dispose();
                    }
            } catch (IOException ex) {
                Logger.getLogger(LoginAsManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginAsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
     private class mousewatch extends MouseMotionAdapter implements MouseListener
            {
        public void mouseClicked(MouseEvent e)
        {
             Object o=e.getSource();
            if(o.equals(jtname)){
             jtname.setText("");
            }
            else if(o.equals(jtpass)){
             jtpass.setText("");
        }
        }
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseDragged(MouseEvent e){}
   
    }
     
       
}

