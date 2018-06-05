import java.awt.*;
import java.util.Scanner;

public class GameController {

    private Scanner scanner = new Scanner(System.in);
    private Game game;
    private String command;
    private int currentRound;

    // Constructor
    public GameController() {
        this.game = new Game();
        this.currentRound = 0;
        playRound(0);
    }

    public void playRound(int round){

        game.setInvaderRate( new Time(20-round) );
        game.setThisRoundNumberOfInvaders(round*10);

        command = scanner.nextLine();
        int intCommand;

        while (!game.isEnded()){

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

            if (command.matches("set target of [a-zA-Z]{5,10} in place [0-9]{1,2} to be invader [0-9]{1,2}")){ // set target of Armory
                String[] tmp = command.split(" ");
                //
            }

            if (command.matches("set target of infantry [0-2] of barracks [0-9]{1,2} to be invader [0-9]{1,2}")){ // set target of barracks' infantry
                String[] tmp = command.split(" ");
                //game.goAfterInvaderSoldier( tmp[4], tmp[7], tmp[11] );
            }

            if (command.matches("set target of infantry [0-2] of game to be invader [0-9]{1,2}")){ // set target of game infantry
                String[] tmp = command.split(" ");
                //game.goAfterInvaderSoldier( tmp[4], PlayGround.numberOfPlaces, tmp[10] );
            }

            if (command.matches("set target of hero to be invader [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                //game.goAfterInvaderHero(tmp[7]);
            }

            if (command.matches("upgrade [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                game.upgradeArmory(Integer.parseInt(tmp[4]));
            }

            if (command.matches("sell [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                game.sellArmory(Integer.parseInt(tmp[4]));
            }

            if (command.matches("set priority of [a-zA-Z]{5,10} in place [0-9]{1,2} [a-zA-Z]{7,14}")){
                String[] tmp = command.split(" ");
                //game.
            }

            if (command.equals("let hero stop time")){
                //method
            }

            if (command.matches("speed x[0-9]{1,2}")){
                String[] tmp = command.split(" ");
                String[] speed = tmp[1].split("[x]");
                /// method for changing the speed
            }

            if (command.equals("divine intervention kill all")){
               /// emdade gheibi
            }

            if (command.equals("divine intervention infantry")){
                /// sarbaze gheibi
            }

            command = scanner.nextLine();

        }

        round++;
        playEndRound();

    }

    public void playBreak(){
        command = scanner.nextLine();
        while (!command.equals("begin next round")){
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
                    game.createArmory(tmp[1], Integer.parseInt(tmp[4]));
                }
            }
            if (command.matches("upgrade [a-zA-Z]{5,10} in place [0-9]{1,2}")){
                String[] tmp = command.split(" ");
                game.upgradeArmory(Integer.parseInt(tmp[4]));
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
            command = scanner.nextLine();
        }
    }

    public void playPause(){

        command = scanner.next();
        while (!command.equals("OK")){

        }

    }

    public void playEndRound(){

        command = scanner.next();
        while (!command.equals("OK")){

        }
        playBreak();
    }

}
