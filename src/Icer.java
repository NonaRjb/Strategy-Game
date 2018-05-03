public class Icer extends Invader implements InvaderAttack {
    final Time attackRateTime;

    Icer(Coordinate init_coordinate){
        this.attackRateTime = new Time(4); //attacks every 4 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
        super.movementSpeed = 4; //moves every 4 time units
        super.range = 3; //Medium range
    }

    @Override
    public void attack() {

    }
}
