public class HockeyMaskMan extends Invader implements InvaderAttack{
    protected int shootPower;
    protected Time attackRateTime;

    HockeyMaskMan(){

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
