package controller;

import java.io.Serializable;
import java.util.Comparator;
import model.*;

/**
 * AutoPart comparator by price
 */
public class PriceComparator implements Comparator<AutoPart>, Serializable {
    public int compare(AutoPart o1, AutoPart o2) {
        if (o1.getPrice() < o2.getPrice()) return -1;
        if (o1.getPrice() > o2.getPrice()) return 1;
        return 0;
    }
}
