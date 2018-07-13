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
    public String levelUp(){//Price gamePrice) {
        String s="";
        if( Game.property.getPrice() >= super.getLevelUpPrice().getPrice() ) {
            super.level++;
            Game.property.decreasePrice(this.getLevelUpPrice());
            super.range = (int)((double)super.range * 1.15);
            this.shotPower = (int)((double)this.shotPower * 1.15);
            this.attackRateTime = new Time( (int)( (double)this.attackRateTime.getTime()*1.15) );
            s=("Sauron id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
        return s;
    }

    @Override
    public Shot attack( Time currentTime, Invader targetInvader) {
        if( currentTime.getTime()-this.lastAttack.getTime() >= this.attackRateTime.getTime() ){
            this.setLastAttack(currentTime);
            return new Bullet(super.coordinate, this, targetInvader, shotPower);
        }
        return null;
    }

    @Override
    public Time getLastAttack() {
        return this.lastAttack;
    }

    public void setLastAttack(Time t){
        this.lastAttack.setTime(t.getTime());// = t;
    }

    @Override
    public String showDetail() {
        String detail="";
        detail = detail + "Sauron id: "+super.id +"\n";
        detail = detail + "Additional Characteristics: Nothing" +"\n";
        detail = detail + "Attack Range: Infinity!" +"\n";
        detail = detail + "Attack Speed: Every "+this.attackRateTime.getTime()+" Seconds" +"\n";
        detail = detail + "Health Level: "+super.healthDegree.getHealthLevel()+" Units" +"\n";
        detail = detail + "Price: "+super.price.getPrice()+" Coins" +"\n";
        detail = detail + "Target Priority: "+super.getTargetPriority() +"\n";
        detail = detail + "//////////////////////////////////////" +"\n";
        return detail;
    }

}

