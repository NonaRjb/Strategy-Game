import java.util.ArrayList;

public class Soldier implements DetailShow{
    private Coordinate coordinate;
    private int range;
    private int speed;
    private int shootPower;
    private HealthLevel health;
    private String barrackID;
    private Invader targetInvader;
    private int graphicalSize;
    private int numberOfKillings;
    private Time lastAttack;
    private Time attackRate;
    private boolean isStopped;
    private boolean isFighting;
    //private Boolean isBoomed;

    Soldier(Coordinate init_coordinate, String barrackID, int healthLevel){
        this.coordinate = init_coordinate;
        this.health = new HealthLevel(healthLevel);
        this.lastAttack = new Time(0);
        this.attackRate = new Time(2); // attacks every 2 time units
        this.speed = 3; // moves 3 pixels every time unit
        this.shootPower = 10;
        this.range = 2; // low Range
        this.barrackID = barrackID;
        this.numberOfKillings = 0;
    }

    public int getRange() {
        return range;
    }

    public int getSpeed() {
        return speed;
    }

    public void setTargetInvader(Invader targetInvader) {
        this.targetInvader = targetInvader;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public HealthLevel getHealth() {
        return health;
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack = lastAttack;
    }

    public void moveGame(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    //ToDo
    @Override
    public void showDetail(){

    }

    //ToDo go after invader! --> Done
    public void goAfterInvader(Invader target, Coordinate nextCoordinate){
        isFighting = true;
        targetInvader = target;
        this.moveGame(nextCoordinate);
    }

    public boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Invader> targetInvaders){
        if ((currentTime.getTime() - this.lastAttack.getTime()) < this.attackRate.getTime()){
            return false;
        }
        else {
            this.setLastAttack(currentTime);
            Invader target = targetInvaders.get(0);
            int distance = Coordinate.distance(  target.getCoordinate(), this.coordinate ) ;
            for (Invader invader : targetInvaders){
                if ( Coordinate.distance( invader.getCoordinate(), this.coordinate ) < distance) {
                    distance = Coordinate.distance( invader.getCoordinate(), this.coordinate );
                    target = invader;
                }
            }
            this.setTargetInvader(target);
            gameShots.add(new Bullet(this.getCoordinate(), this.targetInvader, this.shootPower));
            return true;
        }
    }
}
