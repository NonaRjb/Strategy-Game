import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGameController {

    //GameController gameController;

    /*public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }*/

    /*@FXML
    private void initialize(){
        startGame.setOnAction(event -> {
            try {
                FXMLLoader detailGameLoader = new FXMLLoader(getClass().getResource("detailGame.fxml"));
                DetailGameController detailGameController = detailGameLoader.getController();
                detailGameController.setGameController(gameController);
                Parent detailGameRoot = detailGameLoader.load();
                Scene detailGameScene = new Scene(detailGameRoot,800,600);
                Stage stage = new Stage();
                stage.setScene(detailGameScene);
                stage.show();

            }catch (IOException io){
                io.printStackTrace();
            }

        });
    */
}
