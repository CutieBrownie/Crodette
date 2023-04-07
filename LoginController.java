import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    static Database _list = new Database();
    static String _loginPin;

    @FXML private Button _btnLogin;
    @FXML private Button _btnCreateAccount;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // Here we put code to show the list items in the text area. The list object is a field of the main controller.
    @FXML private void initialize() {
        // Attach event handler(s)
        _btnLogin.setOnAction( e -> onLoginClicked() );    // Always call a method in the outer class
    }

    // Event handlers

    private void onLoginClicked() {
        // Open the second window (stage)
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PIN.fxml"));
            Scene scene = new Scene(root);
            // Stage secondStage  = new Stage();
            // secondStage.setScene(scene);
            // secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            // secondStage.showAndWait();
            Stage secondStage = (Stage) _btnLogin.getScene().getWindow();
            secondStage.setScene(scene);
            secondStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
