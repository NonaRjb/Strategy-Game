public class Skipper extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    Skipper(Coordinate init_coordinate){
        this.shootPower = 5; //high shoot power
        this.attackRateTime = new Time(1); //high attack speed
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 3; //moves every 3 time units
        super.range = 4; //High range
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

    @Override
    public void showDetail(){
        System.out.println("Skipper:");
        System.out.println("Visibility Range: High");
        System.out.println("Movement Speed: Low");
        System.out.println("Health Degree: Low");
        System.out.println("Attack Rate: High");
        System.out.println("Shoot Power: High");
        System.out.println("Additional Abilities: None");
    }
}
