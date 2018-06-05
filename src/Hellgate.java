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
        super.price = new Price(Price.highPrice); //High Price
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
    public void levelUp(Price gamePrice) {
        if( gamePrice.getPrice() >= super.getLevelUpPrice().getPrice() ) {
            super.level++;
            gamePrice.decreasePrice(this.getLevelUpPrice());
            super.range = (int)((double)super.range * 1.15);
            this.shotPower = (int)((double)this.shotPower * 1.15);
            System.out.println("Hellgate id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
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
        System.out.println("Hellgate id: "+super.id);
        System.out.println("Additional Characteristics: Burns Every Invader in Range");
        System.out.println("Attack Range: "+super.range+" pixels!");
        System.out.println("Health Level: "+super.healthDegree.getHealthLevel()+" Units");
        System.out.println("Price: "+super.price.getPrice()+" Coins");
        System.out.println("Target Priority: "+super.getTargetPriority());
        System.out.println("//////////////////////////////////////");
    }

}

