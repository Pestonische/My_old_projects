package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class contains data about account
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
 */
public abstract class AccountAbstract implements Serializable {
    /**The number of account*/
    protected String accountNumber;
    /**The amount of money*/
    protected int amountMoney;
    /**AccountAbstract blocking(true - blocked)*/
    protected boolean blocked;

    public AccountAbstract() {
        accountNumber = null;
        amountMoney = 0;
        blocked = false;
    }

    public AccountAbstract(String accountNumber, int amountMoney, boolean blocked){
        this.accountNumber = accountNumber;
        this.amountMoney = amountMoney;
        this.blocked = blocked;
    }

    public abstract String getAccountNumber();

    public abstract void setAccountNumber(String accountNumber);

    public abstract int getAmountMoney();

    public abstract void setAmountMoney(int amountMoney);

    public abstract boolean isBlocked();

    public abstract void setBlocked(boolean blocked);

    @Override
    public String toString(){
        return "---------------------------------------------" + "\n" +
                "Number of account: " + getAccountNumber() + "\n" +
                "Amount of account: " + getAmountMoney() + "\n" +
                "Blocked: " + isBlocked() + "\n" +
                "---------------------------------------------";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountAbstract account = (AccountAbstract) o;
        return amountMoney == account.amountMoney &&
                blocked == account.blocked &&
                Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, amountMoney, blocked);
    }
}
