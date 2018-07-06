import java.util.ArrayList;

public class Beehive extends Armory implements Weapon{

    private Time attackRateTime;
    private Time lastAttack;

    //Constructor
    public Beehive( int id, Coordinate coordinate) {
        super();
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        this.attackRateTime = new Time((int)(0.5 * (double)super.attackTimeUnit)); //Low Attack Speed
        super.healthDegree = new HealthLevel(2); //Medium Health Level
        super.price = new Price(Price.medPrice); //Medium Price
        super.setTargetPriority(TargetPriority.AllInRange);
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
            this.attackRateTime = new Time( (int)( (double)this.attackRateTime.getTime()*1.15) );
            System.out.println("Beehive id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
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
    public String showDetail() {
        String detail="";
        detail = detail + "Beehive id: "+super.id+"\n";
        detail = detail + "Additional Characteristics: Make a cloud of Poison around"+"\n";
        detail = detail + "Attack Range: "+super.range+" pixels!"+"\n";
        detail = detail + "Attack Speed: Every "+this.attackRateTime.getTime()+" Seconds"+"\n";
        detail = detail + "Health Level: "+super.healthDegree.getHealthLevel()+" Units"+"\n";
        detail = detail + "Price: "+super.price.getPrice()+" Coins"+"\n";
        detail = detail + "Target Priority: "+super.getTargetPriority()+"\n";
        detail = detail + "//////////////////////////////////////"+"\n";
        return detail;
    }
}

