public class Miner extends Invader implements InvaderAttack{
    protected int shootPower;
    protected Time attackRateTime;

    Miner(){

    }

    public boolean isVisible(boolean isHero){
        return (isHero == true);
    }

    @Override
    public void attack() {

    }
}
