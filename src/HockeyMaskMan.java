public class HockeyMaskMan extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    //constructor
    HockeyMaskMan(Coordinate init_coordinate){
        this.shootPower = 3; //Medium shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
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
