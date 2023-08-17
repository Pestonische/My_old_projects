package model;

import java.io.Serializable;

/**
 * Auto part base class
 */
public class AutoPart implements Serializable {
    private String description;
    private double price;

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    };

    public String getName() {
        return this.getClass().getName().substring(6);
    };

    public String getSpecific() {
        return "";
    };

    /**
     * AutoPart constructor
     * @param description_ description of an auto part
     * @param price_ price of an auto part
     */
    public AutoPart(String description_, double price_) {
        description = description_;

        if (price_ > 0) {
            price = price_;
        }
        else {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

    /**
     * Default AutoPart constructor
     */
    public AutoPart() {
        description = "";
        price = 0;
    }
}