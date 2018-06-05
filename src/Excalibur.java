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
        this.attackRateTime = new Time( (int)(0.5 * (double)super.attackTimeUnit) ); //Very Low Attack Speed
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
    public void levelUp(Price gamePrice) {
        if( gamePrice.getPrice() >= super.getLevelUpPrice().getPrice() ) {
            super.level++;
            gamePrice.decreasePrice( super.getLevelUpPrice() );
            super.range = (int) ((double) super.range * 1.15);
            this.attackRateTime = new Time((int) ((double) this.attackRateTime.getTime() * 1.15));
            this.shotPower = (int) ((double) this.shotPower * 1.15);
            System.out.println("Excalibur id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
    }

    @Override
    public void attack( Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots ) {
        this.Activate( currentTime );
        if( this.isActive ) {
            if (currentTime.getTime() - this.lastAttack.getTime() >= this.attackRateTime.getTime()) {
                gameShots.add(new Bullet(super.coordinate, this, targetInvader, shotPower));
                this.setLastAttack(currentTime);
            }
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

        System.out.println("Excalibur id: "+super.id);
        System.out.println("Features: Only One Times could be Produced, with 30 seconds Latency");
        System.out.println("Attack Range: Infinity!");
        System.out.println("Attack Speed: Every "+this.attackRateTime.getTime()+" Seconds");
        System.out.println("Health Level: "+super.healthDegree.getHealthLevel()+" Units");
        System.out.println("Price: "+super.price.getPrice()+" Coins");
        System.out.println("Target Priority: "+super.getTargetPriority());
        System.out.println("//////////////////////////////////////");
    }

}

