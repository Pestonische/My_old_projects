package model;

import controller.PriceComparator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Singleton AutoPartsStore class
 */
public class AutoPartsStore implements Serializable {
    private static AutoPartsStore instance = new AutoPartsStore();
    private static ArrayList<AutoPart> autoParts = new ArrayList<AutoPart>();

    /**
     * Getting unique instance of the AutoPartsStore
     * @return an instance of the AutoPartsStore
     */
    public static AutoPartsStore getInstance() {
        return instance;
    }

    /**
     * Getting all auto parts of the store
     * @return ArrayList of all auto parts of the store
     */
    public static ArrayList<AutoPart> getAutoParts() {
        return autoParts;
    }

    private AutoPartsStore() { }

    /**
     * Adding an auto part to the store
     * @param autoPart auto part to add
     */
    public void addAutoPart(AutoPart autoPart) {
        autoParts.add(autoPart);
    }

    /**
     * Removing an auto part from the store
     * @param name_ name of an auto part
     */
    public void removeAutoPart(String name_) {
        String name = "model.";
        name += name_;

        for (int i = 0; i < autoParts.size(); i++) {
            if (name.equals(autoParts.get(i).getClass().getName())) {
                autoParts.remove(i);
                return;
            }
        }
    }

    /**
     * Getting total price of all auto parts in the store
     * @return total price of all auto parts in the store
     */
    public double getTotalPrice() {
        double totalPrice = 0;

        for (AutoPart autoPart: autoParts) {
            totalPrice += autoPart.getPrice();
        }

        return totalPrice;
    }

    /**
     * Sorting all auto parts in the store by price
     */
    public void sortAutoPartsByPrice() {
        Collections.sort(autoParts, new PriceComparator());
    }
}
