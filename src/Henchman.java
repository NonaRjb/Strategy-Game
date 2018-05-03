public class Henchman extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    //constructor
    Henchman(Coordinate init_coordinate){
        this.shootPower = 2; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium healthLevel
        super.movementSpeed = 1; //moves each time unit
        super.range = 3; //Medium Range
    }

    //getters
    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    ////// attack method
    @Override
    public void attack(){

    }
}