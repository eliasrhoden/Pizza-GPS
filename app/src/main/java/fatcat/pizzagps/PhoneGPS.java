package fatcat.pizzagps;

/**
 * Created by Elias on 2018-01-07.
 */

public interface PhoneGPS {

    Position getPhonePosition();

    /***
     * @returns Angle of the north-pole, 0 deg = phone is pointing to north
     * 90 deg = phone pointing east, 270 deg = phone facing west
     */
    int getPhoneBearing();

    /**
     * @return if the app is allowed to use the GPS/position, MUST BE TRUE for the app to work
     * */
    boolean allowedToUseGPS();

}
