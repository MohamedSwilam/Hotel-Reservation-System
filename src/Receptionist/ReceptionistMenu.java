
package Receptionist;

import hotel.gui.HomeScreen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ReceptionistMenu extends JFrame{
    private JButton jbadd=new JButton("Add Guest");
    private JButton jbedit=new JButton("Edit Guest");
    private JButton jbdelete=new JButton("Delete Guest");
    private JButton jbsearch=new JButton("Search Guest");
    private JButton jbreceive=new JButton("Receive Payment");
    private JButton jbmenu=new JButton("For Signout");
    public ReceptionistMenu(){
    setTitle("Choose What You Want To Do");
    setSize(500, 550);
    setLayout(null);
    myHandler handler=new myHandler();
    
    Container cp=getContentPane();
    cp.setBackground(Color.cyan);
    
     setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\mount_fuji_autumn_maple_japan-1280x800.jpg")));
   
    
    jbadd.setBounds(150,50,175,50);
    jbedit.setBounds(jbadd.getX(), jbadd.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbdelete.setBounds(jbadd.getX(), jbedit.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbsearch.setBounds(jbadd.getX(), jbdelete.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbreceive.setBounds(jbadd.getX(), jbsearch.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    jbmenu.setBounds(jbadd.getX(), jbreceive.getY()+75, jbadd.getWidth(),jbadd.getHeight());
    
    
    jbadd.setBackground(Color.white);
    jbedit.setBackground(Color.white);
    jbdelete.setBackground(Color.white);
    jbsearch.setBackground(Color.white);
    jbreceive.setBackground(Color.white);
    jbmenu.setBackground(Color.white);

    
    this.add(jbadd);
    this.add(jbedit);
    this.add(jbdelete);
    this.add(jbsearch);
    this.add(jbreceive);
    this.add(jbmenu);
    
    
    jbadd.addActionListener(handler);
    jbedit.addActionListener(handler);
    jbdelete.addActionListener(handler);
    jbsearch.addActionListener(handler);
    jbreceive.addActionListener(handler);
    jbmenu.addActionListener(handler);
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }
    
    

    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            AddGuest Eleventh=new AddGuest();
            EditGuest Twelfth=new EditGuest();
            SearchGuest Thirteen=new SearchGuest();
            DeleteGuest Fifteenth=new DeleteGuest();
            HomeScreen First=new HomeScreen();
            ReceivePayment receive=new ReceivePayment();
                    if(x.equals(jbadd)){
                        Eleventh.setVisible(true);
                        dispose();
                    }
                    else if(x.equals(jbedit)){
                        Twelfth.setVisible(true);
                        dispose();
                    }
                    else if(x.equals(jbdelete)){
                        Fifteenth.setVisible(true);
                        dispose();   
                    }
                    else if(x.equals(jbsearch)){
                        Thirteen.setVisible(true);
                        dispose();
                    }
                    else if(x.equals(jbreceive)){
                         receive.setVisible(true);
                         dispose();
                    }
                    else if(x.equals(jbmenu)){
                        First.setVisible(true);
                        dispose();
                    }
        }
    
}
}