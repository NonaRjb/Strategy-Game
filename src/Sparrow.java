import java.util.ArrayList;

public class Sparrow extends Invader implements InvaderAttack{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    //constructor
    Sparrow(Coordinate init_coordinate){
        this.shootPower = 2; //low shoot power
        this.attackRateTime = new Time(2); //attacks every 2 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(2); //Medium degree of health
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
                gameShots.add(new Bullet(super.coordinate, super.getTarget(i), shootPower));
            }
            return true;
        }
    }

    @Override
    public void showDetail(){
        System.out.println("Sparrow:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Medium");
        System.out.println("Health Degree: Medium");
        System.out.println("Attack Rate: Medium");
        System.out.println("Shoot Power: Low");
        System.out.println("Additional Abilities: Sparrow flies so it can only be attacked by armories");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
        System.out.println("Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers);
        System.out.println("Number of times Hero got killed by this Invader" + super.numberOfHeroKill);
    }
}
