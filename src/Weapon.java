import java.util.ArrayList;

public interface Weapon {

    public void attack(Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots);
    public Time getLastAttack();
    public void setLastAttack(Time t);

}

