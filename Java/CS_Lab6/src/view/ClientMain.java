package view;

import controller.Controller;
import controller.SortFind;
//import model.Accounts.CardAccount;
import model.Accounts.PersonalAccount;
import model.Bank;
import model.Remote.RemoteBank;
import java.util.logging.Logger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {

    static final Logger logger = Logger.getLogger( ClientMain.class.getName());

    private static RemoteBank remote_bank;


    public static void main(String[] args) throws RemoteException {

        Registry reg = null;
        try {
            //get registry remote objects
            reg = LocateRegistry.getRegistry("localhost", 12321);
            //find by sluzhba name
            remote_bank = (RemoteBank) reg.lookup("Tolstogo 10");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        logger.info(remote_bank.getBank().getAddress());
        logger.info("Cost of this bank: " + remote_bank.getBank().CostBank());
        SortFind sortFind = new SortFind(remote_bank.getBank());
        Controller.sortAmountMoney(sortFind);
        Controller.findOnAccountNumber(sortFind, "300", "600");
        Controller.findOnAmountMoney(sortFind, 1, 1000);
    }
}
