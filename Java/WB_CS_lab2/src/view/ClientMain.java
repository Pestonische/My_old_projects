package view;


//import model.Accounts.CardAccount;

import Model.Bank;
import Model.Remot.RemoteBank;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class ClientMain {

    static final Logger logger = Logger.getLogger( ClientMain.class.getName());

    private static RemoteBank remote_bank;


    public static void main(String[] args) throws RemoteException {

        Registry reg = null;
        try {
            //get registry remote objects
            reg = LocateRegistry.getRegistry("localhost", 8000);
            //find by sluzhba name
            remote_bank = (RemoteBank) reg.lookup("Bank");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        Bank bank = remote_bank.getBank();

        int i = 0;
        BankOperations bankOperations = new BankOperations(remote_bank.getBank());

        bankOperations.menu(remote_bank.getBank());
    }
}
