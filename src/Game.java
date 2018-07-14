import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Game {
    private PlayGround playGround;
    private ArrayList<Armory> armories;
    private ArrayList<Invader> invaders;
    private ArrayList<Shot> gameShots;/////////////////////
    private ArrayList<Soldier> soldiers;///////////////////
    private Hero hero;
    private Time gameTime;
    private Time invaderRate;
    private Time lastInvaderTime;
    private final int placeHolderNum = 8;
    private final int boomerStopConst = 10;
    static Time burningTimeConst = new Time(10);
    private int thisRoundNumberOfInvaders;
    static Price property;
    private boolean gameSoldierIsUsed;
    private boolean interventionUsed;
    private int remainedTeslas;
    private final int teslaRange = 20;
    private int invaderCounter = 1;
    private static boolean loser = false;
    private ArrayList<Shot> removedShots;
    private ArrayList<Invader> removedInvaders;

    // Constructor
    public Game() {
        this.playGround = PlayGround.getInstance();
        this.armories = new ArrayList<>();
        this.invaders = new ArrayList<>();
        this.soldiers = new ArrayList<>();
        this.gameShots = new ArrayList<>();
        this.gameTime = new Time(0);
        this.invaderRate = new Time(2);
        this.lastInvaderTime = new Time(0);
        this.hero = new Hero( new Coordinate(430,1500) );
        this.property = new Price(100);
        this.gameSoldierIsUsed = false;
        this.interventionUsed = false;
        this.remainedTeslas = 3;
    }

    // Getters
    public ArrayList<Armory> getArmories() {
        return this.armories;
    }
    public int getThisRoundNnumberOfInvaders() {
        return thisRoundNumberOfInvaders;
    }
    public Time getGameTime() {
        return gameTime;
    }

    // Setters
    public void setInvaderRate(Time invaderRate) {
        this.invaderRate = invaderRate;
    }
    public void setThisRoundNumberOfInvaders(int thisRoundNumberOfInvaders) {
        this.thisRoundNumberOfInvaders = thisRoundNumberOfInvaders;
        this.invaderCounter = 1;
    }


    // Other Methods
    ////////////////////////////////////////////////////////////////////////////////////////////
    public String createArmory(String armoryType, int id) {

        String s="";

        if( armoryType.equals("Barracks") ) {

            if( playGround.getPlaceHolder(id).getOwner() != null ){
                s=("Place ID "+id+" is Full!");
            } else {
                Barracks barracks = new Barracks(id, playGround.getPlaceHolder(id).getPlaceCoordinate(), soldiers);
                if( property.getPrice() > barracks.getPrice().getPrice() ) {
                    property.decreasePrice( barracks.getPrice() );
                    this.armories.add(barracks);
                    ArrayList<Soldier> barracksSoldiers = barracks.getBarracksSoldiers();
                    for (int i = 0; i < barracksSoldiers.size(); i++) {
                        soldiers.add(barracksSoldiers.get(i));
                        System.out.println(barracksSoldiers.get(i).getCoordinate().getX() + "," + barracksSoldiers.get(i).getCoordinate().getY());
                    }
                    this.playGround.getPlaceHolder(id).setOwner(this.armories.get(this.armories.size() - 1));
                    s="Barracks Built Successfully"+"\n";
                } else {
                    s="Not Enough Coins!"+"\n";
                }
            }

        } else if( armoryType.equals("Freezer") ){

            if( playGround.getPlaceHolder(id).getOwner() != null ){
                s=("Place ID "+id+" is Full!");
            } else {
                Freezer freezer = new Freezer(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                if(  property.getPrice() > freezer.getPrice().getPrice() ) {
                    property.decreasePrice( freezer.getPrice() );
                    this.armories.add(freezer);
                    this.playGround.getPlaceHolder(id).setOwner(this.armories.get(this.armories.size() - 1));
                    s="Freezer Built Successfully";
                } else {
                    s="Not Enough Coins!";
                }
            }

        } else if (armoryType.equals("MachineGun")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                    s=("Place ID "+id+" is Full!");
                } else {
                    MachineGun machineGun = new MachineGun(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                    if( property.getPrice() > machineGun.getPrice().getPrice() ) {
                        property.decreasePrice( machineGun.getPrice() );
                        this.armories.add(machineGun);
                        this.playGround.getPlaceHolder(id).setOwner(this.armories.get(this.armories.size() - 1));
                        s="MachineGun Built Successfully";
                    } else {
                        s="Not Enough Coins!";
                    }
                }

        } else if (armoryType.equals("Laser")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        s=("Place ID "+id+" is Full!");
                } else {
                        Laser laser = new Laser(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                        if( property.getPrice() > laser.getPrice().getPrice() ) {
                            property.decreasePrice( laser.getPrice() );
                            this.armories.add(laser);
                            this.playGround.getPlaceHolder(id).setOwner(this.armories.get(this.armories.size() - 1));
                            s="Laser Built Successfully";
                        } else {
                            s="Not Enough Coins!";
                        }
                }

        } else if (armoryType.equals("Rocket")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        s=("Place ID "+id+" is Full!");
                } else {
                    Rocket rocket = new Rocket(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                    if( property.getPrice() > rocket.getPrice().getPrice() ) {
                        property.decreasePrice( rocket.getPrice() );
                        this.armories.add(rocket);
                        this.playGround.getPlaceHolder(id).setOwner(this.armories.get(this.armories.size() - 1));
                        s="Rocket Built Successfully";
                    } else {
                        s="Not Enough Coins!";
                    }
                }

        } else if (armoryType.equals("Excalibur")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        s=("Place ID "+id+" is Full!");
                } else {
                        Excalibur excalibur = new Excalibur(id, playGround.getPlaceHolder(id).getPlaceCoordinate(), this.gameTime);
                        if( property.getPrice() > excalibur.getPrice().getPrice() ) {
                            property.decreasePrice( excalibur.getPrice() );
                            this.armories.add(excalibur);
                            this.playGround.getPlaceHolder(id).setOwner(this.armories.get(this.armories.size() - 1));
                            s="Excalibur Built Successfully";
                        } else {
                            s="Not Enough Coins!";
                        }
                }

        } else if (armoryType.equals("Beehive")){

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        s=("Place ID "+id+" is Full!");
                } else {
                    Beehive beehive = new Beehive(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                    if( property.getPrice() > beehive.getPrice().getPrice() ){
                        property.decreasePrice( beehive.getPrice() );
                        this.armories.add(beehive);
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                        s="Beehive Built Successfully";
                    } else {
                        s="Not Enough Coins!";
                    }
                }

        } else if (armoryType.equals("Hellgate")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        s=("Place ID "+id+" is Full!");
                } else {
                        Hellgate hellgate = new Hellgate(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                        if( property.getPrice() > hellgate.getPrice().getPrice() ){
                            property.decreasePrice( hellgate.getPrice() );
                            this.armories.add(hellgate);
                            this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                            s="Hellgate Built Successfully";
                        } else {
                            s="Not Enough Coins!";
                        }
                }

        } else if (armoryType.equals("Sauron")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        s=("Place ID "+id+" is Full!");
                } else {
                        Sauron sauron = new Sauron(id, playGround.getPlaceHolder(id).getPlaceCoordinate());
                        if( property.getPrice() > sauron.getPrice().getPrice() ){
                            property.decreasePrice( sauron.getPrice() );
                            this.armories.add(sauron);
                            this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                            s="Sauron Built Successfully";
                        } else {
                            s="Not Enough Coins!";
                        }
                }

        }
        return s;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String setArmoryTargetPriority(int id, TargetPriority targetPriority){
        String s="";
        if (id == PlayGround.numberOfPlaces){
            for (Armory armory : armories){
                s=s+armory.setTargetPriority(targetPriority)+"\n";
            }
        }else {
            for (Armory armory : armories){
                if (armory.getId() == id){
                    s=s+armory.setTargetPriority(targetPriority)+"\n";
                    break;
                }
            }
        }
        return s;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String increaseTime(){
        String s="";
        //Todo check frozen, Stop, Idle and etc. --> needs to be rechecked
        for( Invader invader : invaders ){
            invader.clearTarget();
            invader.checkFrozen(gameTime);
        }
        for( Armory armory: armories ){
            if( armory instanceof Barracks )
                s=s+((Barracks)armory).reviveSoldiers( gameTime, soldiers );
        }
        hero.checkIdle(gameTime);
        hero.checkStopped(boomerStopConst, gameTime);
        this.moveObjects();
        s=s+this.botherBurnings()+"\n";
        this.botherToxicants();
        //this.botherBurnings();
        //this.botherToxicants();
        this.refreshFrozenArmories();
        s=s+this.doAttacks();
        this.moveObjects();
        this.gameTime.increaseTime();
        this.invaderMaker();
        return s;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Moving all Objects
    public void moveObjects(){

        //move Soldier and Hero with direct command from the player

        removedInvaders = new ArrayList<>();
        for (Invader invader: invaders ) {
            this.moveInvader(invader );
        }
        invaders.removeAll( removedInvaders );

        /*for( Soldier soldier: soldiers){
            this.moveSoldier( soldier );
        }

        this.moveHero( this.hero );*/

        for( Shot shot: gameShots ){
            this.moveShot( shot );
        }


    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets invader's coordinate
    private void moveInvader( Invader invader ) {

        int currentSpeed;
        final int freezeConst = 1;
        // if the invader faces hero or soldiers it stops to fight
        if ((Coordinate.distance(invader.getCoordinate(), hero.getCoordinate()) <= invader.getRange())
                && !(invader instanceof Sparrow) && !(invader instanceof HockeyMaskMan)){
            invader.setFighting(true);
        }
        else {
            for (Soldier soldier : soldiers) {
                if ((Coordinate.distance(invader.getCoordinate(), soldier.getCoordinate()) <= soldier.getRange())
                        && !(invader instanceof Miner) && !(invader instanceof Sparrow) && !(invader instanceof HockeyMaskMan)) {
                    invader.setFighting(true);
                }
            }
        }
        if (!invader.isFighting()) {
            if (invader.getFrozen()) {
                currentSpeed = invader.getMovementSpeed() - freezeConst;
            } else {
                currentSpeed = invader.getMovementSpeed();
            }
            Coordinate nextCoordinate;
            for (int i = 1; i <= currentSpeed; i++) {
                nextCoordinate = playGround.nextCoordinate(invader.getCoordinate() , invader.getPathID());
                invader.setCoordinate(nextCoordinate);
                if (nextCoordinate.getX() == 450 && nextCoordinate.getY() == 1599){
                    //invaders.remove(invader);  //concurrent solved
                    removedInvaders.add(invader);
                    invaderCounter--;
                    if(invaderCounter == 0){
                        loser = true;
                    }
                }
            }
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets soldier's coordinate
    public String moveSoldier( int barracksID, int soldierId, Coordinate coordinate){
        String s="";
        boolean flag = false;
        if( barracksID==PlayGround.numberOfPlaces ){
            for (Soldier soldier : soldiers) {
                if (soldier.getBarracksOwner() == null && soldier.getSoldierID() == soldierId) {
                    s=s+goSoldier(soldier, coordinate);
                    flag = true;
                }
            }
        } else {
            for (Soldier soldier : soldiers) {
                if (soldier.getBarracksOwner().getId() == barracksID && soldier.getSoldierID() == soldierId) {
                    s=s+goSoldier(soldier, coordinate);
                    flag = true;
                }
            }
        }
        if( !flag ){
            s=s+("No Soldier With this Features")+"\n";
        }
        return s;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private String goSoldier( Soldier soldier, Coordinate coordinate){
        String s="";
        //if (playGround.isInWay(coordinate)){
            soldier.moveGame(coordinate);
       // }
        //else {
        //    s=("Moving to the this coordinate is not allowed")+"\n";
       // }
        return s;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets hero's coordinate
    public void moveHero(Coordinate coordinate){
        hero.moveTo(coordinate);
        /*if (playGround.isInWay(coordinate)){
            hero.moveTo(coordinate);
        }
        else {
            System.out.println("Moving to the this coordinate is not allowed");
        }*/
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets Shot's coordinate
    private void moveShot( Shot shot ){

        Coordinate currentCoordinate = shot.getCoordinate();
        Object targetObject = shot.getTarget();
        if( shot instanceof Bullet || shot instanceof Ice ){
            if( targetObject instanceof Invader ) {
                Invader target = (Invader) targetObject;
                Coordinate finalCoordinate = target.getCoordinate();
                shot.setCoordinate( Coordinate.moveTo( currentCoordinate, finalCoordinate, shot.getBulletSpeed() ) );
                //System.out.println(shot.getCoordinate().getX()+","+shot.getCoordinate().getY());//TODO
            }
            else if ( targetObject instanceof Soldier ) {
                Soldier target = (Soldier) targetObject;
                Coordinate finalCoordinate = target.getCoordinate();
                shot.setCoordinate( Coordinate.moveTo( currentCoordinate, finalCoordinate, shot.getBulletSpeed() ) );
            }
            else if ( targetObject instanceof Hero ) {
                Hero target = (Hero) targetObject;
                Coordinate finalCoordinate = target.getCoordinate();
                shot.setCoordinate( Coordinate.moveTo( currentCoordinate, finalCoordinate, shot.getBulletSpeed() ) );
            }
        } else if( shot instanceof LaserShot ) {
            /*if( Coordinate.distance( shot.getCoordinate(), ((Invader)shot.getTarget()).getCoordinate() ) > ((LaserShot) shot).getOwner().range ){
                ((LaserShot)shot).getOwner().endAttack();
                gameShots.remove( shot );
            }*/
        } else if( shot instanceof Fire || shot instanceof Poison || shot instanceof RocketShot ){
            // Nothing to do :))
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String showArmoriesDetails(){
        String details="";
        for( Armory currentArmory : this.armories ){
            details = details + currentArmory.showDetail();
        }
        return details;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void invaderMaker(){
        if( thisRoundNumberOfInvaders > 0 ) {
            //System.out.println(this.gameTime.getTime() - this.lastInvaderTime.getTime());//done: lastInvaderTime = gameTime a great class mistake!
            if (this.gameTime.getTime() - this.lastInvaderTime.getTime() >= this.invaderRate.getTime()) {
                this.produceInvader();
                thisRoundNumberOfInvaders--;
                this.lastInvaderTime.setTime( this.gameTime.getTime() );
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private void produceInvader(){
        Invader newInvader;
        Random rand = new Random();
        int enemyKindNumber= rand.nextInt( Invader.numberOfInvaderKinds );
        Coordinate invaderEnteringCoordinate = playGround.randomOriginMaker();
        int pathId = 0;
        int cnt = 0;
        for (Coordinate coordinate : playGround.getPathOriginCoordinate()){
            if(coordinate.getX() == invaderEnteringCoordinate.getX() && coordinate.getY() == invaderEnteringCoordinate.getY()){
                pathId = cnt;
                break;
            }
            cnt++;
        }
        switch( enemyKindNumber ){
            case 0:
                newInvader = new Henchman( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 1:
                newInvader = new Skipper( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 2:
                newInvader = new Bane( thisRoundNumberOfInvaders ,invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 3:
                newInvader = new Sparrow( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 4:
                newInvader = new Boomer( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 5:
                newInvader = new Healer( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 6:
                newInvader = new Motivator( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 7:
                newInvader = new Icer( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 8:
                newInvader = new Miner( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 9:
                newInvader = new Smelly( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 10:
                newInvader = new Hopper( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 11:
                newInvader = new ExG( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            case 12:
                newInvader = new HockeyMaskMan( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                newInvader.setPathID(pathId);
                break;
            default:
                newInvader = null;
        }

        invaders.add( newInvader );

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String showInvadersDetails(){
        String details="";
        for( Invader currentInvader : this.invaders ){
            details = details + currentInvader.showDetail();
        }
        return details;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String showHeroDetails(){
        return hero.showDetail();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String showSoldiersDetails(){
        String details = "";
        for ( Soldier soldier : soldiers){
            details = details + soldier.showDetail();
        }
        return details;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public String showSlotsDetails(){
        String details="";
        for (PlaceHolder placeHolder : playGround.getPlaceHolder()){
            details = details + placeHolder.showDetail();
        }
        return details;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public String doAttacks(){

        String s="";
        this.removedShots = new ArrayList<>();

        for( Shot shot: gameShots ){
            s=s+effectShot( shot )+"\n"; //concurrent modification solved
        }
        this.gameShots.removeAll( this.removedShots );

        for( Armory armory : armories ){
            armoryAttackGame( armory );
        }

        for( Invader invader : invaders ){
            invaderAttackGame( invader );
        }

        heroAttackGame();

        for (Soldier soldier : soldiers){
            soldierAttackGame(soldier);
        }
        return s;

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Armory Attack
    private void armoryAttackGame( Armory armory ){

        ArrayList<Invader> invadersInRange = findInvaders( armory.getCoordinate(), armory.getRange(), armory.getTargetPriority() );

        // If Miner is in invadersInRange it should be removed because it cannot be seen by anybody except hero
        if(invadersInRange != null) {
            //System.out.println(invadersInRange.get(0).instanceNum);
            ArrayList<Invader> removedMiners = new ArrayList<>();
            for (Invader invader : invadersInRange) {
                if (invader instanceof Miner) {
                    //invadersInRange.remove(invader); //concurrent modification solved
                    removedMiners.add(invader);
                }
            }
            invadersInRange.removeAll( removedMiners );
        }
        //

        Invader targetInvader = null;
        if( invadersInRange != null ) {
            if (armory.getTargetPriority() == TargetPriority.SpecificTarget && invadersInRange.contains(armory.getSpecificTargetInvader()))
                targetInvader = armory.getSpecificTargetInvader();
            else {
                if (invadersInRange.size() > 0)
                    targetInvader = invadersInRange.get(0);
            }
        } else {
            targetInvader = null;
        }

        //TODO: Recheck Laser Stop
        if( !armory.isStopped() ) {
            if (armory instanceof Freezer) {
                Freezer currentFreezer = (Freezer) armory;
                if (targetInvader != null) {
                    Shot attackShot = currentFreezer.attack(this.gameTime, targetInvader);
                    if( attackShot != null )
                        this.gameShots.add(attackShot);
                }
            } else if (armory instanceof Hellgate) {
                Hellgate currentHellgate = (Hellgate) armory;
                if (!currentHellgate.isBurning()) {
                    if (targetInvader != null) {
                        Shot attackShot = currentHellgate.attack(null, null);
                        if( attackShot != null )
                            this.gameShots.add( attackShot );
                        currentHellgate.setBurning(true);
                    }
                }
            } else if (armory instanceof MachineGun) {
                MachineGun currentMachineGun = (MachineGun) armory;
                if (targetInvader != null) {
                    //System.out.println(targetInvader.instanceNum);
                    Shot attackShot = currentMachineGun.attack(this.gameTime, targetInvader);
                    if( attackShot != null )
                        this.gameShots.add(attackShot);
                    //currentMachineGun.attack(this.gameTime, targetInvader, gameShots);//solved: bad gameShot!
                    //System.out.println(gameShots.size());
                }
            } else if (armory instanceof Laser) {
                Laser currentLaser = (Laser) armory;
                if (targetInvader != null) {
                    if (!currentLaser.isOnAttack()) {
                        Shot attackShot = currentLaser.attack(this.gameTime, targetInvader);
                        if( attackShot != null )
                            this.gameShots.add(attackShot);
                    } else {
                        if (currentLaser.getSpecificTargetInvader() != targetInvader) {
                            gameShots.remove(currentLaser.getAttackingLaserShot());
                            Shot attackShot = currentLaser.attack(this.gameTime, targetInvader);
                            if( attackShot != null )
                                this.gameShots.add(attackShot);
                        }
                    }
                } else {
                    if (currentLaser.isOnAttack()) {
                        gameShots.remove(currentLaser.getAttackingLaserShot());
                        currentLaser.endAttack();
                    }
                }
            } else if (armory instanceof Rocket) {
                Rocket currentRocket = (Rocket) armory;
                if (targetInvader != null) {
                    Shot attackShot = currentRocket.attack(this.gameTime, null);
                    if( attackShot != null ) {
                        this.gameShots.add(attackShot);
                        //System.out.println("onja");
                    }
                }
            } else if (armory instanceof Excalibur) {
                Excalibur currentExcalibur = (Excalibur) armory;
                if (targetInvader != null) {
                    Shot attackShot = currentExcalibur.attack(this.gameTime, targetInvader);
                    if( attackShot != null )
                        this.gameShots.add(attackShot);
                }
            } else if (armory instanceof Beehive) {
                Beehive currentBeehive = (Beehive) armory;
                if (targetInvader != null) {
                    Shot attackShot = currentBeehive.attack(this.gameTime, targetInvader);
                    if( attackShot != null )
                        this.gameShots.add(attackShot);
                }
            } else if (armory instanceof Sauron) {
                Sauron currentSauron = (Sauron) armory;
                if (targetInvader != null) {
                    Shot attackShot = currentSauron.attack(this.gameTime, targetInvader);
                    if( attackShot != null )
                        this.gameShots.add(attackShot);
                }
            }
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<Invader> findInvaders( Coordinate origin, int range, TargetPriority priority ){

        ArrayList<Invader> invadersInRange = new ArrayList<>();

        for( Invader invader: invaders ){
            if ( Coordinate.distance( invader.getCoordinate(), origin ) <= range )
                invadersInRange.add( invader );
        }

        if( invadersInRange.size() == 0 )
            return null;
        else{

            if( priority == TargetPriority.MinimumHealth ) {

                Invader targetInvader = invadersInRange.get(0);
                int minHealth = invadersInRange.get(0).healthDegree.getHealthLevel();
                for (Invader invader : invadersInRange) {
                    if (invader.healthDegree.getHealthLevel() < minHealth) {
                        minHealth = invader.healthDegree.getHealthLevel();
                        targetInvader = invader;
                    }
                }
                invadersInRange.clear();
                invadersInRange.add( targetInvader );
                return invadersInRange;

            } else if ( priority == TargetPriority.MaximumHealth ){

                Invader targetInvader = invadersInRange.get(0);
                int maxHealth = invadersInRange.get(0).healthDegree.getHealthLevel();
                for (Invader invader : invadersInRange) {
                    if (invader.healthDegree.getHealthLevel() > maxHealth) {
                        maxHealth = invader.healthDegree.getHealthLevel();
                        targetInvader = invader;
                    }
                }
                invadersInRange.clear();
                invadersInRange.add( targetInvader );
                return invadersInRange;

            } else if ( priority == TargetPriority.Nearest ){

                Invader targetInvader = invadersInRange.get(0);
                int distance = Coordinate.distance( invadersInRange.get(0).getCoordinate(), origin ) ;
                for (Invader invader : invadersInRange) {
                    if ( Coordinate.distance( invader.getCoordinate(), origin ) < distance) {
                        distance = Coordinate.distance( invader.getCoordinate(), origin );
                        targetInvader = invader;
                    }
                }
                invadersInRange.clear();
                invadersInRange.add( targetInvader );
                return invadersInRange;

            } else if ( priority == TargetPriority.AllInRange ){
                return invadersInRange;
            } else {
                return null;
            }

        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /// Invader Attack
    private void invaderAttackGame( Invader invader ){
        boolean isBoomer = false;
        if(invader instanceof Henchman || invader instanceof Skipper || invader instanceof Bane
                || invader instanceof Sparrow || invader instanceof Miner || invader instanceof Smelly || invader instanceof Hopper){
            ArrayList<Object> targets = new ArrayList<>();
            for (Soldier soldier : soldiers){
                    if ( Coordinate.distance( invader.getCoordinate(), soldier.getCoordinate() ) <= invader.getRange()) {
                        targets.add(soldier);
                }
            }
            if(hero!=null){
                if ( Coordinate.distance( invader.getCoordinate(), hero.getCoordinate() ) <= invader.getRange()) {
                    targets.add(hero);
                }
            }
            if (targets.size() != 0) {
                ArrayList<Shot> shots = new ArrayList<>();
                shots = invader.attack(gameTime, gameShots, targets);
                for (Shot shot : shots){
                    gameShots.add(shot);
                }
            }
        }
        if (invader instanceof ExG){
            ArrayList<Object> targets = new ArrayList<>();
            if( hero != null ) {
                if ( Coordinate.distance( invader.getCoordinate(), hero.getCoordinate() ) <= invader.getRange()) {
                    targets.add(hero);
                    ArrayList<Shot> shots = new ArrayList<>();
                    shots = invader.attack(gameTime, gameShots, targets);
                    for (Shot shot : shots){
                        gameShots.add(shot);
                    }
                }
            }
        }
        if (invader instanceof Icer || invader instanceof HockeyMaskMan){
            ArrayList<Object> targets = new ArrayList<>();
            for (Armory armory : armories){
                if ( Coordinate.distance( invader.getCoordinate(), armory.getCoordinate() ) <= invader.getRange()) {
                    targets.add(armory);
                }
            }
            if (targets.size() != 0) {
                ArrayList<Shot> shots = new ArrayList<>();
                shots = invader.attack(gameTime, gameShots, targets);
                for (Shot shot : shots){
                    gameShots.add(shot);
                }
            }
        }
        if(invader instanceof Healer || invader instanceof Motivator){
            ArrayList<Object> targets = new ArrayList<>();
            for (Invader invader1 : invaders){
                if (invaders.indexOf(invader) != invaders.indexOf(invader1)) {
                    if ( Coordinate.distance( invader.getCoordinate(), invader1.getCoordinate() ) <= invader.getRange()) {
                        targets.add(invader1);
                    }
                }
            }
            if (targets.size() != 0) {
                ArrayList<Shot> shots = new ArrayList<>();
                shots = invader.attack(gameTime, gameShots, targets);
                for (Shot shot : shots){
                    gameShots.add(shot);
                }
            }
        }
        if(invader instanceof Boomer){
            ArrayList<Object> targets = new ArrayList<>();
            for (Soldier soldier : soldiers){
                if ( Coordinate.distance( invader.getCoordinate(), soldier.getCoordinate() ) <= invader.getRange()) {
                    targets.add(soldier);
                }
            }
            if( hero != null ) {
                if ( Coordinate.distance( invader.getCoordinate(), hero.getCoordinate() ) <= invader.getRange()) {
                    targets.add(hero);
                }
            }
            for (Armory armory : armories){
                if ( Coordinate.distance( invader.getCoordinate(), armory.getCoordinate() ) <= invader.getRange()) {
                    targets.add(armory);
                }
            }
            if (targets.size() != 0) {
                ArrayList<Shot> shots = new ArrayList<>();
                shots = invader.attack(gameTime, gameShots, targets);
                for (Shot shot : shots){
                    gameShots.add(shot);
                }
                //invaders.remove(invader);
                isBoomer = true;
            }
        }
        if (isBoomer)   invaders.remove(invader);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void heroAttackGame(){
        if(hero != null) {
            ArrayList<Invader> targets = new ArrayList<>();
            //Todo is in mission mix with go after Invader
            if (hero.isInMission() == false) {
                targets = findInvaders(hero.getCoordinate(), hero.getRange(), TargetPriority.AllInRange);
                ArrayList<Integer> idxs = new ArrayList<>();
                if (targets != null) {
                    for (Invader invader : targets) {
                        if (invader instanceof Sparrow) {
                            idxs.add(targets.indexOf(invader));
                        }
                    }
                    for (int i = idxs.size()-1; i >= 0; i--){
                        targets.remove(idxs.get(i));
                    }
                }
                if (targets != null) {
                    hero.attack(gameTime, gameShots, targets);
                }
            }else {
                if (hero.getTargetInvader() != null) {
                    targets.add(hero.getTargetInvader());
                    hero.attack(gameTime, gameShots, targets);
                }
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String goAfterInvaderHero(int invaderID){
        String s="";
        boolean invaderFound = false;
        Invader target = null;
        for (Invader invader : invaders){
            if (invader.getInstanceNum() == invaderID){
                invaderFound = true;
                target = invader;
            }
        }
        if (invaderFound) {
            Coordinate nextCoordinate = hero.getCoordinate();
            while (Coordinate.distance(hero.getCoordinate(), target.getCoordinate()) != hero.getRange()) {
                nextCoordinate = playGround.nextCoordinate(target.getCoordinate(), target.getPathID());
            }
            if (nextCoordinate != null) {
                hero.goAfterInvader(target, nextCoordinate);
            }
            s=("Hero is Going After Invader")+"\n";
        }else {
            s=("Invader not found!")+"\n";
        }
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void soldierAttackGame(Soldier soldier){
        ArrayList<Invader> targets = findInvaders(soldier.getCoordinate(), soldier.getRange(), TargetPriority.AllInRange);
        //Todo is in mission mix with go after Invader
        if (targets != null) {
            if (!soldier.isInMission()) {
                for (Invader invader : targets) {
                    if (invader instanceof Sparrow) {
                        targets.remove(invader);
                    }
                }
                if (targets.size() != 0) {
                    soldier.attack(gameTime, gameShots, targets);
                }
            } else {
                if (soldier.getTargetInvader() != null) {
                    targets.add(soldier.getTargetInvader());
                    soldier.attack(gameTime, gameShots, targets);
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String goAfterInvaderSoldier(int soldierId, int barracksId, int invaderId){
        String s="";
        boolean soldierFound = false;
        Soldier targetSoldier = null;
        for (Soldier soldier : soldiers){
            if ((soldier.getBarracksOwner().getId() == barracksId && soldier.getSoldierID() == soldierId)
               || (soldier.getBarracksOwner() == null && soldier.getSoldierID() == soldierId && barracksId == PlayGround.numberOfPlaces)){
                soldierFound = true;
                targetSoldier = soldier;
                break;
            }
        }

        boolean invaderFound = false;
        Invader targetInvader = null;
        if (soldierFound){
            for (Invader invader : invaders){
                if(invader.getInstanceNum() == invaderId){
                    invaderFound = true;
                    targetInvader = invader;
                    break;
                }
            }
            if(invaderFound){
                Coordinate nextCoordinate = targetSoldier.getCoordinate();
                while (Coordinate.distance(targetSoldier.getCoordinate(), targetInvader.getCoordinate()) != targetSoldier.getRange()){
                    nextCoordinate = playGround.nextCoordinate(targetInvader.getCoordinate(), targetInvader.getPathID());
                }
                if(nextCoordinate != null) {
                    if (targetSoldier.getBarracksOwner() != null){
                        if (Coordinate.distance(nextCoordinate, targetSoldier.getBarracksOwner().getCoordinate()) <= targetSoldier.getBarracksOwner().getRange()) {
                            targetSoldier.goAfterInvader(targetInvader, nextCoordinate);
                        }
                    }else {
                        targetSoldier.goAfterInvader(targetInvader, nextCoordinate);
                    }
                }
            } else {
                s=("Invader not found!")+"\n";
            }
        }else {
            s=("Soldier not found!")+"\n";
        }

        return s;

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String effectShot( Shot shot ){

        String s="";
        if( shot instanceof Bullet ){
            Object target = shot.getTarget();
            Bullet currentBullet = (Bullet)shot;
            if( target instanceof Invader ) {
                Invader targetInvader = (Invader)target;
                if( shot.getCoordinate().isEqual( targetInvader.getCoordinate() ) ){
                    if( targetInvader.getHealthDegree().getHealthLevel() <= shot.getPower() ){
                        s = ("Invader got killed !");
                        removedShots.addAll( cleanShots( targetInvader ) );
                        invaders.remove( targetInvader );
                        if( currentBullet.getOwner() instanceof Hero ){
                            hero.setInMission(false);
                            hero.addNumberOfKillings();
                            hero.addXP(10);
                        } else if( currentBullet.getOwner() instanceof Soldier ){
                            ((Soldier)currentBullet.getOwner()).addNumberOfKillings();
                            ((Soldier)currentBullet.getOwner()).setInMission(false);
                        }
                    } else {
                        targetInvader.getHealthDegree().decreaseHealth( shot.getPower() );
                    }
                    //gameShots.remove( shot );
                    this.removedShots.add( shot );
                    this.property.increasePrice(new Price(10));
                }
            } else if (target instanceof Soldier){
                Soldier targetSoldier = (Soldier) target;
                if(shot.getCoordinate().isEqual(targetSoldier.getCoordinate())){
                    if (targetSoldier.getHealth().getHealthLevel() <= shot.getPower()){
                        s=("Soldier got killed!")+"\n";
                        targetSoldier.getBarracksOwner().removeSoldier( targetSoldier.getSoldierID(), gameTime );
                        soldiers.remove(targetSoldier);
                        if( currentBullet.getOwner() instanceof Invader ){
                            ((Invader)currentBullet.getOwner()).addNumberOfKillings();
                        }
                    } else {
                        targetSoldier.getHealth().decreaseHealth(shot.getPower());
                    }
                    //gameShots.remove( shot );
                    this.removedShots.add( shot );
                }
            } else if (target instanceof Hero){
                Hero targetHero = (Hero) target;
                if (shot.getCoordinate().isEqual(targetHero.getCoordinate())) {
                    if (targetHero.getHealthLevel().getHealthLevel() <= shot.getPower()){
                        s=("Hero will be idle for " + hero.getDelayConst() + " seconds")+"\n";
                        hero.addDeathNum();
                        hero.setIdle(gameTime);
                        if( currentBullet.getOwner() instanceof Invader ){
                            ((Invader)currentBullet.getOwner()).addNumberOfHeroKill();
                        }
                    }
                    //gameShots.remove( shot );
                    this.removedShots.add( shot );
                }
            }
            if (target instanceof Armory){
                Armory targetArmory = (Armory) target;
                if (shot.getCoordinate().isEqual(targetArmory.getCoordinate())){
                    if (targetArmory.getHealthDegree().getHealthLevel() <= shot.getPower()){
                        s=("The Armory got ruined! Place " + targetArmory.getId() + " is now empty!")+"\n";
                        playGround.getPlaceHolder(targetArmory.getId()).setOwner(null);
                        armories.remove(targetArmory);
                    }
                    this.removedShots.add( shot );
                }
                //this.removedShots.add( shot );
            }
        }
        else if( shot instanceof Ice ){
            Object target = shot.getTarget();
            if( target instanceof Invader ) {
                Invader targetInvader = (Invader)target;
                if( shot.getCoordinate().isEqual( targetInvader.getCoordinate() ) ){
                    s=("The Invader got Frozen!")+"\n";
                    targetInvader.setFrozen( true , shot.getPower(), gameTime);
                    //gameShots.remove( shot );
                    this.removedShots.add( shot );
                }
            } else if (target instanceof Armory) {
                Armory targetArmory = (Armory) target;
                if (shot.getCoordinate().isEqual(targetArmory.getCoordinate())) {
                    s=("The Armory got Frozen!")+"\n";
                    targetArmory.setStopped(true, shot.getPower(), gameTime);
                    //gameShots.remove( shot );
                    this.removedShots.add( shot );
                }
            }
        } else if( shot instanceof Fire ){
            ArrayList<Invader> burningInvaders = findInvaders( shot.getCoordinate(), ((Fire) shot).getRange(), TargetPriority.AllInRange );
            if( burningInvaders == null ){
                ((Fire)shot).getOwner().setBurning( false );
                //gameShots.remove( shot );
                this.removedShots.add( shot );
            } else {
                for (Invader invader : burningInvaders) {
                    invader.setBurning(true);
                }
            }
        } else if( shot instanceof Poison ){
            ArrayList<Invader> poisonedInvaders = findInvaders( shot.getCoordinate(), ((Poison) shot).getRange(), TargetPriority.AllInRange );
            if( poisonedInvaders != null ) {
                for (Invader invader : poisonedInvaders) {
                    invader.setPoisoned(true);
                }
            }
            //gameShots.remove( shot );
            this.removedShots.add( shot );
        } else if( shot instanceof RocketShot ){
            //System.out.println("Inja");
            ArrayList<Invader> shootedInvaders = findInvaders( shot.getCoordinate(), ((RocketShot) shot).getRange(), TargetPriority.AllInRange );
            if( shootedInvaders != null ) {
                for (Invader invader : shootedInvaders) {
                    if (invader.getHealthDegree().getHealthLevel() <= shot.getPower()) {
                        s = ("Invader got killed !") + "\n";
                        removedShots.addAll(cleanShots(invader));
                        invaders.remove(invader);
                    } else {
                        invader.getHealthDegree().decreaseHealth(shot.getPower());
                    }
                    //gameShots.remove( shot );
                    //this.removedShots.add(shot);
                }
                //this.removedShots.add(shot);
            }
            this.removedShots.add(shot);
        } else if( shot instanceof LaserShot ) {
            Invader targetInvader = (Invader) shot.getTarget();
            if( targetInvader.getHealthDegree().getHealthLevel() <= shot.getPower() ){
                s=("Invader got killed !")+"\n";
                this.removedShots.addAll( cleanShots( targetInvader ) );
                invaders.remove( targetInvader );
                ((LaserShot)shot).getOwner().endAttack();
                //gameShots.remove( shot );
                this.removedShots.add( shot );

            } else {
                targetInvader.getHealthDegree().decreaseHealth( shot.getPower() );
            }
        }
        return s;

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<Shot> cleanShots( Invader invader ){
        ArrayList<Shot> removedShots = new ArrayList<>();
        for( Shot shot : gameShots ){
            if( shot.getTarget() instanceof Invader ){
                Invader targetInvader = (Invader)shot.getTarget();
                if( targetInvader.equals(invader) ){
                    removedShots.add( shot );
                }
            }
        }
        return removedShots;
        //gameShots.removeAll( removedShots );
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String botherBurnings(){
        String s="";
        ArrayList<Invader> removedInvaders = new ArrayList<>();
        for( Invader invader: invaders ){
            if( invader.isBurning() ){
                if( invader instanceof Icer ){
                    s=("Icer got Burned !")+"\n";
                    gameShots.removeAll( cleanShots( invader ) );
                    removedInvaders.add( invader );
                    //invaders.remove(invader); //Concurrent exception solved
                } else {
                    invader.decreaseBurningTime();
                }
            }
        }
        invaders.removeAll( removedInvaders );
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void botherToxicants(){
        for( Invader invader: invaders ){
            if( invader.isPoisoned() ){
                invader.getHealthDegree().decreaseHealth( Poison.healthDecreasingPower );
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String upgradeArmory(int id){
        for( Armory armory: armories ){
            if( armory.getId() == id )
                //return ( armory.levelUp(property) );
                return ( armory.levelUp() );
        }
        return "No such Armory";
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String sellArmory(int id){
        String s="";
        for( Armory armory: armories ){
            if( armory.getId() == id ) {
                property.increasePrice( armory.getPrice() );
                this.playGround.getPlaceHolder(id).setOwner(null);
                s=("Armory id: "+id+" got sold")+"\n";
                if( armory instanceof Barracks ){
                    for( Soldier soldier: soldiers  ){
                        if( soldier.getBarracksOwner().getId() == id )
                            soldiers.remove(soldier);
                    }
                }
                armories.remove(armory);
            }
        }
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String setTargetForArmory( int armoryID, int invaderID ) {

        String s="";
        Armory whichArmory = null;
        Invader targetInvader = null;
        boolean armoryFounded = false;
        for( Armory armory: armories ){
            if( armory.getId() == armoryID ) {
                whichArmory = armory;
                armoryFounded = true;
            }
        }

        if( armoryFounded ){
            boolean invaderFounded = false;
            for( Invader invader: invaders ){
                if( invader.getInstanceNum()==invaderID ){
                    targetInvader = invader;
                    invaderFounded = true;
                }
            }
            if( invaderFounded ){
                s=s+whichArmory.setTargetPriority(TargetPriority.SpecificTarget)+"\n";
                whichArmory.setSpecificTargetInvader( targetInvader );
            } else {
                s=("No Such Invader in Game")+"\n";
            }
        } else {
            s=("No Such Armory in Game")+"\n";
        }

        return s;

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void refreshFrozenArmories(){
        for( Armory armory : armories ){
            if( armory.isStopped() ){
                armory.checkStopped( gameTime );
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String useTesla( Coordinate originCoordinate ){
        String s="";
        if( this.remainedTeslas > 0 ){
            ArrayList<Invader> targetInvaders = findInvaders( originCoordinate, this.teslaRange, TargetPriority.AllInRange );
            for( Invader invader : targetInvaders ) {

                gameShots.removeAll( cleanShots( invader ) );
                invaders.remove( invader );
                for( Armory armory : armories ){
                    if( armory.specificTargetInvader.equals( invader ) ){
                        s=s+armory.setTargetPriority( TargetPriority.MinimumHealth )+"\n";
                        armory.specificTargetInvader = null;
                    }
                }
                if( hero.getTargetInvader().equals( invader ) ){
                    hero.setTarget( null );
                    hero.setInMission( false );
                }
                for( Soldier soldier : soldiers ){
                    if( soldier.getTargetInvader().equals( invader ) ){
                        soldier.setTargetInvader( null );
                        soldier.setInMission( false );
                    }
                }

            }
            this.remainedTeslas--;
        } else {
            s=("You Don't have Tesla")+"\n";
        }
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String interventionKillAll(){
        String s="";
        if( !this.interventionUsed ){
            hero.setInMission(false);
            for( Soldier soldier : soldiers ){
                soldier.setInMission(false);
            }
            for( Armory armory : armories ){
                armory.setSpecificTargetInvader( null );
                s=s+armory.setTargetPriority(TargetPriority.MinimumHealth)+"\n";
            }
            gameShots.clear();
            invaders.clear();
            this.interventionUsed = true;
            s=("Ha Ha Ha !!! :)))")+"\n";
        } else
            s=("You have used Intervention!")+"\n";

        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String makeGameSoldiers(){
        String s="";
        if( !this.gameSoldierIsUsed ){
            soldiers.add( new Soldier( new Coordinate(10,10), null, 0, new HealthLevel(100) ) );
            soldiers.add( new Soldier( new Coordinate(10,10), null, 1, new HealthLevel(100) ) );
            soldiers.add( new Soldier( new Coordinate(10,10), null, 2, new HealthLevel(100) ) );
            this.gameSoldierIsUsed = true;
            s=("Game Soldiers are now here to help you! Please move them")+"\n";
        } else {
            s=("You have used Game Soldiers!")+"\n";
        }
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String spreadPlague(){
        String s="";
        for( Invader invader : invaders ){
            if( invader.getTarget(0) instanceof Soldier ){
                invader.clearTarget();
                invader.setFighting(false);
            }
        }
        for( Soldier soldier: soldiers ){
            if( soldier.getBarracksOwner() != null ){
                soldier.getBarracksOwner().removeSoldier( soldier.getSoldierID(), gameTime );
            }
        }
        soldiers.clear();
        s=("Plague is Spread! Keep on")+"\n";

        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String naturalEventHappening(){
        String s="";
        if( armories.size()>0 ) {
            Random rand = new Random();
            if (armories.size() > 0) {
                int poorArmoryIndex = rand.nextInt(armories.size());
                Armory poorArmory = armories.get(poorArmoryIndex);
                for (Invader invader : invaders) {
                    if( invader.getTarget(0)!=null ) {
                        if (invader.getTarget(0).equals(poorArmory)) {
                            invader.setFighting(false);
                            invader.clearTarget();
                        }
                    }
                }
                if (poorArmory instanceof Barracks) {
                    ArrayList<Integer> idxs = new ArrayList<>();
                    for (Soldier soldier : soldiers) {
                        if (soldier.getBarracksOwner().getId() == poorArmory.getId()) {
                            idxs.add(soldiers.indexOf(soldier));
                            //soldiers.remove(soldier);
                        }
                    }
                    for (int i = idxs.size()-1; i >= 0; i--){
                        soldiers.remove(idxs.get(i));
                    }
                    ((Barracks) poorArmory).removeSoldier(0, gameTime);
                    ((Barracks) poorArmory).removeSoldier(1, gameTime);
                    ((Barracks) poorArmory).removeSoldier(2, gameTime);
                }
                armories.remove(poorArmory);
                s=("Sorry . It is natural :))")+"\n";
            }
        } else {
            s=("It is natural but don't feel so miserable :)))")+"\n";
        }
        return s;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isEnded(){
        if( thisRoundNumberOfInvaders==0 && invaders.size()==0 )
            return true;
        else
            return false;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Invader> getInvaders() {
        return invaders;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Shot> getGameShots() {
        return gameShots;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Hero getHero() {
        return hero;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean getLoser(){
        return loser;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Price getProperty(){
        return property;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getXP(){
        return hero.getXpCnt();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isOnWay( Coordinate c ){
        return playGround.isInWay(c);
    }
}


