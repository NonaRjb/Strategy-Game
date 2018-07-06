import java.util.ArrayList;

public class Smelly extends Invader {
    final int shootPower;
    final Time attackRateTime;
    //private Poison poisonPlume;
    private Time lastAttack;

    //constructor
    Smelly(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 2; //Medium shoot power
        this.attackRateTime = new Time(3); //attacks every 3 time units
        this.lastAttack = new Time(0);
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
                gameShots.add(new Bullet(super.coordinate, this, super.getTarget(i), shootPower));
            }
            return true;
        }
    }

    @Override
    public String showDetail(){
        String detail="";
        detail = detail + "Smelly:" +"\n";
        detail = detail + "Visibility Range: Medium" +"\n";
        detail = detail + "Movement Speed: Medium" +"\n";
        detail = detail + "Health Degree: Low" +"\n";
        detail = detail + "Attack Rate: Low" +"\n";
        detail = detail + "Shoot Power: Medium" +"\n";
        detail = detail + "Additional Abilities: When it dies it remains a poisonous cloud around itself, if the Hero" +
                           "any of the soldiers smell that, their health degree decreases for some secs" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers +"\n";
        detail = detail + "Number of times Hero got killed by this Invader" + super.numberOfHeroKill +"\n";
        return detail;
    }
}
