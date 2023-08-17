package Model.Remot;

import Model.Bank;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteBank extends Remote {

    public Bank getBank() throws RemoteException;
}
