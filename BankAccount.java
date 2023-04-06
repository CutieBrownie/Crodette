/**
 * This class represents one item in the list.
 */
public class BankAccount {
    private String _email;        // Item ID number
    private String _pin;   // Item name
    private double _balance;
    private String _address;
    private String _name;

    // Two-argument constructor
    public BankAccount(String pin, String email, String name, double balance, String address) {
        _pin = pin;
        _email = email;
        _name = name;
        _balance = balance;
        _address = address;
    }

    public void setPin(String pin){
        _pin = pin;
    }

    public String getPin(){
        return _pin;
    }

    public void setEmail(String email){
        _email = email;
    }

    public String getEmail(){
        return _email;
    }

    public void setName(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }

    public void setBalance(double price){
        _balance = price;
    }

    public double getBalance(){
        return _balance;
    }

    public void setAddress(String address){
        _address = address;
    }

    public String getAddress(){
        return _address;
    }

    public String toString(){
        return getPin()+","+getEmail()+","+getName()+","+getBalance()+","+getAddress();
    }
}
