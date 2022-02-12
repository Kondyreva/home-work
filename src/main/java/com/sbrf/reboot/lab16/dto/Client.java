package com.sbrf.reboot.lab16.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Client {
    private Integer age = 30;
    private String name = "Jon";
}
