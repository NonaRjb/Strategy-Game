import java.util.ArrayList;

public class Hellgate extends Armory implements Weapon{

    private int shotPower;
    private boolean isBurning;

    //Constructor
    public Hellgate( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        super.healthDegree = new HealthLevel(1); //Low Health Level
        super.price = 3 * super.priceUnit; //High Price
        super.setTargetPriority(TargetPriority.AllInRange);
        super.specificTargetInvader = null;
        this.shotPower = 2 * super.shotPowerUnit;  //Medium Shot power
        super.graphicalSize = 5;
        this.isBurning = false;
    }

    // Getters
    public boolean isBurning() {
        return isBurning;
    }

    // Setters
    public void setBurning(boolean burning) {
        isBurning = burning;
    }


    // Other Methods

    @Override
    public void levelUp() {
        super.level++;
        super.range = (int)((double)super.range * 1.15);
        this.shotPower = (int)((double)this.shotPower * 1.15);
    }

    @Override
    public void attack( Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots ) {
            gameShots.add( new Fire(super.coordinate, shotPower, this) );
    }

    @Override
    public Time getLastAttack() {
        return null;
    }

    public void setLastAttack(Time t){}

    @Override
    public void showDetail() {
        System.out.println("Hellgate:");
        System.out.println("Attack Range: Medium");
        System.out.println("Health Level: Low");
        System.out.println("Price: High");
        System.out.println("Target Priority: All In Range");
        System.out.println("Additional Characteristics: Burns Every Invader in Range");
    }

}

