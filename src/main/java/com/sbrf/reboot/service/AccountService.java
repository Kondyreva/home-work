package com.sbrf.reboot.service;

import java.time.LocalDate;
import java.util.Set;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(Long l, Account account) {
    }

    public Account getMaxAccountBalance(Long l) {
    }

    public Set getAllAccountsByDateMoreThen(Long l, LocalDate minusDays) {
    }
}
