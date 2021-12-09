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
    private String name;

    public Account(String name) {
        this.name = name;
    }
}
