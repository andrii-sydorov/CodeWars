package kyu4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase {

    @Test
    void testStringsMix() {
        assertAll("Testing StringsMix application",
                () -> assertEquals("2:eeeee/2:yy/=:hh/=:rr", StringsMix.mix("Are they here", "yes, they are here"),
                        "First test case"),
                () -> assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
                        StringsMix.mix("looping is fun but dangerous", "less dangerous than coding"),
                        "Second test case"),
                () -> assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                        StringsMix.mix(" In many languages", " there's a pair of functions"),
                        "Third test case"));
    }

}
