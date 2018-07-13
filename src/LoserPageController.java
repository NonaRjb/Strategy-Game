import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoserPageController {

    @FXML
    Button byeButton;

    @FXML
    public void initialize(){

        byeButton.setOnAction( event -> {
            Stage stage = (Stage)byeButton.getScene().getWindow();
            stage.close();
        } );

    }


}
