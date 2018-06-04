import java.util.ArrayList;

public class Barracks extends Armory{

    private Soldier[] soldiers = new Soldier[3];
    private HealthLevel soldiersInitHealth;
    private Time soldierCompensationTime;

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
        soldiers[0] = new Soldier(coordinate, super.id, 0, 10);
        soldiers[1] = new Soldier(coordinate, super.id, 1, 10);;
        soldiers[2] = new Soldier(coordinate, super.id, 2, 10);;
        gameSoldiers.add(soldiers[0]);
        gameSoldiers.add(soldiers[1]);
        gameSoldiers.add(soldiers[2]);
        System.out.println("Barracks successfully Build");
        System.out.println("Warning: Move the soldiers to an appropriate place");
    }

    @Override
    public void showDetail() {
        System.out.println("Barracks id: "+super.id);
        System.out.println("Attack Range: "+super.range+" pixels!");
        System.out.println("Health Level: "+super.healthDegree.getHealthLevel()+" Units");
        System.out.println("Price: "+super.price.getPrice()+" Coins");
        System.out.println("Target Priority: "+super.getTargetPriority());
        System.out.println("//////////////////////////////////////");
    }

    @Override
    public void levelUp(Price gamePrice) {
        if (gamePrice.getPrice() >= super.getLevelUpPrice().getPrice()) {
            super.level++;
            gamePrice.decreasePrice(this.getLevelUpPrice());
            super.range = (int) ((double) super.range * 1.15);
            this.soldiersInitHealth.increaseHealth( (int)(this.soldiersInitHealth.getHealthLevel()*0.2) );
            this.soldierCompensationTime = new Time( (int)(this.soldierCompensationTime.getTime()*0.9) );
            System.out.println("Barracks id: " + super.id + " is successfully upgraded to Level " + super.level + " !");
        }
    }



}
