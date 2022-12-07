package kyu8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKata8 {

    @Test
    void converterFromHecToDec() {
        assertAll("testing converter from hexadimal number to decimal numbers",
                () -> assertEquals(1, ConverterToDecimal.hexToDec("1"), "Test with 1"),
                () -> assertEquals(10, ConverterToDecimal.hexToDec("a"), "Test with A"),
                () -> assertEquals(16, ConverterToDecimal.hexToDec("10"), "Test with 10"),
                () -> assertEquals(255, ConverterToDecimal.hexToDec("FF"), "Test with FF"),
                () -> assertEquals(-12, ConverterToDecimal.hexToDec("-C"), "Test with -C"));
    }

    @Test
    void testZywOo() {
        assertAll("testing the summ of descending array",
                () -> assertEquals(9, ZywOo.sumOfDifferences(new int[] { 1, 2, 10 })),
                () -> assertEquals(2, ZywOo.sumOfDifferences(new int[] { -3, -2, -1 })),
                () -> assertEquals(0, ZywOo.sumOfDifferences(new int[] { 1, 1, 1, 1, 1 })),
                () -> assertEquals(34, ZywOo.sumOfDifferences(new int[] { -17, 17 })),
                () -> assertEquals(0, ZywOo.sumOfDifferences(new int[0])),
                () -> assertEquals(0, ZywOo.sumOfDifferences(new int[] { 0 })),
                () -> assertEquals(0, ZywOo.sumOfDifferences(new int[] { -1 })));
    }

}
