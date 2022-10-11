package kyu6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase {

    @Test
    void testPersist() {
        assertAll("Testing persistance number",
                () -> assertEquals(3, Persist.persistence(39L)),
                () -> assertEquals(0, Persist.persistence(4L)),
                () -> assertEquals(2, Persist.persistence(25L)),
                () -> assertEquals(4, Persist.persistence(999L)));
    }

    @Test
    void testConsecutiveStrings() {
        assertAll("Testing the longest consecutive Strings",
                () -> assertEquals("abigailtheta",
                        ConsecutiveStrings.longestConsec(
                                new String[] { "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail" },
                                2),
                        "First test case"),
                () -> assertEquals("oocccffuucccjjjkkkjyyyeehh", ConsecutiveStrings.longestConsec(
                        new String[] { "ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb",
                                "oocccffuucccjjjkkkjyyyeehh" },
                        1), "Second test case"),
                () -> assertEquals("", ConsecutiveStrings.longestConsec(new String[] {}, 3), "Third test case"),
                () -> assertEquals("wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck",
                        ConsecutiveStrings
                                .longestConsec(
                                        new String[] { "itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv",
                                                "vweqilsfytihvrzlaodfixoyxvyuyvgpck" },
                                        2),
                        "Foutrh test case"),
                () -> assertEquals("wlwsasphmxxowiaxujylentrklctozmymu",
                        ConsecutiveStrings
                                .longestConsec(
                                        new String[] { "wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu" },
                                        2),
                        "Fifth test case"),
                () -> assertEquals("", ConsecutiveStrings
                        .longestConsec(new String[] { "zone", "abigail", "theta", "form", "libe", "zas" }, -2),
                        "Sixth test case"),
                () -> assertEquals("ixoyx3452zzzzzzzzzzzz",
                        ConsecutiveStrings
                                .longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" },
                                        3),
                        "Seventh test case"),
                () -> assertEquals("",
                        ConsecutiveStrings
                                .longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" },
                                        15),
                        "Eights test case"),
                () -> assertEquals("",
                        ConsecutiveStrings
                                .longestConsec(new String[] { "it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz" },
                                        0),
                        "Ninth test case"));
    }

}