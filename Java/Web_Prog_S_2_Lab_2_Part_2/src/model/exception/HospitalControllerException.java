package model.exception;

/**
 * controller excepton
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class HospitalControllerException extends Exception {

	/**
     * Constructor with specified string
     *
     * @param message string
     */
    public HospitalControllerException(String message) {
        super(message);
    }

    /**
     * Constructor with specified string and exception
     *
     * @param message string
     * @param e       error covered
     */
    public HospitalControllerException(String message, Throwable e) {
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
