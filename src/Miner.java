import java.util.ArrayList;

public class Miner extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    //constructor
    Miner(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 1 * shootPowerUnit; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        this.lastAttack = new Time( 0 );
        super.healthDegree = new HealthLevel(2*Invader.healthUnit); //Low degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 1 * rangeUnit; //Very low range
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack.setTime(lastAttack.getTime());// = lastAttack;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public boolean isVisible(boolean isHero){
        return (isHero == true);
    }

    @Override
    public ArrayList<Shot> attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        ArrayList<Shot> shots = new ArrayList<>();
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.getAttackRateTime().getTime()){
            return shots;
        }
        else{
            this.setLastAttack(currentTime);
            for (Object target : targets){
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
        detail = detail + "Miner:" +"\n";
        detail = detail + "Visibility Range: very Low" +"\n";
        detail = detail + "Movement Speed: Low" +"\n";
        detail = detail + "Health Degree: Low" +"\n";
        detail = detail + "Attack Rate: Medium" +"\n";
        detail = detail + "Shoot Power: Low" +"\n";
        detail = detail + "Additional Abilities: Moves under the ground and only can be seen by hero" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers +"\n";
        detail = detail + "Number of times Hero got killed by this Invader: " + super.numberOfHeroKill +"\n";
        return detail;
    }
}
