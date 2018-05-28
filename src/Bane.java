import java.util.ArrayList;

public class Bane extends Invader{
    final int shootPower;
    final Time attackRateTime;
    private Time lastAttack;

    // constructor
    Bane(Coordinate init_coordinate){
        this.shootPower = 5; //High shoot power
        this.attackRateTime = new Time(3); //attacks every 3 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
        super.movementSpeed = 1 * super.speedConst; //moves 1 pixels in each time unit
        super.range = 2; //low range
    }

    public Time getLastAttack(){
        return this.lastAttack;
    }
    public void setLastAttack(Time time){
        this.lastAttack = time;
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
                gameShots.add(new Bullet(super.coordinate, super.getTarget(i), shootPower));
            }
            return true;
        }

    }

    @Override
    public void showDetail(){
        System.out.println("Bane:");
        System.out.println("Visibility Range: Low");
        System.out.println("Movement Speed: Very Low");
        System.out.println("Health Degree: High");
        System.out.println("Attack Rate: Low");
        System.out.println("Shoot Power: High");
        System.out.println("Additional Abilities: None");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
    }
}
