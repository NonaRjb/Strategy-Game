import java.util.ArrayList;

public class Beehive extends Armory implements Weapon{

    private Time attackRateTime;
    private Time lastAttack;

    //Constructor
    public Beehive( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        this.attackRateTime = new Time((int)(0.5 * (double)super.attackTimeUnit)); //Low Attack Speed
        super.healthDegree = new HealthLevel(2); //Medium Health Level
        super.price = 3 * super.priceUnit; //Medium Price
        super.setTargetPriority(TargetPriority.AllInRange);
        super.specificTargetInvader = null;
        super.graphicalSize = 5;
        this.lastAttack = new Time(0);
    }

    // Other Methods


    @Override
    public void levelUp() {
        super.level++;
        super.range = (int)((double)super.range * 1.15);
        this.attackRateTime = new Time( (int)( (double)this.attackRateTime.getTime()*1.15) );
    }

    @Override
    public void attack( Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots ) {
        if( currentTime.getTime()-this.lastAttack.getTime() >= this.attackRateTime.getTime() ){
            gameShots.add( new Poison(super.coordinate, super.range) );
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
        System.out.println("Beehive:");
        System.out.println("Attack Range: Medium");
        System.out.println("Attack Speed: Low");
        System.out.println("Health Level: Medium");
        System.out.println("Price: Medium");
        System.out.println("Target Priority: All In Range");
        System.out.println("Additional Characteristics: Make a cloud of Poison around");
    }
}

