package fatcat.pizzagps;

import java.util.Date;

/**
 * All properties of intrested regarding a pizzeria.
 */

public class Pizzeria {
    public String name;
    public double rating;
    public Position pos;
    public Date closingTime;
    public boolean openNow;
    //Not sure which ID is important, TODO: need to check the Google Ref.
    public String id;
    public String place_id;

    public int minutesUntilClosing(){
        //TODO
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        boolean res = false;
        if(obj instanceof Pizzeria){
            Pizzeria other = (Pizzeria) obj;
            res = objectEquals(other.name,name) &&
                    objectEquals(other.id,id) &&
                    objectEquals(other.place_id,place_id) &&
                    objectEquals(other.rating,rating) &&
                    objectEquals(other.openNow,openNow) &&
                    objectEquals(other.closingTime,closingTime) &&
                    objectEquals(other.pos,pos);
        }
        return res;
    }

    private boolean objectEquals(Object o1, Object o2){
        if(o1 == null && o2 == null)
            return true;
        if(o1 == null || o2 == null)
            return false;
        return o1.equals(o2);
    }

    @Override
    public String toString(){
        return "Pizzeria: " + name + "\n" +
                "Pos: " + pos + "\n" +
                "Open now: "+openNow;
    }

}
