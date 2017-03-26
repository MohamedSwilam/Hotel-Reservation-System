
package Manager;

import Manager.DeleteReceptionist;
import Manager.SearchReceptionist;
import Manager.EditReceptionist;
import Manager.AddReceptionist;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import hotel.code.*;
import hotel.gui.HomeScreen;
import hotel.gui.Statistics;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ManagerMenu extends JFrame{
    private JButton jbadd=new JButton("Add Receptionist");
    private JButton jbedit=new JButton("Edit Receptionist");
    private JButton jbdelete=new JButton("Delete Recetionist");
    private JButton jbsearch=new JButton("Search Recetionist");
    private JButton jbservice=new JButton("Add Service");
    private JButton jbgenerate=new JButton("Generate/Reset Rooms File");
    private JButton jbstat=new JButton("Statistics Of Rooms");
    private JButton jbmenu=new JButton("For Signout");
    
    ManagerMenu() {
        
        setTitle("Choose What You Want To Do");
    setSize(500, 650);
    setLayout(null);
     myHandler handler=new myHandler();
    
    Container cp=getContentPane();
    cp.setBackground(Color.lightGray);
    
    
     setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\underwater_bedroom-wallpaper-1280x800 (Custom).jpg")));
        
    jbadd.setBounds(150,15,200,50);
    jbedit.setBounds(jbadd.getX(), jbadd.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbdelete.setBounds(jbadd.getX(), jbedit.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbsearch.setBounds(jbadd.getX(), jbdelete.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbservice.setBounds(jbadd.getX(), jbsearch.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbgenerate.setBounds(jbadd.getX(), jbservice.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbstat.setBounds(jbadd.getX(), jbgenerate.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbmenu.setBounds(jbadd.getX(), jbstat.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    
    jbadd.setBackground(Color.WHITE);
    jbedit.setBackground(Color.WHITE);
    jbdelete.setBackground(Color.WHITE);
    jbsearch.setBackground(Color.WHITE);
    jbservice.setBackground(Color.WHITE);
    jbgenerate.setBackground(Color.WHITE);
    jbmenu.setBackground(Color.WHITE);
    jbstat.setBackground(Color.WHITE);
    
    this.add(jbadd);
    this.add(jbedit);
    this.add(jbdelete);
    this.add(jbsearch);
    this.add(jbservice);
    this.add(jbgenerate);
    this.add(jbmenu);
    this.add(jbstat);
    
    jbadd.addActionListener(handler);
     jbedit.addActionListener(handler);
      jbdelete.addActionListener(handler);
       jbsearch.addActionListener(handler);
       jbservice.addActionListener(handler);
       jbgenerate.addActionListener(handler);
        jbmenu.addActionListener(handler);
        jbstat.addActionListener(handler);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
    }
     
    

     private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            Object x=e.getSource();
            AddReceptionist Forth=new AddReceptionist();
            EditReceptionist Fifth=new EditReceptionist();
            SearchReceptionist Sixth=new SearchReceptionist();
            DeleteReceptionist Eighth=new DeleteReceptionist();
            HomeScreen First=new HomeScreen();
            AddService service=new AddService();
            Statistics stat=new Statistics();
            if(x.equals(jbadd)){                                                                            
                 Forth.setVisible(true);
                 dispose();
            }
            else if(x.equals(jbedit)){
                 Fifth.setVisible(true);
                 dispose();
            }        
            else if(x.equals(jbdelete)){
                 Eighth.setVisible(true);  
                 dispose();
            }    
            else if(x.equals(jbsearch)){
                 Sixth.setVisible(true);
                 dispose();
            }
            else if(x.equals(jbservice)){
                 service.setVisible(true);
                 dispose();
            }
            else if(x.equals(jbgenerate)){
                 Room r1=new Room();
                 r1.hotel_rooms();
                 JOptionPane.showMessageDialog(null, "Done");
            }
            else if(x.equals(jbmenu)){
                 First.setVisible(true);
                 dispose();
            }
            else if(x.equals(jbstat)){
                stat.setVisible(true);
                dispose();
            
            }
                    
        }
    
}
    
}
