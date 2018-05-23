import java.util.ArrayList;

public interface Weapon {

    void attack(Time currentTime, Invader targetInvader, ArrayList<Shot> gameShots);
    Time getLastAttack();
    void setLastAttack(Time t);

}

