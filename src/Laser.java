import java.util.ArrayList;

public class Laser extends Armory implements Weapon, DetailShow{

    private boolean onAttack;
    private int shotPower;

    //Constructor
    public Laser( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        super.healthDegree = new HealthLevel(2); //Medium Health Level
        super.price = 2 * super.priceUnit; //Medium Price
        super.setTargetPriority("MinimumHealth");
        this.shotPower = 2 * super.shotPowerUnit;  //Medium Shot power
        super.graphicalSize = 5;
    }

    // Setters
    public void setOnAttack() { this.onAttack = true; }
    public void EndAttack() { this.onAttack = false; }


    // Other Methods


    @Override
    public void levelUp() {
        super.level++;
        super.range = (int)((double)super.range * 1.15);
        this.shotPower = (int)((double)this.shotPower * 1.15);
    }

    @Override
    public void attack( Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots ) {
        if( !onAttack ){
            gameShots.add( new LaserShot(super.coordinate, targetInvader, shotPower, this) );
            this.setOnAttack();
        }
    }

    @Override
    public Time getLastAttack() { return null; }

    @Override
    public void setLastAttack(Time t) {}

    @Override
    public void showDetail() {
        System.out.println("Laser:");
        System.out.println("Attack Range: Medium");
        System.out.println("Health Level: Medium");
        System.out.println("Price: Medium to High");
        System.out.println("Target Priority: Minimum Health Level");
        System.out.println("Additional Characteristics: Shoot Continues LaserShot ");
    }
}

