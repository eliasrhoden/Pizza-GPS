package fatcat.pizzagps.GUI;

import android.os.Message;
import android.util.Log;

import fatcat.pizzagps.GPS.PhoneCompass;
import fatcat.pizzagps.GPS.PhoneGPS;
import fatcat.pizzagps.GoogleMap.RealGoogleMapAPI;
import fatcat.pizzagps.PizzaException;
import fatcat.pizzagps.Pizzeria;
import fatcat.pizzagps.PizzeriaFinder;
import fatcat.pizzagps.Position;


/**
 * Created by Elias on 2018-02-03.
 * Handles the Threading (multitasking), thats going to refresh the compass needle in the background.
 */

public class PizzaGpsThread extends Thread{

    private PhoneGPS phoneGPS;
    private PizzeriaFinder pizzeriaFinder;
    private final int UPDATE_INTERVAL_MS = 1000/24;
    private Pizzeria bestPizzeria;
    private NeedleActivity needleActivity;
    private PhoneCompass compass;
    private UpdateUi uu;
    private boolean keepRunning;

    public PizzaGpsThread(NeedleActivity needleActivity, PhoneGPS phoneGPS, PhoneCompass compass){
        this.needleActivity = needleActivity;
        this.phoneGPS = phoneGPS;
        this.compass = compass;

        keepRunning = true;
        uu = new UpdateUi();
    }


    @Override
    public void run() {
        Position myPos;
        pizzeriaFinder = new PizzeriaFinder(new RealGoogleMapAPI());

        myPos = findMyPos();

        try {
            bestPizzeria = pizzeriaFinder.getPizzeria(myPos);
        } catch (PizzaException e) {
            uu.txtLine1 = "Kunde ej hitta någon pizzeria i din närhet!";
            uu.txtLine2 = "";
            uu.update();
            return;
        }

        while(keepRunning){
            //Log.i("THREAD", "Keep running: " + keepRunning);
            Message message = new Message();
            myPos = phoneGPS.getPhonePosition();
            int myBearing = compass.getPhoneBearing();

            int angle = myPos.bearingTo(bestPizzeria.pos, myBearing);

            uu.degree = angle;
            uu.txtLine1 = "Närmaste öppna pizzeria: " + bestPizzeria.name;
            uu.update();
            sleep(UPDATE_INTERVAL_MS);
        }
    }

    private Position findMyPos(){
        int deg = 0;
        while(!(phoneGPS.positionAvaliable())){
            uu.txtLine1 = "Söker efter telefonens position...";
            uu.txtLine2 = "";
            uu.degree = deg;
            uu.update();
            deg += 15;
            sleep(800);
        }
        return phoneGPS.getPhonePosition();
    }

    private void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void kill(){
        keepRunning = false;
    }

    public class UpdateUi implements Runnable{

        public int degree;
        public String txtLine1,txtLine2;

        @Override
        public void run() {
            needleActivity.writeTextLine_1(txtLine1);
            needleActivity.writeTextLine_2(txtLine2);
            needleActivity.rotateImage(degree);
        }

        public void update(){
            needleActivity.runOnUiThread(this);
        }
    }

}
