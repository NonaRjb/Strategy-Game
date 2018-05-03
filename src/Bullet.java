public class Bullet extends Shot{

    private Object target;

    // Constuctor
    public Bullet(Coordinate startCoordinate,Invader targetInvader, int power) {
        super.coordinate = startCoordinate;
        this.target = targetInvader;
        super.power = power;
    }

}
