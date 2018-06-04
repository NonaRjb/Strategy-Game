public class PlaceHolder implements DetailShow{

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

    @Override
    public void showDetail() {
        System.out.println("Slot id: " + id);
        System.out.println("Slot Coordinate: " + "(" + this.getPlaceCoordinate().getX() + "," + this.getPlaceCoordinate().getY() + ")");
        if (this.owner == null){
            System.out.println("This Place Is Empty");
        }
        else{
            owner.showDetail();
        }
    }
}
