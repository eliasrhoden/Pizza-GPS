package fatcat.pizzagps;

import android.util.Log;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class HTTP_Request {

    private String url;
    private String response;
    private int responseCode;
    private boolean debugPrintEnabled;
    private HashMap<String,String> urlParams;
    private HashMap<String,String > headerParams;
    private Consumer<String> debug;
    private RequestMethod requestMethod;

    public enum RequestMethod {
        GET,POST
    }

    public HTTP_Request(String url){
        this.url = url;
        urlParams = new HashMap<>();
        headerParams = new HashMap<>();
    }

    public HTTP_Request(String url, boolean debugPrint){
        this(url);
        debugPrintEnabled = debugPrint;
    }

    public void setDebugPrintFunction(Consumer<String> function){
        debug = function;
    }

    public void setRequestMethod(RequestMethod req){
        requestMethod = req;
    }

    public String send() throws Exception{
        URL obj = new URL(url + "?" + getUrlParams());
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        setRequestMethodToConnection(con, requestMethod);

        con.setDoOutput(true);

        responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer httpResponse = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            httpResponse.append(inputLine);
        }
        in.close();
        response = httpResponse.toString();

        printDebugInfo(obj,responseCode,response);

        return response;
    }

    private void printDebugInfo(URL url,int responseCode,String response){
        if(debugPrintEnabled) {

            Log.i("HTTP Request","\nSending "+ requestMethod + " request to URL : " + url.toString());
            Log.i("HTTP Request","Post parameters : " + headerParams);
            Log.i("HTTP Request","Response Code : " + responseCode);
            Log.i("HTTP Request",response);
        }
    }

    private void setRequestMethodToConnection(
            HttpsURLConnection con,
            RequestMethod requestMethod) throws ProtocolException {
        switch (requestMethod){
            case GET:
                con.setRequestMethod("GET");
                break;
            case POST:
                con.setRequestMethod("POST");
                break;
            default:

        }
    }

    public void addUrlParams(String parName,String value){
        urlParams.put(parName,value);
    }

    public void removeUrlParams(String parName){
        urlParams.remove(parName);
    }

    public void addHeaderParams(String parName,String value){
        headerParams.put(parName,value);
    }

    private String getUrlParams(){
        String res = "";
        boolean first = true;
        for(Map.Entry<String,String> entry:urlParams.entrySet()){
            if(!first) res += "&";
            first = false;
            res += entry.getKey() + "=" + entry.getValue();
        }
        return res;
    }

    private void writeHeaderParams(HttpURLConnection con){
        for(Map.Entry<String,String> entry:headerParams.entrySet()){
            con.addRequestProperty(entry.getKey(),entry.getValue());
        }
    }


    public int getResponseCode(){
        return responseCode;
    }

    public String getResponse(){
        return response;
    }

}

