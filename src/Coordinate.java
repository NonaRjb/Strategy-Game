//import org.omg.PortableServer.THREAD_POLICY_ID;

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

    public boolean isEqual( Coordinate C ){
        if( C.getX()==this.getX() && C.getY()==this.getY() )
            return true;
        else
            return false;
    }

    public String showCoordinate( ){
        String s = "("+this.x+","+this.y+")";
        return s;
    }

    static int distance( Coordinate C1, Coordinate C2 ){
        double d = Math.sqrt(Math.pow( (C1.getX() - C2.getX()), 2) + Math.pow( (C1.getY() - C2.getY()), 2) ) ;
        return (int)d;
    }

    static Coordinate moveTo( Coordinate currentCoordinate, Coordinate finalCoordinate, int movement ){
        int d = Coordinate.distance( currentCoordinate, finalCoordinate );
        if( movement >= d ){
            return finalCoordinate;
        } else {
            int x = currentCoordinate.getX() + (int)( (double)( finalCoordinate.getX() - currentCoordinate.getX() ) * ((double)movement/(double)d ) );
            int y = currentCoordinate.getY() + (int)( (double)( finalCoordinate.getY() - currentCoordinate.getY() ) * ((double)movement/(double)d ) );
            return new Coordinate(x,y);
        }
    }

}

