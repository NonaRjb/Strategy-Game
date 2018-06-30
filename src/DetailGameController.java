import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailGameController {

    GameController gameController;

    public void setGameController( GameController gameController ){
        this.gameController=gameController;
    }


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
