package hotel.code;

import java.io.Serializable;

public class Staff extends Human implements Serializable{

    private double Salary;

    public Staff() {
    }

    public void Set_Salary(double s) {
        Salary=s;
    }

    public double Get_Salary() {
        return Salary;
    }
}
