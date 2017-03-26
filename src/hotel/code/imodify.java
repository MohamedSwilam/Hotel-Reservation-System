package hotel.code;

import java.io.IOException;
import java.util.ArrayList;

public interface imodify {

    public boolean Add_Account(String name,String pass,String tele,int age,String email,String country)throws IOException, ClassNotFoundException;

    public boolean Update_Account(int id,String name,String pass,String tele,int age,String email,String country) throws IOException, ClassNotFoundException;

    public boolean Delete_Account(int id) throws IOException, ClassNotFoundException;
    
    public boolean check_id(int id) throws IOException, ClassNotFoundException;
}
