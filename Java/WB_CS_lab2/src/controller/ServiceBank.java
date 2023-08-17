package controller;

import Model.AccountAbstract;
import Model.Bank;
import Model.Client;
import view.BankOperations;

import java.util.ArrayList;

/**
 * Class to work with data of Bank
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
 */
public class ServiceBank {
    public static void addAccount(Bank bank, AccountAbstract account) {
        if (bank.getListAccountsBank().isEmpty()){
            ArrayList<AccountAbstract> list = new ArrayList<>();
            list.add(account);
            bank.setListAccountsBank(list);
        }
        else {
            bank.getListAccountsBank().add(account);
        }
    }

    public static ArrayList<AccountAbstract> deleteAccount(Bank bank, String numberAccount){
        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                bank.getListAccountsBank().remove(account);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static int countMoney(Bank bank) {
        int sumAll = 0;
        for (AccountAbstract account : bank.getListAccountsBank()) {
            sumAll += account.getAmountMoney();
        }
        return sumAll;
    }

    public static int countPositiveBalance(Bank bank) {
        int sumPositive = 0;
        for (AccountAbstract account : bank.getListAccountsBank()) {
            if (account.getAmountMoney() > 0) {
                sumPositive += account.getAmountMoney();
            }
        }
        return sumPositive;
    }

    public static int countNegativeBalance(Bank bank) {
        int sumNegative = 0;
        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAmountMoney() < 0) {
                sumNegative += account.getAmountMoney();
            }
        }
        return sumNegative;
    }

    public static ArrayList<AccountAbstract> block(Bank bank) {
        String numberAccount;
        System.out.print("Enter number of account for block: ");
        numberAccount = BankOperations.inputString();

        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(true);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static ArrayList<AccountAbstract> unblock(Bank bank) {
        String numberAccount;
        System.out.print("Enter number of account for unblock: ");
        numberAccount = BankOperations.inputString();

        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(false);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static ArrayList<Client> addClient(Bank bank, Client client) {
        if (bank.getListClients().isEmpty()){
            ArrayList<Client> list = new ArrayList<>();
            list.add(client);
            bank.setListClients(list);
        }
        else {
            bank.getListClients().add(client);
        }
        return bank.getListClients();
    }

    public static void changeAmountMoney(Bank bank, int plusOrMinusMoney){
        String numberAccount;
        System.out.print("Enter number of account: ");
        numberAccount = BankOperations.inputString();
        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)){
                if (account.isBlocked()){
                    System.out.println("AccountAbstract is blocked");
                    break;
                }
                else {
                    System.out.print("Enter the amount of money:");
                    account.setAmountMoney(account.getAmountMoney() + plusOrMinusMoney*BankOperations.inputNumber());
                    break;
                }
            }
        }
    }
}
