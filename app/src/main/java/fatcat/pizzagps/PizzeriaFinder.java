package fatcat.pizzagps;

import java.util.List;

/**
 * Created on 2018-01-07.
 */

public interface PizzeriaFinder {

    List<Pizzeria> getNearByPizzerias(Position position);

}
