

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
        super.healthDegree = new HealthLevel(2*Invader.healthUnit); //Low degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 2 * rangeUnit; //low range
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
        lastAttack.setTime(time.getTime());// = time;
    }

    @Override
    public ArrayList<Shot> attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        ArrayList<Shot> shots = new ArrayList<>();
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.healRate){
            return shots;
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
            return shots;
        }
    }

    @Override
    public String showDetail(){
        String detail="";
        detail = detail + "Healer:" +"\n";
        detail = detail + "Visibility Range: Low" +"\n";
        detail = detail + "Movement Speed: Low" +"\n";
        detail = detail + "Health Degree: Low" +"\n";
        detail = detail + "Heal Rate: Medium" +"\n";
        detail = detail + "Heal Power: Low" +"\n";
        detail = detail + "Additional Abilities: Instead of attacking, heals other Invaders but it can't heals itself" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        return detail;
    }
}
