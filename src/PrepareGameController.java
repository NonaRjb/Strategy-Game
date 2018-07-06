import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PrepareGameController {

    GameController gameController = GameController.getInstance();
    private PlayGround playGround = new PlayGround();
    private ArrayList<Path> paths = playGround.getMap().getPaths();
    private Coordinate[] placeOfArmories = playGround.getPlaceOfArmories();

   // @FXML

    /*@FXML
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
    */
    /*public ArrayList<ImageView> armoryPlaceBuilder(Coordinate[] placeOfArmories){
        for (Coordinate armoryPlace: placeOfArmories){
            ImageView imageView = new ImageView();
        }
    }*/
}
