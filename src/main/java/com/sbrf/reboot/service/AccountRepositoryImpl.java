package com.sbrf.reboot.service;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {
    private final String path;

    public AccountRepositoryImpl(String path) {
        this.path = path;
    }

    @Override
    public Set<Account> getAllAccountsByClientId(Integer clientId) throws IOException {
        Set<Account> accounts = new HashSet();
        if (path != null) {
            String result = getDataFromFile().toString();
            int findClientIdIndex = 0;
            int findNumberIndex;
            while (findClientIdIndex != -1) {
                findClientIdIndex = result.indexOf("clientId", findClientIdIndex + 1);
                if (findClientIdIndex != -1) {
                    /*парсинг номера clientId и сравнение его с входящим параметром clientId*/
                    /*парсить json стринговыми методами бесчеловечно!*/
                    if (result.substring(findClientIdIndex + 11,
                            result.indexOf(",", findClientIdIndex + 11)).equals(clientId.toString())) {
                        findNumberIndex = result.indexOf("number", findClientIdIndex + 11);
                        String str = result.substring(findNumberIndex + 10,
                                result.indexOf("\"", findNumberIndex + 10));
                        accounts.add(new Account(str));
                    }
                }
            }
        }
        return accounts;
    }

    private StringBuilder getDataFromFile() throws IOException {
        try (FileInputStream inputStream = new FileInputStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
                result.append(System.lineSeparator());
            }
            return result;
        }
    }

    @Override
    public Set<Account> getAllAccountsByClientId(Long clientId) throws IOException {
        return getAllAccountsByClientId(clientId.intValue());
    }

    @Override
    public void changeAccountClientId(Integer oldClientId, Integer newClientId) throws IOException {
        if (path != null) {
            StringBuilder oldString = getDataFromFile();
            StringBuilder newString = new StringBuilder(oldString);
            int findClientIdIndex = 0;
            while (findClientIdIndex != -1) {
                findClientIdIndex = newString.indexOf("clientId", findClientIdIndex + 1);
                if (findClientIdIndex != -1) {
                    if (newString.substring(findClientIdIndex + 11,
                            newString.indexOf(",", findClientIdIndex + 11)).equals(oldClientId.toString())) {
                        newString.replace(findClientIdIndex + 11,
                                newString.indexOf(",", findClientIdIndex + 11), newClientId.toString());
                    }
                }
            }
            if (!newString.toString().equals(oldString.toString())) {
                writeToFile(newString);
            }
        }
    }

    private void writeToFile(StringBuilder result) throws IOException {
        try (FileWriter targetFile = new FileWriter(path)) {
            targetFile.write(result.toString());
        }
    }
}
