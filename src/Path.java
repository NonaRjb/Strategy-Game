import java.util.ArrayList;

public class Path {

    private ArrayList<Coordinate> pathWay = new ArrayList<>();

    // Constructor
    public Path() {}

    // Other Methods
    public void buildPath(int x, int y){
        pathWay.add( new Coordinate(x,y) );
    }

    // checks if the path contains the given coordinate
    public Boolean isInWay(Coordinate coordinate){
        for (Coordinate pathCoor : pathWay){
            if (pathCoor.getX() == coordinate.getX() && pathCoor.getY() == coordinate.getY()){
                    return true;
            }
        }
        return false;
    }

    // gives the next coordinate of a given coordinate of a path
    // if the given coordinate is the last coordinate of the path the method returns (450,1599)
    public Coordinate nextCoordinate(Coordinate coordinate){
        int index = -2;
        for (Coordinate pathCoor : pathWay){
            if(pathCoor.getX() == coordinate.getX() && pathCoor.getY() == coordinate.getY()){
                index = pathWay.indexOf(pathCoor);
            }
        }
        if(pathWay.size()-1 == index){
            Coordinate nextCoordinate = new Coordinate(450, 1599);
            return nextCoordinate;
        }
        else {
            return pathWay.get(index+1);
        }
    }
}
