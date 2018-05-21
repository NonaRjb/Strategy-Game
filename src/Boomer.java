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

    @Override
    public void showDetail(){
        System.out.println("Boomer:");
        System.out.println("Visibility Range: Medium");
        System.out.println("Movement Speed: High");
        System.out.println("Health Degree: Very Low");
        System.out.println("Attack Rate: None");
        System.out.println("Shoot Power: None");
        System.out.println("Additional Abilities: When it get to the first building in its way, it explodes and causes" +
                           "that building stops working for some secs");
    }
}
