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

    public PizzaGpsThread(NeedleActivity needleActivity, PhoneGPS phoneGPS, PhoneCompass compass) throws PizzaException{
        Position myPos;

        this.needleActivity = needleActivity;

        this.phoneGPS = phoneGPS;
        this.compass = compass;

        if(!phoneGPS.allowedToUseGPS())
            throw new PizzaException(PizzaException.Error.NOT_ALLOWED_TO_USE_GPS);


        pizzeriaFinder = new PizzeriaFinder(new RealGoogleMapAPI());
        myPos = phoneGPS.getPhonePosition();

        bestPizzeria = pizzeriaFinder.getPizzeria(myPos);

        uu = new UpdateUi();
    }



    @Override
    public void run() {

        while(true){
            Message message = new Message();
            Position myPos = phoneGPS.getPhonePosition();
            int myBearing = compass.getPhoneBearing();

            int angle = myPos.bearingTo(bestPizzeria.pos, myBearing);

            uu.degree = angle;
            uu.pizzeriaName = bestPizzeria.name;
            Log.i("GPS Thread","A "+ angle);
            needleActivity.runOnUiThread(uu);
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
            String str = "Pizzeria: " + pizzeriaName + "\n" +
                    "Angle: " + degree;

            Log.i("Update UI",str);

            needleActivity.writeTextLine_1(pizzeriaName);
            needleActivity.writeTextLine_2("ANGLE: " + degree);
            needleActivity.rotateImage(degree);
        }
    }

}
