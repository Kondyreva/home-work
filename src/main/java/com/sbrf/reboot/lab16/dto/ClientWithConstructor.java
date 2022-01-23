package com.sbrf.reboot.lab16.dto;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ClientWithConstructor {
    private Client client;

    @Autowired
    public ClientWithConstructor(Client client){
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
