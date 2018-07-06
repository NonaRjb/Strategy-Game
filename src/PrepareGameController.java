import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PrepareGameController {

    private GameController gameController = GameController.getInstance();


    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button doCommand;
    @FXML
    private Button startGameButton;
    @FXML
    private TextArea comments;

    @FXML
    private void initialize() {
        doCommand.setOnAction( event -> {
            comments.setText( gameController.playBreak( textField.getText() ) );
            textField.clear();
        } );
        startGameButton.setOnAction( event -> {
            try {
                FXMLLoader mainGameLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
                MainGameController mainGameController = mainGameLoader.getController();
                //mainGameController.setGameController(gameController);
                Parent mainGameRoot = mainGameLoader.load();
                Scene mainGameScene = new Scene(mainGameRoot, 800, 600);
                Stage stage = new Stage();
                stage.setScene(mainGameScene);
                stage.show();

            } catch (IOException io) {
                io.printStackTrace();
            }
        } );
        /*textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if( event.getCode().equals(KeyCode.ENTER) ){
                    gameController.playBreak( textField.getText() );
                }
            }
        });*/

        /*startGame.setOnAction(event -> {
            try {
                FXMLLoader mainGameLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
                MainGameController mainGameController = mainGameLoader.getController();
                mainGameController.setGameController(gameController);
                Parent mainGameRoot = mainGameLoader.load();
                Scene mainGameScene = new Scene(mainGameRoot, 800, 600);
                Stage stage = new Stage();
                stage.setScene(mainGameScene);
                stage.show();

            } catch (IOException io) {
                io.printStackTrace();
            }

        });*/
    }
}
