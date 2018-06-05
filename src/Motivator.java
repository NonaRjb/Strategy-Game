import java.util.ArrayList;

public class Motivator extends Invader {
    final int motivePower;
    final int motiveRate;
    private Time lastAttack;

    //constructor
    Motivator(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.motivePower = 1; //low motive power
        this.motiveRate = 2; //motives every 2 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 2; //low range
    }

    public int getMotivePower() {
        return motivePower;
    }

    public int getMotiveRate() {
        return motiveRate;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack = lastAttack;
    }

    @Override
    public Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.motiveRate){
            return false;
        }
        else{
            this.setLastAttack(currentTime);
            for (Object target : targets){
                super.setTarget(target);
            }
            return true;
        }
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
