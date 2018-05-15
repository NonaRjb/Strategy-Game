import java.util.ArrayList;

public class Path {

    ArrayList<Coordinate> pathWay = new ArrayList<>();

    // Constructor
    public Path() {}

    // Other Methods
    public void buildPath(int x, int y){
        pathWay.add( new Coordinate(x,y) );
    }

}
