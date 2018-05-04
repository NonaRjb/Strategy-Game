import java.util.ArrayList;

public class Hellgate extends Armory implements Weapon{

    private int shotPower;

    //Constructor
    public Hellgate( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1; //Beginning
        super.range = 2 * super.rangeUnit; //Medium Range
        super.healthDegree = new HealthLevel(1); //Low Health Level
        super.price = 3 * super.priceUnit; //High Price
        super.setTargetPriority("MinimumHealth");
        this.shotPower = 2 * super.shotPowerUnit;  //Medium Shot power
        super.graphicalSize = 5;
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
            gameShots.add( new Fire(super.coordinate, targetInvader, shotPower) );
    }

    @Override
    public Time getLastAttack() {
        return null;
    }

    public void setLastAttack(Time t){}

}

