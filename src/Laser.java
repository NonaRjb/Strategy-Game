import java.util.ArrayList;

public class Laser extends Armory implements Weapon{

    private boolean onAttack;
    private int shotPower;
    private LaserShot attackingLaserShot;

    //Constructor
    public Laser( int id, Coordinate coordinate) {
        super();
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        super.healthDegree = new HealthLevel(2); //Medium Health Level
        super.price = new Price(Price.medPrice); //Medium Price
        super.setTargetPriority(TargetPriority.MinimumHealth);
        this.shotPower = 2 * super.shotPowerUnit;  //Medium Shot power
        super.graphicalSize = 5;
        this.attackingLaserShot = null;
    }

    // Getters
    public boolean isOnAttack() {
        return onAttack;
    }
    public LaserShot getAttackingLaserShot() { return attackingLaserShot; }

    // Setters
    public void setOnAttack(LaserShot laserShot) {
        this.attackingLaserShot = laserShot;
        this.onAttack = true;
    }

    public void endAttack() {
        this.onAttack = false;
        this.attackingLaserShot = null;
    }


    // Other Methods


    @Override
    public void levelUp(Price gamePrice) {
        if( gamePrice.getPrice() >= super.getLevelUpPrice().getPrice() ) {
            super.level++;
            gamePrice.decreasePrice(this.getLevelUpPrice());
            super.range = (int)((double)super.range * 1.15);
            this.shotPower = (int)((double)this.shotPower * 1.15);
            System.out.println("Laser id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
    }

    @Override
    public Shot attack( Time currentTime, Invader targetInvader ) {
        if( !onAttack ){
            LaserShot laserShot = new LaserShot(super.coordinate, targetInvader, shotPower, this);
            this.setOnAttack( laserShot );
            return laserShot ;
        }
        return null;
    }

    @Override
    public Time getLastAttack() { return null; }

    @Override
    public void setLastAttack(Time t) {}

    @Override
    public String showDetail() {
        String detail = "";
        detail = detail + "Laser id: "+super.id +"\n";
        detail = detail + "Additional Characteristics: Shoot Continues LaserShot " +"\n";
        detail = detail + "Attack Range: "+super.range+" pixels!" +"\n";
        detail = detail + "Health Level: "+super.healthDegree.getHealthLevel()+" Units" +"\n";
        detail = detail + "Price: "+super.price.getPrice()+" Coins" +"\n";
        detail = detail + "Target Priority: "+super.getTargetPriority() +"\n";
        detail = detail + "//////////////////////////////////////" +"\n";
        return detail;

    }
}

