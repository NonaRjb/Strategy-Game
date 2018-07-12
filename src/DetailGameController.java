import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailGameController {

    private GameController gameController = GameController.getInstance();

    @FXML
    private TextArea details;
    @FXML
    private Button playNextRound;

    /*public void setGameController( GameController gameController ){
        this.gameController=gameController;
    }*/


    @FXML
    private void initialize() {
        details.setText( gameController.showDetail() );
        playNextRound.setOnAction(event -> {
            try {
                FXMLLoader prepareGameLoader = new FXMLLoader(getClass().getResource("prepareGame.fxml"));
                PrepareGameController prepareGameController = prepareGameLoader.getController();
                //prepareGameController.setGameController(gameController);
                Parent prepareGameRoot = prepareGameLoader.load();
                Scene prepareGameScene = new Scene(prepareGameRoot, 1600, 900);
                Stage stage = new Stage();
                stage.setScene(prepareGameScene);
                stage.show();

            } catch (IOException io) {
                io.printStackTrace();
            }

        });
    }

}
