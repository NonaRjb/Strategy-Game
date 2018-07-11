import java.util.ArrayList;

public interface Weapon {

    Shot attack(Time currentTime, Invader targetInvader);
    Time getLastAttack();
    void setLastAttack(Time t);

}

