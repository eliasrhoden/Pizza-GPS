package fatcat.pizzagps.GPS;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
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
    private final long MIN_UPDATE_TIME_ms = 1000;

    @SuppressLint("MissingPermission")
    public GPSZ(Context C) {
        context = C;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LOCATION_PROVIDER,MIN_UPDATE_TIME_ms,MIN_UPDATE_DISTANCE_m,this);
        lastKnownLocation = locationManager.getLastKnownLocation(LOCATION_PROVIDER);
    }

    @Override
    public Position getPhonePosition() {
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

    @Override
    public synchronized void onLocationChanged(Location location) {
        lastKnownLocation = location;
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
}
