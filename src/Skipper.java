public class Skipper extends Invader implements InvaderAttack{
    private int shootPower;
    private Time attackRaateTime;

    public int getShootPower() {
        return shootPower;
    }

    public Time getAttackRaateTime() {
        return attackRaateTime;
    }

    public void setShootPower(int shootPower) {
        this.shootPower = shootPower;
    }

    public void setAttackRaateTime(Time attackRaateTime) {
        this.attackRaateTime = attackRaateTime;
    }

    @Override
    public void attack() {

    }
}
