public class Fire extends Shot{


    final int range = 20;

    // Constructor
    public Fire(Coordinate startCoordinate, int power) {
        super.coordinate = startCoordinate;
        super.power = power;
        super.target = null;
    }

    // Getter
    public int getRange() {
        return range;
    }

}
