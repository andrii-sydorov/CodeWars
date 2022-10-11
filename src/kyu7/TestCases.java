package kyu7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TestCases {

    @Disabled(value = "test to diasble testcase")
    @Test
    void testFighters() {
        assertEquals("Lew", TwoFigters.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", TwoFigters.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald",
                TwoFigters.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald",
                TwoFigters.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald",
                TwoFigters.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald",
                TwoFigters.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

    @Test
    void testFixedStrings() {
        assertEquals("code", FixStringCase.solve("code"));
        assertEquals("CODE", FixStringCase.solve("CODe"));
        assertEquals("code", FixStringCase.solve("COde"));
        assertEquals("code", FixStringCase.solve("Code"));
        assertEquals("", FixStringCase.solve(""));
    }

    @Test
    void testReverseString() {
        assertAll("Test tasks with reversing strings without numbers",
                () -> assertEquals("nahsirk", ReverseLetter.reverseLetter("krishan"), "First test case"),
                () -> assertEquals("nortlu", ReverseLetter.reverseLetter("ultr53o?n"),
                        "Second test case with combination numbers and special marks"),
                () -> assertEquals("cba", ReverseLetter.reverseLetter("ab23c"), "Third test case witn numbers"),
                () -> assertEquals("nahsirk", ReverseLetter.reverseLetter("krish21an"),
                        "Fourth test case witn numbers"));
    }

    @Test
    void testSumOfTriangleNumbers() {
        assertAll("Sum of Triangular numbers",
                () -> assertEquals(56, SumOfTriangleNumbers.sumTriangularNumbers(6), "First test case with 6"),
                () -> assertEquals(7140, SumOfTriangleNumbers.sumTriangularNumbers(34), "First test case with 34"),
                () -> assertEquals(0, SumOfTriangleNumbers.sumTriangularNumbers(-291), "First test case with -291"),
                () -> assertEquals(140205240, SumOfTriangleNumbers.sumTriangularNumbers(943),
                        "First test case with 943"),
                () -> assertEquals(0, SumOfTriangleNumbers.sumTriangularNumbers(-971), "First test case with -971"));

    }

    @Test
    void testAlphabetWar() {
        assertAll("Testing kata's alphabetWar",
                () -> assertEquals("Right side wins!", AlphabetWar.alphabetWar("z"), "First test case"),
                () -> assertEquals("Let's fight again!", AlphabetWar.alphabetWar("zdqmwpbs"), "Second test case"),
                () -> assertEquals("Right side wins!", AlphabetWar.alphabetWar("zzzzs"), "Thirtd test case"),
                () -> assertEquals("Left side wins!", AlphabetWar.alphabetWar("wwwwwwz"), "Fourth test case"));
    }

    @Test
    void testMostDigit() {
        assertAll("Testing most longest digits in Array",
                () -> assertEquals(100, MostDigit.findLongest(new int[] { 1, 10, 100 })),
                () -> assertEquals(9000, MostDigit.findLongest(new int[] { 9000, 8, 800 })),
                () -> assertEquals(40000, MostDigit.findLongest(new int[] { 3, 40000, 100 })),
                () -> assertEquals(100000, MostDigit.findLongest(new int[] { 1, 200, 100000 })),
                () -> assertEquals(-10, MostDigit.findLongest(new int[] { -10, 1, 0, 1, 10 })));
    }

    @Test
    void testStrayNumber() {
        assertAll("Testing the algorithm of finding unique numbers in the array",
                () -> assertEquals(2, StrayNumber.stray(new int[] { 1, 1, 2 })),
                () -> assertEquals(3, StrayNumber.stray(new int[] { 17, 17, 3, 17, 17, 17, 17 })),
                () -> assertEquals(2, StrayNumber.stray2(new int[] { 1, 1, 2 })),
                () -> assertEquals(3, StrayNumber.stray2(new int[] { 17, 17, 3, 17, 17, 17, 17 })));
    }

}
