public class Motivator extends Invader implements InvaderAttack {
    final int motivePower;
    final int motiveRate;

    //constructor
    Motivator(Coordinate init_coordinate){
        this.motivePower = 1; //low motive power
        this.motiveRate = 2; //motives every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium degree of health
        super.movementSpeed = 2; //moves 2 pixels in each time unit
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

    @Override
    public void showDetail(){
        System.out.println("Motivator:");
        System.out.println("Visibility Range: Low");
        System.out.println("Movement Speed: Low");
        System.out.println("Health Degree: Medium");
        System.out.println("Motivation Rate: Medium");
        System.out.println("Motivation Power: Low");
        System.out.println("Additional Abilities: Causes every Invaders in it's range, have more shoot power");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
    }
}
