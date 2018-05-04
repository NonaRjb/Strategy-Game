import java.util.ArrayList;

public class Rocket extends Armory implements Weapon{

    private Time attackRateTime;
    private Time lastAttack;
    private int shotPower;

    //Constructor
    public Rocket( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        this.attackRateTime = new Time(1 * super.attackTimeUnit); //Low Attack Speed
        super.healthDegree = new HealthLevel(2); //Medium Health Level
        super.price = 3 * super.priceUnit; //High Price
        super.setTargetPriority("AllInRang");
        this.shotPower = 2 * super.shotPowerUnit;  //Medium Shot power
        super.graphicalSize = 5;
        this.lastAttack = new Time(0);
    }

    // Other Methods


    @Override
    public void levelUp() {
        super.level++;
        super.range = (int)((double)super.range * 1.15);
        this.attackRateTime = new Time( (int)( (double)this.attackRateTime.getTime()*1.15) );
        this.shotPower = (int)((double)this.shotPower * 1.15);
    }

    @Override
    public void attack( Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots ) {
        if( currentTime.getTime()-this.lastAttack.getTime() >= this.attackRateTime.getTime() ){
            gameShots.add( new RocketShot(super.coordinate, shotPower) );
            this.setLastAttack(currentTime);
        }
    }

    @Override
    public Time getLastAttack() {
        return this.lastAttack;
    }

    public void setLastAttack(Time t){
        this.lastAttack = t;
    }

    @Override
    public void showDetail() {
        System.out.println("Rocket:");
        System.out.println("Attack Range: Medium");
        System.out.println("Attack Speed: Low");
        System.out.println("Health Level: Medium");
        System.out.println("Price: High");
        System.out.println("Target Priority: All In Range");
        System.out.println("Additional Characteristics: Shoot Everybody in Range");
    }

}

