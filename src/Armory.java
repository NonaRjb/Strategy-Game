import org.omg.IOP.CodecFactoryOperations;

abstract class Armory {

    protected Coordinate coordinate;
    protected int id;
    protected HealthLevel healthDegree;
    protected int level;
    protected int price;
    protected int range;
    protected int graphicalSize;
    private String targetPriority;

    final int priceUnit = 100;
    final int attackTimeUnit = 100;
    final int rangeUnit = 10;
    final int shotPowerUnit = 10;

    // Setters
    public void setTargetPriority(String targetPriority) { this.targetPriority = targetPriority; }

    // Getters
    public Coordinate getCoordinate(){ return this.coordinate; }
    public int getPrice(){ return this.price; }
    public int getLevel(){ return this.level; }
    public String getTargetPriority() { return targetPriority; }

    // Other Methods
    public void levelUp(){}

    public int getLevelUpPrice(){
        return ((this.level + 1)* this.price);
    }

}
