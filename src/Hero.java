import java.util.ArrayList;

public class Hero implements DetailShow {
    private Coordinate coordinate;
    private HealthLevel healthLevel;
    private int level;
    private final int maxLevel = 5;
    private int delayConst;
    private int speedLevel;
    private int range;
    private int xpCnt;
    private int graphicalSize;
    private int numberOfKillings;
    private int deathNum;
    private Invader targetInvader;
    private Time attackRate;
    private Time lastAttack;
    private final int attackConst = 4;
    private int shootPower;
    private final int shootConst = 10;
    private boolean isIdle;
    private Time idleStartTime;
    private boolean isStopped;
    private Time stopStartTime;
    private boolean isInMission;
    //private Boolean isBoomed;

    //constructor
    Hero(Coordinate init_coordinate){
        coordinate = init_coordinate;
        level = 1;
        attackRate = new Time((maxLevel+1-level) * attackConst);
        lastAttack = new Time(0);
        shootPower = level * shootConst;
        healthLevel = new HealthLevel(1); //Hero's health unit is one
        delayConst = 10; //Just to be here! should be changed
        speedLevel = 1; // High Speed
        range = 4; // High Range
        this.xpCnt = 0;
        numberOfKillings = 0;
        deathNum = 0;
        idleStartTime = new Time(0);
        isInMission = false;
        isIdle = false;
        isStopped = false;
        stopStartTime = new Time(0);
    }

    //setter & getters
    public void addNumberOfKillings() {
        this.numberOfKillings++;
    }
    public void addDeathNum() {
        this.deathNum++;
    }
    public void setStopped(boolean stopped) {
        isStopped = stopped;
    }
    public boolean isInMission() {
        return isInMission;
    }
    public boolean isIdle() {
        return isIdle;
    }
    public int getNumberOfKillings() {
        return numberOfKillings;
    }
    public Coordinate getCoordinate(){
        return this.coordinate;
    }
    public Time getLastAttack() {
        return lastAttack;
    }
    public int getRange() {
        return range;
    }
    public HealthLevel getHealthLevel() {
        return healthLevel;
    }
    public int getDelayConst() {
        return delayConst;
    }
    public Invader getTargetInvader() {
        return targetInvader;
    }
    public boolean isStopped() {
        return isStopped;
    }
    public void setTarget(Invader invader){ this.targetInvader = invader; }
    public void setLastAttack(Time currentTime){ this.lastAttack.setTime(currentTime.getTime());}// = currentTime; }
    public void setIdle(Time currentTime){
        this.isIdle = true;
        this.idleStartTime = currentTime;
    }
    public void addXP(int xp){
        this.xpCnt += xp;
    }


    public void setInMission(boolean inMission) {
        isInMission = inMission;
    }

    public boolean checkIdle(Time currentTime){
       if ((currentTime.getTime() - this.idleStartTime.getTime()) < delayConst && isIdle){
           return true;
       }
       else {
           this.isIdle = false;
           return false;
       }
    }

    public boolean checkStopped(int stopConst, Time currentTime){
        if((currentTime.getTime() - stopStartTime.getTime()) < stopConst && isStopped){
            return true;
        } else {
            isStopped = false;
            return false;
        }
    }

    public void levelUp(){
        if(this.level < maxLevel) {
            this.level++;
            delayConst--; //delayConst must be decreased with each level upgrade
        }
    }

    public boolean freezeGame(){ //Notice! FreezeGame return value is boolean now!
        if(this.level >= 3){
            return true;
        }
        else return false;
    }

    public void goAfterInvader(Invader invader, Coordinate coordinate){
        //this.isFighting = true;
        this.isInMission = true;
        this.targetInvader = invader;
        this.moveTo(coordinate);
    }

    public void moveTo(Coordinate coordinate){

        this.coordinate = coordinate;
    }

    @Override
    public String showDetail() {
        String detail="";
        detail = detail + "Hero:" +"\n";
        detail = detail + "Level: " + level +"\n";
        detail = detail + "Health Level: " + healthLevel.getHealthLevel() +"\n";
        detail = detail + "XP count: " + xpCnt +"\n";
        detail = detail + "Delay after getting killed: " + delayConst +"\n";
        detail = detail + "Number of killed Invaders by Hero: " + numberOfKillings +"\n";
        detail = detail + "Number of times that hero has been killed: " + deathNum +"\n";
        detail = detail + "Current Coordinate: " + this.coordinate.getX() + "," + this.coordinate.getY() +"\n";
        // Speed and range are assumed to be constant
        return detail;
    }

    public boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Invader> targetInvaders){
        if((currentTime.getTime() - this.lastAttack.getTime()) < attackRate.getTime()){
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
           this.setTarget(target);
           gameShots.add(new Bullet(this.getCoordinate(), this, this.targetInvader, this.shootPower));
           return true;
        }
    }
}
