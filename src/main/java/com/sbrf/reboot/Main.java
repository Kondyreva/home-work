package com.sbrf.reboot;

import com.sbrf.reboot.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 10;
        Integer result = Calculator.getAddition(5,10);
        System.out.println(result.toString());
    }
}
