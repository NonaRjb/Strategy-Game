public class Skipper extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    Skipper(Coordinate init_coordinate){
        this.shootPower = 5; //high shoot power
        this.attackRateTime = new Time(1); //high attack speed
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 3; //moves every 3 time units
        super.range = 4; //High range
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
