public class Poison extends Shot{

    private int range;

    // Constuctor
    public Poison(Coordinate startCoordinate, int range) {
        super.coordinate = startCoordinate;
        this.range = range;
    }

}
