import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Armory> gameArmories= new ArrayList<>();
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
                            gameArmories.add( new Freezer( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(command.equals("MachineGun")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new MachineGun( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(command.equals("Laser")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new Laser( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(command.equals("Rocket")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new Rocket( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(command.equals("Excalibur")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new Excalibur( intCommand, armoryCoordinates[intCommand], new Time(0) ) );
                        }
                    }
                } else if(command.equals("Beehive")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new Beehive( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(command.equals("Hellgate")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new Hellgate( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(command.equals("Sauron")){
                    command = scan.next();
                    if( command.equals("in") ){
                        command = scan.next();
                        if( command.equals("place") ){
                            command = scan.next();
                            intCommand = Integer.parseInt(command);
                            gameArmories.add( new Sauron( intCommand, armoryCoordinates[intCommand] ) );
                        }
                    }
                } else if(  command.equals("Henchman") ){
	                gameInvaders.add( new Henchman( armoryCoordinates[0] ) );
                } else if(  command.equals("Skipper") ){
                    gameInvaders.add( new Skipper( armoryCoordinates[0] ) );
                } else if(  command.equals("Bane") ){
                    gameInvaders.add( new Bane( armoryCoordinates[0] ) );
                } else if(  command.equals("Sparrow") ){
                    gameInvaders.add( new Sparrow( armoryCoordinates[0] ) );
                } else if(  command.equals("Boomer") ){
                    gameInvaders.add( new Boomer( armoryCoordinates[0] ) );
                } else if(  command.equals("Healer") ){
                    gameInvaders.add( new Healer( armoryCoordinates[0] ) );
                } else if(  command.equals("Motivator") ){
                    gameInvaders.add( new Motivator( armoryCoordinates[0] ) );
                } else if(  command.equals("Icer") ){
                    gameInvaders.add( new Icer( armoryCoordinates[0] ) );
                } else if(  command.equals("Miner") ){
                    gameInvaders.add( new Miner( armoryCoordinates[0] ) );
                } else if(  command.equals("Smelly") ){
                    gameInvaders.add( new Smelly( armoryCoordinates[0] ) );
                } else if(  command.equals("Hopper") ){
                    gameInvaders.add( new Hopper( armoryCoordinates[0] ) );
                } else if(  command.equals("ExG") ){
                    gameInvaders.add( new ExG( armoryCoordinates[0] ) );
                } else if(  command.equals("HockeyMaskMan") ){
                    gameInvaders.add( new HockeyMaskMan( armoryCoordinates[0] ) );
                }


            } else if( command.equals("show") ){
	            command = scan.next();
	            if( command.equals("details") ){
	                command = scan.next();
	                if( command.equals("weapons") ){
	                    for( Armory currentArmory : gameArmories ){
	                        currentArmory.showDetail();
                        }
                    } else if ( command.equals("enemy") ){
                        for( Invader currentInvader : gameInvaders ){
                            currentInvader.showDetail();
                        }
                    }
                }
            }


            command = scan.next();

        }


    }
}