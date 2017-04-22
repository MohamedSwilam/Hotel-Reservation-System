
package client;

import javax.swing.JFrame;


public class Client {
    public static void main(String[] args) {
        ClientReserveGUI First=new ClientReserveGUI();
        ClientReserveGUI second=new ClientReserveGUI();
        First.setVisible(true);
        second.setVisible(true);
        
        First.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
