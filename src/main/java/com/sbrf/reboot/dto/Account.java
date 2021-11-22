package com.sbrf.reboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Account {
    Long id;
    LocalDate createDate;
    BigDecimal balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", balance=" + balance +
                '}';
    }
}
