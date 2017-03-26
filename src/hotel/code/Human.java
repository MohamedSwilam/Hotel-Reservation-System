package hotel.code;

import java.io.Serializable;

public abstract class Human implements Serializable{

    private int ID;

    private String Name;
    
    private String password;

    private String TeleNO;

    private int Age;

    private String EmailAddress;

    private String Country;
    
    private String userName;
    
    //**********************************************/

    public void Set_ID(int id) {
        ID = id;
    }

    public void Set_Name(String name) {
        Name = name;
    }
    public void Set_userName(String name,int id){
        userName=name+Integer.toString(id);
    }
    public void Set_password(String Password)
    {
        this.password=Password;
    }
    public void Set_TeleNO(String telenumber) {
        TeleNO = telenumber;
    }

    public void Set_Country(String country) {
        Country = country;
    }

    public void Set_EmailAddress(String Email) {
        EmailAddress = Email;
    }
    public void Set_Age(int age){
        Age = age;
    }
/*******************************************************************/
    public int Get_Age(){
    return Age;
    }
    public int Get_ID() {
        return ID;
    }
    public String Get_Password(){
        return password;
    }
    public String Get_Name() {
        return Name;
    }
    
    public String Get_userName(){
        return userName;
    }

    public String Get_PhoneNumber() {
    return TeleNO;
    }

    public String Get_Country() {
    return Country;
    }

    public String Get_EmailAddress() {
    return EmailAddress;
    }

   
}
