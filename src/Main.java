import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        ArrayList<Invader> gameInvaders = new ArrayList<>();
        Coordinate[] armoryCoordinates = new Coordinate[10];
        for(int i=0; i<10; i++){
            armoryCoordinates[i] = new Coordinate(i,i);
        }

        Scanner scan = new Scanner(System.in);
	    String command = scan.next();
	    int intCommand;

	    while (!command.equals("end")){

	        if( command.equals("add") ){
	            command = scan.next();

	            if( command.equals("Freezer") ){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Freezer", intCommand );
                        }
                    }
                } else if(command.equals("MachineGun")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "MachineGun", intCommand );
                        }
                    }
                } else if(command.equals("Laser")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Laser", intCommand );
                        }
                    }
                } else if(command.equals("Rocket")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Rocket", intCommand );
                        }
                    }
                } else if(command.equals("Excalibur")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Excalibur", intCommand );
                        }
                    }
                } else if(command.equals("Beehive")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Beehive", intCommand );
                        }
                    }
                } else if(command.equals("Hellgate")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Hellgate", intCommand );
                        }
                    }
                } else if(command.equals("Sauron")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            game.createArmory( "Sauron", intCommand );
                        }
                    }
                }


            } else if( command.equals("show") ){
	            command = scan.next();
	            if( command.equals("details") ){
	                command = scan.next();
	                if( command.equals("weapons") ){
	                    game.showArmoriesDetails();
                    } else if ( command.equals("enemy") ){
                        game.showInvadersDetails();
                    }
                }
            }

            game.invaderMaker();
	        game.increaseTime();
            command = scan.next();

        }


    }
}