import javafx.scene.layout.Priority;

import java.util.ArrayList;
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
    private Price property;
    private boolean gameSoldierIsUsed;
    private boolean interventionUsed;
    private int remainedTeslas;
    private final int teslaRange = 20;


    // Constructor
    public Game() {
        this.playGround = new PlayGround();
        this.armories = new ArrayList<>();
        this.invaders = new ArrayList<>();
        this.soldiers = new ArrayList<>();
        this.gameShots = new ArrayList<>();
        this.gameTime = new Time(0);
        this.invaderRate = new Time(2);
        this.lastInvaderTime = new Time(0);
        this.hero = new Hero( new Coordinate(10,10) );
        this.property = new Price(10);
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
    }


    // Other Methods
    public void createArmory(String armoryType, int id) {

        if( armoryType.equals("Barracks") ) {

            if( playGround.getPlaceHolder(id).getOwner() != null ){
                System.out.println("Place ID "+id+" is Full!");
            } else {
                this.armories.add( new Barracks(id, playGround.getPlaceHolder(id).getPlaceCoordinate(), soldiers) );
                this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
            }

        } else if( armoryType.equals("Freezer") ){

            if( playGround.getPlaceHolder(id).getOwner() != null ){
                System.out.println("Place ID "+id+" is Full!");
            } else {
                this.armories.add(new Freezer(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
            }

        } else if (armoryType.equals("MachineGun")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                    System.out.println("Place ID "+id+" is Full!");
                } else {
                    this.armories.add(new MachineGun(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                    this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        } else if (armoryType.equals("Laser")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        System.out.println("Place ID "+id+" is Full!");
                } else {
                        this.armories.add(new Laser(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        } else if (armoryType.equals("Rocket")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        System.out.println("Place ID "+id+" is Full!");
                } else {
                        this.armories.add(new Rocket(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        } else if (armoryType.equals("Excalibur")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        System.out.println("Place ID "+id+" is Full!");
                } else {
                        this.armories.add(new Excalibur(id, playGround.getPlaceHolder(id).getPlaceCoordinate(), this.gameTime));
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        } else if (armoryType.equals("Beehive")){

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        System.out.println("Place ID "+id+" is Full!");
                } else {
                        this.armories.add(new Beehive(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        } else if (armoryType.equals("Hellgate")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        System.out.println("Place ID "+id+" is Full!");
                } else {
                        this.armories.add(new Hellgate(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        } else if (armoryType.equals("Sauron")) {

                if( playGround.getPlaceHolder(id).getOwner() != null ){
                        System.out.println("Place ID "+id+" is Full!");
                } else {
                        this.armories.add(new Sauron(id, playGround.getPlaceHolder(id).getPlaceCoordinate()));
                        this.playGround.getPlaceHolder(id).setOwner( this.armories.get( this.armories.size()-1 ) );
                }

        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setArmoryTargetPriority(int id, TargetPriority targetPriority){
        if (id == PlayGround.numberOfPlaces){
            for (Armory armory : armories){
                armory.setTargetPriority(targetPriority);
            }
        }else {
            for (Armory armory : armories){
                if (armory.getId() == id){
                    armory.setTargetPriority(targetPriority);
                    break;
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void increaseTime(){
        //Todo check frozen, Stop, Idle and etc. --> needs to be rechecked
        for( Invader invader : invaders ){
            invader.clearTarget();
            invader.checkFrozen(gameTime);
        }
        for( Armory armory: armories ){
            if( armory instanceof Barracks )
                ((Barracks)armory).reviveSoldiers( gameTime, soldiers );
        }
        hero.checkIdle(gameTime);
        hero.checkStopped(boomerStopConst, gameTime);
        this.moveObjects();
        this.botherBurnings();
        this.botherToxicants();
        this.botherBurnings();
        this.botherToxicants();
        this.refreshFrozenArmories();
        this.doAttacks();
        this.moveObjects();
        this.gameTime.increaseTime();
        this.invaderMaker();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Moving all Objects
    public void moveObjects(){

        //move Soldier and Hero with direct command from the player

        for (Invader invader: invaders ) {
            this.moveInvader(invader );
        }

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
                if ((Coordinate.distance(invader.getCoordinate(), soldier.getCoordinate()) <= invader.getRange())
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
                nextCoordinate = playGround.nextCoordinate(invader.getCoordinate());
                invader.setCoordinate(nextCoordinate);
            }
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets soldier's coordinate
    public void moveSoldier( int barracksID, int soldierId, Coordinate coordinate){
        boolean flag = false;
        if( barracksID==PlayGround.numberOfPlaces ){
            for (Soldier soldier : soldiers) {
                if (soldier.getBarracksOwner() == null && soldier.getSoldierID() == soldierId) {
                    goSoldier(soldier, coordinate);
                    flag = true;
                }
            }
        } else {
            for (Soldier soldier : soldiers) {
                if (soldier.getBarracksOwner().getId() == barracksID && soldier.getSoldierID() == soldierId) {
                    goSoldier(soldier, coordinate);
                    flag = true;
                }
            }
        }
        if( !flag ){
            System.out.println("No Soldier With this Features");
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private void goSoldier( Soldier soldier, Coordinate coordinate){
        if (playGround.isInWay(coordinate)){
            soldier.moveGame(coordinate);
        }
        else {
            System.out.println("Moving to the this coordinate is not allowed");
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets hero's coordinate
    public void moveHero(Coordinate coordinate){
        if (playGround.isInWay(coordinate)){
            hero.moveTo(coordinate);
        }
        else {
            System.out.println("Moving to the this coordinate is not allowed");
        }
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
    public void showArmoriesDetails(){
        for( Armory currentArmory : this.armories ){
            currentArmory.showDetail();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void invaderMaker(){
        if( thisRoundNumberOfInvaders > 0 ) {
            if (this.gameTime.getTime() - this.lastInvaderTime.getTime() >= this.invaderRate.getTime()) {
                this.produceInvader();
                thisRoundNumberOfInvaders--;
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private void produceInvader(){
        Invader newInvader;
        Random rand = new Random();
        int enemyKindNumber= rand.nextInt( Invader.numberOfInvaderKinds );
        Coordinate invaderEnteringCoordinate = playGround.randomOriginMaker();
        switch( enemyKindNumber ){
            case 0:
                newInvader = new Henchman( thisRoundNumberOfInvaders, invaderEnteringCoordinate );

                break;
            case 1:
                newInvader = new Skipper( thisRoundNumberOfInvaders, invaderEnteringCoordinate );

                break;
            case 2:
                newInvader = new Bane( thisRoundNumberOfInvaders ,invaderEnteringCoordinate );
                break;
            case 3:
                newInvader = new Sparrow( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 4:
                newInvader = new Boomer( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 5:
                newInvader = new Healer( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 6:
                newInvader = new Motivator( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 7:
                newInvader = new Icer( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 8:
                newInvader = new Miner( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 9:
                newInvader = new Smelly( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 10:
                newInvader = new Hopper( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 11:
                newInvader = new ExG( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            case 12:
                newInvader = new HockeyMaskMan( thisRoundNumberOfInvaders, invaderEnteringCoordinate );
                break;
            default:
                newInvader = null;
        }

        invaders.add( newInvader );

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void showInvadersDetails(){
        for( Invader currentInvader : this.invaders ){
            currentInvader.showDetail();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void showHeroDetails(){
        hero.showDetail();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void showSoldiersDetails(){
        for ( Soldier soldier : soldiers){
            soldier.showDetail();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void showSlotsDetails(){
        for (PlaceHolder placeHolder : playGround.getPlaceHolder()){
            placeHolder.showDetail();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public void doAttacks(){

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

        for( Shot shot: gameShots ){
            effectShot( shot );
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Armory Attack
    private void armoryAttackGame( Armory armory ){

        ArrayList<Invader> invadersInRange = findInvaders( armory.getCoordinate(), armory.getRange(), armory.getTargetPriority() );

        // If Miner is in invadersInRange it should be removed because it cannot be seen by anybody except hero
        for (Invader invader : invadersInRange){
            if (invader instanceof Miner){
                invadersInRange.remove(invader);
            }
        }
        //

        Invader targetInvader;
        if( invadersInRange != null ) {
            if (armory.getTargetPriority() == TargetPriority.SpecificTarget && invadersInRange.contains(armory.getSpecificTargetInvader()))
                targetInvader = armory.getSpecificTargetInvader();
            else
                targetInvader = invadersInRange.get(0);
        } else {
            targetInvader = null;
        }

        //TODO: Recheck Laser Stop
        if( !armory.isStopped() ) {
            if (armory instanceof Freezer) {
                Freezer currentFreezer = (Freezer) armory;
                if (targetInvader != null) {
                    currentFreezer.attack(this.gameTime, targetInvader, gameShots);
                }
            } else if (armory instanceof Hellgate) {
                Hellgate currentHellgate = (Hellgate) armory;
                if (!currentHellgate.isBurning()) {
                    if (targetInvader != null) {
                        currentHellgate.attack(null, null, gameShots);
                        currentHellgate.setBurning(true);
                    }
                }
            } else if (armory instanceof MachineGun) {
                MachineGun currentMachineGun = (MachineGun) armory;
                if (targetInvader != null) {
                    currentMachineGun.attack(this.gameTime, targetInvader, gameShots);
                }
            } else if (armory instanceof Laser) {
                Laser currentLaser = (Laser) armory;
                if (targetInvader != null) {
                    if (!currentLaser.isOnAttack()) {
                        currentLaser.attack(this.gameTime, targetInvader, gameShots);
                    } else {
                        if (currentLaser.getSpecificTargetInvader() != targetInvader) {
                            gameShots.remove(currentLaser.getAttackingLaserShot());
                            currentLaser.attack(this.gameTime, targetInvader, gameShots);
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
                    currentRocket.attack(this.gameTime, null, gameShots);
                }
            } else if (armory instanceof Excalibur) {
                Excalibur currentExcalibur = (Excalibur) armory;
                if (targetInvader != null) {
                    currentExcalibur.attack(this.gameTime, targetInvader, gameShots);
                }
            } else if (armory instanceof Beehive) {
                Beehive currentBeehive = (Beehive) armory;
                if (targetInvader != null) {
                    currentBeehive.attack(this.gameTime, targetInvader, gameShots);
                }
            } else if (armory instanceof Sauron) {
                Sauron currentSauron = (Sauron) armory;
                if (targetInvader != null) {
                    currentSauron.attack(this.gameTime, targetInvader, gameShots);
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
                invader.attack(gameTime, gameShots, targets);
            }
        }
        if (invader instanceof ExG){
            ArrayList<Object> targets = new ArrayList<>();
            if( hero != null ) {
                if ( Coordinate.distance( invader.getCoordinate(), hero.getCoordinate() ) <= invader.getRange()) {
                    targets.add(hero);
                    invader.attack(gameTime, gameShots, targets);
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
                invader.attack(gameTime, gameShots, targets);
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
                invader.attack(gameTime, gameShots, targets);
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
                invader.attack(gameTime, gameShots, targets);
                invaders.remove(invader);
            }
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void heroAttackGame(){
        if(hero != null) {
            ArrayList<Invader> targets = new ArrayList<>();
            //Todo is in mission mix with go after Invader
            if (hero.isInMission() == false) {
                targets = findInvaders(hero.getCoordinate(), hero.getRange(), TargetPriority.AllInRange);
                if (targets != null) {
                    System.out.println(targets.size());/////////////////test
                    for (Invader invader : targets) {
                        if (invader instanceof Sparrow) {
                            targets.remove(invader);
                        }
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
    public void goAfterInvaderHero(int invaderID){
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
                nextCoordinate = playGround.nextCoordinate(target.getCoordinate());
            }
            if (nextCoordinate != null) {
                hero.goAfterInvader(target, nextCoordinate);
            }
        }else {
            System.out.println("Invader not found!");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void soldierAttackGame(Soldier soldier){
        ArrayList<Invader> targets = findInvaders(soldier.getCoordinate(), soldier.getRange(), TargetPriority.AllInRange);
        //Todo is in mission mix with go after Invader
        if (!soldier.isInMission()) {
            for (Invader invader : targets) {
                if (invader instanceof Sparrow) {
                    targets.remove(invader);
                }
            }
            if (targets.size() != 0) {
                soldier.attack(gameTime, gameShots, targets);
            }
        }else {
            if (soldier.getTargetInvader() != null) {
                targets.add(soldier.getTargetInvader());
                soldier.attack(gameTime, gameShots, targets);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void goAfterInvaderSoldier(int soldierId, int barracksId, int invaderId){
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
                    nextCoordinate = playGround.nextCoordinate(targetInvader.getCoordinate());
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
                System.out.println("Invader not found!");
            }
        }else {
            System.out.println("Soldier not found!");
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void effectShot( Shot shot ){

        if( shot instanceof Bullet ){
            Object target = shot.getTarget();
            Bullet currentBullet = (Bullet)shot;
            if( target instanceof Invader ) {
                Invader targetInvader = (Invader)target;
                if( shot.getCoordinate().isEqual( targetInvader.getCoordinate() ) ){
                    if( targetInvader.getHealthDegree().getHealthLevel() <= shot.getPower() ){
                        System.out.println("Invader got killed !");
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
                    gameShots.remove( shot );
                    this.property.increasePrice(new Price(10));
                }
            } else if (target instanceof Soldier){
                Soldier targetSoldier = (Soldier) target;
                if(shot.getCoordinate().isEqual(targetSoldier.getCoordinate())){
                    if (targetSoldier.getHealth().getHealthLevel() <= shot.getPower()){
                        System.out.println("Soldier got killed!");
                        targetSoldier.getBarracksOwner().removeSoldier( targetSoldier.getSoldierID(), gameTime );
                        soldiers.remove(targetSoldier);
                        if( currentBullet.getOwner() instanceof Invader ){
                            ((Invader)currentBullet.getOwner()).addNumberOfKillings();
                        }
                    } else {
                        targetSoldier.getHealth().decreaseHealth(shot.getPower());
                    }
                    gameShots.remove( shot );
                }
            } else if (target instanceof Hero){
                Hero targetHero = (Hero) target;
                if (shot.getCoordinate().isEqual(targetHero.getCoordinate())) {
                    if (targetHero.getHealthLevel().getHealthLevel() <= shot.getPower()){
                        System.out.println("Hero will be idle for " + hero.getDelayConst() + " seconds");
                        hero.addDeathNum();
                        hero.setIdle(gameTime);
                        if( currentBullet.getOwner() instanceof Invader ){
                            ((Invader)currentBullet.getOwner()).addNumberOfHeroKill();
                        }
                    }
                    gameShots.remove( shot );
                }
            }
            if (target instanceof Armory){
                Armory targetArmory = (Armory) target;
                if (shot.getCoordinate().isEqual(targetArmory.getCoordinate())){
                    if (targetArmory.getHealthDegree().getHealthLevel() <= shot.getPower()){
                        System.out.println("The Armory got ruined! Place " + targetArmory.getId() + " is now empty!");
                        playGround.getPlaceHolder(targetArmory.getId()).setOwner(null);
                        armories.remove(targetArmory);
                    }
                }
            }
        }
        else if( shot instanceof Ice ){
            Object target = shot.getTarget();
            if( target instanceof Invader ) {
                Invader targetInvader = (Invader)target;
                if( shot.getCoordinate().isEqual( targetInvader.getCoordinate() ) ){
                    System.out.println("The Invader got Frozen!");
                    targetInvader.setFrozen( true , shot.getPower(), gameTime);
                    gameShots.remove( shot );
                }
            } else if (target instanceof Armory) {
                Armory targetArmory = (Armory) target;
                if (shot.getCoordinate().isEqual(targetArmory.getCoordinate())) {
                    System.out.println("The Armory got Frozen!");
                    targetArmory.setStopped(true, shot.getPower(), gameTime);
                    gameShots.remove( shot );
                }
            }
        } else if( shot instanceof Fire ){
            ArrayList<Invader> burningInvaders = findInvaders( shot.getCoordinate(), ((Fire) shot).getRange(), TargetPriority.AllInRange );
            if( burningInvaders == null ){
                ((Fire)shot).getOwner().setBurning( false );
                gameShots.remove( shot );
            } else {
                for (Invader invader : burningInvaders) {
                    invader.setBurning(true);
                }
            }
        } else if( shot instanceof Poison ){
            ArrayList<Invader> poisonedInvaders = findInvaders( shot.getCoordinate(), ((Poison) shot).getRange(), TargetPriority.AllInRange );
            for (Invader invader : poisonedInvaders) {
                invader.setPoisoned( true );
            }
            gameShots.remove( shot );
        } else if( shot instanceof RocketShot ){
            ArrayList<Invader> shoootedInvaders = findInvaders( shot.getCoordinate(), ((RocketShot) shot).getRange(), TargetPriority.AllInRange );
            for (Invader invader : shoootedInvaders) {
                if( invader.getHealthDegree().getHealthLevel() <= shot.getPower() ){
                    System.out.println("Invader got killed !");
                    invaders.remove( invader );
                } else {
                    invader.getHealthDegree().decreaseHealth( shot.getPower() );
                }
                gameShots.remove( shot );
            }
        } else if( shot instanceof LaserShot ) {
            Invader targetInvader = (Invader) shot.getTarget();
            if( targetInvader.getHealthDegree().getHealthLevel() <= shot.getPower() ){
                System.out.println("Invader got killed !");
                invaders.remove( targetInvader );
                ((LaserShot)shot).getOwner().endAttack();
                gameShots.remove( shot );

            } else {
                targetInvader.getHealthDegree().decreaseHealth( shot.getPower() );
            }
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void botherBurnings(){
        for( Invader invader: invaders ){
            if( invader.isBurning() ){
                if( invader instanceof Icer ){
                    System.out.println("Icer got Burned !");
                    invaders.remove(invader);
                } else {
                    invader.decreaseBurningTime();
                }
            }
        }
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
    public void upgradeArmory(int id){
        for( Armory armory: armories ){
            if( armory.getId() == id )
                armory.levelUp(property);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void sellArmory(int id){
        for( Armory armory: armories ){
            if( armory.getId() == id ) {
                property.increasePrice( armory.getPrice() );
                this.playGround.getPlaceHolder(id).setOwner(null);
                System.out.println("Armory id: "+id+" got sold");
                if( armory instanceof Barracks ){
                    for( Soldier soldier: soldiers  ){
                        if( soldier.getBarracksOwner().getId() == id )
                            soldiers.remove(soldier);
                    }
                }
                armories.remove(armory);
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setTargetForArmory( int armoryID, int invaderID ) {

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
                whichArmory.setTargetPriority(TargetPriority.SpecificTarget);
                whichArmory.setSpecificTargetInvader( targetInvader );
            } else {
                System.out.println("No Such Invader in Game");
            }
        } else {
            System.out.println("No Such Armory in Game");
        }


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
    public void useTesla( Coordinate originCoordinate ){
        if( this.remainedTeslas > 0 ){
            ArrayList<Invader> targetInvaders = findInvaders( originCoordinate, this.teslaRange, TargetPriority.AllInRange );
            for( Invader invader : targetInvaders ) {

                invaders.remove( invader );
                for( Armory armory : armories ){
                    if( armory.specificTargetInvader.equals( invader ) ){
                        armory.setTargetPriority( TargetPriority.MinimumHealth );
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
            System.out.println("You Don't have Tesla");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void interventionKillAll(){
        if( !this.interventionUsed ){
            hero.setInMission(false);
            for( Soldier soldier : soldiers ){
                soldier.setInMission(false);
            }
            for( Armory armory : armories ){
                armory.setSpecificTargetInvader( null );
                armory.setTargetPriority(TargetPriority.MinimumHealth);
            }
            invaders.clear();
            this.interventionUsed = true;
            System.out.println("Ha Ha Ha !!! :)))");
        } else
            System.out.println("You have used Intervention!");
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void makeGameSoldiers(){
        if( !this.gameSoldierIsUsed ){
            soldiers.add( new Soldier( new Coordinate(10,10), null, 0, new HealthLevel(100) ) );
            soldiers.add( new Soldier( new Coordinate(10,10), null, 1, new HealthLevel(100) ) );
            soldiers.add( new Soldier( new Coordinate(10,10), null, 2, new HealthLevel(100) ) );
            this.gameSoldierIsUsed = true;
            System.out.println("Game Soldiers are now here to help you! Please move them");
        } else {
            System.out.println("You have used Game Soldiers!");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void spreadPlague(){
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
        System.out.println("Plague is Spread! Keep on");
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void naturalEventHappening(){
        Random rand = new Random();
        int poorArmoryIndex = rand.nextInt( armories.size() );
        Armory poorArmory = armories.get( poorArmoryIndex );
        for( Invader invader : invaders ){
            if( invader.getTarget(0).equals(poorArmory) ){
                invader.setFighting(false);
                invader.clearTarget();
            }
        }
        if( poorArmory instanceof Barracks ){
            for( Soldier soldier : soldiers ){
                if( soldier.getBarracksOwner().getId()==poorArmory.getId() ) {
                    soldiers.remove(soldier);
                }
            }
            ((Barracks)poorArmory).removeSoldier( 0, gameTime );
            ((Barracks)poorArmory).removeSoldier( 1, gameTime );
            ((Barracks)poorArmory).removeSoldier( 2, gameTime );
        }
        armories.remove(poorArmory);
        System.out.println("Sorry . It is natural :))");
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean isEnded(){
        if( thisRoundNumberOfInvaders==0 && invaders.size()==0 )
            return true;
        else
            return false;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

}


