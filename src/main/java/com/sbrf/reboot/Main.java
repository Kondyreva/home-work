package com.sbrf.reboot;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.utils.AccountUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<Account>() {{
            add(Account.builder().id(1L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
            add(Account.builder().id(1L).createDate(LocalDate.now()).balance(BigDecimal.ONE).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(3)).balance(BigDecimal.TEN).build());
            add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(1)).balance(BigDecimal.ZERO).build());
            add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        }};

        AccountUtils.sortedByIdDateBalance(accounts);

        System.out.println(accounts.toString());
    }
}
