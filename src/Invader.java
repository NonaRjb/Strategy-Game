import java.util.ArrayList;

abstract class Invader implements DetailShow, InvaderAttack{
    protected Coordinate coordinate;
    protected HealthLevel healthDegree;
    protected int movementSpeed;
    protected int speedConst;
    protected int range;
    protected int instanceNum;
    private boolean isFrozen;
    private boolean isBurning;
    private boolean isPoisoned;
    private boolean isFighting;
    private int graphicalSize;
    protected int numberOfKilledSoldiers;
    protected int numberOfHeroKill;
    private ArrayList<Object> target;
    private Time burningTime;
    private Time freezingTime;
    private int icePower = 0;

    static final int numberOfInvaderKinds = 13;

    //constructor
    Invader(){
        numberOfKilledSoldiers = 0;
        numberOfHeroKill = 0;
        speedConst = 2;
        target = new ArrayList<>();
    }

    // Getters
    public boolean isBurning() {
        return isBurning;
    }
    public boolean getFrozen(){ return isFrozen; }
    public boolean isPoisoned() {
        return isPoisoned;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }
    public int getGraphicalSize() {
        return graphicalSize;
    }
    public HealthLevel getHealthDegree() {
        return healthDegree;
    }
    public Object getTarget(int index) {
        if( target != null )
            return target.get(index);
        return null;
    }
    public int getRange() {
        return range;
    }
    public int getInstanceNum() {
        return instanceNum;
    }
    public int getNumberOfKillings() {
        return numberOfKilledSoldiers;
    }
    public int getMovementSpeed() {
        return movementSpeed;
    }

    public boolean isFighting() {
        return isFighting;
    }

    // Setters
    public void setHealthDegree(HealthLevel healthDegree) {
        this.healthDegree = healthDegree;
    }
    public void setFrozen(boolean frozen , int power, Time currentTime) {
        icePower = power;  // If attacked by two IceShots, the Last one will be applied :))
        freezingTime = currentTime;
        isFrozen = frozen;
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public void setGraphicalSize(int graphicalSize) {
        this.graphicalSize = graphicalSize;
    }
    public void addNumberOfKillings() {
        this.numberOfKilledSoldiers++;
    }
    public void addNumberOfHeroKill() {
        this.numberOfHeroKill++;
    }
    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }
    public void setTarget(Object target) {
        this.target.add(target);
    }
    public void clearTarget(){
        this.target.clear();
    }

    public void setFighting(boolean fighting) {
        isFighting = fighting;
    }

    public int targetNum(){
        return this.target.size();
    }

    public boolean checkFrozen(Time currentTime){
        if (this.isFrozen){
            if( (currentTime.getTime() - this.freezingTime.getTime()) < this.icePower ) {
                return true;
            } else {
                isFrozen = false;
                return false;
            }
        }
        return false;
    }

    public void decreaseBurningTime() {
        if( this.burningTime.getTime() > 0 ) {
            this.burningTime = new Time(this.burningTime.getTime() - 1);
            this.healthDegree.decreaseHealth(Fire.healthDecreasingPower);
        } else {
            this.isBurning = false;
        }

    }

    public void setBurning(boolean burning) {
        isBurning = burning;
        if( burning ){
            this.burningTime = Game.burningTimeConst;
        }
    }

}
