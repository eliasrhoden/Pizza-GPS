package fatcat.pizzagps.GUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fatcat.pizzagps.GPS.GPSZ;
import fatcat.pizzagps.GPS.PhoneGPS;
import fatcat.pizzagps.GPS.PizzaGPS;
import fatcat.pizzagps.GoogleMap.RealGoogleMapAPI;
import fatcat.pizzagps.Pizzeria;
import fatcat.pizzagps.PizzeriaFinder;
import fatcat.pizzagps.Position;
import fatcat.pizzagps.R;

public class NeedleActivity extends AppCompatActivity {

    private PizzaGPS pizzaGPS;
    private PizzeriaFinder pizzeriaFinder;
    private PhoneGPS gps;
    private Pizzeria bestPizzeria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needle);

        gps = new GPSZ(this);
        pizzeriaFinder = new PizzeriaFinder(new RealGoogleMapAPI());

        if(gps.allowedToUseGPS()){
            needleUpdate.start();
        }else{
            UserMsgBox.showMsgBox_OK("Platsåtkomst ej möjlig","Appen har inte behörig att läsa enhetes position, aktivera behörigheten under \"inställningar\"",this);
        }
    }

    private Pizzeria pizzeriaToPointAt(Position phonePos) throws Exception {
        List<Pizzeria> pz = pizzeriaFinder.getNearByPizzerias(phonePos);
        return pizzeriaFinder.getBestPizzeria(phonePos,pz);
    }

    private void test1() {
        try {
            Position phoneP = gps.getPhonePosition();
            bestPizzeria = pizzeriaToPointAt(phoneP);
            pizzaGPS = new PizzaGPS(bestPizzeria.pos);
            writeDebugTextFields(bestPizzeria,phoneP);
        } catch (Exception e) {
            //TODO Display that no pizzeria was found...
            Log.i("","Failed to retrive best pizzeria");
            TextView closePizz = findViewById(R.id.closePizzeria);

            closePizz.setText("Failed to recive pizzeria");
        }


    }

    private void writeDebugTextFields(Pizzeria p,Position phoneP){
        TextView closePizz = findViewById(R.id.closePizzeria);
        TextView yourPos = findViewById(R.id.yourPos);
        TextView pizzaPos = findViewById(R.id.pizzeriaPos);

        closePizz.setText("Närmaste pizzeria: "+p.name);
        yourPos.setText("Din position: "+phoneP.toString());
        pizzaPos.setText("Pizzerians pos: "+p.pos.toString());
    }

    private void writeTextLine_1(String txt){
        TextView closePizz = findViewById(R.id.closePizzeria);
        closePizz.setText(txt);
    }

    private void writeTextLine_2(String txt){
        TextView yourPos = findViewById(R.id.yourPos);
        yourPos.setText(txt);

    }

    private void writeTextLine_3(String txt){
        TextView pizzaPos = findViewById(R.id.pizzeriaPos);
        pizzaPos.setText(txt);
    }


    private void rotateImage(double degrees){
        ImageView img = findViewById(R.id.arrow_view);
        float dg = (float) degrees;
        img.setRotation(dg);
    }


    private Thread needleUpdate = new Thread(new Runnable() {
        private final int UPDATE_INTERVAL_ms = 500;
        @Override
        public void run() {
            while(true) {
                update();
                try {
                    Thread.sleep(UPDATE_INTERVAL_ms);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("Needle", "Lifebeat Thread");
            }
        }
    });

    private void update() {
        Position myPos = gps.getPhonePosition();
        writeTextLine_1("My position: "+myPos.toString());

    }

    private void updatePizzaGPS(){
        Position myPos = gps.getPhonePosition();
        writeTextLine_1("My position: "+myPos.toString());
        int phoneBearing = gps.getPhoneBearing();
        pizzaGPS.setMyPosition(myPos,phoneBearing);
    }

}
