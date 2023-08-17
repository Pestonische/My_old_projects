package controller.sorting;

import model.AccountAbstract;

import java.util.Comparator;

/**
 * Helper class to use interface to sort accounts by amount of money
 * Created by Kozunov Alexei.
 */
public class SortedByAmountMoney implements Comparator<AccountAbstract> {
    @Override
    public int compare(AccountAbstract o1, AccountAbstract o2) {
        int money1 = o1.getAmountMoney();
        int money2 = o2.getAmountMoney();

        if (money1 > money2){
            return 1;
        }
        else if (money1 < money2){
            return -1;
        }
        else {
            return 0;
        }
    }
}
