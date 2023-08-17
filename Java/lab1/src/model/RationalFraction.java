package model;

/**
 * This is the class of Rational Fraction
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class RationalFraction {
    /**
     * x component - numerator
     */
    private final double x;

    /**
     * x component getter
     * @return numerator
     */
    public double getNumerator() {
        return x;
    }


    /**
     *
     */
    private final double y;

    /**
     * y component getter
     * @return y component of point
     */
    public double getDenominator() {
        return y;
    }

    /**
     * Constructor of point with given (x, y) coordinates
     * @param x component of fraction
     * @param y component of fraction
     */
    public RationalFraction(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Default constructor to create (0, 0) fraction
     */
    public RationalFraction(){
        this.x = 0;
        this.y = 1;
    }

    public double toDouble(){
        return this.x / this.y;
    }
    @Override
    public String toString() {
        return "( " + x + " / " + y + " )";
    }

}


