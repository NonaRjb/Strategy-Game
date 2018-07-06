import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainGameController {

    private GameController gameController = GameController.getInstance();

    private void updateScene(){

    }

    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button doCommand;
    @FXML
    private TextArea comments;

    /*public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }*/

    TimerTask playing = new TimerTask() {
        @Override
        public void run() {
            if( gameController.goAheadRound() ){
                //TODO now infinity Rounds!
                try {
                    FXMLLoader detailGameLoader = new FXMLLoader(getClass().getResource("detailGame.fxml"));
                    DetailGameController detailGameController = detailGameLoader.getController();
                    //detailGameController.setGameController(gameController);
                    Parent detailGameRoot = detailGameLoader.load();
                    Scene detailGameScene = new Scene(detailGameRoot,800,600);
                    Stage stage = new Stage();
                    stage.setScene(detailGameScene);
                    stage.show();

                }catch (IOException io){
                    io.printStackTrace();
                }
            } else {
                updateScene();
            }
        }
    };

    Timer timer = new Timer();


    @FXML
    private void initialize() {
        gameController.initiateRound();
        //timer.schedule(playing,0L, 2*1000L);
        timer.scheduleAtFixedRate(playing, 0L, 1*1000L);
        doCommand.setOnAction( event -> {
            comments.setText( gameController.playRound( textField.getText() ) );
            textField.clear();
        } );
        /*startGame.setOnAction(event -> {
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

        });*/
    }
}
