import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
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
    //private ObservableList<Node> primaryNodes;
    private ArrayList<ImageView> invadersIMV = new ArrayList<>();
    private ArrayList<ImageView> previousInvadersIMV = new ArrayList<>();
    private ArrayList<ImageView> shotsIMV = new ArrayList<>();
    private ArrayList<ImageView> previousShotsIMV = new ArrayList<>();
    private ImageView heroIMV = new ImageView();
    private ImageView previousHeroIMV = new ImageView();
    private ArrayList<ImageView> soldiersIMV = new ArrayList<>();
    private ArrayList<ImageView> previousSoldierIMV = new ArrayList<>();


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
        //this.addButton();
        heroIMV = this.heroBuilder();
        invadersIMV = this.InvaderBuilder();
        shotsIMV = this.shotBuilder();
        soldiersIMV = this.soldierBuilder();
        ((AnchorPane)GameFX.root).getChildren().removeAll(previousHeroIMV);
        ((AnchorPane)GameFX.root).getChildren().removeAll(previousInvadersIMV);
        ((AnchorPane)GameFX.root).getChildren().removeAll(previousSoldierIMV);
        ((AnchorPane)GameFX.root).getChildren().removeAll(previousShotsIMV);
        ((AnchorPane)GameFX.root).getChildren().addAll(heroIMV);
        ((AnchorPane)GameFX.root).getChildren().addAll(invadersIMV);
        ((AnchorPane)GameFX.root).getChildren().addAll(soldiersIMV);
        ((AnchorPane)GameFX.root).getChildren().addAll(shotsIMV);
        //((AnchorPane)GameFX.root).getChildren().setAll( primaryNodes );//, (ArrayList<Node>)invadersIMV );
        //((AnchorPane)GameFX.root).getChildren().addAll( invadersIMV );
        previousHeroIMV = heroIMV;
        previousInvadersIMV = invadersIMV;
        previousShotsIMV = shotsIMV;
        previousSoldierIMV = soldiersIMV;
        /*if(!done)
        ((AnchorPane)GameFX.root).getChildren().addAll(button);
        done = true;*/
        //System.out.println( ((AnchorPane)GameFX.root).getChildren().addAll(button) );
        //System.out.println(button.getScene().getRoot().getChildrenUnmodifiable());



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

    private TimerTask playing = new TimerTask() {
        @Override
        public void run() {
            Platform.runLater( ()->{

            //} );
            if( gameController.goAheadRound() ){
                //TODO now infinity Rounds!
                if (Game.getLoser()){
                    try {
                        FXMLLoader loserPageLoader = new FXMLLoader(getClass().getResource("loserPage.fxml"));
                        GameFX.root = loserPageLoader.load();
                        Scene loserPageScene = new Scene(GameFX.root,1600,900);
                        Stage stage = (Stage) doCommand.getScene().getWindow();
                        stage.setScene(loserPageScene);
                        stage.setTitle("you lost!");
                        stage.show();
                    } catch (IOException io){
                        io.printStackTrace();
                    }
                }
                else {
                    try {
                        FXMLLoader detailGameLoader = new FXMLLoader(getClass().getResource("detailGame.fxml"));
                        GameFX.root = detailGameLoader.load();
                        Scene detailGameScene = new Scene(GameFX.root, 1600, 900);

                        Stage stage = (Stage) doCommand.getScene().getWindow();
                        stage.setScene(detailGameScene);
                        stage.setTitle("Game Details");
                        stage.show();

                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }
            } else {
                updateView();
            }

            } );

        }
    };

    private Timer timer = new Timer();

    /*private boolean done=false;
    public void addButton(){
        ImageView imv = new ImageView( new Image("./bane.png") );
        if( !done )
            ((AnchorPane)(GameFX.root)).getChildren().addAll(imv);
        done=true;
    }*/


    @FXML
    private void initialize() {
        gameController.initiateRound();
        //timer.schedule(playing,0L, 2*1000L);
        timer.scheduleAtFixedRate(playing, 1000L, 1*1000L);
        doCommand.setOnAction( event -> {
            comments.setText( gameController.playRound( textField.getText() ) );
            textField.clear();
        } );

        //primaryNodes = GameFX.root.getChildrenUnmodifiable();

        //FXMLLoader mainGameLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
        //MainGameController mainGameController = mainGameLoader.getController();
        //GameFX.root = mainGameLoader.load();
        //Scene mainGameScene = new Scene(GameFX.root, 1600, 900);
        //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //stage.setScene(mainGameScene);
        //stage.show();

        //((AnchorPane)(GameFX.root)).getChildren().addAll(button);
        //System.out.println(GameFX.root.getChildrenUnmodifiable());
        //System.out.println(button.getScene().getRoot().getChildrenUnmodifiable());
        //System.out.println();

        //System.out.println(comments.getScene().getRoot());//comments.getScene().setRoot(GameFX.root);

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
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Henchman){
                Image image = new Image("./Henchman1.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Skipper){
                Image image = new Image("./skipper.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Sparrow){
                Image image = new Image("./sparrow.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Boomer){
                Image image = new Image("./boomer.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Healer){
                Image image = new Image("./healer.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Motivator){
                Image image = new Image("./motivator.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Icer){
                Image image = new Image("./icer.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Miner){
                Image image = new Image("./miner.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Smelly){
                Image image = new Image("./smelly.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof Hopper){
                Image image = new Image("./hopper.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof ExG){
                Image image = new Image("./exg.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            } else if (invader instanceof HockeyMaskMan){
                Image image = new Image("./hockeymaskman.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(invader.getCoordinate().getY()-50);
                imageView.setY(invader.getCoordinate().getX()-50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                invadersIMV.add(imageView);
            }
        }
        return invadersIMV;
    }

    public ArrayList<ImageView> shotBuilder() {

        ArrayList<ImageView> shotsIMV = new ArrayList<>();
        ArrayList<Shot> shots = gameController.getGame().getGameShots();
        for (Shot shot : shots) {
            if (shot instanceof Bullet) {
                Image image = new Image("./bullet.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(shot.getCoordinate().getY() - 15);
                imageView.setY(shot.getCoordinate().getX() - 15);
                imageView.setFitHeight(30);
                imageView.setFitWidth(30);
                imageView.prefWidth(30);
                imageView.prefHeight(30);
                shotsIMV.add(imageView);
                //System.out.println(shot.getCoordinate().getX()+","+shot.getCoordinate().getY());
            } else if (shot instanceof Ice) {
                Image image = new Image("./ice.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(shot.getCoordinate().getY() - 50);
                imageView.setY(shot.getCoordinate().getX() - 50);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                shotsIMV.add(imageView);
            } else if (shot instanceof Fire) {
                Image image = new Image("./fire.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(shot.getCoordinate().getY() - 50);
                imageView.setY(shot.getCoordinate().getX() - 50);
                imageView.setFitHeight(100); //TODO: fire range
                imageView.setFitWidth(100);
                imageView.prefWidth(100);
                imageView.prefHeight(100);
                shotsIMV.add(imageView);
            } /*else if (shot instanceof LaserShot){
                LaserShot currentLaserShot = (LaserShot)shot;
                Line line = new Line();
                line.setFill(Color.RED);
                line.setStartX( currentLaserShot.getCoordinate().getX() );
                line.setStartY( currentLaserShot.getCoordinate().getY() );
                line.setEndX( currentLaserShot.getEndCoordinate().getX() );
                line.setEndY( currentLaserShot.getEndCoordinate().getY() );
                /*Image image = new Image("./fire.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setX(shot.getCoordinate().getY()-5);
                imageView.setY(shot.getCoordinate().getX()-5);
                imageView.setFitHeight(10);
                imageView.setFitWidth(10);
                imageView.prefWidth(10);
                imageView.prefHeight(10);
                shotsIMV.add(imageView);
            }*/
        }
        return shotsIMV;

    }

    public ImageView heroBuilder(){
        ImageView heroIMV = new ImageView();
        Image heroIMG = new Image("./hero.png");
        Hero hero = gameController.getGame().getHero();
        heroIMV.setImage(heroIMG);
        heroIMV.setX(hero.getCoordinate().getY()-50);
        heroIMV.setY(hero.getCoordinate().getX()-50);
        heroIMV.setFitWidth(100);
        heroIMV.setFitHeight(100);
        return heroIMV;
    }

    public ArrayList<ImageView> soldierBuilder(){
        ArrayList<ImageView> soldierIMV = new ArrayList<>();
        ArrayList<Soldier> soldiers = gameController.getGame().getSoldiers();
        for (Soldier soldier : soldiers){
            Image image = new Image("./soldier.png");
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setY(soldier.getCoordinate().getX());
            imageView.setX(soldier.getCoordinate().getY());
            soldierIMV.add(imageView);
        }
        return soldierIMV;
    }


}
