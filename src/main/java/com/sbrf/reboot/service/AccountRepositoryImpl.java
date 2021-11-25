package com.sbrf.reboot.service;

import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public Set<Account> getAllAccountsByClientId(Long clientId) {
        /*TODO: убрать заглушку и использовать поиск по файлу*/
        Account account = new Account("ACC1234NUM");
        Set<Account> accounts = new HashSet();
        accounts.add(account);
        return accounts;
    };
}
