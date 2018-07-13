import java.util.ArrayList;

public class Soldier implements DetailShow{
    private Coordinate coordinate;
    private int range;
    private int speed;
    private int shootPower;
    private HealthLevel health;
    private Barracks barracksOwner;
    private Invader targetInvader;
    private int graphicalSize;
    private int numberOfKillings;
    private Time lastAttack;
    private Time attackRate;
    private boolean isStopped;
    private boolean isInMission;
    private int soldierID;
    //private Boolean isBoomed;

    Soldier(Coordinate init_coordinate, Barracks barracksOwner, int soldierID,HealthLevel healthLevel){
        this.coordinate = init_coordinate;
        this.health = healthLevel;
        this.lastAttack = new Time(0);
        this.attackRate = new Time(2); // attacks every 2 time units
        this.speed = 3; // moves 3 pixels every time unit
        this.shootPower = 10;
        this.range = 50; // low Range
        this.barracksOwner = barracksOwner;
        this.soldierID = soldierID;
        this.numberOfKillings = 0;
        this.isInMission = false;
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
    public Barracks getBarracksOwner() {
        return barracksOwner;
    }
    public boolean isInMission() {
        return isInMission;
    }
    public boolean isStopped() {
        return isStopped;
    }
    public int getSoldierID() {
        return soldierID;
    }
    public Invader getTargetInvader() { return targetInvader; }

    // Setters
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
    public void addNumberOfKillings(){ this.numberOfKillings++; }
    public void setLastAttack(Time lastAttack) {
        this.lastAttack.setTime(lastAttack.getTime());// = lastAttack;
    }
    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }
    public void setInMission(boolean inMission) {
        isInMission = inMission;
    }

    public void moveGame(Coordinate coordinate) {
        if (this.barracksOwner == null){
            this.coordinate = coordinate;
            System.out.println("Soldier number " + this.soldierID + " of Game  Successfully Moved to Place " + coordinate.showCoordinate());
        } else {
            if( Coordinate.distance(this.coordinate, coordinate) <= this.getBarracksOwner().getRange() ){
                this.coordinate = coordinate;
                System.out.println("Soldier number "+this.soldierID+" of Barrack ID: "+this.barracksOwner.getId()+
                                   " Successfully Moved to Place "+coordinate.showCoordinate());
            } else {
                System.out.println("Movement is out of Barracks Range");
            }
        }
    }

    @Override
    public String showDetail(){
        String detail="";
        detail = detail + "Soldier " +"\n";
        detail = detail + "HealthLevel: " + health +"\n";
        detail = detail + "Number of killed invaders by this soldier: " + numberOfKillings +"\n";
        detail = detail + "Current coordinate: " + this.getCoordinate().getX() + "," + this.getCoordinate().getY() +"\n";
        detail = detail + "////////////////////////////////////////" +"\n";
        return detail;
    }

    public void goAfterInvader(Invader target, Coordinate nextCoordinate){
        if (this.barracksOwner == null){
            isInMission = true;
            targetInvader = target;
            this.moveGame(nextCoordinate);
            System.out.println("Soldier number " + this.soldierID + " is Going After Invader: " + target.getInstanceNum());
        } else {
            if( Coordinate.distance(this.coordinate, nextCoordinate) <= this.getBarracksOwner().getRange() ){
                isInMission = true;
                targetInvader = target;
                this.moveGame(nextCoordinate);
                System.out.println("Soldier number " + this.soldierID + " is Going After Invader: " + target.getInstanceNum());
            } else {
                System.out.println("Invader is out of Barracks Range");
            }
        }
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
            gameShots.add(new Bullet(this.getCoordinate(), this, this.targetInvader, this.shootPower));
            return true;
        }
    }
}
