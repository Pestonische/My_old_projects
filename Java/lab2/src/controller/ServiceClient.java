package controller;

import model.Account;
import model.AccountAbstract;
import model.Client;

/**
 * Class to work with data of clint
 * Created by Kozunov Alexei.
 */
public class ServiceClient {

    public static void addAccount(Client client, Account account) {
        client.getListAccountsClient().add(account);
    }

    public static void deleteAccount(Client client, Account account) {
        client.getListAccountsClient().remove(account);
    }
}
