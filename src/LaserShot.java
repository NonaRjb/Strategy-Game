public class LaserShot extends Shot{

    private Laser owner;

    // Constuctor
    public LaserShot(Coordinate startCoordinate,Invader targetInvader, int power, Laser owner) {
        super.coordinate = startCoordinate;
        super.target = targetInvader;
        super.power = power;
        this.owner = owner;
    }

}
