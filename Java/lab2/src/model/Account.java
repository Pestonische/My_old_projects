package model;

public class Account extends AccountAbstract {
    private boolean vip;
    private String name;

    public Account() {
        super();
        this.vip = true;
        this.name = "";
    }
    public Account(Account account) {
        super(account);
        this.vip = account.vip;
        this.name = account.name;
    }

    public Account(String accountNumber, int amountMoney, boolean blocked, boolean vip, String name){
        super(accountNumber, amountMoney, blocked);
        this.vip = vip;
        this.name = name;
    }

    public Account(int amountMoney, boolean blocked, boolean vip, String name){
        super(amountMoney, blocked);
        this.vip = vip;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        return new Account(this);
    }
}
