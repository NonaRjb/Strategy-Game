public class Bullet extends Shot{

    private Object target;

    // Constuctor
    public Bullet(Coordinate startCoordinate,Object target, int power) {
        super.coordinate = startCoordinate;
        this.target = target;
        super.power = power;
    }

}
