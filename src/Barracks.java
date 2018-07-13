import java.util.ArrayList;

public class Barracks extends Armory{

    private Soldier[] soldiers = new Soldier[3];
    private HealthLevel soldiersInitHealth;
    private Time soldierCompensationTime;
    private Time[] lastKilledsoldierTime = new Time[3];
    private ArrayList<Soldier> barracksSoldiers = new ArrayList<>();

    //Constructor
    public Barracks(int id, Coordinate coordinate, ArrayList<Soldier> gameSoldiers) {
        super.id = id;
        super.coordinate = coordinate;
        super.level = 1;
        super.range = 3 * super.rangeUnit; //High Range
        super.healthDegree = new HealthLevel(2);  //Medium Health Level
        super.price = new Price(Price.medPrice); //Medium Price
        super.setTargetPriority(TargetPriority.MinimumHealth);
        super.specificTargetInvader = null;
        super.graphicalSize = 5;
        soldiersInitHealth = new HealthLevel(10);
        soldierCompensationTime = new Time(10);
        soldiers[0] = new Soldier(coordinate, this, 0, soldiersInitHealth);
        soldiers[1] = new Soldier(coordinate, this, 1, soldiersInitHealth);;
        soldiers[2] = new Soldier(coordinate, this, 2, soldiersInitHealth);;
        barracksSoldiers.add(soldiers[0]);
        barracksSoldiers.add(soldiers[1]);
        barracksSoldiers.add(soldiers[2]);
        System.out.println("Barracks successfully Build");
        System.out.println("Warning: Move the soldiers to an appropriate place");
    }

    public void setSoldierCompensationTime( Time t ){ soldierCompensationTime = t; }

    public ArrayList<Soldier> getBarracksSoldiers() {
        return barracksSoldiers;
    }

    @Override
    public String showDetail() {
        String detail = "";
        detail = detail + "Barracks id: "+super.id+"\n";
        detail = detail + "Attack Range: "+super.range+" pixels!"+"\n";
        detail = detail + "Health Level: "+super.healthDegree.getHealthLevel()+" Units"+"\n";
        detail = detail + "Price: "+super.price.getPrice()+" Coins"+"\n";
        detail = detail + "Target Priority: "+super.getTargetPriority()+"\n";
        detail = detail + "//////////////////////////////////////"+"\n";
        return detail;
    }

    @Override
    public String levelUp(){//Price gamePrice) {
        String s = "";
        if (Game.property.getPrice() >= super.getLevelUpPrice().getPrice()) {
            super.level++;
            Game.property.decreasePrice(this.getLevelUpPrice());
            super.range = (int) ((double) super.range * 1.15);
            this.soldiersInitHealth.increaseHealth( (int)(this.soldiersInitHealth.getHealthLevel()*0.2) );
            this.soldierCompensationTime = new Time( (int)(this.soldierCompensationTime.getTime()*0.9) );
            s = ("Barracks id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
        return s;
    }


    public void removeSoldier( int soldierID, Time currentTime ){
        soldiers[soldierID] = null;
        lastKilledsoldierTime[soldierID].setTime( currentTime.getTime() );// = currentTime;
    }

    public String reviveSoldiers( Time currentTime, ArrayList<Soldier> gameSoldiers){
        String s="";
        for( int i=0; i<3; i++ ){
            if( soldiers[i] == null ){
                if( currentTime.getTime() - lastKilledsoldierTime[i].getTime() >= soldierCompensationTime.getTime() ){
                    soldiers[i] = new Soldier(this.coordinate, this, i, this.soldiersInitHealth );
                    gameSoldiers.add(soldiers[i]);
                    s=s+("New Soldier: "+i+" Revived to Barracks: "+this.id)+"\n";
                }
            }
        }
        return s;
    }



}
