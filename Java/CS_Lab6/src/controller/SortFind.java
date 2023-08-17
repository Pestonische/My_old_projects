package controller;

import model.Accounts.Account;
import model.Bank;
import model.Comparators.AmountMoneyComparator;
import model.Remote.RemoteBank;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class SortFind implements RemoteBank {

    /**
     * private field bank
     */
    private Bank bank;

    /**
     * GetMethod for field bank
     * @return
     */
    @Override
    public Bank getBank() throws RemoteException {
        return bank;
    }
    /**
     * Constructor
     * @param bank
     */
    public SortFind(Bank bank) {
        this.bank = bank;
    }

    /**
     * Method that sorted array of accounts by amount of money
     */
    public void sortedByAmountMoney() {
        Collections.sort(bank.GetAccounts(), new AmountMoneyComparator());
    }

    /**
     * Method that find account according to amount money interval
     * @param amountMin
     * @param amountMax
     * @return new array
     */
    public ArrayList<Account> findOnAmountMoney(int amountMin, int amountMax){
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> Accounts = bank.GetAccounts();

        for(Account account: Accounts){
            if(account.GetAmountMoney() >= amountMin && account.GetAmountMoney() <= amountMax){
                result.add(account);
            }
        }
        return result;
    }

    /**
     * Method that find accounts according to number account interval
     * @param numberMin
     * @param numberMax
     * @return new array
     */
    public ArrayList<Account> findOnAccountNumber(String numberMin, String numberMax){
        ArrayList<Account> result = new ArrayList<>();
        ArrayList<Account> Accounts = bank.GetAccounts();
        try {
            for (Account account : Accounts) {
                if (Integer.parseInt(account.GetAccountNumber()) >= Integer.parseInt(numberMin) && Integer.parseInt(account.GetAccountNumber()) <= Integer.parseInt(numberMax)) {
                    result.add(account);
                }
            }
        }
        catch (NumberFormatException e)
        {
            return result;
        }

        return result;
    }


    @Override
    public int getAmountOfAccounts() throws RemoteException {
        return 0;
    }

    @Override
    public CopyOnWriteArrayList<Account> GetAccounts() throws RemoteException {
        return null;
    }




}
