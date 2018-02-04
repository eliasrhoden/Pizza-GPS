package fatcat.pizzagps.GUI;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

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

    public PizzaGpsThread(Activity needleActivity) throws PizzaException{
        Position myPos;
        Pizzeria bestPizzeria;
        if(handler == null){
            handler = new UiHandler(needleActivity);
        }
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
            int myBearing = phoneGPS.getPhoneBearing();

            angleToPizza.setMyPosition(myPos,myBearing);

            int angle = angleToPizza.getBearingToPizzeria();
            long dist = angleToPizza.getDistanceToPizzeria();

            message.arg1 = angle;
            message.obj = dist;
            handler.dispatchMessage(message);
            
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

    private class UiHandler extends Handler{

        private NeedleUI needleActivity;

        public UiHandler(Activity needleActivity){
            super(Looper.getMainLooper());
            this.needleActivity = (NeedleUI) needleActivity;
        }

        @Override
        public void handleMessage(Message msg){
            //Handles the message from the "Run" function.
            int angle = msg.arg1;
            long distance = (long) msg.obj;

            needleActivity.rotateImage(angle);
            Log.i("PizGpsThread","Updated needle");
        }
    }

}
