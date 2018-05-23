public class Coordinate {
    private int x;
    private int y;

    //constructor
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    static int distance( Coordinate C1, Coordinate C2 ){

        double d = Math.sqrt(Math.pow( (C1.getX() - C2.getX()), 2) + Math.pow( (C1.getY() - C2.getY()), 2) ) ;
        return (int)d;

    }

}

