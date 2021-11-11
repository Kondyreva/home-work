package com.sbrf.reboot.service;

import java.util.Set;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Boolean isAccountExist(Long clientId, Account account) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        boolean result = false;
        for (Account a : accounts) {
            if (a.getName().equals(account.getName())) {
                result = true;
                break;
            }
        }
        return result;
    }
}

