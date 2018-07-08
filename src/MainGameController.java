import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainGameController implements ArmoryPlaceBuilder{

    private GameController gameController = GameController.getInstance();
    private PlayGround playGround = PlayGround.getInstance();

    Button button = new Button("SALAM");

    private void updateView(){
        /// update armories
        ArrayList<Image> armories = armoryPlaceBuilder();
        ID_0.setImage(armories.get(0));
        ID_1.setImage(armories.get(1));
        ID_2.setImage(armories.get(2));
        ID_3.setImage(armories.get(3));
        ID_4.setImage(armories.get(4));
        ID_5.setImage(armories.get(5));
        ID_6.setImage(armories.get(6));
        ID_7.setImage(armories.get(7));
        //ImageView imageView = new ImageView("./bane.png");


    }

    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button doCommand;
    @FXML
    private TextArea comments;
    @FXML
    private ImageView ID_0;
    @FXML
    private ImageView ID_1;
    @FXML
    private ImageView ID_2;
    @FXML
    private ImageView ID_3;
    @FXML
    private ImageView ID_4;
    @FXML
    private ImageView ID_5;
    @FXML
    private ImageView ID_6;
    @FXML
    private ImageView ID_7;

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
                    //Parent detailGameRoot = detailGameLoader.load();
                    GameFX.root = detailGameLoader.load();
                    //ArrayList<ImageView> invaders = InvaderBuilder();
                    //Scene detailGameScene = new Scene(detailGameRoot,800,600);
                    Scene detailGameScene = new Scene(GameFX.root,800,600);

                    Stage stage = new Stage();
                    stage.setScene(detailGameScene);
                    stage.show();

                }catch (IOException io){
                    io.printStackTrace();
                }
            } else {
                updateView();
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


        //FXMLLoader mainGameLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
        //MainGameController mainGameController = mainGameLoader.getController();
        //GameFX.root = mainGameLoader.load();
        //Scene mainGameScene = new Scene(GameFX.root, 1600, 900);
        //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //stage.setScene(mainGameScene);
        //stage.show();

        ((AnchorPane)(GameFX.root)).getChildren().addAll(button);
        //System.out.println(comments.getScene().getRoot().getChildrenUnmodifiable());

        System.out.println(comments.getScene().getRoot());//comments.getScene().setRoot(GameFX.root);

        //Scene mainGameScene = new Scene(GameFX.root, 1600, 900);
        //Stage stage = (Stage) button.getScene().getWindow();
        //stage.setScene(mainGameScene);
        //stage.show();
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

    @Override
    public ArrayList<Image> armoryPlaceBuilder() {
            ArrayList<javafx.scene.image.Image> armoryPlaces = new ArrayList<>();
            for (PlaceHolder placeHolder: playGround.getPlaceHolder()){
                if (placeHolder.getOwner() == null){
                    javafx.scene.image.Image image = new javafx.scene.image.Image("./placeholder.png");
                    armoryPlaces.add(image);
                }
                else {
                    if (placeHolder.getOwner() instanceof Barracks){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./barracks.png");
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof MachineGun){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./machineGun.png");
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Freezer){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./freezer1.png");
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Hellgate){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./hellgate1.png");
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Laser){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./laser1.png");
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Rocket){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./machineGun.png"); //todo should be changed
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Excalibur){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./machineGun.png"); //todo should be changed
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Beehive){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./machineGun.png"); //todo should be changed
                        armoryPlaces.add(image);
                    } else if (placeHolder.getOwner() instanceof Sauron){
                        javafx.scene.image.Image image = new javafx.scene.image.Image("./machineGun.png"); //todo should be changed
                        armoryPlaces.add(image);
                    }
                }
            }
            return armoryPlaces;
    }

    public ArrayList<ImageView> InvaderBuilder(){
        ArrayList<ImageView> invadersIMV = new ArrayList<>();
        ArrayList<Invader> invaders = gameController.getGame().getInvaders();
        for (Invader invader : invaders){
            if (invader instanceof Bane){
                Image image = new Image("./bane.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Henchman){
                Image image = new Image("./Henchman1.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Skipper){
                Image image = new Image("./Henchman1.png"); //todo must be changed
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Sparrow){
                Image image = new Image("./sparrow.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Boomer){
                Image image = new Image("./boomer.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Healer){
                Image image = new Image("./Henchman1.png"); // todo should be changed
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Motivator){
                Image image = new Image("./Henchman1.png"); // todo should be changed
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Icer){
                Image image = new Image("./Henchman1.png"); //todo
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Miner){
                Image image = new Image("./Henchman1.png");//todo
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Smelly){
                Image image = new Image("./Henchman1.png"); //todo
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Hopper){
                Image image = new Image("./Henchman1.png"); //todo
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof ExG){
                Image image = new Image("./Henchman1.png"); //todo
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof HockeyMaskMan){
                Image image = new Image("./Henchman1.png"); //todo
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            }
        }
        return invadersIMV;
    }

}
