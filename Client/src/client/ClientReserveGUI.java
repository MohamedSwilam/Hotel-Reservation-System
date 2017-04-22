
package client;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ClientReserveGUI extends JFrame{
    private JButton jbreserve=new JButton("Reserve");
    private JComboBox jcbview=new JComboBox(new String[]{"--VIEW--"});
    private JComboBox jcbtype=new JComboBox(new String[]{"--TYPE--"});
    private JTextField jtnights=new JTextField("Enter number of nights");
    private JTextField jtid=new JTextField("Enter ID");
    public ClientReserveGUI(){
        setTitle("Online Reservation");
        setSize(550,550);
        setLayout(null);
        jcbview.addItem("pool");
        jcbview.addItem("beach");
        jcbtype.addItem("single");
        jcbtype.addItem("double");
        jcbtype.addItem("suite");
        
        myHandler handler=new myHandler();
        
        Container cp=getContentPane();
        cp.setBackground(Color.pink);
        
         jbreserve.setBounds(75+180,550-180,175,50);
         jcbtype.setBounds(150, 60, 175, 35);
         jcbview.setBounds(150, 100, 175, 35);
         jtnights.setBounds(jcbview.getX(), jcbview.getY()+100, jcbview.getWidth(), 50);
         jtid.setBounds(jtnights.getX(), jtnights.getY()+100, jtnights.getWidth(), 50);
         
         jbreserve.setBackground(Color.WHITE);
         jcbview.setBackground(Color.WHITE);
         jcbtype.setBackground(Color.WHITE);
         jtnights.setBackground(Color.WHITE);
         jtid.setBackground(Color.WHITE);
         
         this.add(jbreserve);
         this.add(jcbview);
         this.add(jcbtype);
         this.add(jtnights);
         this.add(jtid);
         
         jbreserve.addActionListener(handler);
    }
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            myclient client1=new myclient();
            Object x=e.getSource();
            if(x.equals(jbreserve)){
                String type = (String)jcbtype.getSelectedItem();
                String view=(String)jcbview.getSelectedItem();
                String nights=jtnights.getText();
                String id=jtid.getText();
                try {
                    if(client1.run(id,type,view,nights)==true){
                        JOptionPane.showMessageDialog(null, "Room Reserved");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to reserve!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClientReserveGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        }

