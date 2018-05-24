public class Fire extends Shot{


    final int range = 20;
    static final int healthDecreasingPower = 2;

    private Hellgate owner;

    // Constructor
    public Fire(Coordinate startCoordinate, int power, Hellgate owner) {
        super.coordinate = startCoordinate;
        super.power = power;
        super.target = null;
        this.owner = owner;
    }

    // Getter
    public int getRange() {
        return range;
    }
    public Hellgate getOwner() {
        return owner;
    }
}
