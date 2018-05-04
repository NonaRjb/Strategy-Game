public class Hero implements DetailShow {
    Coordinate coordinate;
    HealthLevel healthLevel;
    int level;
    int delayConst;
    int speedLevel;
    int range;
    int xpCnt;
    int graphicalSize;
    int numberOfKillings;
    Invader targetInvader;

    //constructor
    Hero(Coordinate init_coordinate, int xpCnt){
        coordinate = init_coordinate;
        level = 1;
        healthLevel = new HealthLevel(1); //Hero's health unit is one
        delayConst = 10; //Just to be here! should be changed
        speedLevel = 1; // High Speed
        range = 4; // High Range
        this.xpCnt = xpCnt;
        numberOfKillings = 0;
    }

    //setter & getters

    public void setNumberOfKillings(int numberOfKillings) {
        this.numberOfKillings = numberOfKillings;
    }

    public int getNumberOfKillings() {
        return numberOfKillings;
    }

    public void levelUp(){
        this.level++;
        delayConst--; //delayConst must be decreased with each level upgrade
    }

    public boolean freezeGsme(){ //Notice! FreezeGame return value is boolean now!
        if(this.level >= 3){
            return true;
        }
        else return false;
    }

    public void goAfterInvader(Invader invader){
        this.targetInvader = invader;
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
        // Speed and range are assumed to be constant
    }
}
