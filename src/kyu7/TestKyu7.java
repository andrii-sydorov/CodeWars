package kyu7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKyu7 {

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
}
