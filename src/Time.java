public class Time {
    private int time;

    // Constructor
    public Time(int time) {
        this.time = time;
    }

    // Getters
    public int getTime() {
        return time;
    }

    // Setters
    public void setTime(int time) {
        this.time = time;
    }

    // Other Methods
    public void increaseTime(){
        this.time++;
    }
}
