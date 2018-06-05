public class Bullet extends Shot{

    private Object owner;

    // Constructor
    public Bullet(Coordinate startCoordinate,Object owner, Object target, int power) {
        super.coordinate = startCoordinate;
        this.owner = owner;
        super.target = target;
        super.power = power;
    }

    // Getters
    public Object getOwner() {
        return owner;
    }

}
