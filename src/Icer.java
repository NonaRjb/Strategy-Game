import java.util.ArrayList;

public class Icer extends Invader{
    final Time attackRateTime;
    private Time lastAttack;

    Icer(Coordinate init_coordinate){
        this.attackRateTime = new Time(4); //attacks every 4 time units
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
        this.lastAttack = lastAttack;
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
    public void showDetail(){
        System.out.println("Icer:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: Very Low");
        System.out.println("Health Degree: High");
        System.out.println("Attack Rate: Very Low");
        System.out.println("Shoot Power: None");
        System.out.println("Additional Abilities: Only attacks buildings and causes them to stop working for 10 secs");
        System.out.println("current coordinate: " + "(" + super.coordinate.getX() + " , "  + super.coordinate.getY() + ")");
    }
}
