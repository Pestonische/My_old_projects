package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Account;
import model.AccountAbstract;
import model.Bank;
import model.Client;
import view.BankOperations;

import java.util.ArrayList;

/**
 * Class to work with data of Bank
 * Created by Kozunov Alexei on 2021.
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
        for (int i = 0; i < bank.getListAccountsBank().size(); i++) {
            if (bank.getListAccountsBank().get(i).getAccountNumber().equals(numberAccount)) {
                bank.getListAccountsBank().remove(bank.getListAccountsBank().get(i));
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

    public static ArrayList<AccountAbstract> block(Bank bank, Integer number) {
        String numberAccount = String.valueOf(number);

        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)) {
                account.setBlocked(true);
                break;
            }
        }
        return bank.getListAccountsBank();
    }

    public static ArrayList<AccountAbstract> unblock(Bank bank, Integer number) {
        String numberAccount = String.valueOf(number);

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

    public static void changeAmountMoney(Bank bank, int money, String numberAc){
        String numberAccount;

        numberAccount = numberAc;
        for (AccountAbstract account: bank.getListAccountsBank()) {
            if (account.getAccountNumber().equals(numberAccount)){
                if (account.isBlocked()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Money");
                    alert.setHeaderText("AccountAbstract is blocked");
                    alert.showAndWait().ifPresent(rs -> {});
                    break;
                }
                else {
                    account.setAmountMoney(account.getAmountMoney() + money);
                    break;
                }
            }
        }
    }
}
