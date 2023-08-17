package controller;

import model.Accounts.Account;
import model.Bank;
import model.Factory.AccountType;
import model.Factory.AccountsFactory;
import view.ClientMain;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class Controller {
    static final Logger logger = Logger.getLogger( Controller.class.getName());

    public Bank createBank(String address) {
        Account acc1 = AccountsFactory.newAccount("3459", 5550, false);
        Account acc2 = AccountsFactory.newAccount("359", 850, false);
        Account acc3 = AccountsFactory.newAccount("789", 500, false);
        Bank bank = new Bank(new Account[] {acc1, acc2, acc3} , address);
        return bank;
    }




    /**
     * Method that shows sort of accounts by amount of money
     */
    public static void sortAmountMoney(SortFind sortFind) throws RemoteException {
        sortFind.sortedByAmountMoney();
        ArrayList<Account> arrayOfAccounts = sortFind.getBank().GetAccounts();
        System.out.println("\nAccounts sorted by amount of money: ");
        logger.info("\nAccounts sorted by amount of money: ");
        for(Account account: arrayOfAccounts) {
            System.out.println(account);
            logger.info(account.toString());
        }
    }

    /**
     * Method that show accounts that found according to interval of amount of money
     */
    public static void findOnAmountMoney(SortFind sortFind, int min, int max) {
        if(min > max){
            throw new IllegalArgumentException("Min value can't be more than max!!!");
        }
        ArrayList<Account> arrayOfAccounts = sortFind.findOnAmountMoney(min, max);
        System.out.println("\nAccounts with amount of money: ("+ min + "; "+ max +"):");
        logger.info("\nAccounts with amount of money: ("+ min + "; "+ max +"):");
        for(Account account: arrayOfAccounts) {
            System.out.println(account);
            logger.info(account.toString());
        }
    }

    /**
     * Method that show accounts that found according to interval of account number
     */
    public static void findOnAccountNumber(SortFind sortFind, String min, String max) {
        if(Integer.parseInt(min) > Integer.parseInt(max)){
            throw new IllegalArgumentException("\nMin value can't be more than max!!!");
        }
        ArrayList<Account> arrayOfAccounts = sortFind.findOnAccountNumber(min, max);
        System.out.println("\nAccounts with number: ("+ min + "; "+ max +"):");
        logger.info("\nAccounts with number: ("+ min + "; "+ max +"):");
        for(Account account: arrayOfAccounts) {
            System.out.println(account);
            logger.info(account.toString());
        }
    }
}