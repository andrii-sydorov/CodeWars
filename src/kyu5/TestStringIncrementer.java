package kyu5;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("00000000000000000238752136360447460", StringIncrementer.incrementString("00000000000000000238752136360447459"));
        assertEquals("11532022802707002102891", StringIncrementer.incrementString("11532022802707002102890"));
    }

}
