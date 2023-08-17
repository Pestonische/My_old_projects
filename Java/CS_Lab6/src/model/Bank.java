package model;

import controller.Controller;
import controller.SortFind;
import model.Accounts.Account;
import model.Remote.RemoteBank;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bank implements Serializable {

    Bank bank;
    /**
     * all accounts in bank
     */
    private ArrayList<Account> accounts;

    /**
     * address of bank
     */
    private String address;

    /**
     * GetMethod for bank address
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * GetMethod for amount of accounts
     * @return amount of accounts
     */
    public int getAmountOfAccounts() {
        return accounts.size();
    }

    /**
     * GetMethod for array of accounts
     * @return array of accounts
     */
    public ArrayList<Account> GetAccounts() {
        return accounts;
    }

    /**
     * default constructor
     */
    public Bank() {
        accounts = new ArrayList<>();
        address = "Tolstogo 10";
    }

    /**
     * Constructor with parameters
     * @param account - array of accounts
     * @param add - address of bank
     */
    public Bank(Account[] account, String add) {
        accounts = new ArrayList<>();
        for(Account item: account){
            accounts.add(item);
        }
        address = add;
    }


    /**
     * add new account to bank
     * @param account - new account
     */
    public void addAccountToBank(Account account){
        this.accounts.add(account);
    }

    /**
     * Override method toString for object taxis
     * @return object in string
     */
    @Override
    public String toString() {
        String result = "_____________BANK_____________\n\nAddress: " + address;
        for(Account account: accounts){
            result += account + "\n";
        }
        return result;
    }

    /**
     * Method that find sum of amountMoney of all accounts in bank
     * @return sum
     */
    public double CostBank() {
        double sum = 0;
        for(Account account: accounts){
            sum += account.GetAmountMoney();
        }
        return sum;
    }

}
