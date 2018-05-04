import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Armory> gameArmories= new ArrayList<>();
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
                }


            } else if( command.equals("show") ){
	            command = scan.next();
	            if( command.equals("details") ){
	                command = scan.next();
	                if( command.equals("weapons") ){
	                    for( Armory currentArmory : gameArmories ){
	                        currentArmory.showDetail();
                        }
                    }
                }
            }


            command = scan.next();

        }


    }
}