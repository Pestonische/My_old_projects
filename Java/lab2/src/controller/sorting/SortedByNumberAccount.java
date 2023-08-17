package controller.sorting;

import model.AccountAbstract;

import java.util.Comparator;

/**
 * Helper class to use interface To sort accounts by client name
 * Created by Kozunov Alexei.
 */
public class SortedByNumberAccount  implements Comparator<AccountAbstract> {
    @Override
    public int compare(AccountAbstract o1, AccountAbstract o2) {
        String owner1 = o1.getAccountNumber();
        String owner2 = o2.getAccountNumber();

        return owner1.compareTo(owner2);
    }
}
