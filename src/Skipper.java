//import org.omg.CORBA.TIMEOUT;

import java.util.ArrayList;

public class Skipper extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    Skipper(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 5; //high shoot power
        this.attackRateTime = new Time(1); //high attack speed
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 4; //High range
    }
    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack = lastAttack;
    }

    public Time getLastAttack() {
        return lastAttack;
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
        String detail ="";
        detail = detail + "Skipper:" +"\n";
        detail = detail + "Visibility Range: High" +"\n";
        detail = detail + "Movement Speed: Low" +"\n";
        detail = detail + "Health Degree: Low" +"\n";
        detail = detail + "Attack Rate: High" +"\n";
        detail = detail + "Shoot Power: High" +"\n";
        detail = detail + "Additional Abilities: None" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers +"\n";
        detail = detail + "Number of times Hero got killed by this Invader" + super.numberOfHeroKill +"\n";
        return detail;
    }
}
