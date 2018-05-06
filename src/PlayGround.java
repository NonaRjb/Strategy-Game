import java.util.Random;

public class PlayGround {
    final int numberOfPlaces = 3;
    final int numberOfOrigins = 2;
    Coordinate[] placeOfArmories = {new Coordinate(1,1),
                                    new Coordinate(2,2),
                                    new Coordinate(3,3)};

    Coordinate[] pathOriginCoordinate = {new Coordinate(1,2),
                                        new Coordinate(3,4)};

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

}
