import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class TransferController {
    private Database _list = LoginController._list;  // A reference to the list of Bank Accounts
    static String _loginPin = PinController._loginPin;
    private BankAccount _login;

    @FXML private Label _balance;
    @FXML private TextField _email;
    @FXML private TextField _amount;
    @FXML private Button _btnEnter;
    @FXML private Button _btnBack;
    @FXML private Button num1;
    @FXML private Button num2;
    @FXML private Button num3;
    @FXML private Button num4;
    @FXML private Button num5;
    @FXML private Button num6;
    @FXML private Button num7;
    @FXML private Button num8;
    @FXML private Button num9;
    @FXML private Button num0;
    @FXML private Button num00;
    @FXML private Button btnDot;
    

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // You can put code here to initialize your model objects, for example load list of items from file.
    @FXML private void initialize() {
        _login = _list.lookup(_loginPin);
        _balance.setText("$"+_login.getBalance());
        _email.setText("Tester+0@fakemail.com");
        _btnBack.setOnAction(e -> onBackClicked());
        _btnEnter.setOnAction(e -> onEnterClicked());
        _list.loadData();
        num0.setOnAction(e -> onNumberClicked("0"));
        num1.setOnAction(e -> onNumberClicked("1"));
        num2.setOnAction(e -> onNumberClicked("2"));
        num3.setOnAction(e -> onNumberClicked("3"));
        num4.setOnAction(e -> onNumberClicked("4"));
        num5.setOnAction(e -> onNumberClicked("5"));
        num6.setOnAction(e -> onNumberClicked("6"));
        num7.setOnAction(e -> onNumberClicked("7"));
        num8.setOnAction(e -> onNumberClicked("8"));
        num9.setOnAction(e -> onNumberClicked("9"));
        num00.setOnAction(e -> onNumberClicked("00"));
        btnDot.setOnAction(e -> onNumberClicked("."));
    }

    private void onNumberClicked(String number){
        _amount.setText(_amount.getText()+number);
    }

    private boolean checkRecipientFilled(){
        return !_email.getText().equals("");
    }

    /**
     * @return
     */
    private boolean enoughFunds(){
        double balance = _login.getBalance();
        double amount = 0;
        try {
            amount = Double.parseDouble(_amount.getText());
        }
        catch (NullPointerException e){
            Alert alert = new Alert(AlertType.ERROR,"Please enter an amount to transfer");
            alert.show();
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR,"Please enter an proper amount to transfer");
            alert.show();
            _amount.setText("");
        }
        return balance >= amount;
    }

    private void transferFund(BankAccount receiver, double amount){
        _list.updateBalance(_login.getName(), _login.getBalance() - amount);
        _list.updateBalance(receiver.getName(), receiver.getBalance() + amount);
    }

    private void onEnterClicked() {
        if (!enoughFunds()){
            Alert alert = new Alert(AlertType.ERROR,"Not enough funds to transfer");
            alert.show();
            _amount.setText("");
        }
        else if (!checkRecipientFilled()){
            Alert alert = new Alert(AlertType.ERROR,"Please enter the recipient email");
            alert.show();
        }
        BankAccount recipient = _list.emailLookup(_email.getText());
        double amount = Double.parseDouble(_amount.getText());
        transferFund(recipient, amount);
        
        Alert alert = new Alert(AlertType.INFORMATION,"Successfully send $"+amount+"\nto "+_email.getText());
        alert.show();

        Stage stage = (Stage) _btnEnter.getScene().getWindow();
        // Close the window
        stage.close();
    }

    private void onBackClicked() {
        Stage stage = (Stage) _btnEnter.getScene().getWindow();
        // Close the window
        stage.close();
    }

}