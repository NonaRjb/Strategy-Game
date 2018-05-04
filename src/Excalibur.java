import java.util.ArrayList;

public class Excalibur extends Armory implements Weapon,DetailShow{

    private Time attackRateTime;
    private Time lastAttack;
    private Time creationTime;
    private int shotPower;
    private boolean isActive;

    final Time activationLatency = new Time(30);
    //Constructor
    public Excalibur( int id, Coordinate coordinate, Time currentTime) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 10 * super.rangeUnit; //Infinity Range
        this.attackRateTime = new Time( (int)(0.5 * (double)super.attackTimeUnit) ); //Very Low Attack Speed
        super.healthDegree = new HealthLevel(3); //High Health Level
        super.price = 4 * super.priceUnit; //Very High Price
        super.setTargetPriority("MinimumHealth");
        this.shotPower = 4 * super.shotPowerUnit;  //Very High Shot power
        this.creationTime = currentTime;
        this.isActive = false;
        super.graphicalSize = 5;
        this.lastAttack = new Time(0);
    }


    // Setters
    public void setActive() { isActive = true; }

    // Getters
    public boolean isExcaliburActive() { return isActive; }


    // Other Methods
    public void Activate(Time currentTime){
        if( !this.isActive ) {
            if (currentTime.getTime() - this.creationTime.getTime() > this.activationLatency.getTime())
                this.setActive();
        }

    }

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
            gameShots.add( new Bullet(super.coordinate, targetInvader, shotPower) );
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
        System.out.println("Excalibur:");
        System.out.println("Attack Range: Infinity");
        System.out.println("Attack Speed: Very Low");
        System.out.println("Health Level: High");
        System.out.println("Price: Very High");
        System.out.println("Target Priority: Minimum Health Degree");
        System.out.println("Additional Characteristics: Only One Times could be Produced, with 30 seconds Latency");
    }

}

