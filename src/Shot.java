abstract class Shot {

    protected int power;
    protected Coordinate coordinate;
    protected Object target;

    final int BulletSpeed = 10;

    // Getters
    public Coordinate getCoordinate() { return coordinate; }
    public int getPower() {
        return power;
    }
    public Object getTarget() { return target; }
    public int getBulletSpeed() {
        return BulletSpeed;
    }

    // Setters
    public void setCoordinate(Coordinate coordinate) { this.coordinate = coordinate; }

    // ToDo each shot's owner

}
