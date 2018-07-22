package fatcat.pizzagps.GPS;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import fatcat.pizzagps.Position;

/**
 * Created by Nisse on 2018-01-16.
 */

public class GPSZ implements PhoneGPS, LocationListener {

    private LocationManager locationManager;
    private Context context;
    private Location lastKnownLocation;
    private final String LOCATION_PROVIDER = LocationManager.GPS_PROVIDER;
    private final float MIN_UPDATE_DISTANCE_m = 5;
    private final long MIN_UPDATE_TIME_ms = 500;
    private final float MAX_ACCURACY = 40;
    private final int MAX_AGE_OF_LOCATION_MIN = 5;

    @SuppressLint("MissingPermission")
    public GPSZ(Context C) {
        context = C;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LOCATION_PROVIDER,MIN_UPDATE_TIME_ms,MIN_UPDATE_DISTANCE_m,this);
        tryOldPos(locationManager.getLastKnownLocation(LOCATION_PROVIDER));
    }

    @Override
    public Position getPhonePosition() {
        while(lastKnownLocation==null);
        return new Position(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }

    @Override
    public boolean allowedToUseGPS() {
        boolean permitted = ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        return permitted;
    }

    public void stopGPS(){
        locationManager.removeUpdates(this);
    }

    @SuppressLint("MissingPermission")
    public void startGPS(){
        locationManager.requestLocationUpdates(LOCATION_PROVIDER,MIN_UPDATE_TIME_ms,MIN_UPDATE_DISTANCE_m,this);
    }


    @Override
    public synchronized void onLocationChanged(Location location) {
        Log.i("GPS","POS ACC: " + location.getAccuracy());
        if(location.getAccuracy()<MAX_ACCURACY){
            lastKnownLocation = location;
        }
    }

    private void tryOldPos(Location location){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            long locationAgeNanos =
                    SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos();
            double locationAgeMinutes =  locationAgeNanos/(Math.pow(10,9)*60);
            if(locationAgeMinutes<MAX_AGE_OF_LOCATION_MIN){
                tryNewPos(location);
            }
        }
    }

    private synchronized void tryNewPos(Location location){
        Log.i("GPS","POS ACC: " + location.getAccuracy());
        if(location.getAccuracy()<MAX_ACCURACY){
            lastKnownLocation = location;
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
    @Override
    public synchronized boolean positionAvaliable(){
        return lastKnownLocation != null;
    }

}
