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

public class MainController {
    // The list of items, has package (omitted) visibility and is static so we can access it easily from SecondController.
    /*package*/ static Database _list = new Database();

    @FXML private TextField _text1;    // This field is linked with the GUI object with fx:id "_text1"
    @FXML private Button _btnUpdate;
    @FXML private Button _btnDisplay;
    @FXML private Button _btnLookupIndex;
    @FXML private Button _btnLookupName;
    @FXML private TextField _email;
    @FXML private TextField _name;
    @FXML private TextField _balance;
    @FXML private TextField _address;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // You can put code here to initialize your model objects, for example load list of items from file.
    @FXML private void initialize() {
        // Attach event handler(s)
        _btnUpdate.setOnAction (e -> onDisplayClicked() );    // Always call a method in the outer class
        // _list.load();
    }

    // Event handlers
    private void displayAlert(String message){
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.show();
    }

    
    //Open second window

    private void onDisplayClicked() {
        // Open the second window (stage)
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Second.fxml"));
            Scene scene = new Scene(root);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            secondStage.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
