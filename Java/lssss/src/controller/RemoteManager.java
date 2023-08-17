package controller;

import model.AutoPart;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteManager extends Remote {
    /**
     * Adding an auto part to the store
     * @param autoPart auto part to add
     */
    void addAutoPart(AutoPart autoPart) throws RemoteException;

    /**
     * Removing an auto part from the store
     * @param name name of an auto part
     */
    void removeAutoPart(String name) throws RemoteException;

    /**
     * Getting total price of all auto parts in the store
     * @return total price of all auto parts in the store
     */
    double getTotalPrice() throws RemoteException;

    /**
     * Sorting all auto parts in the store by price
     */
    void sortAutoPartsByPrice() throws RemoteException;
}
