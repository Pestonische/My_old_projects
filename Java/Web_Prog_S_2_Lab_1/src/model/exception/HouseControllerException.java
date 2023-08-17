package model.exception;

/**
 * controller excepton
 * @author Козунов Алексей
 * @version 1.0.0
 */
public class HouseControllerException extends Exception {

	/**
     * Constructor with specified string
     *
     * @param message string
     */
    public HouseControllerException(String message) {
        super(message);
    }

    /**
     * Constructor with specified string and exception
     *
     * @param message string
     * @param e       error covered
     */
    public HouseControllerException(String message, Throwable e) {
        super(message, e);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
	
}
