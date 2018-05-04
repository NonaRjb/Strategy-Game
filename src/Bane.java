public class Bane extends Invader implements InvaderAttack, DetailShow{
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

    @Override
    public void showDetail(){
        System.out.println("Bane:");
        System.out.println("Visibility Range: Low");
        System.out.println("Movement Speed: Very Low");
        System.out.println("Health Degree: High");
        System.out.println("Attack Rate: Low");
        System.out.println("Shoot Power: High");
        System.out.println("Additional Abilities: None");
    }
}
