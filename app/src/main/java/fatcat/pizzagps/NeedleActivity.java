package fatcat.pizzagps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;

public class NeedleActivity extends AppCompatActivity {

    private PizzaGPS pizzaGPS;
    private PizzeriaFinder pizzeriaFinder;
    private PhoneGPS gps;
    private Pizzeria bestPizzeria;

    public NeedleActivity(){
        gps = null; //TODO waiting for implementation
        pizzeriaFinder = new PizzeriaFinder(new RealGoogleMapAPI());
        try {
            bestPizzeria = pizzeriaToPointAt();
            pizzaGPS = new PizzaGPS(bestPizzeria.pos);
        } catch (Exception e) {
            //TODO Display that no pizzeria was found...
        }
    }

    private Pizzeria pizzeriaToPointAt() throws Exception {
        Position phonePos = gps.getPhonePosition();
        List<Pizzeria> pz = pizzeriaFinder.getNearByPizzerias(phonePos);
        return pizzeriaFinder.getBestPizzeria(phonePos,pz);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needle);


        //Un-comment to start the needle updating
        //needleUpdate.start();

        //Start of test-Code

        testGPS();

        final Thread imgRot = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<360;i+=30){
                    rotateImage(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
        });

        imgRot.start();
        //End of test-code
    }


    private void testGPS(){
        Log.i("","GPS===================");
        PhoneGPS gps = new GPSZ(this);
        Position p = gps.getPhonePosition();
        Log.i("GPS: ",p.toString());
    }


    private void rotateImage(double degrees){
        ImageView img = findViewById(R.id.arrow_view);
        float dg = (float) degrees;
        img.setRotation(dg);
    }

    private Thread needleUpdate = new Thread(new Runnable() {
        private final int UPDATE_INTERVAL_ms = 800;
        @Override
        public void run() {
            updatePizzaGPS();
            int needleAngle = pizzaGPS.getBearingToPizzeria();
            rotateImage(needleAngle);
            try {
                Thread.sleep(UPDATE_INTERVAL_ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void updatePizzaGPS(){
            Position myPos = gps.getPhonePosition();
            int phoneBearing = gps.getPhoneBearing();
            pizzaGPS.setMyPosition(myPos,phoneBearing);
        }

    });



}
