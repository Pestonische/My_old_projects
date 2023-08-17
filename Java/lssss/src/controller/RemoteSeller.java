package controller;

import model.AutoPart;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteSeller extends Remote {
    /**
     * Selling an auto part from store
     * @param name_ name of an auto part
     * @return AutoPart or null if no such auto part in the store
     */
    AutoPart sell(String name_) throws RemoteException;

    /**
     * Getting a price of auto part
     * @param name_ name of an auto part
     * @return price of an auto part
     */
    double getPriceOf(String name_) throws RemoteException;

    /**
     * Getting menu of the store
     * @return store menu
     */
    String getMenu() throws RemoteException;

    /**
     * Getting auto parts in the following price range
     * @param lowestPrice lowest price (included)
     * @param highestPrice highest price (included)
     * @return AutoPart Arraylist that satisfy price range
     */
    ArrayList<AutoPart> getAutoPartsByPriceRange(double lowestPrice, double highestPrice) throws RemoteException;
}
