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
        saveData(); // Supposingly save to file
    }

    public BankAccount lookup(String pin){
        for (int i = 0; i < getSize(); i++){
            BankAccount item = _list.get(i);
            if (item.getPin().equals(pin)){
                return item;
            }
        }
        return null;
    }

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

    public void updateItem(String name, String email, double balance, String address){
        BankAccount acc = lookup(name);
        _list.set(indexLookup(name), new BankAccount(acc.getPin(),email, name, balance, address));
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
        System.out.println("At save: "+_list);
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
        System.out.println("At load: "+_list);
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
}
