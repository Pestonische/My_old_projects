package controller;

import model.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Factory Seller class for a store
 */
public class Seller implements RemoteSeller {
    AutoPartsStore store;

    public Seller(AutoPartsStore store_) {
        store = store_;
    }

    /**
     * Selling an auto part from store
     * @param name_ name of an auto part
     * @return AutoPart or null if no such auto part in the store
     */
    public synchronized AutoPart sell(String name_) throws RemoteException {
        String name = "model.";
        name += name_;

        for (AutoPart autoPart: store.getAutoParts()) {
            if (name.equals(autoPart.getClass().getName())) {
                return autoPart;
            }
        }

        return null;
    }

    /**
     * Getting a price of auto part
     * @param name_ name of an auto part
     * @return price of an auto part
     */
    public synchronized double getPriceOf(String name_) throws RemoteException {
        String name = "model.";
        name += name_;

        for (AutoPart autoPart: store.getAutoParts()) {
            if (name.equals(autoPart.getClass().getName())) {
                return autoPart.getPrice();
            }
        }

        return 0;
    }

    /**
     * Getting menu of the store
     * @return store menu
     */
    public synchronized String getMenu() throws RemoteException {
        String menu = "";

        for (AutoPart autoPart: store.getAutoParts()) {
            String name = autoPart.getClass().getName().substring(6);

            menu += (name + " - " + autoPart.getPrice() + ": " + autoPart.getDescription() + "\n");
        }

        return menu;
    }

    /**
     * Getting auto parts in the following price range
     * @param lowestPrice lowest price (included)
     * @param highestPrice highest price (included)
     * @return AutoPart Arraylist that satisfy price range
     */
    public synchronized ArrayList<AutoPart> getAutoPartsByPriceRange(double lowestPrice, double highestPrice) throws RemoteException {
        ArrayList<AutoPart> rangedAutoParts = new ArrayList<>();

        for (AutoPart autoPart: store.getAutoParts()) {
            if (autoPart.getPrice() >= lowestPrice && autoPart.getPrice() <= highestPrice) {
                rangedAutoParts.add(autoPart);
            }
        }

        return rangedAutoParts;
    }
}
