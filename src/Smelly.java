public class Smelly extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;
    //private Poison poisonPlume;

    //constructor
    Smelly(Coordinate init_coordinate){
        this.shootPower = 2; //Medium shoot power
        this.attackRateTime = new Time(3); //attacks every 3 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 2; //moves every 2 time units
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
