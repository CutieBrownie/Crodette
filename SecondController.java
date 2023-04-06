import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SecondController {
	private Database _list = MainController._list;  // A reference to the list of items

    @FXML private Button _btnClose;
    @FXML private TextArea _textArea1;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    // Here we put code to show the list items in the text area. The list object is a field of the main controller.
    @FXML private void initialize() {
        // Attach event handler(s)
        _btnClose.setOnAction( e -> onEnterClicked() );    // Always call a method in the outer class

        String display = "";
        for (int index = 0; index < _list.getSize(); index++) {
            display += _list.getItem(index);
            display += "\n";     // Go to the next line
        }

        _textArea1.setWrapText(true);
        _textArea1.setText(display);
    }

    // Event handlers

    private void onEnterClicked() {
        // Get a reference to the stage
        Stage stage = (Stage) _btnClose.getScene().getWindow();
        // Close the window
        stage.close();
    }

}
