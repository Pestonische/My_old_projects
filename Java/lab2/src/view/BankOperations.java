package view;

import controller.AccountLoader;
import controller.ServiceBank;
import controller.ServiceClient;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;
import model.Account;

import javafx.scene.control.Button;

import java.util.Scanner;

/**
 * Class contain input methods
 * and to create menu
 *
 * @version 1.0 19 Sep 2021
 * @author  Kozunov Alexei
 */
public class BankOperations {

    @FXML
    private Button addAccount;

    @FXML
    private Button deleteAccount;

    @FXML
    private Button viewAllMoney;

    @FXML
    private Button block;

    @FXML
    private Button unblock;

    @FXML
    private Button acTrans;

    @FXML
    private TextField nameTf;

    @FXML
    private TextField moneyEnter;

    @FXML
    private TextField moneyTf;

    @FXML
    private CheckBox actStatusTf;

    @FXML
    private TableView<Object> table;

    @FXML
    private TableColumn<Account, String> name;

    @FXML
    private TableColumn<Account, String> acNam;

    @FXML
    private TableColumn<Account, String> acMoney;

    @FXML
    private TableColumn<Account, Boolean> blocked;


    private ObservableList<Object> usersData = FXCollections.observableArrayList();

    public BankOperations() {
    }

    @FXML
    void initialize() {
        Bank bank;
        bank = AccountLoader.initializationAccounts();
        name.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        acNam.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAccountNumber()));
        acMoney.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getAmountMoney())));
        blocked.setCellValueFactory(cellData -> new ReadOnlyBooleanWrapper(cellData.getValue().isBlocked()));
        addArray(bank, usersData);
        // заполняем таблицу данными
        table.setItems(usersData);
        deleteAccount.setOnAction(event1 -> {
            if (table.getSelectionModel().getSelectedIndex() != -1) {
                deleteAccount.setVisible(false);

                table.getItems().remove(table.getSelectionModel().getSelectedIndex());
                ServiceBank.deleteAccount(bank, ((Account)table.getItems().get(table.getSelectionModel().getSelectedIndex())).getAccountNumber());

                for (Client client: bank.getListClients()){
                    for (int i = 0; i < client.getListAccountsClient().size(); i++){
                        if (client.getListAccountsClient().get(i).equals(table.getSelectionModel().getSelectedItem())){
                            ServiceClient.deleteAccount(client, client.getListAccountsClient().get(i));

                        }
                    }
                }
                deleteAccount.setVisible(true);
            }
        });
        viewAllMoney.setOnAction(event1 ->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Money");
            alert.setHeaderText("All money: " + ServiceBank.countMoney(bank));
            alert.showAndWait().ifPresent(rs -> {});
        });
        block.setOnAction( event1 ->{
            block.setVisible(false);

            ((Account)table.getItems().get(table.getSelectionModel().getSelectedIndex())).setBlocked(true);

            table.refresh();
            ServiceBank.block(bank, table.getSelectionModel().getSelectedIndex());
            block.setVisible(true);
        });
        unblock.setOnAction( event1 ->{
            block.setVisible(false);

            ((Account)table.getItems().get(table.getSelectionModel().getSelectedIndex())).setBlocked(false);

            table.refresh();
            ServiceBank.unblock(bank, table.getSelectionModel().getSelectedIndex());
            block.setVisible(true);
        });
        addAccount.setOnAction( event1 -> {
            addAccount.setVisible(false);
            boolean check = true;
            if(actStatusTf.isSelected())
            {
                check = false;
            }
            if(isNumeric(moneyTf.getText()) && !nameTf.getText().equals("")) {
                Account account = new Account(Integer.parseInt(moneyTf.getText()), check, true, nameTf.getText());
                Client client = new Client(nameTf.getText(), account);

                ServiceBank.addAccount(bank, account);
                ServiceBank.addClient(bank, client);
                usersData.add(account);
                table.setItems(usersData);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Money");
                alert.setHeaderText("Incorrect data");
                alert.showAndWait().ifPresent(rs -> {});
            }
            addAccount.setVisible(true);

        });
        acTrans.setOnAction( event1 -> {
            acTrans.setVisible(false);
            if(isNumeric(moneyEnter.getText())) {
                ServiceBank.changeAmountMoney(bank, Integer.parseInt(moneyEnter.getText()), ((Account) table.getItems().get(table.getSelectionModel().getSelectedIndex())).getAccountNumber());
                table.refresh();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Money");
                alert.setHeaderText("Not number " + moneyEnter.getText());
                alert.showAndWait().ifPresent(rs -> {});
            }
            acTrans.setVisible(true);
        });
        /*fileButton.setOnAction(event -> {
            checkFile = 0;
            new WindowApp().getWindow(addAccount, "../forms/TextForm.fxml");
        });

        addAccount.setOnAction(event -> new WindowApp().getWindow(addAccount, "../forms/ShowForm.fxml"));
        deleteAccount.setOnAction(event -> new WindowApp().getWindow(addAccount, "../forms/AddForm.fxml"));
        viewAllMoney.setOnAction(event -> new WindowApp().getWindow(addAccount, "../forms/DeleteForm.fxml"));*/
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void addArray(Bank bank, ObservableList<Object> usersData)
    {
        for(int i = 0; i < bank.getListAccountsBank().size(); i++)
        {
            usersData.add(bank.getListAccountsBank().get(i));
        }
    }

    public static int inputNumber(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    /*public static void menu(Bank bank) {

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
    }*/
}
