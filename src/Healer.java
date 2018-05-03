public class Healer extends Invader implements InvaderAttack {
    final int healPower;
    final int healRate;

    //constructor
    Healer(Coordinate init_coordinate){
        this.healRate = 5; //heals every 5 time units(Medium)
        this.healPower = 1; //low power of each heal
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 3; //moves every 3 time units
        super.range = 2; //low range
    }

    public int getHealPower() {
        return healPower;
    }

    public int getHealRate() {
        return healRate;
    }

    @Override
    public void attack() {

    }
}
