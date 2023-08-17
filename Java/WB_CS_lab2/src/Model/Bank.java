package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class simulates the work of the bank
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
 */
public class Bank implements Serializable {
    /**The list of all accounts*/
    private ArrayList<AccountAbstract> listAccountsBank;// = new ArrayList<>();
    /**The list of all clients*/
    private ArrayList<Client> listClients;// = new ArrayList<>();

    public Bank(){
        listAccountsBank = new ArrayList<>();
        listClients = new ArrayList<>();
    }
    public void setListAccountsBank(ArrayList<AccountAbstract> listAccountsBank) {
        this.listAccountsBank = listAccountsBank;
    }

    public void setListClients(ArrayList<Client> listClients) {
        this.listClients = listClients;
    }

    public ArrayList<AccountAbstract> getListAccountsBank() {
        return listAccountsBank;
    }

    public ArrayList<Client> getListClients() {
        return listClients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(listAccountsBank, bank.listAccountsBank) &&
                Objects.equals(listClients, bank.listClients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listAccountsBank, listClients);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "listAccountsBank=" + listAccountsBank +
                ", listClients=" + listClients +
                '}';
    }
}
