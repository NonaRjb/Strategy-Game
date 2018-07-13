import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class GameController implements DetailShow {

    private static GameController gameController_instance = null;
    private Scanner scanner = new Scanner(System.in);
    private Game game;
    private String command;
    private int currentRound;
    private Time plagueTime;
    private int plagueRound;
    private Time naturalEventTime;
    private int naturalEventRound;

    private final int numberOfRounds = 5;

    // Constructor
    private GameController() {
        this.game = new Game();
        this.currentRound = 0;
       // playRound(0);
        Random rand = new Random();
        this.plagueRound = rand.nextInt( this.numberOfRounds );
        this.plagueTime = new Time( rand.nextInt( 100 ) );
        this.naturalEventRound = rand.nextInt( this.numberOfRounds );
        this.naturalEventTime = new Time( rand.nextInt( 100 ) );
        command = " ";
    }

    public static GameController getInstance(){
        if (gameController_instance == null){
            gameController_instance = new GameController();
        }
        return gameController_instance;
    }

    //TODO: details
    @Override
    public String showDetail() {
        String details="";
        details = details + game.showInvadersDetails();
        details = details + game.showArmoriesDetails();
        details = details + game.showHeroDetails();
        details = details + game.showSlotsDetails();
        details = details + game.showSoldiersDetails();
        return details;

    }

    public void initiateRound(){
        game.setInvaderRate( new Time(20-this.currentRound) ); //todo
        game.setThisRoundNumberOfInvaders((this.currentRound+1)*10);
    }

    public boolean goAheadRound(){
        if( game.isEnded() ){
            if( this.currentRound < this.numberOfRounds ) {
                //playEndRound();
                this.currentRound++;
            } else {
                //playWinnerEnd();
            }
            return true;
        } else {
            game.increaseTime();
            if(game.getLoser()){
               return true;
            }
            if( this.currentRound == this.plagueRound && game.getGameTime().getTime()==this.plagueTime.getTime() ){
                game.spreadPlague();
            }
            if( this.currentRound == this.naturalEventRound && game.getGameTime().getTime()==this.naturalEventTime.getTime() ){
                game.naturalEventHappening();
            }
            return false;
        }

    }

    public String playRound(String command){//int round){

        //game.setInvaderRate( new Time(20-round) );
        //game.setThisRoundNumberOfInvaders((round+1)*10);

        //command = scanner.nextLine();
       // while (/*!game.isEnded()*/!command.equals("end")){

            if (command.matches("add [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                return ( game.createArmory(tmp[1], Integer.parseInt(tmp[4])) );
            }
            if (command.matches("show details [a-z]{4,8}")){
                String[] tmp = command.split(" ");
                if (tmp[2].equals("weapons")){
                    return game.showArmoriesDetails();
                }
                if (tmp[2].equals("enemy")){
                    return game.showInvadersDetails();
                }
                if (tmp[2].equals("infantry")){
                    return game.showSoldiersDetails();
                }
                if (tmp[2].equals("slots")){
                    return game.showSlotsDetails();
                }
                if (tmp[2].equals("hero")){
                    return game.showHeroDetails();
                }
            }

            if( command.equals("Pause") ){
                playPause();
            }

            /*if (command.equals("go ahead one sec")){
                game.increaseTime();
                System.out.println("Game Time Successfully increased");
            }*/

            if (command.matches("set target of [a-zA-Z]{5,10} in place [0-9]{1,2} to be invader [0-9]{1,2}")){ // set target of Armory
                String[] tmp = command.split(" ");
                game.setTargetForArmory(Integer.parseInt(tmp[6]),Integer.parseInt(tmp[10]));
            }

            if (command.matches("set target of infantry [0-2] of barracks [0-9]{1,2} to be invader [0-9]{1,2}")){ // set target of barracks' infantry
                String[] tmp = command.split(" ");
                game.goAfterInvaderSoldier( Integer.parseInt(tmp[4]), Integer.parseInt(tmp[7]), Integer.parseInt(tmp[11]) );
            }

            if (command.matches("set target of infantry [0-2] of game to be invader [0-9]{1,2}")){ // set target of game infantry
                String[] tmp = command.split(" ");
                game.goAfterInvaderSoldier( Integer.parseInt(tmp[4]), PlayGround.numberOfPlaces, Integer.parseInt(tmp[10]));
            }

            if (command.matches("set target of hero to be invader [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                game.goAfterInvaderHero(Integer.parseInt(tmp[7]));
            }

            if (command.matches("upgrade [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                return ( game.upgradeArmory(Integer.parseInt(tmp[4])) );
            }

            if (command.matches("sell [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                game.sellArmory(Integer.parseInt(tmp[4]));
            }

            if (command.matches("set priority of [a-zA-Z]{5,10} in place [0-9]{1,2} [a-zA-Z]{7,14}")){
                String[] tmp = command.split(" ");
                game.setArmoryTargetPriority(Integer.parseInt(tmp[6]), TargetPriority.valueOf(tmp[7]));
            }

            if (command.matches("set priority of all [a-zA-Z]{7,14}")){
                String[] tmp = command.split(" ");
                game.setArmoryTargetPriority(PlayGround.numberOfPlaces, TargetPriority.valueOf(tmp[4]));
            }

            if( command.contains("add tesla in point") ){
                String[] tmp = command.split(" ");
                String coordinateString = tmp[4]; // (x,y)
                int x = coordinateString.charAt(1);
                int y = coordinateString.charAt(3);
                game.useTesla( new Coordinate(x,y) );
            }

            if( command.contains("move hero to") ){
                String[] tmp = command.split(" ");  // (x,y)
                String coordinateString = tmp[3];
                int x = coordinateString.charAt(1);
                int y = coordinateString.charAt(3);
                game.moveHero( new Coordinate(x,y) );
            }

            //TODO hero stop time
            if (command.equals("let hero stop time")){
                //method
            }

            //Todo game speed
            if (command.matches("speed x[0-9]{1,2}")){
                String[] tmp = command.split(" ");
                String[] speed = tmp[1].split("[x]");
                /// method for changing the speed
            }

            if (command.equals("divine intervention kill all")){
               game.interventionKillAll();
            }

            if (command.equals("divine intervention infantry")){
                game.makeGameSoldiers();
            }

            return "Done :))";

            /*if( round == this.plagueRound && game.getGameTime().getTime()==this.plagueTime.getTime() ){
                game.spreadPlague();
            }

            if( round == this.naturalEventRound && game.getGameTime().getTime()==this.naturalEventTime.getTime() ){
                game.naturalEventHappening();
            }*/

            //command = scanner.nextLine();

       // }

       /* round++;
        if( round <= this.numberOfRounds )
            playEndRound();
        else
            playWinnerEnd();*/


    }

    public String playBreak( String command ){
        //command = scanner.nextLine();
        //while (!command.equals("begin next round")){
            if (command.equals("show details weapons")){
                game.showArmoriesDetails();
            }
            if (command.equals("show details hero")){
                game.showHeroDetails();
            }
            if (command.equals("show details infantry")){
                game.showSoldiersDetails();
            }
            if (command.equals("show details slots")){
                game.showSlotsDetails();
            }
            if (command.contains("add")){
                String[] tmp = command.split(" ");
                if(tmp.length == 5) {
                    return ( game.createArmory(tmp[1], Integer.parseInt(tmp[4])) );
                }
            }
            if (command.matches("upgrade [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                return ( game.upgradeArmory(Integer.parseInt(tmp[4])) );
            }
            if (command.matches("sell [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                game.sellArmory(Integer.parseInt(tmp[4]));
            }
            if (command.contains("move hero to")){
                String[] tmp = command.split("");
                if (tmp.length == 4){
                    String[] XY = tmp[3].split("[(),]");
                    Coordinate coordinate = new Coordinate(Integer.parseInt(XY[1]), Integer.parseInt(XY[2]));
                    game.moveHero(coordinate);
                }
            }
            if (command.contains("set infantry")){ ////set infantry [0 1 2] of barracks in place N to go to (X,Y)
                String[] tmp = command.split(" ");
                if (tmp.length == 12){
                    String[] XY = tmp[11].split("[(),]");
                    Coordinate coordinate = new Coordinate(Integer.parseInt(XY[1]), Integer.parseInt(XY[2]));
                    game.moveSoldier(Integer.parseInt(tmp[7]), Integer.parseInt(tmp[2]), coordinate);
                }else if(tmp.length == 9){
                    String[] XY = tmp[7].split("[(),]");
                    Coordinate coordinate = new Coordinate(Integer.parseInt(XY[1]), Integer.parseInt(XY[2]));
                    game.moveSoldier(PlayGround.numberOfPlaces , Integer.parseInt(tmp[2]), coordinate);
                }
            }
            return "Done :))";
            //command = scanner.nextLine();
        //}
    }

    public void playPause(){

        command = scanner.next();
        while (!command.equals("OK")){
            command = scanner.nextLine();
        }

    }

    public void playEndRound(){

        command = scanner.next();
        while (!command.equals("OK")){
            command = scanner.nextLine();
        }
        //playBreak();
    }

    public void playWinnerEnd(){
        System.out.println("Congratulation :)) You won the game ...");
    }

    /*public void setCommand(String command){
        this.command = command;
        System.out.println(command);
        this.doCommand(command);
    }

    public void doCommand(String command){
        if (command.matches("add [a-zA-Z]{5,10} in place [0-9]{1,2}")){
            String[] tmp = command.split(" ");
            game.createArmory(tmp[1], Integer.parseInt(tmp[4]));
        }
        if (command.matches("show details [a-z]{4,8}")){
            String[] tmp = command.split(" ");
            if (tmp[2].equals("weapons")){
                game.showArmoriesDetails();
            }
            if (tmp[2].equals("enemy")){
                game.showInvadersDetails();
            }
            if (tmp[2].equals("infantry")){
                game.showSoldiersDetails();
            }
            if (tmp[2].equals("slots")){
                game.showSlotsDetails();
            }
            if (tmp[2].equals("hero")){
                game.showHeroDetails();
            }
        }

        if( command.equals("Pause") ){
            playPause();
        }

        if (command.equals("go ahead one sec")){
            game.increaseTime();
            System.out.println("Game Time Successfully increased");
        }
    }*/

    public Game getGame() {
        return game;
    }
}
