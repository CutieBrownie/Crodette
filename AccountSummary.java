import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccountSummary {
    // The list of items, has package (omitted) visibility and is static so we can access it easily from SecondController.
    private Database _list = LoginController._list;  // A reference to the list of Bank Accounts
    static String _loginPin = PinController._loginPin;
    private BankAccount _login;

    @FXML private Label _accountName;
    @FXML private Label _balance;
    @FXML private Label _email;
    @FXML private Label _address;
    @FXML private Button _btnBack;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // You can put code here to initialize your model objects, for example load list of items from file.
    @FXML private void initialize() {
        // Attach event handler(s)
        _login = _list.lookup(_loginPin);
        _accountName.setText(_login.getName());
        _balance.setText("$"+_login.getBalance());
        _email.setText(_login.getEmail());
        _address.setText(_login.getAddress());
        _btnBack.setOnAction( e -> onBackClicked() );    
    }

    private void onBackClicked() {
        Stage stage = (Stage) _btnBack.getScene().getWindow();
        // Close the window
        stage.close();
    }

}