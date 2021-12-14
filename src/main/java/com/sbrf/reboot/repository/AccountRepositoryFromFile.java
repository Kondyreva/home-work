package com.sbrf.reboot.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Account;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountRepositoryFromFile implements AccountRepository {
    private final String path;
    private static final ObjectMapper mapper = new ObjectMapper();

    public AccountRepositoryFromFile(String path) {
        this.path = path;
    }

    @Override
    public <T extends  Number> Set<Account> getAllAccountsByClientId(T clientId) throws IOException {
        Set<Account> accounts = new HashSet();
        if (path != null) {
            String result = readFromFile(path);

            List<Account> accountList = mapper.readValue(result, new TypeReference<List<Account>>(){});
            accounts = accountList.stream()
                    .filter(account -> account.getClientId().equals(1L))
                    .collect(Collectors.toSet());
        }

        return accounts;
    }

    private String readFromFile(String path) throws IOException {
        StringBuilder s = new StringBuilder();
        FileReader fr = new FileReader(path);
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            s.append(scan.nextLine());
        }
        fr.close();
        return s.toString();
    }
}
