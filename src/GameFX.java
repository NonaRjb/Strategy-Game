import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameFX extends Application {

    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            /// Roots

            FXMLLoader startLoader = new FXMLLoader(getClass().getResource("startPage.fxml"));
            StartPageController startPageController = startLoader.getController();
            //startPageController.setModel( gameController );
            Parent startRoot = startLoader.load();


            /// Scenes
            Scene startScene = new Scene(startRoot,1600,900);

            primaryStage.setTitle("Tower Defense");
            primaryStage.setScene(startScene);
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
