public class Bane extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    // constructor
    Bane(Coordinate init_coordinate){
        this.shootPower = 5; //High shoot power
        this.attackRateTime = new Time(3); //attacks every 3 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
        super.movementSpeed = 4; //moves every 4 time units
        super.range = 2; //low range
    }
    public int getShootPower() {
        return shootPower;
    }
    public Time getAttackRateTime(){
        return attackRateTime;
    }

    @Override
    public void attack() {

    }
}
