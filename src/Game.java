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


    // Constructor
    public Game() {
        this.playGround = new PlayGround();
        this.armories = new ArrayList<>();
        this.invaders = new ArrayList<>();
        this.gameTime = new Time(0);
        this.invaderRate = new Time(2);
        this.lastInvaderTime = new Time(0);
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
        this.invaderAttackGame();
        this.moveInvader();
        this.gameTime.increaseTime();
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
        int enemyKindNumber= rand.nextInt(13);
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // sets invaders' coordinate
    public void moveInvader(){
        for (Invader invader: invaders ) {
            Coordinate nextCoordinate;
            for (int i = 1; i <= invader.getMovementSpeed(); i++) {
                nextCoordinate = playGround.nextCoordinate(invader.getCoordinate());
                invader.setCoordinate(nextCoordinate);
            }
        }
    }

    /// Invader Attack
    public void invaderAttackGame(){
        for (Invader invader : invaders){
            if(invader instanceof Henchman || invader instanceof Skipper || invader instanceof Bane
                    || invader instanceof Sparrow || invader instanceof Miner || invader instanceof Smelly || invader instanceof Hopper){
                ArrayList<Object> targets = new ArrayList<>();
                for (Soldier soldier : soldiers){
                        if (Math.sqrt(Math.pow((soldier.getCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                                Math.pow((soldier.getCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                            targets.add(soldier);
                    }
                }
                if (Math.sqrt(Math.pow((hero.getCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                        Math.pow((hero.getCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                    targets.add(hero);
                }
                 invader.attack(gameTime, gameShots, targets);
            }
            if (invader instanceof ExG){
                ArrayList<Object> targets = new ArrayList<>();
                if (Math.sqrt(Math.pow((hero.getCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                        Math.pow((hero.getCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                     targets.add(hero);
                     invader.attack(gameTime, gameShots, targets);
                }
            }
            if (invader instanceof Icer || invader instanceof HockeyMaskMan){
                ArrayList<Object> targets = new ArrayList<>();
                for (PlaceHolder placeHolder : playGround.getPlaceHolder()){
                    if (Math.sqrt(Math.pow((placeHolder.getPlaceCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                            Math.pow((placeHolder.getPlaceCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                        targets.add(placeHolder);
                    }
                }
                invader.attack(gameTime, gameShots, targets);
            }
            if(invader instanceof Healer || invader instanceof Motivator){
                ArrayList<Object> targets = new ArrayList<>();
                for (Invader invader1 : invaders){
                    if (invaders.indexOf(invader) != invaders.indexOf(invader1)) {
                        if (Math.sqrt(Math.pow((invader1.getCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                                Math.pow((invader1.getCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                            targets.add(invader1);
                        }
                    }
                }
                invader.attack(gameTime, gameShots, targets);
            }
            if(invader instanceof Boomer){
                ArrayList<Object> targets = new ArrayList<>();
                for (Soldier soldier : soldiers){
                    if (Math.sqrt(Math.pow((soldier.getCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                            Math.pow((soldier.getCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                        targets.add(soldier);
                    }
                }
                if (Math.sqrt(Math.pow((hero.getCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                        Math.pow((hero.getCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                    targets.add(hero);
                }
                for (PlaceHolder placeHolder : playGround.getPlaceHolder()){
                    if (Math.sqrt(Math.pow((placeHolder.getPlaceCoordinate().getX() - invader.getCoordinate().getX()), 2) +
                            Math.pow((placeHolder.getPlaceCoordinate().getY() - invader.getCoordinate().getY()), 2)) <= invader.getRange()) {
                        targets.add(placeHolder);
                    }
                }
                invader.attack(gameTime, gameShots, targets);
            }
        }
    }
}


