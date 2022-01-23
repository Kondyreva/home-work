package com.sbrf.reboot.lab16.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Account {
    private Double balance;
    private String currency;
}