package controller;

import Model.AccountAbstract;
import Model.Client;

/**
 * Class to work with data of clint
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
 */
public class ServiceClient {

    public static void addAccount(Client client, AccountAbstract account) {
        client.getListAccountsClient().add(account);
    }

    public static void deleteAccount(Client client, AccountAbstract account) {
        client.getListAccountsClient().remove(account);
    }
}
