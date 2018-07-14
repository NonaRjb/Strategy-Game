import java.util.ArrayList;

public class Boomer extends Invader{

    static final int boomingTimeConst = 10;

    //constructor
    Boomer(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1*Invader.healthUnit); //Very low degree of health
        super.movementSpeed = 4 * super.speedConst; //moves 4 pixels in each time unit
        super.range = 3 * rangeUnit; //Medium range
    }

    @Override
    public ArrayList<Shot> attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        ArrayList<Shot> shots = new ArrayList<>();
        for (Object target : targets) {
            if (target instanceof Armory){
                ((Armory) target).setStopped(true, boomingTimeConst ,currentTime);
            }else if (target instanceof Soldier){
                ((Soldier) target).setStopped(true);
            }else if (target instanceof Hero){
                ((Hero) target).setStopped(true);
            }
            super.setTarget(target);
        }
        return shots;
    }

    @Override
    public String showDetail(){
        String detail="";
        detail = detail + "Boomer:"+"\n";
        detail = detail + "Visibility Range: Medium"+"\n";
        detail = detail + "Movement Speed: High"+"\n";
        detail = detail + "Health Degree: Very Low"+"\n";
        detail = detail + "Attack Rate: None"+"\n";
        detail = detail + "Shoot Power: None"+"\n";
        detail = detail + "Additional Abilities: When it get to the first building in its way, it explodes and causes" +
                           "that building stops working for some secs"+"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")"+"\n";
        detail = detail + "Number of soldiers killed by this Invader: " + super.numberOfKilledSoldiers+"\n";
        detail = detail + "Number of times Hero got killed by this Invader" + super.numberOfHeroKill+"\n";
        return detail;
    }
}
