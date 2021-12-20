package com.sbrf.reboot.service;

import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isAccountExist(Long clientId, Account account) throws IOException {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }

    public Account getMaxAccountBalance(Long clientId) throws IOException {
        Set<Account> accounts= accountRepository.getAllAccountsByClientId(clientId);
        if(accounts.stream().max(Comparator.comparing(Account::getBalance)).isPresent()){
            return accounts.stream().max(Comparator.comparing(Account::getBalance)).get();
        }
        return null;
    }

    public Set<Account> getAllAccountsByDateMoreThen(Long clientId, LocalDate startDay) throws IOException {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.stream().filter(account -> account.getCreateDate().isAfter(startDay) || account.getCreateDate().isEqual(startDay))
                .collect(Collectors.toSet());
    }
}
