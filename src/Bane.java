import java.util.ArrayList;

public class Bane extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    // constructor
    Bane( int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 5; //High shoot power
        this.attackRateTime = new Time(3); //attacks every 3 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel( 4*Invader.healthUnit ); //High degree of health
        super.movementSpeed = 1 * super.speedConst; //moves 1 pixels in each time unit
        super.range = 2; //low range
    }

    public Time getLastAttack(){
        return this.lastAttack;
    }
    public void setLastAttack(Time time){
        this.lastAttack.setTime(time.getTime());// = time;
    }
    public int getShootPower() {
        return shootPower;
    }
    public Time getAttackRateTime(){
        return attackRateTime;
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
        detail = detail + "Bane:"+"\n";
        detail = detail + "Visibility Range: Low"+"\n";
        detail = detail + "Movement Speed: Very Low"+"\n";
        detail = detail + "Health Degree: High"+"\n";
        detail = detail + "Attack Rate: Low"+"\n";
        detail = detail + "Shoot Power: High"+"\n";
        detail = detail + "Additional Abilities: None"+"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")"+"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers+"\n";
        detail = detail + "Number of times Hero got killed by this Invader: " + super.numberOfHeroKill+"\n";
        return detail;
    }
}
