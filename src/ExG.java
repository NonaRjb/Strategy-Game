import java.util.ArrayList;

public class ExG extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    /////// constructor
    ExG(Coordinate init_coordinate){
        this.shootPower = 2; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 2; //Medium range
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
        this.lastAttack = time;
    }

    @Override
    public Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        if((currentTime.getTime() - this.getLastAttack().getTime()) < this.getAttackRateTime().getTime()){
            return false;
        }
        else {
            this.lastAttack = currentTime;
            for (Object target : targets) {
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
        System.out.println("Henchman:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Low");
        System.out.println("Health Degree: Medium");
        System.out.println("Attack Rate: Medium");
        System.out.println("Shoot Power: Low");
        System.out.println("Additional Abilities: Only attacks Hero");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
        System.out.println("Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers);
        System.out.println("Number of times Hero got killed by this Invader" + super.numberOfHeroKill);
    }
}
