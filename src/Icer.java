import java.util.ArrayList;

public class Icer extends Invader{
    final Time attackRateTime;
    private Time lastAttack;

    Icer(int id, Coordinate init_coordinate){
        super();
        super.instanceNum = id;
        this.attackRateTime = new Time(4); //attacks every 4 time units
        this.lastAttack = new Time(0);
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(1); //High degree of health
        super.movementSpeed = 1 * super.speedConst; //moves 1 pixels in each time unit
        super.range = 3; //Medium range
    }

    public Time getLastAttack() {
        return lastAttack;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public void setLastAttack(Time lastAttack) {
        this.lastAttack.setTime(lastAttack.getTime());// = lastAttack;
    }

    @Override
    public Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> targets) {
        if ((currentTime.getTime() - this.getLastAttack().getTime()) < this.getAttackRateTime().getTime()){
            return false;
        }else {
            this.setLastAttack(currentTime);
            PlaceHolder target = (PlaceHolder) targets.get(0);
            int distance = Coordinate.distance(  target.getPlaceCoordinate(), this.coordinate ) ;
            for (Object placeHolder : targets) {
                if ( Coordinate.distance( ((PlaceHolder) placeHolder).getPlaceCoordinate(), this.coordinate ) < distance) {
                    distance = Coordinate.distance( ((PlaceHolder) placeHolder).getPlaceCoordinate(), this.coordinate );
                    target = (PlaceHolder) placeHolder;
                }
            }
            super.setTarget(target);
            gameShots.add(new Ice(this.coordinate, target, 10));
            return true;

        }
    }

    @Override
    public String showDetail(){
        String detail = "";
        detail = detail + "Icer:" +"\n";
        detail = detail + "Visibility Range: Medium" +"\n";
        detail = detail + "Movement Speed: Very Low" +"\n";
        detail = detail + "Health Degree: High" +"\n";
        detail = detail + "Attack Rate: Very Low" +"\n";
        detail = detail + "Shoot Power: None" +"\n";
        detail = detail + "Additional Abilities: Only attacks buildings and causes them to stop working for 10 secs" +"\n";
        detail = detail + "current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")" +"\n";
        return detail;
    }
}
