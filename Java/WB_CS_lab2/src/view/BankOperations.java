package view;

import Model.Bank;
import Model.Client;
import controller.ServiceBank;
import controller.ServiceClient;
import controller.ServicesFile;
import controller.sorting.SortedByAmountMoney;
import controller.sorting.SortedByNumberAccount;
import Model.AccountAbstract;
import Model.Account;
import Model.Remot.RemoteBank;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Class contain input methods
 * and to create menu
 *
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
 */
public class BankOperations implements RemoteBank {

    public static int inputNumber(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    private Bank bank;

    public BankOperations(Bank bank)
    {
        this.bank = bank;
    }
    public void menu(Bank bank) {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Select an action...");
            System.out.println("1)Add account");
            System.out.println("2)Delete account");
            System.out.println("3)View all money");
            System.out.println("4)Count positive and negative balances");
            System.out.println("5)Block an account");
            System.out.println("6)Unblock an account");
            System.out.println("7)View data");
            System.out.println("8)Sort by amount of money");
            System.out.println("9)Sort by number of account");
            System.out.println("10)AccountAbstract transactions");
            System.out.println("0)Exit");
            System.out.println("---------------------------------------------");

            menu:
            switch (BankOperations.inputNumber()){
                case 1: {

                    while (true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("1)Add new client");
                        System.out.println("2)Add new account for client");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");

                        switch (BankOperations.inputNumber()) {
                            case 1: {
                                Client client;
                                Account account = new Account();
                                String nameClient;

                                System.out.print("Enter client name:");
                                nameClient = BankOperations.inputString();
                                System.out.print("Enter account number: ");
                                account.setAccountNumber(BankOperations.inputString());
                                System.out.print("Enter amount of money: ");
                                account.setAmountMoney(BankOperations.inputNumber());
                                account.setBlocked(false);

                                ServiceBank.addAccount(bank, account);
                                client = new Client(nameClient, account);
                                ServiceBank.addClient(bank, client);
                                break menu;
                            }
                            case 2: {
                                Account account = new Account();
                                String nameClient;

                                System.out.print("Enter owner: ");
                                nameClient = BankOperations.inputString();
                                System.out.print("Enter account number: ");
                                account.setAccountNumber((BankOperations.inputString()));
                                System.out.print("Enter amount of money: ");
                                account.setAmountMoney(BankOperations.inputNumber());
                                account.setBlocked(false);
                                ServiceBank.addAccount(bank, account);
                                for (Client client: bank.getListClients()) {
                                    if (client.getName().equals(nameClient)){
                                        ServiceClient.addAccount(client, account);
                                        break menu;
                                    }
                                }
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 2: {

                    System.out.print("Enter account number for delete: ");
                    String numberAccount = BankOperations.inputString();
                    ServiceBank.deleteAccount(bank, numberAccount);
                    for (Client client: bank.getListClients()){
                        for (AccountAbstract account: client.getListAccountsClient()) {
                            if (account.getAccountNumber().equals(numberAccount)){
                                ServiceClient.deleteAccount(client, account);
                                break menu;
                            }
                        }
                    }
                }
                case 3: {
                    System.out.println("All money: " + ServiceBank.countMoney(bank));
                    break;
                }
                case 4: {
                    System.out.println("Positive balance: " + ServiceBank.countPositiveBalance(bank));
                    System.out.println("Negative balance: " + ServiceBank.countNegativeBalance(bank));
                    break;
                }
                case 5: {
                    ServiceBank.block(bank);
                    break;
                }
                case 6: {
                    ServiceBank.unblock(bank);
                    break;
                }
                case 7: {

                    while (true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("1)View all accounts");
                        System.out.println("2)View all clients");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");

                        switch (BankOperations.inputNumber()) {
                            case 1: {
                                for (AccountAbstract account : bank.getListAccountsBank()) {
                                    System.out.println(account);
                                }
                                break;
                            }
                            case 2: {
                                for (Client client: bank.getListClients()) {
                                    System.out.println(client);
                                }
                                break;
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 8: {
                    bank.getListAccountsBank().sort(new SortedByAmountMoney());

                    for (AccountAbstract account: bank.getListAccountsBank()) {
                        System.out.println(account);
                    }
                    break;
                }
                case 9: {
                    bank.getListAccountsBank().sort(new SortedByNumberAccount());

                    for (AccountAbstract account: bank.getListAccountsBank()) {
                        System.out.println(account);
                    }
                    break;
                }
                case 10: {
                    while(true) {
                        System.out.println("---------------------------------------------");
                        System.out.println("1)Put money");
                        System.out.println("2)Pull off money");
                        System.out.println("0)Previous");
                        System.out.println("---------------------------------------------");

                        switch (BankOperations.inputNumber()){
                            case 1: {
                                ServiceBank.changeAmountMoney(bank, 1);
                                break;
                            }
                            case 2: {
                                ServiceBank.changeAmountMoney(bank, -1);
                                break;
                            }
                            case 0: {
                                break menu;
                            }
                            default: {
                                System.out.println("---------------------------------------------");
                                System.out.println("Impossible choice or format. Repeat please ...");
                            }
                        }
                    }
                }
                case 0: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Work completed");
                    File file = new File("src/file/accounts.txt");
                    ServicesFile.writeFile(bank, file);
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }
                default: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Impossible choice or format. Repeat please ...");
                }
            }
        }
    }

    @Override
    public Bank getBank() throws RemoteException {
        return bank;
    }
}
