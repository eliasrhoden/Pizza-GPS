package fatcat.pizzagps.GoogleMap;

import fatcat.pizzagps.Position;

/**
 * Created by Elias on 2018-01-08.
 */

public interface GoogleMapAPI {
    String positionSearch(String keyWord, Position pos);
}
