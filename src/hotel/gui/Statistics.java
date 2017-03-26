/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;
import hotel.code.Room;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ada
 */
public class Statistics extends JFrame{
    private JLabel jlreserved=new JLabel("Reserved Rooms");
    private JLabel jlempty=new JLabel("Empty Rooms");
   public Statistics()
   {
      setTitle("Statistics Of Reserved Rooms And Empty Rooms");
      setSize(550, 600);
      Container cp=getContentPane();
      cp.add(new PaintPane());
      
      
   }
    public class PaintPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    
   public void paintComponent(Graphics g){
       Room r=new Room();
       super.paintComponent(g);
        try {
                BufferedImage img=ImageIO.read(new File("C:\\Users\\moham\\OneDrive\\Documents\\NetBeansProjects\\Hotel-code\\Hotel Picture\\modern_interior-wallpaper-1280x800.jpg"));
                g.drawImage(img, 0, 0, null);
            } catch (IOException ex) {
                Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            }
        
     
        final int degree=360;
      
        g.drawArc(100, 100, 350, 350, 360, 360);
        g.setColor(Color.red);
        g.fillArc(100, 100, 350, 350,(r.rooms_statistics()/500)*(100)*(degree) ,degree-(r.rooms_statistics()/500)*(100)*(degree));
     //g.fillArc(100, 100, 350, 350, 90,360-90);
        setLayout(null);
       
       
       
      jlreserved.setBounds(100, 20, 150, 50);
      jlempty.setBounds(300, 20, 150, 50);
      
      jlreserved.setForeground(Color.darkGray);
      jlempty.setForeground(Color.red);
      
      this.add(jlreserved);
      this.add(jlempty);
      
   }
    }
    
}