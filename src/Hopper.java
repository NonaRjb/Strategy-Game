public class Hopper extends Invader implements InvaderAttack, DetailShow{
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

    @Override
    public void showDetail(){
        System.out.println("Hopper:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Medium");
        System.out.println("Health Degree: Low");
        System.out.println("Attack Rate: Medium");
        System.out.println("Shoot Power: Medium");
        System.out.println("Additional Abilities: When it gets to the hero or a soldier for the first time, it moves 2" +
                           "times of its traveled distance in a sec");
    }
}
