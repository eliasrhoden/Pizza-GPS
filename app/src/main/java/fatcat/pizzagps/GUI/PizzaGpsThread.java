package fatcat.pizzagps.GUI;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

import fatcat.pizzagps.GPS.GPSZ;
import fatcat.pizzagps.GPS.PhoneGPS;
import fatcat.pizzagps.GPS.PizzaGPS;
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

    private static Handler handler;
    private PhoneGPS phoneGPS;
    private PizzeriaFinder pizzeriaFinder;
    private PizzaGPS angleToPizza;
    private final int UPDATE_INTERVAL_MS = 500;
    private Pizzeria bestPizzeria;
    private NeedleActivity needleActivity;

    public PizzaGpsThread(NeedleActivity needleActivity) throws PizzaException{
        Position myPos;

        this.needleActivity = needleActivity;

        phoneGPS = new GPSZ(needleActivity);

        if(!phoneGPS.allowedToUseGPS())
            throw new PizzaException(PizzaException.Error.NOT_ALLOWED_TO_USE_GPS);


        pizzeriaFinder = new PizzeriaFinder(new RealGoogleMapAPI());
        myPos = phoneGPS.getPhonePosition();

        bestPizzeria = pizzeriaFinder.getPizzeria(myPos);


        angleToPizza = new PizzaGPS(bestPizzeria.pos);
        Log.i("BEST PIZZERIA",bestPizzeria.toString());
    }



    @Override
    public void run() {

        while(true){
            Message message = new Message();
            Position myPos = phoneGPS.getPhonePosition();
            int myBearing = 0;

            angleToPizza.setMyPosition(myPos,myBearing);

            int angle = angleToPizza.getBearingToPizzeria();
            long dist = angleToPizza.getDistanceToPizzeria();

            UpdateUi uu = new UpdateUi();
            uu.degree = angle;
            uu.pizzeriaName = bestPizzeria.name;

            needleActivity.runOnUiThread(uu);
            Log.i("GPS Thread","Updated MyPos");
            Log.i("GPS Thread",myPos.toString());
            Log.i("GPS Thread","My bearinf: " + myBearing);
            sleep(UPDATE_INTERVAL_MS);
        }
    }

    private void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public class UpdateUi implements Runnable{

        public int degree;
        public String pizzeriaName;

        @Override
        public void run() {
            needleActivity.writeTextLine_1(pizzeriaName);
            needleActivity.writeTextLine_2("ANGLE: " + degree);
            needleActivity.rotateImage(degree);
        }
    }

    private class UiHandler extends Handler{

        private WeakReference<NeedleActivity> needleActivity;
        private int angle;
        private long distance;

        public UiHandler(NeedleActivity needleActivity){
            super(Looper.getMainLooper());
            this.needleActivity = new WeakReference<NeedleActivity>(needleActivity);
        }

        @Override
        public void handleMessage(Message msg){
            //Handles the message from the "Run" function.
            NeedleActivity needleA = needleActivity.get();

            angle = msg.arg1;
            distance = (long) msg.obj;

            needleA.writeTextLine_1("HEH");
            //needleActivity.writeTextLine_2("Angle: " + angle);

            needleA.rotateImage(angle);
            Log.i("PizGpsThread","Updated needle");
        }

        private void update(){

        }

    }

}
