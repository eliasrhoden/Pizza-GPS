package fatcat.pizzagps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

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
        Location lastKnownLocation = getLoc();

        return new Position(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }

    @Override
    public int getPhoneBearing() {

        return Math.round(getLoc().getBearing());
    }

    private Location getLoc(){
        String locationProvider = LocationManager.NETWORK_PROVIDER;
// Or use LocationManager.GPS_PROVIDER

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null; // TODO
        }
        return locationManager.getLastKnownLocation(locationProvider);
    }
}
