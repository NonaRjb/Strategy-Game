public class HealthLevel {
    private int healthLevel;
    private int healthUnit;

    HealthLevel(int healthUnit){
       this.healthUnit = healthUnit;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public void decreaseHealth(int unitNum){
        this.healthLevel -= unitNum * healthUnit;
    }

    public void increaseHealth(int unitNum){
        this.healthLevel += unitNum * healthUnit;
    }

}

