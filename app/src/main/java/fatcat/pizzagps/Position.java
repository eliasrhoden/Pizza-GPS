package fatcat.pizzagps;

import android.location.Location;

/**
 * Created on 2018-01-07.
 */

public class Position{
    public double latitude;
    public double longitude;
    private static double errorMargin = 0.001;

    public Position(double la,double lo){
        latitude = la;
        longitude = lo;
    }
    /**
    * @returns distance between two positions in METERS!
    * */
    public static double distance(Position p1,Position p2){
        Location l1 = parseLocation(p1);
        Location l2 = parseLocation(p2);

        return l1.distanceTo(l2);
    }

    public static Location parseLocation(Position p){
        Location loc = new Location("Position Parsed");
        loc.setLongitude(p.longitude);
        loc.setLatitude(p.latitude);
        return loc;
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


    //Returns degrees, 0 deg = straight ahead, 90 deg = Left, 270 = Right
    public int bearingTo(Position other, int myBearing){

        double myX, myY,pX,pY,x ,y;
        int res = 0;
        myX = longitude;
        myY = latitude;
        pX = other.longitude;
        pY = other.latitude;

        x = pX - myX;
        y = pY - myY;

        res =(int) Math.atan(y/x);

        return res - myBearing;
    }

    public double distanceTo(Position other){
        return distance(this,other);
    }

    @Override
    public String toString(){
        return "[LAT: "+latitude+"; LONG: "+longitude+"]";
    }

    private static boolean closeEnough(double target, double val){
        return (val < (target + errorMargin)) && (val > (target - errorMargin));
    }
}
