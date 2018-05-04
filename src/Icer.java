public class Icer extends Invader implements InvaderAttack, DetailShow {
    final Time attackRateTime;

    Icer(Coordinate init_coordinate){
        this.attackRateTime = new Time(4); //attacks every 4 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
        super.movementSpeed = 4; //moves every 4 time units
        super.range = 3; //Medium range
    }

    @Override
    public void attack() {

    }

    @Override
    public void showDetail(){
        System.out.println("Icer:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Very Low");
        System.out.println("Health Degree: High");
        System.out.println("Attack Rate: Very Low");
        System.out.println("Shoot Power: None");
        System.out.println("Additional Abilities: Only attacks buildings and causes them to stop working for 10 secs");
    }
}
