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

    public int getId() {
        return id;
    }

    // Setters
    public void setOwner(Armory owner) { this.owner = owner; }

    @Override
    public String  showDetail() {
        String detail="";
        detail = detail + "Slot id: " + id +"\n";
        detail = detail + "Slot Coordinate: " + "(" + this.getPlaceCoordinate().getX() + "," + this.getPlaceCoordinate().getY() + ")"+"\n";
        if (this.owner == null){
            detail = detail + "This Place Is Empty"+"\n";
        }
        else{
            detail = detail + owner.showDetail();
        }
        return detail;
    }
}
