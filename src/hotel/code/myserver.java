
package hotel.code;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class myserver {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter pwToSocket;
    private BufferedReader fromSocket;
    static final int PORT_NUMBER=3000;
    public myserver(){
        try {
            serverSocket=new ServerSocket(PORT_NUMBER);
        } catch (IOException e) {
            System.out.println("Trouble on port "+PORT_NUMBER+": "+e);
        }
    }
    public void run() throws InterruptedException{
        while (true)
        {
        try {
            socket=serverSocket.accept();
            //Thread.sleep(15000);
            fromSocket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String data=fromSocket.readLine();
            String []result=new String[10];
            int ctr=0;
            StringTokenizer st2=new StringTokenizer(data,"@");
            while(st2.hasMoreElements()){
            result[ctr]=st2.nextToken();
            ctr++;
            }
            int id=Integer.parseInt(result[0]);
            String type=result[1];
            String view=result[2];
            int nights=Integer.parseInt(result[3]);
            Room r1=new Room();
            Reservation res=new Reservation();
            int roomno=r1.get_empty_room(type ,view);
            if(res.ReserveRoom(roomno,nights,id)==true){
            pwToSocket=new PrintWriter(socket.getOutputStream(),true);
            pwToSocket.println("Done");
            pwToSocket.close();
            System.out.println("Room reserved");
            System.out.println("Your room number is: "+roomno);
            }
            else{
            pwToSocket=new PrintWriter(socket.getOutputStream(),true);
            pwToSocket.println("failed");
            pwToSocket.close();
            System.err.println("Room is already reserved!");
            }
            fromSocket.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Trouble contacting the server "+e);
        }
        }
    }
}
