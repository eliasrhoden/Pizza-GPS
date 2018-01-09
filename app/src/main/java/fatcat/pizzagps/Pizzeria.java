package fatcat.pizzagps;

import java.util.Date;

/**
 * All properties of intrested regarding a pizzeria.
 */

public class Pizzeria {
    public String name;
    public double rating;
    public Position pos;
    //public Date closingTime;
    public boolean openNow;
    public String id;
    public String place_id;

    public int minutesUntilClosing(){
        //TODO
        return 0;
    }
}
