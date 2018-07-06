import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartPageController {

    private GameController gameController = GameController.getInstance();

    @FXML
    private Button startGame;

    @FXML
    private void initialize(){
        startGame.setOnAction(event -> {
            //this.gameController.setCommand("go ahead one sec");
            try {
                FXMLLoader prepareGameLoader = new FXMLLoader(getClass().getResource("prepareGame.fxml"));
                Parent prepareGameRoot = prepareGameLoader.load();
                Scene prepareGameScene = new Scene(prepareGameRoot,1600,900);
                //Stage stage = new Stage();
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(prepareGameScene);
                stage.setTitle("Preparation Page");
                stage.show();

            }catch (IOException io){
                io.printStackTrace();
            }

        });
    }



    /*public void setModel( GameController gameController ){
        this.gameController = gameController;
    }*/
}
