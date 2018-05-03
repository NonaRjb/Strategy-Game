public class Hopper extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    //constructor
    Hopper(Coordinate init_coordinate){
        this.shootPower = 3; //Medium shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
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

    public void accelerate(){

    }

    @Override
    public void attack() {

    }
}
