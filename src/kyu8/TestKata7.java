package kyu8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKata7 {

    @Test
    void converterFromHecToDec() {
        assertAll("testing converter from hexadimal number to decimal numbers",
                () -> assertEquals(1, ConverterToDecimal.hexToDec("1"), "Test with 1"),
                () -> assertEquals(10, ConverterToDecimal.hexToDec("a"), "Test with A"),
                () -> assertEquals(16, ConverterToDecimal.hexToDec("10"), "Test with 10"),
                () -> assertEquals(255, ConverterToDecimal.hexToDec("FF"), "Test with FF"),
                () -> assertEquals(-12, ConverterToDecimal.hexToDec("-C"), "Test with -C"));
    }

}
