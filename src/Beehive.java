public class Beehive extends Armory implements Weapon{

    private Time attackRateTime;
    private Time lastAttack;
    private int shotPower;

    //Constructor
    public Beehive( int id, Coordinate coordinate) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1;
        super.range = 2 * super.rangeUnit; //Medium Range
        this.attackRateTime = new Time(1 * super.attackTimeUnit); //Low Attack Speed
        super.healthDegree = new HealthLevel(2);
        super.price = 3 * super.priceUnit;
        super.setTargetPriority("MinimumHealth");
        super.graphicalSize = 5;
        this.lastAttack = new Time(0);
    }

    // Other Methods


    @Override
    public void levelUp() {
        super.level++;
        super.range = (int)((double)super.range * 1.15);
        this.attackRateTime = new Time( (int)( (double)this.attackRateTime.getTime()*1.15) );
        this.shotPower = (int)((double)this.shotPower * 1.15);
    }

    @Override
    public void attack() {

    }

    @Override
    public Time getLastAttack() {
        return this.lastAttack;
    }

    public void setLastAttack(Time t){
        this.lastAttack = t;
    }

}
