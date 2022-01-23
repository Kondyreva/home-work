package com.sbrf.reboot.lab16.dto;

public class AccountWithConstructor {
    private Account account;

    public AccountWithConstructor(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
