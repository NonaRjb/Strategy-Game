import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrepareGameController {

    GameController gameController;

    public void setGameController( GameController gameController ){
        this.gameController=gameController;
    }


    @FXML
    private void initialize(){
        startGame.setOnAction(event -> {
            try {
                FXMLLoader mainGameLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
                MainGameController mainGameController = mainGameLoader.getController();
                mainGameController.setGameController(gameController);
                Parent mainGameRoot = mainGameLoader.load();
                Scene mainGameScene = new Scene(mainGameRoot,800,600);
                Stage stage = new Stage();
                stage.setScene(mainGameScene);
                stage.show();

            }catch (IOException io){
                io.printStackTrace();
            }

        });

}
