package com.sbrf.reboot.lab14.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private Integer age;
    private String name;
    private List<Account> accounts;
}
