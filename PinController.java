import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PinController {
    private Database _list = LoginController._list;  // A reference to the list of Bank Accounts
    static String _loginPin = LoginController._loginPin; // A reference to the login account 

    @FXML private Button _btnEnter;
    @FXML private Button _btnBack;
    @FXML private TextField _textPin;
    @FXML private Button one;
    @FXML private Button two;
    @FXML private Button three;
    @FXML private Button four;
    @FXML private Button five;
    @FXML private Button six;
    @FXML private Button seven;
    @FXML private Button eight;
    @FXML private Button nine;
    @FXML private Button zero;
    
    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // Here we put code to show the list items in the text area. The list void is a field of the main controller.
    @FXML private void initialize() {
        // Attach event handler(s)
        _btnEnter.setOnAction( e -> onEnterClicked() );    // Always call a method in the outer class
        _btnBack.setOnAction( e -> onBackClicked() );    // Always call a method in the outer class
        one.setOnAction( e -> onNumberClicked("1") );
        two.setOnAction( e -> onNumberClicked("2") );
        three.setOnAction( e -> onNumberClicked("3") );
        four.setOnAction( e -> onNumberClicked("4") );
        five.setOnAction( e -> onNumberClicked("5") );
        six.setOnAction( e -> onNumberClicked("6") );
        seven.setOnAction( e -> onNumberClicked("7") );
        eight.setOnAction( e -> onNumberClicked("8") );
        nine.setOnAction( e -> onNumberClicked("9") );
        zero.setOnAction( e -> onNumberClicked("0") );
    }

    
    // Event handlers

    private void onBackClicked() {
        try {
            // Load the main screen
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);

            // Set the current stage into second stage 
            Stage secondStage  = (Stage) _btnEnter.getScene().getWindow();
            secondStage.setScene(scene);
            secondStage.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    private void displayAlert(String message){
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.show();
    }
    
    private void onNumberClicked(String number){
        _textPin.setText(_textPin.getText()+number);
    }

    private boolean accountExist(String pin){
        return _list.lookup(pin) != null;
    }

    private void onEnterClicked() {
        // Open the second window (stage)
        if (!accountExist(_textPin.getText())){
            displayAlert("Account "+ _textPin.getText() +" not exist");
            _textPin.setText("");
            return;
        }

        _loginPin = _textPin.getText();
        Alert alert = new Alert(AlertType.INFORMATION, "Successfully login as "+_list.lookup(_loginPin).getName());
        alert.showAndWait();
        try {
            // Load the main screen
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);

            // Set the current stage into second stage 
            Stage secondStage  = (Stage) _btnEnter.getScene().getWindow();
            secondStage.setScene(scene);
            secondStage.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
