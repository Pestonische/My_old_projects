package model;

import java.io.Serializable;

/**
 * Window auto part class
 */
public class Window extends model.AutoPart implements Serializable {
    private int tint;

    public int getTint() {
        return tint;
    }

    /**
     * Window constructor
     * @param description_ description of a window
     * @param price_ price of a window
     * @param tint_ tint of a window
     */
    public Window(String description_, double price_, int tint_) {
        super(description_, price_);

        if (price_ > 0) {
            tint = tint_;
        }
        else {
            throw new IllegalArgumentException("Tint must be greater than 0");
        }
    }

    public String getSpecific() {
        return "Tint: " + String.valueOf(tint);
    };
}
