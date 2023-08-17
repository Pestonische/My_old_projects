package model;

import java.io.Serializable;

/**
 * Wheel auto part class
 */
public class Wheel extends AutoPart implements Serializable {
    private int radius;

    public int getRadius() {
        return radius;
    }

    /**
     * Wheel constructor
     * @param description_ description of a wheel
     * @param price_ price of a wheel
     * @param radius_ radius of a wheel
     */
    public Wheel(String description_, double price_, int radius_) {
        super(description_, price_);

        if (price_ > 0) {
            radius = radius_;
        }
        else {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
    }

    public String getSpecific() {
        return "Radius: " + String.valueOf(radius);
    };
}
