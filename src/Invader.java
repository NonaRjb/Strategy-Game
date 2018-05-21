abstract class Invader implements DetailShow{
    protected Coordinate coordinate;
    protected HealthLevel healthDegree;
    protected int movementSpeed;
    protected int range;
    private int InstanceNum;
    private boolean isFreezed;
    private boolean isBurning;
    private boolean isPoisoned;
    private int graphicalSize;
    private int numberOfKillings;

    //constructor
    Invader(){
        numberOfKillings = 0;
    }

    public boolean isBurning() {
        return isBurning;
    }

    public boolean isFreezed() {
        return isFreezed;
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

    public int getInstanceNum() {
        return InstanceNum;
    }

    public int getNumberOfKillings() {
        return numberOfKillings;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setHealthDegree(HealthLevel healthDegree) {
        this.healthDegree = healthDegree;
    }

    public void setBurning(boolean burning) {
        isBurning = burning;
    }

    public void setFreezed(boolean freezed) {
        isFreezed = freezed;
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

}
