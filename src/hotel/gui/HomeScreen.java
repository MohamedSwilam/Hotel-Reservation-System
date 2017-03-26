
package hotel.gui;
import Guest.LoginAsGuest;
import Manager.LoginAsManager;
import Receptionist.LoginAsReceptionist;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame{
     private JLabel jltitle=new JLabel("LOGIN AS");
     private JButton jbmanager=new JButton("Manager");
     private JButton jbreceptionist=new JButton("Receptionist"); 
     private JButton jbguest=new JButton("Guest");
     private int Yaxis=175;
     private int Xaxis=450;
    public HomeScreen(){
        
    setTitle("Welcome");
    setSize(900, 500);
    setLayout(null);
    
    myHandler handler=new myHandler();
    Container cp=getContentPane();
    
    cp.setBackground(Color.ORANGE);
    
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\red_chair-wallpaper-1280x800 (Custom).jpg")));
    
    Font myFont=new Font("Dialog.italic",300,45);
    
    Font myFont2=new Font("Arial Italic",100,20);
    
    jltitle.setFont(myFont);
    jbmanager.setFont(myFont2);
    jbreceptionist.setFont(myFont2);
    jbguest.setFont(myFont2);
    
    jbmanager.setBounds(60,95+60,290,60);
    jbreceptionist.setBounds(60, 160+90, 290, 60);
    jbguest.setBounds(60, 225+120, 290, 60);
    jltitle.setBounds(110,15,260,50);
     
    
    
    jbguest.setBackground(Color.white);
    jbreceptionist.setBackground(Color.WHITE);
    jbmanager.setBackground(Color.WHITE);
    
    
    this.add(jbmanager);
    this.add(jbreceptionist);
    this.add(jbguest);
    this.add(jltitle);
    
    
    jbmanager.addActionListener( handler );
    jbreceptionist.addActionListener( handler );
    jbguest.addActionListener( handler );

    
    Thread th=new Thread()
    {
    public void run() {
        
        while (true) {
             if (Xaxis>1800)
             {
                 Xaxis=1000;
                 
             }
             repaint();
             
               try {
                  Thread.sleep(800); 
                  
               } catch (InterruptedException ex) { }
         
               Xaxis+=100;
        
        
                if (Xaxis<-200)
           {
               Xaxis=1000;
           }
               repaint();
         try {
                  Thread.sleep(800 );  
               } catch (InterruptedException ex) { }
         
               Xaxis-=100;
           }
           }
     
    };
    th.start();
    }
    
    public void paint(Graphics g) 
            
    {
        super.paint(g);                
        Font font = new Font("Comic Sans MS",Font.ITALIC,50);
        g.setFont(font);       
        g.setColor(Color.darkGray);
        g.drawString("WELCOME", Xaxis, Yaxis);     
      }
    
    
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object x=e.getSource();
            LoginAsManager Second=new LoginAsManager();
            LoginAsReceptionist Nineth=new LoginAsReceptionist();
            LoginAsGuest Sixteenth=new LoginAsGuest();
                    if(x.equals(jbmanager)){
                       Second.setVisible(true);
                       Second.setBounds(350, 175, 500, 550);
                       dispose();
                     
                    }
                    else if(x.equals(jbreceptionist)){
                        Nineth.setVisible(true);
                       Nineth.setBounds(350, 175, 500, 550);
                       dispose();
                    }
                    else if(x.equals(jbguest)){
                        Sixteenth.setVisible(true);
                        Sixteenth.setBounds(350, 175, 500, 550);
                       dispose();
                    }
        }
    
}
}
    

