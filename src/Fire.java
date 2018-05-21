public class Fire extends Shot{

    Invader targetInvader;

    // Constuctor
    public Fire(Coordinate startCoordinate,Invader targetInvader, int power) {
        super.coordinate = startCoordinate;
        this.targetInvader = targetInvader;
        super.power = power;
    }

}
