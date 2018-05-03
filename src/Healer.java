public class Healer extends Invader implements InvaderAttack {
    private int healPower;
    private int healRate;

    public int getHealPower() {
        return healPower;
    }

    public int getHealRate() {
        return healRate;
    }

    public void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    public void setHealRate(int healRate) {
        this.healRate = healRate;
    }

    @Override
    public void attack() {

    }
}
