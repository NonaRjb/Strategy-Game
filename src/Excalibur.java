import java.util.ArrayList;

public class Excalibur extends Armory implements Weapon{

    private Time attackRateTime;
    private Time lastAttack;
    private Time creationTime;
    private int shotPower;
    private boolean isActive;

    private final Time activationLatency = new Time(30);

    //Constructor
    public Excalibur( int id, Coordinate coordinate, Time currentTime) {
        super();
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 100 * super.rangeUnit; //Infinity Range
        this.attackRateTime = new Time(5*super.attackTimeUnit);//new Time( (int)(0.5 * (double)super.attackTimeUnit) ); //Very Low Attack Speed
        super.healthDegree = new HealthLevel(3); //High Health Level
        super.price = new Price(Price.veryHighPrice); //Very High Price
        super.setTargetPriority(TargetPriority.MinimumHealth);
        this.shotPower = 4 * super.shotPowerUnit;  //Very High Shot power
        this.creationTime = currentTime;
        this.isActive = false;
        super.graphicalSize = 5;
        this.lastAttack = new Time(0);
    }


    // Setters
    private void setActive() { isActive = true; }


    // Other Methods
    private void Activate(Time currentTime){
        if( !this.isActive ) {
            if (currentTime.getTime() - this.creationTime.getTime() > this.activationLatency.getTime())
                this.setActive();
        }

    }

    @Override
    public String levelUp(){//Price gamePrice) {
        String s = "";
        if( Game.property.getPrice() >= super.getLevelUpPrice().getPrice() ) {
            super.level++;
            Game.property.decreasePrice( super.getLevelUpPrice() );
            super.range = (int) ((double) super.range * 1.15);
            this.attackRateTime = new Time((int) ((double) this.attackRateTime.getTime() * 0.85));
            this.shotPower = (int) ((double) this.shotPower * 1.15);
            s = ("Excalibur id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
        return s;
    }

    @Override
    public Shot attack( Time currentTime, Invader targetInvader ) {
        this.Activate( currentTime );
        if( this.isActive ) {
            if (currentTime.getTime() - this.lastAttack.getTime() >= this.attackRateTime.getTime()) {
                this.setLastAttack(currentTime);
                return new Bullet(super.coordinate, this, targetInvader, shotPower);
            }
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
        detail = detail +"Excalibur id: "+super.id+"\n";
        detail = detail +"Features: Only One Times could be Produced, with 30 seconds Latency"+"\n";
        detail = detail +"Attack Range: Infinity!"+"\n";
        detail = detail +"Attack Speed: Every "+this.attackRateTime.getTime()+" Seconds"+"\n";
        detail = detail +"Health Level: "+super.healthDegree.getHealthLevel()+" Units"+"\n";
        detail = detail +"Price: "+super.price.getPrice()+" Coins"+"\n";
        detail = detail +"Target Priority: "+super.getTargetPriority()+"\n";
        detail = detail +"//////////////////////////////////////"+"\n";
        return detail;
    }

}

