import java.util.Random;

public class PlayGround {
    final int numberOfPlaces = 3;
    final int numberOfOrigins = 9;
    final Map map = new Map();

    Coordinate[] placeOfArmories = {new Coordinate(1,1),
                                    new Coordinate(2,2),
                                    new Coordinate(3,3)};

    Coordinate[] pathOriginCoordinate = {new Coordinate(300,0),
                                         new Coordinate(310,0),
                                         new Coordinate(320,0),
                                         new Coordinate(600,0),
                                         new Coordinate(610,0),
                                         new Coordinate(620,0),
                                         new Coordinate(899,590),
                                         new Coordinate(899,600),
                                         new Coordinate(899,610)};

    PlaceHolder[] placeHolder = new PlaceHolder[numberOfPlaces];

    // Constructor
    public PlayGround() {
        for( int i=0; i<numberOfPlaces; i++ ){
            this.placeHolder[i] = new PlaceHolder( i,placeOfArmories[i] );
        }
    }

    // Getters
    public PlaceHolder getPlaceHolder(int id) {
        return placeHolder[id];
    }

    // Other Methods
    public Coordinate randomOriginMaker(){
        Random rand = new Random();
        int placeToEnter = rand.nextInt( numberOfOrigins );
        return this.pathOriginCoordinate[ placeToEnter ];
    }

    // returns the next coordinate of a given coordinate
    // if the given coordinate is the last coordinate of the path the method returns (450,1599)
    public Coordinate nextCoordinate (Coordinate currentCoordinate){

        return map.nextCoordinate(currentCoordinate);
    }

}
