package com.sbrf.reboot.lab14.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private Double balance;
    private String currency;
    private LocalDate createDate;
}