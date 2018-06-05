abstract class Armory implements DetailShow {

    protected Coordinate coordinate;
    protected int id;
    protected HealthLevel healthDegree;
    protected int level;
    protected Price price;
    protected int range;
    protected int graphicalSize;
    private TargetPriority targetPriority;
    protected Invader specificTargetInvader;
    private boolean isStopped = false;
    private Time freezingTime;
    private int icePower;

    final int priceUnit = Price.basePrice;
    final int attackTimeUnit = 100;
    final int rangeUnit = 10;
    final int shotPowerUnit = 10;

    // Setters
    public void setTargetPriority(TargetPriority targetPriority) {
        this.targetPriority = targetPriority;
        System.out.println("Armory ID: "+this.id+" Priority is set to: "+this.targetPriority);
    }
    public void setSpecificTargetInvader(Invader specificTargetInvader) {
        this.specificTargetInvader = specificTargetInvader;
    }

    // Getters
    public Coordinate getCoordinate(){ return this.coordinate; }
    public Price getPrice(){ return this.price; }
    public int getLevel(){ return this.level; }
    public int getRange() { return range; }
    public TargetPriority getTargetPriority() { return targetPriority; }
    public Invader getSpecificTargetInvader() {
        return specificTargetInvader;
    }
    public HealthLevel getHealthDegree() {
        return healthDegree;
    }
    public int getId(){
        return id;
    }
    public boolean isStopped() {
        return isStopped;
    }

    // Other Methods
    public void levelUp(Price gamePrice){}

    public void setStopped(boolean stopped , int power, Time currentTime) {
        this.isStopped = stopped;
        icePower = power;
        this.freezingTime = currentTime;
    }

    public Price getLevelUpPrice(){
        return new Price( (this.level + 1)* this.price.getPrice() );
    }

    public void checkStopped( Time currentTime ){
        if (this.isStopped){
            if((currentTime.getTime() - this.freezingTime.getTime()) >= this.icePower ){
                this.isStopped = false;
            }
        }
    }

}
