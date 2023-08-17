package model;

import java.io.Serializable;

/**
 * Engine auto part class
 */
public class Engine extends model.AutoPart implements Serializable {
    private int power;

    public int getPower() {
        return power;
    }

    /**
     * Egine constructor
     * @param description_ description of an engine
     * @param price_ price of an engine
     * @param power_ power of an engine
     */
    public Engine(String description_, double price_, int power_) {
        super(description_, price_);

        if (power_ > 0) {
            power = power_;
        }
        else {
            throw new IllegalArgumentException("Power must be greater than 0");
        }
    }

    public String getSpecific() {
        return "Power: " + String.valueOf(power);
    };
}
