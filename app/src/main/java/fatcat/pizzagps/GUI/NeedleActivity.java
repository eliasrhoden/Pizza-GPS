package fatcat.pizzagps.GUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.WindowManager;
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
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private void startPizzaGps(){
        threadPool = createThreadPool();

        gps = new GPSZ(this);
        compass = new PhoneCompass(this);

        pizzaThread = new PizzaGpsThread(this, gps, compass);
        threadPool.execute(pizzaThread);
    }

    @Override
    public void onPause(){
        super.onPause();
        stopGPS();
        Log.i("NeeldeAct","ON PAUSE");
    }

    @Override
    public void onStop(){
        super.onStop();
        stopGPS();
        Log.i("NeeldeAct","ON STOP");

    }

    @Override
    public void onResume(){
        super.onResume();
        startPizzaGps();
        Log.i("NeeldeAct","RESUME");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        startPizzaGps();
        Log.i("NeeldeAct","RESTART");
    }

    private void stopGPS(){
        compass.stopCompassUpdate();
        gps.stopGPS();
        threadPool.shutdownNow();
        threadPool.shutdown();
        pizzaThread.kill();
        //pizzaThread.destroy();
        //pizzaThread.suspend();
        Log.i("NeeldeAct","Stopped Gps");
        this.finish();
    }


    public void writeTextLine_2(String txt){
        TextView closePizz = findViewById(R.id.closePizzeria);
        closePizz.setText(txt);
    }

    public void writeTextLine_1(String txt){
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
