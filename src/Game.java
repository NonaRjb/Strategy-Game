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
    static Time burningTimeConst = new Time(10);


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
        this.hero = null;
    }

    // Getters
    public ArrayList<Armory> getArmories() {
        return this.armories;
    }

    // Other Methods
    public void createArmory(String armoryType, int id) {
        if (armoryType.equals("Freezer")) {
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
    public void increaseTime(){
        for (Invader invader : invaders){
            invader.clearTarget();
        }
        this.moveObjects();
        this.doAttacks();
        this.gameTime.increaseTime();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Moving all Objects
    public void moveObjects(){

        for (Invader invader: invaders ) {
            this.moveInvader(invader );
        }

        for( Soldier soldier: soldiers){
            this.moveSoldier( soldier );
        }

        this.moveHero( this.hero );

        for( Shot shot: gameShots ){
            this.moveShot( shot );
        }


    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets invader's coordinate
    private void moveInvader( Invader invader ) {

        //TODO: Slower Move if Frozen --> DONE
        int currentSpeed;
        final int freezeConst = 1;
        if(invader.getFrozen()){
            currentSpeed = invader.getMovementSpeed() - freezeConst;
        }else {
            currentSpeed = invader.getMovementSpeed();
        }
        //
        Coordinate nextCoordinate;
        for (int i = 1; i <= currentSpeed ; i++) {
            nextCoordinate = playGround.nextCoordinate(invader.getCoordinate());
            invader.setCoordinate(nextCoordinate);
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets soldier's coordinate
    private void moveSoldier( Soldier soldier ){

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets hero's coordinate
    private void moveHero( Hero hero ){
        
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
        if( this.gameTime.getTime() - this.lastInvaderTime.getTime() >= this.invaderRate.getTime() ){
            produceInvader();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public void produceInvader(){
        Invader newInvader;
        Random rand = new Random();
        int enemyKindNumber= rand.nextInt( Invader.numberOfInvaderKinds );
        Coordinate invaderEnteringCoordinate = playGround.randomOriginMaker();
        switch( enemyKindNumber ){
            case 0:
                newInvader = new Henchman( invaderEnteringCoordinate );

                break;
            case 1:
                newInvader = new Skipper( invaderEnteringCoordinate );

                break;
            case 2:
                newInvader = new Bane( invaderEnteringCoordinate );
                break;
            case 3:
                newInvader = new Sparrow( invaderEnteringCoordinate );
                break;
            case 4:
                newInvader = new Boomer( invaderEnteringCoordinate );
                break;
            case 5:
                newInvader = new Healer( invaderEnteringCoordinate );
                break;
            case 6:
                newInvader = new Motivator( invaderEnteringCoordinate );
                break;
            case 7:
                newInvader = new Icer( invaderEnteringCoordinate );
                break;
            case 8:
                newInvader = new Miner( invaderEnteringCoordinate );
                break;
            case 9:
                newInvader = new Smelly( invaderEnteringCoordinate );
                break;
            case 10:
                newInvader = new Hopper( invaderEnteringCoordinate );
                break;
            case 11:
                newInvader = new ExG( invaderEnteringCoordinate );
                break;
            case 12:
                newInvader = new HockeyMaskMan( invaderEnteringCoordinate );
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public void doAttacks(){

        for( Armory armory : armories ){
            armoryAttackGame( armory );
        }

        for( Invader invader : invaders ){
            invaderAttackGame( invader );
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

        if( armory instanceof Freezer ){
            Freezer currentFreezer = (Freezer) armory;
            if( targetInvader != null ) {
                currentFreezer.attack(this.gameTime, targetInvader, gameShots);
            }
        } else if( armory instanceof Hellgate ){
            Hellgate currentHellgate = (Hellgate)armory;
            if( ! currentHellgate.isBurning() ){
                if( targetInvader != null ){
                    currentHellgate.attack(null, null, gameShots);
                    currentHellgate.setBurning( true );
                }
            }
        } else if( armory instanceof MachineGun ){
            MachineGun currentMachineGun = (MachineGun) armory;
            if( targetInvader != null ) {
                currentMachineGun.attack(this.gameTime, targetInvader, gameShots);
            }
        } else if( armory instanceof Laser ) {
            Laser currentLaser = (Laser) armory;
            if( targetInvader != null ) {
                if (!currentLaser.isOnAttack()) {
                    currentLaser.attack(this.gameTime, targetInvader, gameShots);
                } else {
                    if (currentLaser.getSpecificTargetInvader() != targetInvader) {
                        gameShots.remove( currentLaser.getAttackingLaserShot() );
                        currentLaser.attack(this.gameTime, targetInvader, gameShots);
                    }
                }
            } else {
                if( currentLaser.isOnAttack() ){
                    gameShots.remove( currentLaser.getAttackingLaserShot() );
                    currentLaser.endAttack();
                }
            }
        } else if( armory instanceof Rocket ) {
            Rocket currentRocket = (Rocket)armory;
            if( targetInvader != null ){
                currentRocket.attack(this.gameTime, null, gameShots);
            }
        } else if( armory instanceof Excalibur ){
            Excalibur currentExcalibur = (Excalibur) armory;
            if( targetInvader != null ){
                currentExcalibur.attack(this.gameTime, targetInvader, gameShots);
            }
        } else if( armory instanceof Beehive ){
            Beehive currentBeehive = (Beehive)armory;
            if( targetInvader != null ){
                currentBeehive.attack(this.gameTime, targetInvader, gameShots);
            }
        } else if( armory instanceof Sauron ){
            Sauron currentSauron = (Sauron)armory;
            if( targetInvader != null ){
                currentSauron.attack(this.gameTime, targetInvader, gameShots);
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
             invader.attack(gameTime, gameShots, targets);
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
            for (PlaceHolder placeHolder : playGround.getPlaceHolder()){
                if ( Coordinate.distance( invader.getCoordinate(), placeHolder.getPlaceCoordinate() ) <= invader.getRange()) {
                    targets.add(placeHolder);
                }
            }
            invader.attack(gameTime, gameShots, targets);
        }
        if(invader instanceof Healer || invader instanceof Motivator){
            //TODO Healer Rescue Toxicants ! :)) --> DONE (in Healer attack method)
            ArrayList<Object> targets = new ArrayList<>();
            for (Invader invader1 : invaders){
                if (invaders.indexOf(invader) != invaders.indexOf(invader1)) {
                    if ( Coordinate.distance( invader.getCoordinate(), invader1.getCoordinate() ) <= invader.getRange()) {
                        targets.add(invader1);
                    }
                }
            }
            invader.attack(gameTime, gameShots, targets);
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
            for (PlaceHolder placeHolder : playGround.getPlaceHolder()){
                if ( Coordinate.distance( invader.getCoordinate(), placeHolder.getPlaceCoordinate() ) <= invader.getRange()) {
                    targets.add(placeHolder);
                }
            }
            invader.attack(gameTime, gameShots, targets);
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void heroAttackGame(){
        if(hero != null) {
            ArrayList<Invader> targets = findInvaders(hero.getCoordinate(), hero.getRange(), TargetPriority.Nearest);
            for (Invader invader : targets){
                if (invader instanceof Sparrow){
                    targets.remove(invader);
                }
            }
            hero.attack(gameTime, gameShots, targets);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void effectShot( Shot shot ){

        if( shot instanceof Bullet ){
            Object target = shot.getTarget();
            if( target instanceof Invader ) {
                Invader targetInvader = (Invader)target;
                if( shot.getCoordinate().isEqual( targetInvader.getCoordinate() ) ){
                    if( targetInvader.getHealthDegree().getHealthLevel() <= shot.getPower() ){
                        System.out.println("Invader got killed !");
                        invaders.remove( targetInvader );
                    } else {
                        targetInvader.getHealthDegree().decreaseHealth( shot.getPower() );
                    }
                    gameShots.remove( shot );
                }
            }
        } else if( shot instanceof Ice ){
            Object target = shot.getTarget();
            if( target instanceof Invader ) {
                Invader targetInvader = (Invader)target;
                if( shot.getCoordinate().isEqual( targetInvader.getCoordinate() ) ){
                    targetInvader.setFrozen( true , shot.getPower(), gameTime);
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
}


