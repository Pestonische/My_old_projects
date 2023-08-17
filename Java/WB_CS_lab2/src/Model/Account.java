package Model;


public class Account extends AccountAbstract {
    private boolean vip;

    public Account() {
        super();
        this.vip = true;
    }

    public Account(String accountNumber, int amountMoney, boolean blocked, boolean vip){
        super(accountNumber, amountMoney, blocked);
        this.vip = vip;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int getAmountMoney() {
        return amountMoney;
    }

    @Override
    public void setAmountMoney(int amountMoney) {
        this.amountMoney = amountMoney;
    }

    @Override
    public boolean isBlocked() {
        return blocked;
    }

    @Override
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
