public class Miner extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    //constructor
    Miner(Coordinate init_coordinate){
        this.shootPower = 1; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 3; //moves every 3 time units
        super.range = 1; //Very low range
    }

    public boolean isVisible(boolean isHero){
        return (isHero == true);
    }

    @Override
    public void attack() {

    }
}
