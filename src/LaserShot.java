public class LaserShot extends Shot{

    private Invader targetInvader;
    private Laser owner;

    // Constuctor
    public LaserShot(Coordinate startCoordinate,Invader targetInvader, int power, Laser owner) {
        super.coordinate = startCoordinate;
        this.targetInvader = targetInvader;
        super.power = power;
        this.owner = owner;
    }

}
