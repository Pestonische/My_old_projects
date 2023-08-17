package controller;

import Model.Account;
import Model.Bank;
import Model.Client;

import java.io.File;

/**
 * Service to work with class Accounts
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
 */
public class AccountLoader {
    /**Method to initialize the saved data*/
    public static Bank initializationAccounts() {
        Bank bank = new Bank();
        File file = new File("src/file/accounts.txt");
        String string = ServicesFile.readFile(file);
        String[] str = string.split("\\s");

        for (int i = 0; i < str.length; i += 4){
            Account account = new Account(str[i + 1], Integer.parseInt(str[i + 2]), Boolean.parseBoolean(str[i + 3]), true);
            Client client = new Client(str[i], account);

            ServiceBank.addAccount(bank, account);
            ServiceBank.addClient(bank, client);
        }
        return bank;
    }
}
