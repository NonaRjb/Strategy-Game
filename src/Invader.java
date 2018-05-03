abstract class Invader {
    private Coordinate coordinate;
    private HealthLevel healthLevel;
    protected int movementSpeed;
    protected int range;
    private int InstanceNum;
    private boolean isFreezed;
    private boolean isBurning;
    private boolean isPoisoned;
    private int graphicalSize;
    private int numberOfKillings;

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

    public HealthLevel getHealthLevel() {
        return healthLevel;
    }

    public int getInstanceNum() {
        return InstanceNum;
    }

    public int getNumberOfKillings() {
        return numberOfKillings;
    }

    public void setHealthLevel(HealthLevel healthLevel) {
        this.healthLevel = healthLevel;
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

    public void showDetails(){
        ////// code goes here
    }
}
