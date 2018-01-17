package fatcat.pizzagps;


/**
 * Created by Elias on 2018-01-10.
 */

public class RealGoogleMapAPI implements GoogleMapAPI {

    private final String API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private final String API_KEY = "AIzaSyA5HG-b4hfxLxiEFkxBXtHbC9YZbQyGOjQ";
    private HTTP_Request request;

    public static void test() {
        //Send a reqeust as a test. (Not to be used in JUnit!)
        RealGoogleMapAPI api = new RealGoogleMapAPI();
        System.out.println("Test GRÅBO as location");
        Position grabo = new Position(57.83977,12.28821);
        String response =  api.positionSearch("pizzeria",grabo);
        System.out.println(response);
    }

    public RealGoogleMapAPI(){
        request = new HTTP_Request(API_URL);
        request.addUrlParams("key",API_KEY);
        request.addUrlParams("rankby","distance");
        request.setRequestMethod(HTTP_Request.RequestMethod.GET);
    }

    @Override
    public String positionSearch(String keyWord, Position pos) {
        String res = "";
        request.removeUrlParams("location");
        request.removeUrlParams("keyword");
        request.addUrlParams("location",getLocationString(pos));
        request.addUrlParams("keyword",keyWord);
        try {
            res = request.send();
        } catch (Exception e) {
            e.printStackTrace();
            res = "Failed to connect to Server!";
        }
        return res;
    }

    private String getLocationString(Position pos) {
        return pos.latitude + ","+pos.longitude;
    }


}
