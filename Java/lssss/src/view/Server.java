package view;

import controller.Manager;
import controller.RemoteManager;
import controller.RemoteSeller;
import controller.Seller;
import model.AutoPartsStore;
import model.Engine;
import model.Wheel;
import model.Window;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

/**
 * RMI server class
 */
public class Server {
    static private final Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        logger.info("Server is started");

        try {
            AutoPartsStore store = AutoPartsStore.getInstance();
            Manager manager = new Manager(store);
            Seller seller = new Seller(store);

            manager.addAutoPart(new Engine("Engine #1", 500, 1000));
            manager.addAutoPart(new Window("Window #1", 200, 1));
            manager.addAutoPart(new Wheel("Wheel #1", 100, 30));

            RemoteManager remoteManager = (RemoteManager) UnicastRemoteObject.exportObject(manager, 0);
            RemoteSeller remoteSeller = (RemoteSeller) UnicastRemoteObject.exportObject(seller, 0);

            Registry reg = LocateRegistry.createRegistry(8000);
            reg.bind("remotemanager", remoteManager);
            reg.bind("remoteseller", remoteSeller);

            logger.info("RMI is configured");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
