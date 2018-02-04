package fatcat.pizzagps.GPS;

import android.location.Location;
import android.util.Log;

import fatcat.pizzagps.Position;

/**
 * Created on 2018-01-07.
 */

public class PizzaGPS {

    private Position pizzeriaPos;
    private Position myPosition;
    private int myBearing;

    public PizzaGPS(Position pizzeriaPos){
        this.pizzeriaPos = pizzeriaPos;
    }

    public void setMyPosition(Position myPos, int myBearing){
        this.myPosition = myPos;
        this.myBearing = myBearing;
    }

    //Returns degrees, 0 deg = straight ahead, 90 deg = Left, 270 = Right
    public int getBearingToPizzeria(){
        if (myPosition == null)
                return -1;
        double xMe = myPosition.latitude;
        double yMe = myPosition.longitude;

        double xP = pizzeriaPos.latitude;
        double yP = pizzeriaPos.longitude;

        double x = xP - xMe;
        double y = yP - yMe;

        double res = Math.atan(x/y)*180/Math.PI;

        Log.i("degre","VINKEL: " + res);

        return (int) res;
    }

    //Returns meters, 'Fågelvägen'
    public long getDistanceToPizzeria(){
        //TODO
        return -1;
    }

}
