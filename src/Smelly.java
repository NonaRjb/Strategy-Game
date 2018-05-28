import java.util.ArrayList;

public class Smelly extends Invader {
    final int shootPower;
    final Time attackRateTime;
    //private Poison poisonPlume;
    private Time lastAttack;

    //constructor
    Smelly(Coordinate init_coordinate){
        this.shootPower = 2; //Medium shoot power
        this.attackRateTime = new Time(3); //attacks every 3 time units
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 3 * super.speedConst; //moves 3 pixels in each time unit
        super.range = 3; //Medium range
    }

    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack = lastAttack;
    }

    @Override
    public Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.getAttackRateTime().getTime()){
            return false;
        }
        else{
            this.setLastAttack(currentTime);
            for (Object target : targets){
                super.setTarget(target);
            }
            for (int i = 0; i < super.targetNum(); i++) {
                gameShots.add(new Bullet(super.coordinate, super.getTarget(i), shootPower));
            }
            return true;
        }
    }

    @Override
    public void showDetail(){
        System.out.println("Smelly:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Medium");
        System.out.println("Health Degree: Low");
        System.out.println("Attack Rate: Low");
        System.out.println("Shoot Power: Medium");
        System.out.println("Additional Abilities: When it dies it remains a poisonous cloud around itself, if the Hero" +
                           "any of the soldiers smell that, their health degree decreases for some secs");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
    }
}
