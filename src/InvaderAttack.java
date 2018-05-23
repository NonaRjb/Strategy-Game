import java.util.ArrayList;

public interface InvaderAttack {
    Boolean attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> target);
}
