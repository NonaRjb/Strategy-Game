public class Healer extends Invader implements InvaderAttack {
    final int healPower;
    final int healRate;

    //constructor
    Healer(Coordinate init_coordinate){
        this.healRate = 5; //heals every 5 time units(Medium)
        this.healPower = 1; //low power of each heal
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 2; //moves 2 pixels in each time unit
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

    @Override
    public void showDetail(){
        System.out.println("Healer:");
        System.out.println("Visibility Range: Low");
        System.out.println("Movement Speed: Low");
        System.out.println("Health Degree: Low");
        System.out.println("Heal Rate: Medium");
        System.out.println("Heal Power: Low");
        System.out.println("Additional Abilities: Instead of attacking, heals other Invaders but it can't heals itself");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
    }
}
