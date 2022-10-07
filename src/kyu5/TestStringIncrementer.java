package kyu5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestStringIncrementer {

    @Test
    void test() {
        assertEquals("foo1", StringIncrementer.incrementString("foo"));
        assertEquals("foobar24", StringIncrementer.incrementString("foobar23"));
        assertEquals("foo0043", StringIncrementer.incrementString("foo0042"));
        assertEquals("foo11", StringIncrementer.incrementString("foo10"));
        assertEquals("foo100", StringIncrementer.incrementString("foo099"));
        assertEquals("fo99obar100", StringIncrementer.incrementString("fo99obar99"));
        assertEquals("00000000000000000238752136360447460",
                StringIncrementer.incrementString("00000000000000000238752136360447459"));
        assertEquals("11532022802707002102891", StringIncrementer.incrementString("11532022802707002102890"));
    }

    @Test
    void testKPrimes() {
        assertEquals(
                Arrays.toString(new long[] { 4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49, 51,
                        55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95 }),
                Arrays.toString(kPrimes.countKPrimes(2, 0, 100)));
        assertEquals(
                Arrays.toString(new long[] { 8, 12, 18, 20, 27, 28, 30, 42, 44, 45, 50, 52, 63, 66, 68, 70, 75, 76,
                        78, 92, 98, 99 }),
                Arrays.toString(kPrimes.countKPrimes(3, 0, 100)));
        assertEquals(
                Arrays.toString(new long[] { 1020, 1026, 1032, 1044, 1050, 1053, 1064, 1072, 1092, 1100 }),
                Arrays.toString(kPrimes.countKPrimes(5, 1000, 1100)));
        assertEquals(
                Arrays.toString(new long[] { 500, 520, 552, 567, 588, 592, 594 }),
                Arrays.toString(kPrimes.countKPrimes(5, 500, 600)));
        
        assertEquals(
                Arrays.toString(new long[] { 4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39, 46, 49, 51,
                        55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95 }),
                Arrays.toString(kPrimes.countKPrimes2(2, 0, 100)));
        assertEquals(
                Arrays.toString(new long[] { 8, 12, 18, 20, 27, 28, 30, 42, 44, 45, 50, 52, 63, 66, 68, 70, 75, 76,
                        78, 92, 98, 99 }),
                Arrays.toString(kPrimes.countKPrimes2(3, 0, 100)));
        assertEquals(
                Arrays.toString(new long[] { 1020, 1026, 1032, 1044, 1050, 1053, 1064, 1072, 1092, 1100 }),
                Arrays.toString(kPrimes.countKPrimes2(5, 1000, 1100)));
        assertEquals(
                Arrays.toString(new long[] { 500, 520, 552, 567, 588, 592, 594 }),
                Arrays.toString(kPrimes.countKPrimes2(5, 500, 600)));
    }

}
