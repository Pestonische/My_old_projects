package model;


import java.util.TreeMap;

/**
 * This is the class of Circle with some functions to work with it
 *
 * @author Kozunov Alexei
 * @version 1.0.0
 */
public class Circle {

    /**
     * X is horizontal coordinate of circle
     */
    private RationalFraction X;

    /**
     * X point getter
     * @return X coordinate of circle
     */
    public RationalFraction getX() {
        return X;
    }

    /**
     * Y is vertical coordinate of circle
     */
    private RationalFraction Y;

    /**
     * Y coordinate getter
     * @return Y point
     */
    public RationalFraction getY() {
        return Y;
    }

    /**
     * radius is circle radius
     */
    private RationalFraction radius;

    /**
     * radius getter
     * @return radius
     */
    public RationalFraction getRadius() {
        return radius;
    }

    /**
     * square of circle
     */
    private final double square;

    /**
     * quadrilateral square getter
     * @return square of quadrilateral
     */
    public double getSquare() {
        return square;
    }

    /**
     * perimeter of quadrilateral
     */
    private final double perimeter;

    /**
     * quadrilateral perimeter getter
     * @return perimeter of quadrilateral
     */
    public double getPerimeter() {
        return perimeter;
    }


    /**
     * Constructor of circle with count square and perimeter, recognize type
     *
     * @param X of circle
     * @param Y point of quadrilateral
     * @param radius point of circle
     */
    public Circle(RationalFraction X, RationalFraction Y, RationalFraction radius) {

        this.X = X;
        this.Y = Y;
        this.radius = radius;
        perimeter = countPerimeter();
        square = countSquare();
    }

    public boolean checkLine(Circle m, Circle k) {
        return (this.getX().toDouble() - m.getX().toDouble()) / (this.getY().toDouble() - m.getY().toDouble()) ==
                (this.getX().toDouble() - k.getX().toDouble()) / (this.getY().toDouble() - k.getY().toDouble());
    }

    /**
     * count perimeter of circle
     */
    private double countPerimeter() {

        return 2* Math.PI * Math.abs(this.getRadius().toDouble());
    }

    /**
     * count square of circle
     */
    private double countSquare() {
        return Math.PI * Math.pow(getRadius().toDouble(), 2);
    }

    @Override
    public String toString() {
        return String.format("X - %s\nY - %s\nradius - %s\nperimeter is %.2f\nsquare is %.2f\n",
                X.toString(),
                Y.toString(),
                radius.toString(),
                perimeter,
                square);
    }

}
