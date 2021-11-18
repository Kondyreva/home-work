package com.sbrf.reboot.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    private static Stream<Arguments> provideArgsForAddition() {
        return Stream.of(
                Arguments.of(1, 2, 3, "firstTerm=1, secondTerm=2, result should be 3"),
                Arguments.of(10, 20, 30, "firstTerm=10, secondTerm=20, result should be 30")
        );
    }

    @ParameterizedTest(name = "{index}. Use {3}")
    @MethodSource("provideArgsForAddition")
    void getAdditionParameterizedTest(Integer a, Integer b, Integer expected, String description) {
        assertEquals(expected, Calculator.getAddition(a, b));
    }

    @Test
    void getAdditionOverflow() {
        assertThrows(ArithmeticException.class, () -> Calculator.getAddition(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    void getAdditionNullValue() {
        assertThrows(NullPointerException.class, () -> Calculator.getSubtraction(null, 3));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
    }

    @Test
    void getExponentiation() {
        assertEquals((int) Math.pow(5, 9), Calculator.getExponentiation(5, 9));
    }

    @Test
    void classHasSevenMethods() {
        assertEquals(7, Calculator.class.getMethods().length - Object.class.getMethods().length);
    }

    @Test
    void convertSimpleOperationsToString() {
        assertEquals("Subtraction", Calculator.convertSimpleOperationsToString("-"));
    }

    @Test
    void integerToBinaryString() {
        assertEquals("100010101", Calculator.integerToBinaryString(277));
    }

}