package controller.sorting;

import Model.AccountAbstract;

import java.util.Comparator;

/**
 * Helper class to use interface to sort accounts by amount of money
 * @version 1.0 12 Sep 2021
 * @author  Kozunov Alexei
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
