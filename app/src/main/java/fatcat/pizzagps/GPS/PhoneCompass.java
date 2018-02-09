package fatcat.pizzagps.GPS;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;


/**
 * Created by Elias on 2018-02-04.
 */

public class PhoneCompass {

    private int lastBearing = -1;
    private final int REFRESH_RATE_us = 1000;
    private SensorManager sensorManager;
    private CompassSensorListener compassListener;

    public PhoneCompass(Context c){
        Log.i("GGGG","CREATED COMPASS");
        sensorManager = (SensorManager) c.getSystemService(Context.SENSOR_SERVICE);
        Sensor orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        compassListener = new CompassSensorListener();
        sensorManager.registerListener(compassListener,orientationSensor,REFRESH_RATE_us);
    }

    /***
     * @returns Angle of the north-pole, 0 deg = phone is pointing to north
     * 90 deg = phone pointing east, 270 deg = phone facing west
     */
    public int getPhoneBearing(){
        while(lastBearing == -1);
        System.out.println("RETURNING " + lastBearing);
        System.out.println(this);
        return lastBearing;
    }

    public void stopCompassUpdate(){
        sensorManager.unregisterListener(compassListener);
    }

    class CompassSensorListener implements SensorEventListener{

        private final int INDEX_DEGREE_TO_NORTH = 0;
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(isBadSensorEvent(sensorEvent))
                return;
            float rawVal = sensorEvent.values[INDEX_DEGREE_TO_NORTH];
            lastBearing = (int) rawVal;
            Log.i("GPS","New Bearing: " + lastBearing);

        }

        private boolean isBadSensorEvent(SensorEvent sensorEvent){
            return (sensorEvent.accuracy == SensorManager.SENSOR_STATUS_ACCURACY_LOW) ||
                    (sensorEvent.sensor.getType() != Sensor.TYPE_ORIENTATION);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
            // I dunno... lol
        }
    }

}
