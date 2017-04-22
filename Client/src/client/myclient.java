/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.io.*;
import java.net.*;

 

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myclient {
    private Socket socket;
    private PrintWriter pwToClient;
    private BufferedReader fromServer;
    static final int PORT_NUMBER=3000;
    public boolean run(String id, String type, String view, String nights) throws InterruptedException{
        try {
            socket=new Socket("127.0.0.1",PORT_NUMBER);
            String s;
            s=id+"@"+type+"@"+view+"@"+nights;
            pwToClient=new PrintWriter(socket.getOutputStream(),true);
            pwToClient.println(s);
            Thread.sleep(1500);
            fromServer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String data=fromServer.readLine();
            if(data.equals("Done")){
            return true;
            }
            else if(data.equals("failed")){
                return false;
            }
            pwToClient.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Trouble with a connection"+e);
        }
        return false;
    }
}
