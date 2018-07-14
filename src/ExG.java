import java.util.ArrayList;

public class ExG extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    /////// constructor
    ExG(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 2 * shootPowerUnit; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(3*Invader.healthUnit); //Medium degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 3 * rangeUnit; //Medium range
    }

    public int getShootPower() {
        return shootPower;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public void setLastAttack(Time time){
        this.lastAttack.setTime(time.getTime());// = time;
    }

    @Override
    public ArrayList<Shot> attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        ArrayList<Shot> shots = new ArrayList<>();
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.getAttackRateTime().getTime()){
            return shots;
        }
        else {
            this.lastAttack = currentTime;
            for (Object target : targets) {
                super.setTarget(target);
            }
            for (int i = 0; i < super.targetNum(); i++) {
                shots.add(new Bullet(super.coordinate, this, super.getTarget(i), shootPower));
            }
            return shots;
        }
    }

    @Override
    public String showDetail(){
        String detail="";
        detail = detail + "Henchman:" +"\n";
        detail = detail + "Visibility Range: Medium" +"\n";
        detail = detail + "Movement Speed: Low" +"\n";
        detail = detail + "Health Degree: Medium" +"\n";
        detail = detail + "Attack Rate: Medium" +"\n";
        detail = detail + "Shoot Power: Low" +"\n";
        detail = detail + "Additional Abilities: Only attacks Hero" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers +"\n";
        detail = detail + "Number of times Hero got killed by this Invader" + super.numberOfHeroKill +"\n";
        return detail;
    }
}
