package com.sbrf.reboot.calculator;

import java.math.BigInteger;

public class Calculator {
    public static int getAddition(int firstTerm, int secondTerm) {
        return Math.addExact(firstTerm, secondTerm);
    }

    public static Integer getSubtraction(Integer minuend, Integer subtrahend) {
        return minuend - subtrahend;
    }

    public static int getMultiplication(int firstMultiplier, int secondMultiplier) {
        return Math.multiplyExact(firstMultiplier, secondMultiplier);
    }

    public static Integer getDivision(int dividend, int divider) {
        if (divider != 0) {
            return dividend / divider;
        }
        return 0;
    }

    public static Integer getExponentiation(Integer base, Integer index) {
        int result = 1;
        for (int i = 1; i <= index; i++) {
            result = Math.multiplyExact(result, base);
        }
        return result;
    }

    public static String convertSimpleOperationsToString(String operation) {
        String result;
        switch (operation) {
            case "+":
                result = "Addition";
                break;
            case "-":
                result = "Subtraction";
                break;
            case "*":
                result = "Multiplication";
                break;
            case "/":
                result = "Division";
                break;
            default:
                result = "It's not simple operation";
        }
        return result;
    }

    public static String integerToBinaryString(Integer x){
        return Integer.toBinaryString(x);
    }
}
