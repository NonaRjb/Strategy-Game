public class PlaceHolder {

    private Coordinate placeCoordinate;
    private int id;
    private Armory owner;

    // Constructor
    public PlaceHolder( int id, Coordinate placeCoordinate ) {
        this.placeCoordinate = placeCoordinate;
        this.owner = null;
        this.id = id;
    }

    // Getters
    public Coordinate getPlaceCoordinate() { return placeCoordinate; }
    public Armory getOwner() { return owner; }

    // Setters
    public void setOwner(Armory owner) { this.owner = owner; }

}
