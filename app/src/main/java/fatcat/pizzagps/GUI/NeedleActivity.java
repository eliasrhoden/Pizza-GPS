package fatcat.pizzagps.GUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import fatcat.pizzagps.GPS.GPSZ;
import fatcat.pizzagps.GPS.PhoneCompass;
import fatcat.pizzagps.GPS.PhoneGPS;
import fatcat.pizzagps.PizzaException;
import fatcat.pizzagps.R;

public class NeedleActivity extends AppCompatActivity implements NeedleUI {

    public final int IMG_OFFSET_DEG = +90;
    private static ThreadPoolExecutor threadPool;
    private PizzaGpsThread pizzaThread;
    private PhoneCompass compass;
    private PhoneGPS gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needle);
        threadPool = createThreadPool();

        gps = new GPSZ(this);
        compass = new PhoneCompass(this);

        try {
            pizzaThread = new PizzaGpsThread(this, gps, compass);
            threadPool.execute(pizzaThread);
        } catch (PizzaException e) {

            switch(e.error){
                case FAILED_TO_RETRIEVE_POSITION:
                    break;
                case FAILED_TO_RETRIEVE_PIZZERIAS:
                    break;
                case NO_PIZZERIA_IS_OPEN:
                    break;
                case NOT_ALLOWED_TO_USE_GPS:
                    break;
                default:

            }

            e.printStackTrace();
            Log.i("VAAAAAA","HITTADE DEN INGEN PIZZERIA`????");
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        stopGPS();
    }

    @Override
    public void onStop(){
        super.onStop();
        stopGPS();
        threadPool.shutdown();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onRestart(){
        super.onRestart();
    }

    private void stopGPS(){
        compass.stopCompassUpdate();
        gps.stopGPS();
    }

    private void restartGPS(){

    }

    public void writeTextLine_1(String txt){
        TextView closePizz = findViewById(R.id.closePizzeria);
        closePizz.setText(txt);
    }

    public void writeTextLine_2(String txt){
        TextView yourPos = findViewById(R.id.yourPos);
        yourPos.setText(txt);
    }

    public void writeTextLine_3(String txt){
        TextView pizzaPos = findViewById(R.id.pizzeriaPos);
        pizzaPos.setText(txt);
    }

    public void rotateImage(double degrees){
        ImageView img = findViewById(R.id.arrow_view);
        float dg = (float) degrees + IMG_OFFSET_DEG;
        img.setRotation(dg);
    }

    private static ThreadPoolExecutor createThreadPool(){
        int timeUntilTerminate = 1;
        TimeUnit timeUntilTerminateUnits = TimeUnit.SECONDS;
        int noOfCores = Runtime.getRuntime().availableProcessors();

        return new ThreadPoolExecutor(
                noOfCores,
                noOfCores,       // Max pool size
                timeUntilTerminate,
                timeUntilTerminateUnits,
                new LinkedBlockingDeque<Runnable>());
    }
}
