package model.Remote;

import controller.SortFind;
import model.Accounts.Account;
import model.Bank;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.CopyOnWriteArrayList;

public interface RemoteBank extends Remote {

    public int getAmountOfAccounts() throws RemoteException;

    public CopyOnWriteArrayList<Account> GetAccounts() throws RemoteException;

    public Bank getBank() throws RemoteException;
}
