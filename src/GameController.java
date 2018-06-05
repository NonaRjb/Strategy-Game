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

        command = scanner.next();
        int intCommand;

        while (!game.isEnded()){

            if( command.equals("add") ){
                command = scanner.next();

                if( command.equals("Freezer") ){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Freezer", intCommand );
                        }
                    }
                } else if(command.equals("MachineGun")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "MachineGun", intCommand );
                        }
                    }
                } else if(command.equals("Laser")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Laser", intCommand );
                        }
                    }
                } else if(command.equals("Rocket")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Rocket", intCommand );
                        }
                    }
                } else if(command.equals("Excalibur")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Excalibur", intCommand );
                        }
                    }
                } else if(command.equals("Beehive")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Beehive", intCommand );
                        }
                    }
                } else if(command.equals("Hellgate")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Hellgate", intCommand );
                        }
                    }
                } else if(command.equals("Sauron")){
                    command = scanner.next();
                    if( command.equals("in") ){
                        command = scanner.next();
                        if( command.equals("place") ){
                            command = scanner.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Sauron", intCommand );
                        }
                    }
                }


            } else if( command.equals("show") ){
                command = scanner.next();
                if( command.equals("details") ){
                    command = scanner.next();
                    if( command.equals("weapons") ){
                        game.showArmoriesDetails();
                    } else if ( command.equals("enemy") ){
                        game.showInvadersDetails();
                    }
                }
            } else if( command.equals("Pause") ){
                playPause();
            } else if( command.equals("go") ){
                command = scanner.next();
                if( command.equals("ahead") ){
                    command = scanner.next();
                    if( command.equals("sec") ){
                        game.increaseTime();
                        System.out.println("Game Time Successfully increased");
                    }
                }
            }

            command = scanner.next();

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
            if (command.contains("upgrade")){
                String[] tmp = command.split(" ");
                if (tmp.length == 5){

                }
            }
            if (command.contains("sell")){
                String[] tmp = command.split(" ");
                if (tmp.length == 5){

                }
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
                    game.moveSoldier(10 , Integer.parseInt(tmp[2]), coordinate);
                }
            }


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
