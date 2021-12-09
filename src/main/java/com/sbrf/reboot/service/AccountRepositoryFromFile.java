package com.sbrf.reboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AccountRepositoryFromFile implements AccountRepository {
    private final String path;
    private static final ObjectMapper mapper = new ObjectMapper();

    public AccountRepositoryFromFile(String path) {
        this.path = path;
    }

    @Override
    public Set<Account> getAllAccountsByClientId(Long clientId) throws IOException {
        Set<Account> accounts = new HashSet();
        if (path != null) {
            String result = readFromFile(path);

            StringReader reader = new StringReader(result);
            mapper.readValue(reader, String.class);
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
