public class Hopper extends Invader implements InvaderAttack{
    private int shootPower;
    private Time attackRateTime;

    Hopper(){

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

    public void accelerate(){

    }

    @Override
    public void attack() {

    }
}
