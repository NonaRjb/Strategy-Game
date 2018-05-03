public class Motivator extends Invader implements InvaderAttack {
    final int motivePower;
    final int motiveRate;

    //constructor
    Motivator(Coordinate init_coordinate){
        this.motivePower = 1; //low motive power
        this.motiveRate = 2; //motives every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium degree of health
        super.movementSpeed = 3; //moves every 3 time units
        super.range = 2; //low range
    }

    public int getMotivePower() {
        return motivePower;
    }

    public int getMotiveRate() {
        return motiveRate;
    }

    @Override
    public void attack() {

    }
}
