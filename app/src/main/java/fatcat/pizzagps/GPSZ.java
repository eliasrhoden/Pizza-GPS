package fatcat.pizzagps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by Nisse on 2018-01-16.
 */

public class GPSZ implements PhoneGPS {


    private LocationManager locationManager;
    private Context context;

    public GPSZ(Context C) {
        context = C;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public Position getPhonePosition() {
        Log.i("","Reqeust phone pos FIST");
        Location lastKnownLocation = getLoc();

        return new Position(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }

    @Override
    public int getPhoneBearing() {

        return Math.round(getLoc().getBearing());
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

    @SuppressLint("MissingPermission")
    private Location getLoc(){
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        // Or use LocationManager.GPS_PROVIDER

        if(!(allowedToUseGPS()))
            Log.i("","Reqeust phone location");

        return locationManager.getLastKnownLocation(locationProvider);
    }
}
