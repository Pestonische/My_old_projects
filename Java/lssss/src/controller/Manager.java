package controller;

import model.*;

import java.rmi.RemoteException;

/**
 * Proxy Manager class for a store
 */
public class Manager implements RemoteManager {
    AutoPartsStore store;

    /**
     * Manager constructor
     * @param store_ store object
     */
    public Manager(AutoPartsStore store_) {
        store = store_;
    }

    /**
     * Adding an auto part to the store
     * @param autoPart auto part to add
     */
    public synchronized void addAutoPart(AutoPart autoPart) throws RemoteException {
        store.addAutoPart(autoPart);
    }

    /**
     * Removing an auto part from the store
     * @param name name of an auto part
     */
    public synchronized void removeAutoPart(String name) throws RemoteException {
        store.removeAutoPart(name);
    }

    /**
     * Getting total price of all auto parts in the store
     * @return total price of all auto parts in the store
     */
    public synchronized double getTotalPrice() throws RemoteException {
        return store.getTotalPrice();
    }

    /**
     * Sorting all auto parts in the store by price
     */
    public synchronized void sortAutoPartsByPrice() throws RemoteException {
        store.sortAutoPartsByPrice();
    }
}
