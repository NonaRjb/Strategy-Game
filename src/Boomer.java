public class Boomer extends Invader implements InvaderAttack {

    //constructor
    Boomer(Coordinate init_coordinate){
        super.coordinate = init_coordinate;
        super.healthDegree = new HealthLevel(4); //Very low degree of health
        super.movementSpeed = 1; //moves every time units
        super.range = 3; //Medium range
    }

    @Override
    public void attack() {

    }
}
