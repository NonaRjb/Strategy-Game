//mport com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Hopper extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    //constructor
    Hopper(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 3; //Medium shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
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
        this.lastAttack.setTime(lastAttack.getTime());// = lastAttack;
    }

    public void accelerate(){

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
                gameShots.add(new Bullet(super.coordinate, this, super.getTarget(i), shootPower));
            }
            return true;
        }
    }

    @Override
    public String showDetail(){
        String detail="";
        detail = detail + "Hopper:" +"\n";
        detail = detail + "Visibility Range: Medium" +"\n";
        detail = detail + "Movement Speed: Medium" +"\n";
        detail = detail + "Health Degree: Low" +"\n";
        detail = detail + "Attack Rate: Medium" +"\n";
        detail = detail + "Shoot Power: Medium" +"\n";
        detail = detail + "Additional Abilities: When it gets to the hero or a soldier for the first time, it moves 2" +
                           "times of its traveled distance in a sec" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers +"\n";
        detail = detail + "Number of times Hero got killed by this Invader" + super.numberOfHeroKill +"\n";
        return detail;
    }
}
