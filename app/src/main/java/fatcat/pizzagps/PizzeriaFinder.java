package fatcat.pizzagps;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fatcat.pizzagps.GoogleMap.GoogleMapAPI;
import fatcat.pizzagps.GoogleMap.RealGoogleMapAPI;

/**
 * Created on 2018-01-07.
 */

public class PizzeriaFinder {

    private GoogleMapAPI api;

    public PizzeriaFinder(GoogleMapAPI api){
        this.api = api;
    }

    public List<Pizzeria> getNearByPizzerias(Position position){

        List<Pizzeria> result = new ArrayList<>();
        String rawResponse = api.positionSearch("pizzeria",position);
        JSONArray pizzerias = parseJsonArray(rawResponse);

        for(int i = 0;i<pizzerias.length();i++){
            try {
                Pizzeria pizzeria = parsePizzeria(pizzerias.getJSONObject(i));
                result.add(pizzeria);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
       
    public Pizzeria getBetsPizzeria(List<Pizzeria> pizzerias){
        //TODO
        return null;
    }

    public Pizzeria getBestPizzeria(Position myPos, List<Pizzeria> pizzerias) throws Exception {
        //TODO create better algorithm to determine best pizzeria
        Pizzeria best = null;
        for(Pizzeria p:pizzerias){
            if(p.openNow){
                best = p;
                break;
            }
        }
        if(best == null)
            throw new Exception("Didn't found any open pizzerias close by!");
        return best;
    }

    private JSONArray parseJsonArray(String rawResponse) {
        JSONObject responseAsJson;
        JSONArray array = null;
        try {
            responseAsJson = new JSONObject(rawResponse);
        } catch (JSONException e) {
            e.printStackTrace();
            responseAsJson = writeErrorMsgToJSON();
        }

        try {
            array = responseAsJson.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
            responseAsJson = writeErrorMsgToJSON();
        }
        return array;
    }

    private JSONObject writeErrorMsgToJSON(){
        JSONObject res = null;
        try {
            res = new JSONObject("{Error: \"Failed to parse JSON\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    private Pizzeria parsePizzeria(JSONObject pizzeriaInJSON) {
        Pizzeria p = new Pizzeria();
        p.name = retriveString(pizzeriaInJSON,"name");
        p.id = retriveString(pizzeriaInJSON,"id");
        p.place_id = retriveString(pizzeriaInJSON,"place_id");
        p.rating = retriveDouble(pizzeriaInJSON,"rating");
        p.openNow = isPizzeriaOpen(pizzeriaInJSON);
        p.pos = parsePizzeriaPos(pizzeriaInJSON);
        return p;
    }

    private Position parsePizzeriaPos(JSONObject pizzeriaInJSON) {
        JSONObject location = null;
        double lat = 0,lon = 0;
        try {
            location = pizzeriaInJSON.getJSONObject("geometry").getJSONObject("location");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            lat = location.getDouble("lat");
            lon = location.getDouble("lng");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Position(lat,lon);
    }

    private boolean isPizzeriaOpen(JSONObject pizzeriaInJSON) {
        JSONObject openHours = null;
        boolean res = false;
        try {
            openHours = pizzeriaInJSON.getJSONObject("opening_hours");
        } catch (JSONException e) {
        }

        try {
            res = openHours.getBoolean("open_now");
        } catch (Exception e) {
            //If Google don't know the opening hours of this pizzeria, assume its closed.
            res = false;
        }
        return res;
    }

    private String retriveString(JSONObject json, String key){
        String res = "";
        try {
            res = json.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    private double retriveDouble(JSONObject json, String key){
        double res = 0;
        try {
            res = json.getDouble(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void test(){
        //NOT to be used bu JUnit!!!

        PizzeriaFinder finder = new PizzeriaFinder(new RealGoogleMapAPI());
        Position grabo = new Position(57.83977,12.28821);
        List<Pizzeria> pizzerias = finder.getNearByPizzerias(grabo);
        System.out.println("Found pizzerias: ");
        for(Pizzeria p:pizzerias){
            Log.i("- ",p.toString());
        }



    }

}
