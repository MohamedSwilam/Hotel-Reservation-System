
package hotel.code;

public interface iPay {
    void creditcard(int id,double price);
    void cash(int id,double price);
    void cheque(int id,double price);
}
