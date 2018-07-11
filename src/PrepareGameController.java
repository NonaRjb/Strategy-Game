import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PrepareGameController implements ArmoryPlaceBuilder{

    GameController gameController = GameController.getInstance();
    private PlayGround playGround = PlayGround.getInstance();
    private ArrayList<Path> paths = playGround.getMap().getPaths();
    private PlaceHolder[] placeOfArmories = playGround.getPlaceHolder();
    //private ArrayList<ImageView> armoryPlaces = armoryPlaceBuilder();

    @FXML
    private TextField textField = new TextField();
    @FXML
    private Button doCommand;
    @FXML
    private Button startGameButton;
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

    @FXML
    private void initialize() {
        doCommand.setOnAction( event -> {
            comments.setText( gameController.playBreak( textField.getText() ) );
            textField.clear();
            updateView();
        } );

        startGameButton.setOnAction( event -> {
            try {
                //comments.getScene().setRoot(new Parent() {});
                FXMLLoader mainGameLoader = new FXMLLoader(getClass().getResource("mainGame.fxml"));
                //MainGameController mainGameController = new MainGameController();
                //mainGameController.setGameController(gameController);
                //Parent mainGameRoot = mainGameLoader.load();
                GameFX.root = mainGameLoader.load();
                //MainGameController mainGameController = mainGameLoader.getController();
                //mainGameController.addButton();

                //Parent mainGameRoot = mainGameLoader.load();
                //((AnchorPane)(GameFX.root)).getChildren().addAll( mainGameRoot );

                //GameFX.root = (Parent)( ((AnchorPane)(GameFX.root)).getChildren().addAll(bb) );
                //Scene mainGameScene = new Scene(mainGameRoot, 1600, 900);
                Scene mainGameScene = new Scene(GameFX.root, 1600, 900);

                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(mainGameScene);
                stage.show();
                //System.out.println("Shame!");
                //Button bb = new Button("ll");
                //((AnchorPane)(GameFX.root)).getChildren().addAll(bb);

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
                Scene mainGameScene = new Scene(mainGameRoot,800,600);
                Stage stage = new Stage();
                stage.setScene(mainGameScene);
                stage.show();

            }catch (IOException io){
                io.printStackTrace();
            }

        });
    */}

   @Override
    public ArrayList<Image> armoryPlaceBuilder(){
        ArrayList<Image> armoryPlaces = new ArrayList<>();
        for (PlaceHolder placeHolder: playGround.getPlaceHolder()){
            if (placeHolder.getOwner() == null){
                Image image = new Image("./placeholder.png");
                armoryPlaces.add(image);
            }
            else {
                if (placeHolder.getOwner() instanceof Barracks){
                    Image image = new Image("./barracks.png");
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof MachineGun){
                    Image image = new Image("./machineGun.png");
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Freezer){
                    Image image = new Image("./freezer1.png");
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Hellgate){
                    Image image = new Image("./hellgate1.png");
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Laser){
                    Image image = new Image("./laser1.png");
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Rocket){
                    Image image = new Image("./machineGun.png"); //todo should be changed
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Excalibur){
                    Image image = new Image("./machineGun.png"); //todo should be changed
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Beehive){
                    Image image = new Image("./machineGun.png"); //todo should be changed
                    armoryPlaces.add(image);
                } else if (placeHolder.getOwner() instanceof Sauron){
                    Image image = new Image("./machineGun.png"); //todo should be changed
                    armoryPlaces.add(image);
                }
            }
        }
        return armoryPlaces;
    }

    public void updateView(){
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
    }
}
