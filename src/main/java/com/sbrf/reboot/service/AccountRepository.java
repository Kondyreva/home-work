package com.sbrf.reboot.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(Integer clientId) throws IOException;
    Set<Account> getAllAccountsByClientId(Long clientId) throws IOException;
    void changeAccountClientId(Integer oldClientId, Integer newClientId) throws IOException;
}
