package com.sbrf.reboot.utils;

import com.sbrf.reboot.dto.Account;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {
    public static void sortedById(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId));
    }

    public static void sortedByIdDate(List<Account> accounts) {
        Collections.sort(accounts, new Comparator() {
            public int compare(Object acc1, Object acc2) {
                Long x1 = ((Account) acc1).getId();
                Long x2 = ((Account) acc2).getId();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                LocalDate date1 = ((Account) acc1).getCreateDate();
                LocalDate date2 = ((Account) acc2).getCreateDate();
                return date1.compareTo(date2);
            }
        });
    }

    public static void sortedByIdDateBalance(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId)
                .thenComparing(Account::getCreateDate)
                .thenComparing(Account::getBalance));
    }
}

