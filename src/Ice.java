public class Ice extends Shot{

    private Invader targetInvader;

    // Constructor

    public Ice(Coordinate startCoordinate,Invader targetInvader, int power) {
        super.coordinate = startCoordinate;
        this.targetInvader = targetInvader;
        super.power = power;
    }
}
