package fatcat.pizzagps;

/**
 * Created on 2018-01-07.
 */

public class Position {
    public double latitude;
    public double longitude;
    private static double errorMargin = 0.001;

    public Position(double la,double lo){
        latitude = la;
        longitude = lo;
    }

    public static double distance(Position p1,Position p2){
        //TODO
        return -1;
    }

    @Override
    public boolean equals(Object otherPos){
        if(otherPos instanceof Position){
            Position oP = (Position) otherPos;
            if(closeEnough(longitude,oP.longitude) && closeEnough(latitude,oP.latitude))
                return true;
        }
        return false;
    }

    private static boolean closeEnough(double target, double val){
        return (val < (target + errorMargin)) && (val > (target - errorMargin));
    }
}
