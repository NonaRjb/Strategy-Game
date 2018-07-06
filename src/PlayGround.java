import java.util.Random;

public class PlayGround {
    static final int numberOfPlaces = 8;
    static final int numberOfOrigins = 9;
    final Map map = new Map();

    private final Coordinate[] placeOfArmories = {new Coordinate(290,499),
                                    new Coordinate(230,1199),
                                    new Coordinate(600,300),
                                    new Coordinate(740,1049),
                                    new Coordinate(750,1540),
                                    new Coordinate(690,590),
                                    new Coordinate(540,680),
                                    new Coordinate(470,1000)};

    private final Coordinate[] pathOriginCoordinate = {new Coordinate(300,0),
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
        return placeHolder[id-1];
    }

    public PlaceHolder[] getPlaceHolder(){
        return placeHolder;
    }

    public Coordinate[] getPlaceOfArmories() {
        return placeOfArmories;
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

    // Just to see if a specific Coordinate is in a path
    public Boolean isInWay(Coordinate coordinate){
        return map.isInWay(coordinate);
    }

    public Map getMap() {
        return map;
    }

}
