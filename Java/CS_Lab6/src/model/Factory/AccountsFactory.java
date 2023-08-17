package model.Factory;

import model.Accounts.Account;
//import model.Accounts.CardAccount;
//import model.Accounts.DepositAccount;
import model.Accounts.PersonalAccount;

public class AccountsFactory {

    /**
     * Constructor with 1 parameter

     * @return new object
     */
    public static Account newAccount() {
//        switch (type) {
//            case CARD_ACCOUNT:
//                return new CardAccount();
//            case DEPOSIT_ACCOUNT:
//                return new DepositAccount();
//            case PERSONAL_ACCOUNT:
        return new PersonalAccount();
//            default:
//                throw new EnumConstantNotPresentException(AccountType.class, type.name());
//        }
    }

    /**
     * Constructor with many parameters

     * @param accountNumber
     * @param amountMoney
     * @param blocked
     * @return
     */
    public static Account newAccount(String accountNumber, int amountMoney, boolean blocked) {
//        switch (type) {
//            case CARD_ACCOUNT:
//                return new CardAccount(accountNumber, amountMoney, blocked);
//            case DEPOSIT_ACCOUNT:
//                return new DepositAccount(accountNumber, amountMoney, blocked);
//            case PERSONAL_ACCOUNT:
                return new PersonalAccount(accountNumber, amountMoney, blocked);
//            default:
//                throw new EnumConstantNotPresentException(AccountType.class, type.name());
//        }
    }
}