package com.sbrf.reboot.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Account {
    private Long clientId;
    private Long id;
    private BigDecimal balance;
    private LocalDate createDate;
    private String number;

    public Account(String number) {

        this.number = number;
    }

    public Account(Integer clientId, String number) {
        this.clientId = Long.valueOf(clientId);
        this.number = number;
    }
}
