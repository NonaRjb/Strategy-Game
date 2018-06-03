import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.text.StyledEditorKit;
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
    private boolean isFighting;
    //private Boolean isBoomed;

    //constructor
    Hero(Coordinate init_coordinate, int xpCnt){
        coordinate = init_coordinate;
        level = 1;
        attackRate = new Time((maxLevel+1-level) * attackConst);
        lastAttack = new Time(0);
        shootPower = level * shootConst;
        healthLevel = new HealthLevel(1); //Hero's health unit is one
        delayConst = 10; //Just to be here! should be changed
        speedLevel = 1; // High Speed
        range = 4; // High Range
        this.xpCnt = xpCnt;
        numberOfKillings = 0;
        deathNum = 0;
        isIdle = false;
        idleStartTime = new Time(0);
    }

    //setter & getters

    public void setNumberOfKillings(int numberOfKillings) {
        this.numberOfKillings = numberOfKillings;
    }

    public void setStopped(boolean stopped) {
        isStopped = stopped;
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

    public boolean isStopped() {
        return isStopped;
    }

    public void setTarget(Invader invader){ this.targetInvader = invader; }

    public void setLastAttack(Time currentTime){ this.lastAttack = currentTime; }

    public void setIdle(Time currentTime){
        this.isIdle = true;
        this.idleStartTime = currentTime;
    }

    public boolean checkIdle(Time currentTime){
       if ((currentTime.getTime() - this.idleStartTime.getTime()) > delayConst){
           this.isIdle = false;
           return false;
       }
       else {
           return true;
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

    //ToDo go after Invader! --> Done
    public void goAfterInvader(Invader invader, Coordinate coordinate){
        this.isFighting = true;
        this.targetInvader = invader;
        this.moveTo(coordinate);
    }

    public void moveTo(Coordinate coordinate){

        this.coordinate = coordinate;
    }

    @Override
    public void showDetail() {
        System.out.println("Hero:");
        System.out.println("Level: " + level);
        System.out.println("Health Level: " + healthLevel.getHealthLevel());
        System.out.println("XP count: " + xpCnt);
        System.out.println("Delay after getting killed: " + delayConst);
        System.out.println("Number of killed ivaders by Hero: " + numberOfKillings);
        System.out.println("Number of times that hero has been killed: " + deathNum);
        System.out.println("Current Coordinate: " + this.coordinate.getX() + "," + this.coordinate.getY());
        // Speed and range are assumed to be constant
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
           gameShots.add(new Bullet(this.getCoordinate(), this.targetInvader, this.shootPower));
           return true;
        }
    }
}
