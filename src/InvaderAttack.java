import java.util.ArrayList;

public interface InvaderAttack {
    ArrayList<Shot> attack(Time currentTime, ArrayList<Shot> gameShots, ArrayList<Object> target);
}
