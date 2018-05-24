import java.util.ArrayList;

abstract class Invader implements DetailShow, InvaderAttack{
    protected Coordinate coordinate;
    protected HealthLevel healthDegree;
    protected int movementSpeed;
    protected int range;
    private int InstanceNum;
    private boolean isFrozen;
    private boolean isBurning;
    private boolean isPoisoned;
    private int graphicalSize;
    private int numberOfKillings;
    private ArrayList<Object> target;
    private Time burningTime;

    static final int numberOfInvaderKinds = 13;

    //constructor
    Invader(){
        numberOfKillings = 0;
        target = new ArrayList<>();
    }

    // Getters
    public boolean isBurning() {
        return isBurning;
    }
    public boolean isFrozen() {
        return isFrozen;
    }
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
        return target.get(index);
    }
    public int getRange() {
        return range;
    }
    public int getInstanceNum() {
        return InstanceNum;
    }
    public int getNumberOfKillings() {
        return numberOfKillings;
    }
    public int getMovementSpeed() {
        return movementSpeed;
    }



    // Setters
    public void setHealthDegree(HealthLevel healthDegree) {
        this.healthDegree = healthDegree;
    }
    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public void setGraphicalSize(int graphicalSize) {
        this.graphicalSize = graphicalSize;
    }
    public void setInstanceNum(int instanceNum) {
        InstanceNum = instanceNum;
    }
    public void setNumberOfKillings(int numberOfKillings) {
        this.numberOfKillings = numberOfKillings;
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
    public int targetNum(){
        return this.target.size();
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
