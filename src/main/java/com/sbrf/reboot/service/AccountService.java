package com.sbrf.reboot.service;

import java.io.IOException;
import java.util.Set;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Boolean isAccountExist(Long clientId, Account account) throws IOException {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        boolean result = false;
        for (Account a : accounts) {
            if (a.getNumber().equals(account.getNumber())) {
                result = true;
                break;
            }
        }
        return result;
    }
}

