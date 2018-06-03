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
        game.setThisRoundNnumberOfInvaders(round*10);

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
