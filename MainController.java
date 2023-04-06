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

public class MainController {
    // The list of items, has package (omitted) visibility and is static so we can access it easily from SecondController.
    static BankAccount _login = PinController._login;

    @FXML private Label _txtFieldName;
    @FXML private Button _btnTransfer;
    @FXML private Button _btnWithdrawDeposit;
    @FXML private Button _btnViewAccount;
    @FXML private Button _btnLogout;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // You can put code here to initialize your model objects, for example load list of items from file.
    @FXML private void initialize() {
        // Attach event handler(s)
        _txtFieldName.setText("Welcome "+_login.getName());
        _btnViewAccount.setOnAction (e -> onViewAccountClicked() );    // Always call a method in the outer class
        // _list.load();
    }

    // Event handlers
    private void displayAlert(String message){
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.show();
    }

    
    //Open second window

    private void onViewAccountClicked() {
        // Open the second window (stage)
        _txtFieldName.setText("Changing this eh?");
        // try {
        //     Parent root = FXMLLoader.load(getClass().getResource("Second.fxml"));
        //     Scene scene = new Scene(root);
        //     Stage secondStage = new Stage();
        //     secondStage.setScene(scene);
        //     secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
        //     secondStage.showAndWait();
        // } catch(IOException e) {
        //     e.printStackTrace();
        // }
    }
}
