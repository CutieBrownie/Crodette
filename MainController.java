import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    private Database _list = LoginController._list;  // A reference to the list of Bank Accounts
    static String _loginPin = PinController._loginPin;
    private BankAccount _login;

    @FXML private Label _txtFieldName;
    @FXML private Button _btnTransfer;
    @FXML private Button _btnWithdrawDeposit;
    @FXML private Button _btnViewAccount;
    @FXML private Button _btnLogout;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // You can put code here to initialize your model objects, for example load list of items from file.
    @FXML private void initialize() {
        // Attach event handler(s)
        _login = _list.lookup(_loginPin);
        _txtFieldName.setText("Welcome "+_login.getName());
        _btnViewAccount.setOnAction (e -> onViewAccountClicked() );
        _btnLogout.setOnAction (e -> onLogOutClicked() );
        _btnTransfer.setOnAction(e -> onTransferClicekd());
    }
    
    private void onTransferClicekd() {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Transfer.fxml")));
            Stage secondStage  = new Stage();
            secondStage.setScene(scene);
            secondStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Switch scene back to login screen
    private void onLogOutClicked() {
        Stage stage = (Stage) _btnLogout.getScene().getWindow();
        stage.close();
    }

    //Open second window
    private void onViewAccountClicked() {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Infosample.fxml")));
            Stage secondStage  = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
