import java.util.ArrayList;

public class Freezer extends Armory implements Weapon {

    private Time attackRateTime;
    private Time lastAttack;
    private int shotPower;

    //Constructor
    public Freezer( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1;
        super.range = 2 * super.rangeUnit; //Medium Range
        this.attackRateTime = new Time(1 * super.attackTimeUnit); //Low Attack Speed
        super.healthDegree = new HealthLevel(2);  //Medium Health Level
        super.price = new Price(Price.highPrice); //High Price
        super.setTargetPriority(TargetPriority.MinimumHealth);
        super.specificTargetInvader = null;
        this.shotPower = 1 * super.shotPowerUnit;  //Low Shot power
        super.graphicalSize = 5;
        this.lastAttack = new Time(0);
    }

    // Other Methods


    @Override
    public void levelUp(Price gamePrice) {
        if( gamePrice.getPrice() >= super.getLevelUpPrice().getPrice() ) {
            super.level++;
            gamePrice.decreasePrice(this.getLevelUpPrice());
            super.range = (int)((double)super.range * 1.15);
            this.shotPower = (int)((double)this.shotPower * 1.15);
            this.attackRateTime = new Time( (int)( (double)this.attackRateTime.getTime()*1.15) );
            System.out.println("Freezer id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
    }

    @Override
    public void attack(Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots) {
        if( currentTime.getTime()-this.lastAttack.getTime() >= this.attackRateTime.getTime() ){
            gameShots.add( new Ice(super.coordinate, targetInvader, shotPower) );
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

        System.out.println("Freezer id: "+super.id);
        System.out.println("Additional Characteristics: Make an Invader Frozen");
        System.out.println("Attack Range: "+super.range+" pixels!");
        System.out.println("Attack Speed: Every "+this.attackRateTime.getTime()+" Seconds");
        System.out.println("Health Level: "+super.healthDegree.getHealthLevel()+" Units");
        System.out.println("Price: "+super.price.getPrice()+" Coins");
        System.out.println("Target Priority: "+super.getTargetPriority());
        System.out.println("//////////////////////////////////////");
    }
}
