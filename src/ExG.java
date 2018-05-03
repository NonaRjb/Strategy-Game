public class ExG extends Invader implements InvaderAttack{
    private int shootPower;
    private Time attackRateTime;

    /////// constructor
    ExG(){

    }

    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRateTime() {
        return attackRateTime;
    }

    public void setAttackRateTime(Time attackRateTime) {
        this.attackRateTime = attackRateTime;
    }

    public void setShootPower(int shootPower) {
        this.shootPower = shootPower;
    }

    @Override
    public void attack() {

    }
}
