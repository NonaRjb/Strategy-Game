public class HealthLevel {
    private int healthLevel;

    HealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public void decreaseHealth(int percentage){
        this.healthLevel -= percentage;
    }

    public void increaseHealth(int percentage){
        this.healthLevel += percentage;
    }

}

