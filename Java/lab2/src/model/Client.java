package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class contains data about client
 * @version 1.0 19 Sep 2021
 * @author  Kozunov Alexei
 */
public class Client {
    /**The name of client*/
    private String name;
    /**The list of client account*/
    private ArrayList<Account> listAccountsClient;// = new ArrayList<>();

    public void setListAccountsClient(ArrayList<Account> listAccountsClient) {
        this.listAccountsClient = listAccountsClient;
    }

    public Client(String name, Account account) {
        this.name = name;
        listAccountsClient = new ArrayList<>();
        listAccountsClient.add(account);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getListAccountsClient() {
        return listAccountsClient;
    }

    public String toString() {
        String data = "---------------------------------------------" + "\n" + "Owner: " + getName();
        for (AccountAbstract account: listAccountsClient) {
            data += "\n" + account + "\n";
        }
        data += "---------------------------------------------";
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(listAccountsClient, client.listAccountsClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listAccountsClient);
    }
}
