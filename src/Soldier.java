import java.util.ArrayList;

public class Soldier implements DetailShow{
    private Coordinate coordinate;
    private int range;
    private int speed;
    private int shootPower;
    private HealthLevel health;
    private int barrackID;
    private Invader targetInvader;
    private int graphicalSize;
    private int numberOfKillings;
    private Time lastAttack;
    private Time attackRate;
    private boolean isStopped;
    private boolean isFighting;
    private boolean isInMission;
    private int soldierID;
    //private Boolean isBoomed;

    Soldier(Coordinate init_coordinate, int barrackID, int soldierID,int healthLevel){
        this.coordinate = init_coordinate;
        this.health = new HealthLevel(healthLevel);
        this.lastAttack = new Time(0);
        this.attackRate = new Time(2); // attacks every 2 time units
        this.speed = 3; // moves 3 pixels every time unit
        this.shootPower = 10;
        this.range = 2; // low Range
        this.barrackID = barrackID;
        this.soldierID = soldierID;
        this.numberOfKillings = 0;
        this.isInMission = false;
        this.isFighting = false;
        this.isStopped = false;
    }


    // Getters
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
    public int getBarrackID() {
        return barrackID;
    }
    public boolean isInMission() {
        return isInMission;
    }

    public boolean isFighting() {
        return isFighting;
    }

    public boolean isStopped() {
        return isStopped;
    }
    public int getSoldierID() {
        return soldierID;
    }

    // Setters
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack = lastAttack;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }

    public void moveGame(Coordinate coordinate){
        if( this.barrackID == PlayGround.numberOfPlaces )
            this.coordinate = coordinate;
        else {
            //TODO: barracksID --> Barraks
        }
    }

    //ToDo
    @Override
    public void showDetail(){
        System.out.println("Soldier");
        System.out.println("HealthLevel: " + health);
        System.out.println("Number of killed invaders by this soldier: " + numberOfKillings);
        System.out.println("Current coordinate: " + this.getCoordinate().getX() + "," + this.getCoordinate().getY());
    }

    //ToDo go after invader! --> Done
    public void goAfterInvader(Invader target, Coordinate nextCoordinate){
        //isFighting = true;
        isInMission = true;
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
