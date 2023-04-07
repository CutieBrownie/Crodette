import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will do all the I/O work
 * I call it database
 * 
 * Author: Linh Tu
 */

 public class Database {
    // The list of people
    private ArrayList<BankAccount> _list = new ArrayList<BankAccount>();

    public Database() {
        // generateRandomData();
        loadData(); // Supposingly load to use. Will clear the list and get new from txt file
        // saveData(); // Supposingly save to file
    }
    /**
     * Lookup account base on PIN
     * @param pin
     * @return
     */
    public BankAccount lookup(String pin){
        for (int i = 0; i < getSize(); i++){
            BankAccount item = _list.get(i);
            if (item.getPin().equals(pin)){
                return item;
            }
        }
        return null;
    }

    public BankAccount emailLookup(String email){
        for (int i = 0; i < getSize(); i++){
            BankAccount item = _list.get(i);
            if (item.getEmail().equals(email)){
                return item;
            }
        }
        return null;
    }

    /**
     * Lookup the index of item base on the PIN
     * @param pin
     * @return
     */
    private int indexLookup(String pin){
        for (int i = 0; i < getSize(); i++){
            BankAccount item = _list.get(i);
            if (item.getPin().equals(pin)){
                return i;
            }
        }
        return -1;
    }

    // Get the number of items in the list
    public int getSize() {
        return _list.size();
    }

    /**
     * This method will help update an account
     * @param pin - The PIN of the account
     * @param email
     * @param balance
     * @param address
     */
    public void updateItem(String name, String email, double balance, String address){
        BankAccount acc = lookupByName(name);
        _list.set(indexLookup(acc.getPin()), new BankAccount(acc.getPin(),email, name, balance, address));
        saveData();
        loadData();
    }

    private BankAccount lookupByName(String pin) {
        for (int i = 0; i < getSize(); i++){
            BankAccount item = _list.get(i);
            if (item.getName().equals(pin)){
                return item;
            }
        }
        return null;
    }
    /**
     * This method will only update the balance of the account
     * @param pin
     */
    public void updateBalance(String name, double amount){
        BankAccount acc = lookupByName(name);
        _list.set(indexLookup(acc.getPin()), new BankAccount(acc.getPin(),acc.getEmail(), name, amount, acc.getAddress()));
        saveData();
        loadData();
    }

    // Get a list item
    public BankAccount getItem(int index) {
        if (index > getSize() - 1){
            return null;
        }
        return _list.get(index);
    }

    public static void main(String[] args) throws Exception {
        Database self = new Database();
        // self.generateRandomData();
        
    }

    public void generateRandomData(){
        for (int i = 0; i < 100; i++){
            BankAccount acc = new BankAccount(""+(9900+i), "Tester+"+i+"@fakemail.com", "Tester"+i, 10000, "Address Fake "+i);
            _list.add(acc);
        }
    }

    public void saveData() {
        // Create 3 separate BankAccount objects (this will become an array list)
        PrintWriter writer = null;
        try {
            File fileDescriptor = new File("bank_account.txt");
            writer = new PrintWriter(fileDescriptor);
            for (int i = 0; i < _list.size(); i++) {
                BankAccount acc = _list.get(i);
                writer.println(acc);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Add error recovery here if needed
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public void loadData() {
        Scanner reader = null;
        try {
            File fileDescriptor = new File("bank_account.txt");
            reader = new Scanner(fileDescriptor);

            _list.clear();   // Make sure the list is empty before we start
            while (reader.hasNext()) {
                // Now split the string into separate fields...
                String record = reader.nextLine();
                String[] fields = record.split(",");
                BankAccount p = new BankAccount(fields[0],fields[1],fields[2],Double.parseDouble(fields[3]),fields[4]); // ID
                _list.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Add error recovery here if needed
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void viewDatabase(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(_list.get(i));
        }
    }
}

