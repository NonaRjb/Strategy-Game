import java.util.ArrayList;

public class Healer extends Invader {
    final int healPower;
    final int healRate;
    private Time lastAttack;
    private final int healConst = 10;

    //constructor
    Healer(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.healRate = 5; //heals every 5 time units(Medium)
        this.healPower = 1 * healConst; //low power of each heal
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 2; //low range
    }

    public int getHealPower() {
        return healPower;
    }

    public int getHealRate() {
        return healRate;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(Time time){
        lastAttack = time;
    }

    @Override
    public Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.healRate){
            return false;
        }
        else{
            this.setLastAttack(currentTime);
            for (Object target : targets){
                super.setTarget(target);
            }
            for (Object invader : targets){
                if (((Invader) invader).isPoisoned()) {
                    ((Invader) invader).setPoisoned(false);
                }else {
                    ((Invader) invader).setHealthDegree(new HealthLevel(this.healPower));
                }
            }
            return true;
        }
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
