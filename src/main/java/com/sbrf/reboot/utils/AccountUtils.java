package com.sbrf.reboot.utils;

import com.sbrf.reboot.dto.Account;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {
    public static void sortedById(List<Account> accounts) {
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account acc1, Account acc2) {
                return acc1.getId().intValue() - acc2.getId().intValue();
            }
        };
        Collections.sort(accounts, comparator);
    }

    public static void sortedByIdDate(List<Account> accounts) {
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account acc1, Account acc2) {
                Long x1 = acc1.getId();
                Long x2 = acc2.getId();
                int idCompare = x1.compareTo(x2);
                if (idCompare != 0) {
                    return idCompare;
                }
                LocalDate date1 = acc1.getCreateDate();
                LocalDate date2 = acc2.getCreateDate();
                return date1.compareTo(date2);
            }
        };
        Collections.sort(accounts, comparator);
    }

    public static void sortedByIdDateBalance(List<Account> accounts) {
        Comparator<Account> comparator = new Comparator<Account>() {
            @Override
            public int compare(Account acc1, Account acc2) {
                Long x1 = acc1.getId();
                Long x2 = acc2.getId();
                int idCompare = x1.compareTo(x2);
                if (idCompare != 0) {
                    return idCompare;
                }
                LocalDate date1 = acc1.getCreateDate();
                LocalDate date2 = acc2.getCreateDate();
                int dateCompare = date1.compareTo(date2);
                if (dateCompare != 0) {
                    return dateCompare;
                }
                return acc1.getBalance().compareTo(acc2.getBalance());
            }
        };
        Collections.sort(accounts, comparator);
    }
}

