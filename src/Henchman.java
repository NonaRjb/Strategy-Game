import java.util.ArrayList;

public class Henchman extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    //constructor
    Henchman(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.shootPower = 2; //Low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        super.coordinate = init_coordinate;
        this.lastAttack = new Time(0);
        super.healthDegree = new HealthLevel(2); //Medium healthLevel
        super.movementSpeed = 4 * super.speedConst; //moves 4 pixels in each time unit
        super.range = 3; //Medium Range
    }

    //getters
    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(Time time){
        lastAttack = time;
    }

    ////// attack method
    @Override
    public Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets){
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
        System.out.println("Henchman:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: High");
        System.out.println("Health Degree: Medium");
        System.out.println("Attack Rate: Medium");
        System.out.println("Shoot Power: Low");
        System.out.println("Additional Abilities: None");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
        System.out.println("Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers);
        System.out.println("Number of times Hero got killed by this Invader" + super.numberOfHeroKill);
    }
}