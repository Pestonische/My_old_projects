package view;

import controller.RemoteManager;
import controller.RemoteSeller;
import model.AutoPart;
import model.exception.LookupException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

/**
 * RMI client class
 */
public class Client {
    static private final Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) throws LookupException {
        RemoteManager remoteManager = null;
        RemoteSeller remoteSeller = null;
        Registry reg;
        try {
            reg = LocateRegistry.getRegistry("localhost", 8000);
            remoteManager = (RemoteManager) reg.lookup("remotemanager");
            remoteSeller = (RemoteSeller) reg.lookup("remoteseller");

            logger.info("Manager: \"Total price of all auto parts is " + remoteManager.getTotalPrice() + "$\"");

            logger.info("\n*Seller* showing menu...");
            logger.info(remoteSeller.getMenu());

            logger.info("*Manager* sorts auto parts...");
            remoteManager.sortAutoPartsByPrice();
            logger.info("Manager: \"Sorted menu by price!\"");
            logger.info(remoteSeller.getMenu());

            logger.info("*Seller* shows auto parts with price range 100-400...");
            for (AutoPart autoPart: remoteSeller.getAutoPartsByPriceRange(100, 400)) {
                String name = autoPart.getClass().getName().substring(6);

                logger.info(name + " - " + autoPart.getPrice() + ": " + autoPart.getDescription());
            }

            logger.info("\nLet's see the price of a wheel!");
            logger.info("Price of a wheel is " + remoteSeller.getPriceOf("Wheel"));

            logger.info("\nBuying the wheel returns " + remoteSeller.sell("Wheel"));
            logger.info("Removing the wheel...");
            remoteManager.removeAutoPart("Wheel");
            logger.info("*Seller shows new menu...*");
            logger.info(remoteSeller.getMenu());
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new LookupException("Can't lookup remote object");
        }
    }
}