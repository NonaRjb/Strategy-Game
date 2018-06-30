import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartPageController {

    GameController gameController;

    @FXML
    private Button startGame;

    @FXML
    private void initialize(){
        startGame.setOnAction(event -> {
            try {
                FXMLLoader prepareGameLoader = new FXMLLoader(getClass().getResource("prepareGame.fxml"));
                PrepareGameController prepareGameController = prepareGameLoader.getController();
                prepareGameController.setGameController(gameController);
                Parent prepareGameRoot = prepareGameLoader.load();
                Scene prepareGameScene = new Scene(prepareGameRoot,800,600);
                Stage stage = new Stage();
                stage.setScene(prepareGameScene);
                stage.show();

            }catch (IOException io){
                io.printStackTrace();
            }

        });
    }

    public void setModel( GameController gameController ){
        this.gameController = gameController;
    }
}
