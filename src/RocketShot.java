public class RocketShot extends Shot{

    private int range;

    // Constuctor
    public RocketShot(Coordinate startCoordinate, int power) {
        super.coordinate = startCoordinate;
        super.power = power;
        this.range = 20;
        super.target = null;
    }

    // Getters
    public int getRange() {
        return range;
    }

}
