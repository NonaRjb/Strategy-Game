import java.util.ArrayList;

public class Sauron extends Armory implements Weapon{

    private Time attackRateTime;
    private Time lastAttack;
    private int shotPower;

    //Constructor
    public Sauron( int id, Coordinate coordinate) {
        super();
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 100 * super.rangeUnit; //Infinity Range
        this.attackRateTime = new Time(2 * super.attackTimeUnit); //Medium Attack Speed
        super.healthDegree = new HealthLevel(2); //Medium Health Level
        super.price = new Price(Price.highPrice); //High Price
        super.setTargetPriority(TargetPriority.MinimumHealth);
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
            System.out.println("Sauron id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
    }

    @Override
    public void attack( Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots ) {
        if( currentTime.getTime()-this.lastAttack.getTime() >= this.attackRateTime.getTime() ){
            gameShots.add( new Bullet(super.coordinate, this, targetInvader, shotPower) );
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

        System.out.println("Sauron id: "+super.id);
        System.out.println("Additional Characteristics: Nothing");
        System.out.println("Attack Range: Infinity!");
        System.out.println("Attack Speed: Every "+this.attackRateTime.getTime()+" Seconds");
        System.out.println("Health Level: "+super.healthDegree.getHealthLevel()+" Units");
        System.out.println("Price: "+super.price.getPrice()+" Coins");
        System.out.println("Target Priority: "+super.getTargetPriority());
        System.out.println("//////////////////////////////////////");
    }

}

