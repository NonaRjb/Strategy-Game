public class HealthLevel {
    private int healthLevel;
    final int armoryHealthUnit = 5;

    public HealthLevel(int healthDegree) {
        this.healthLevel = healthDegree * armoryHealthUnit;
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

