import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PinController {
	private Database _list = LoginController._list;  // A reference to the list of items
    static BankAccount _login; // A reference to the login account 

    @FXML private Button _btnEnter;
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
        one.setOnAction( e -> onOneClicked() );
        two.setOnAction( e -> onTwoClicked() );
        three.setOnAction( e -> onThreeClicked() );
        four.setOnAction( e -> onFourClicked() );
        five.setOnAction( e -> onFiveClicked() );
        six.setOnAction( e -> onSixClicked() );
        seven.setOnAction( e -> onSevenClicked() );
        eight.setOnAction( e -> onEightClicked() );
        nine.setOnAction( e -> onNineClicked() );
        zero.setOnAction( e -> onZeroClicked() );
    }

    // Event handlers

    private void displayAlert(String message){
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.show();
    }
    
    private void onZeroClicked() {
        _textPin.setText(_textPin.getText()+"0");
    }

    private void onNineClicked() {
        _textPin.setText(_textPin.getText()+"9");
    }

    private void onEightClicked() {
        _textPin.setText(_textPin.getText()+"8");
    }

    private void onSevenClicked() {
        _textPin.setText(_textPin.getText()+"7");
    }

    private void onSixClicked() {
        _textPin.setText(_textPin.getText()+"6");
    }

    private void onFiveClicked() {
        _textPin.setText(_textPin.getText()+"5");
    }

    private void onFourClicked() {
        _textPin.setText(_textPin.getText()+"4");
    }

    private void onThreeClicked() {
        _textPin.setText(_textPin.getText()+"3");
    }

    private void onTwoClicked() {
        _textPin.setText(_textPin.getText()+"2");
    }

    private void onOneClicked() {
        _textPin.setText(_textPin.getText()+"1");
    }

    private boolean accountExist(String pin){
        return _list.lookup(pin) != null;
    }

    private void onEnterClicked() {
        // Open the second window (stage)
        if (!accountExist(_textPin.getText())){
            displayAlert("Account "+ _textPin.getText() +" not exist");
            return;
        }
        _login = _list.lookup(_textPin.getText()); 
        Alert alert = new Alert(AlertType.INFORMATION, "Successfully login as "+_login.getName());
        alert.showAndWait();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            secondStage.showAndWait();
            secondStage.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
