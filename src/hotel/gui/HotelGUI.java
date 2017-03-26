
package hotel.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HotelGUI extends JPanel{
    
public static void Screens(){
        
              HomeScreen First=new HomeScreen();
              First.setVisible(true);
              First.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
}

    public static void main(String[] args) {
     Screens();  
    }
    
}
