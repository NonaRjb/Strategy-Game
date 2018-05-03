public class ExG extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    /////// constructor
    ExG(Coordinate init_coordinate){
        this.shootPower = 2; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium degree of health
        super.movementSpeed = 3; //moves every 3 time units
        super.range = 3; //Medium range
    }

    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    @Override
    public void attack() {

    }
}
