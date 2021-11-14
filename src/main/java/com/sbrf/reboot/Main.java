package com.sbrf.reboot;

import com.sbrf.reboot.service.Account;
import com.sbrf.reboot.service.AccountRepository;
import com.sbrf.reboot.service.AccountRepositoryImpl;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountRepository accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);
        accountRepository.changeAccountClientId(7, 1);
    }
}
