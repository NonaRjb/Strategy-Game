public class HockeyMaskMan extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;

    //constructor
    HockeyMaskMan(Coordinate init_coordinate){
        this.shootPower = 3; //Medium shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
        super.movementSpeed = 2; //moves 2 pixels in each time unit
        super.range = 3; //Medium range
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
        System.out.println("HockeyMaskMan:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Low");
        System.out.println("Health Degree: High");
        System.out.println("Attack Rate: Medium");
        System.out.println("Shoot Power: Medium");
        System.out.println("Additional Abilities: When it gets to a building, starts shooting it until the building" +
                           "collapses or it dies itself");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
    }
}
