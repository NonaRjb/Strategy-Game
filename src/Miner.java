import java.util.ArrayList;

public class Miner extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    //constructor
    Miner(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 1; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        this.lastAttack = new Time( 0 );
        super.healthDegree = new HealthLevel(3); //Low degree of health
        super.movementSpeed = 2 * super.speedConst; //moves 2 pixels in each time unit
        super.range = 1; //Very low range
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack = lastAttack;
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
    public void showDetail(){
        System.out.println("Miner:");
        System.out.println("Visibility Range: very Low");
        System.out.println("Movement Speed: Low");
        System.out.println("Health Degree: Low");
        System.out.println("Attack Rate: Medium");
        System.out.println("Shoot Power: Low");
        System.out.println("Additional Abilities: Moves under the ground and only can be seen by hero");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
        System.out.println("Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers);
        System.out.println("Number of times Hero got killed by this Invader" + super.numberOfHeroKill);
    }
}
