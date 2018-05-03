public class Smelly extends Invader implements InvaderAttack{
    private int shootPower;
    private Time attackRateTime;
    private Poison poisonPlume;

    Smelly(){

    }

    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public void setShootPower(int shootPower) {
        this.shootPower = shootPower;
    }

    public void setAttackRateTime(Time attackRateTime) {
        this.attackRateTime = attackRateTime;
    }

    @Override
    public void attack() {

    }
}
