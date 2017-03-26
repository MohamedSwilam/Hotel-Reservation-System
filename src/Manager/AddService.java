
package Manager;

import Manager.ManagerMenu;
import Manager.AddGlassBoat;
import Manager.AddSafari;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class AddService extends JFrame{
    private JButton jbsafari=new JButton("Add Safari Trip");
    private JButton jbglassboat=new JButton("Add Glass Boat Trip");
    private JButton jbgoback=new JButton("GO BACK");
    public AddService(){
    setTitle("AddService");
    setSize(500,550);
    myHandler handler=new myHandler();
    
    
    setLayout(null);
    
    setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\on_the_couch-wallpaper-1280x800 (Custom).jpg")));
      
    Container cp=getContentPane();
    cp.setBackground(Color.red);
    
    
    jbsafari.setBounds(150, 50, 175, 75);
    jbglassboat.setBounds(jbsafari.getX(), jbsafari.getY()+100, jbsafari.getWidth(), jbsafari.getHeight());
    jbgoback.setBounds(150, 400, jbsafari.getWidth(), jbsafari.getHeight());
    
    jbsafari.setBackground(Color.white);
    jbglassboat.setBackground(Color.white);
    jbgoback.setBackground(Color.white);

    
    this.add(jbsafari);
    this.add(jbglassboat);
    this.add(jbgoback);
    
    jbsafari.addActionListener(handler);
    jbglassboat.addActionListener(handler);
    jbgoback.addActionListener(handler);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            AddSafari safari=new AddSafari();
            AddGlassBoat glassboat=new AddGlassBoat();
            ManagerMenu Third=new ManagerMenu();
            Object x=e.getSource(); 
                    if(x.equals(jbsafari)){
                    safari.setVisible(true);
                        dispose();
                    }
                    else if(x.equals(jbglassboat)){
                    glassboat.setVisible(true);
                        dispose();
                    }
                    else if(x.equals(jbgoback)){
                        Third.setVisible(true);
                        dispose();
                    }
    }
    }
}