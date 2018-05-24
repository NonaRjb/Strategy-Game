public class Poison extends Shot{

    private int range;
    static final int healthDecreasingPower = 1;

    // Constructor
    public Poison(Coordinate startCoordinate, int range) {
        super.coordinate = startCoordinate;
        this.range = range;
        super.target = null;
        super.power = 0;
    }

    // Getters
    public int getRange() { return range; }

}
