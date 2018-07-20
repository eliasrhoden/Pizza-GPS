package fatcat.pizzagps.GPS;

import fatcat.pizzagps.Position;

/**
 * Created by Elias on 2018-01-07.
 */

public interface PhoneGPS {

    Position getPhonePosition();

    /**
     * @return if the app is allowed to use the GPS/position, MUST BE TRUE for the app to work
     * */
    boolean allowedToUseGPS();

    void stopGPS();

    void startGPS();

    boolean positionAvaliable();

}
