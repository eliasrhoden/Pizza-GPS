package fatcat.pizzagps;

/**
 * Created by Elias on 2018-02-04.
 */

public class PizzaException extends Exception{

    public static enum Error{
        NOT_ALLOWED_TO_USE_GPS("App is not allowed to read phone position."),
        FAILED_TO_RETRIEVE_POSITION("Failed to retrieve phone position."),
        FAILED_TO_RETRIEVE_PIZZERIAS("Failed to retrieve close by pizzerias."),
        NO_PIZZERIA_IS_OPEN("No pizzerias is open close by.");

        public String msg;

        Error(String msg){
            this.msg = msg;
        }
    }

    public Error error;

    public PizzaException(Error errorEnum){
        super(errorEnum.msg);
        error = errorEnum;

    }

}
