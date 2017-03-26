package hotel.code;

public class Gym extends Servises {

    private int No_Of_months;
    
    private double price;

    public Gym() {
        
    }

    public void Set_No_Of_months(int noOfMonths) {
        No_Of_months=noOfMonths;
    }
    
    public int Get_No_Of_months() {
        return No_Of_months;
    }
    
    public double get_price(){
        price=250;
        return price;
    }
    
}
