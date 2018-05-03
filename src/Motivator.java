public class Motivator extends Invader implements InvaderAttack {
    private int motivePower;
    private int motiveRate;

    Motivator(){

    }

    public int getMotivePower() {
        return motivePower;
    }

    public int getMotiveRate() {
        return motiveRate;
    }

    public void setMotivePower(int motivePower) {
        this.motivePower = motivePower;
    }

    public void setMotiveRate(int motiveRate) {
        this.motiveRate = motiveRate;
    }

    @Override
    public void attack() {

    }
}
