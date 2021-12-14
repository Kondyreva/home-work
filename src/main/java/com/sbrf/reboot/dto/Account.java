package com.sbrf.reboot.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Account{" +
                "clientId=" + clientId +
                ", id=" + id +
                ", balance=" + balance +
                ", createDate=" + createDate +
                ", number='" + number + '\'' +
                '}';
    }
}
