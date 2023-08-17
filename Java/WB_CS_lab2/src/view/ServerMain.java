package view;

import controller.AccountLoader;
import Model.Bank;
import Model.Remot.RemoteBank;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class ServerMain {

    static final Logger logger = Logger.getLogger( ServerMain.class.getName());

    public static void main(String[] args) {
        try {
            Bank bank = new Bank();
            bank = AccountLoader.initializationAccounts();


            BankOperations bankOperations = new BankOperations(bank);

            //export remote object
            RemoteBank remote_bank = (RemoteBank) UnicastRemoteObject.exportObject(bankOperations, 0);
            //create exemp remote objects reestr on local host, that gets requests on this port
            Registry reg = LocateRegistry.createRegistry(8000);
            reg.bind("Bank", remote_bank);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
