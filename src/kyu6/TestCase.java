package kyu6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
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
                                                                new String[] { "zone", "abigail", "theta", "form",
                                                                                "libe", "zas", "theta", "abigail" },
                                                                2),
                                                "First test case"),
                                () -> assertEquals("oocccffuucccjjjkkkjyyyeehh", ConsecutiveStrings.longestConsec(
                                                new String[] { "ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb",
                                                                "oocccffuucccjjjkkkjyyyeehh" },
                                                1), "Second test case"),
                                () -> assertEquals("", ConsecutiveStrings.longestConsec(new String[] {}, 3),
                                                "Third test case"),
                                () -> assertEquals(
                                                "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck",
                                                ConsecutiveStrings
                                                                .longestConsec(
                                                                                new String[] { "itvayloxrp",
                                                                                                "wkppqsztdkmvcuwvereiupccauycnjutlv",
                                                                                                "vweqilsfytihvrzlaodfixoyxvyuyvgpck" },
                                                                                2),
                                                "Foutrh test case"),
                                () -> assertEquals("wlwsasphmxxowiaxujylentrklctozmymu",
                                                ConsecutiveStrings
                                                                .longestConsec(
                                                                                new String[] { "wlwsasphmxx",
                                                                                                "owiaxujylentrklctozmymu",
                                                                                                "wpgozvxxiu" },
                                                                                2),
                                                "Fifth test case"),
                                () -> assertEquals("", ConsecutiveStrings
                                                .longestConsec(new String[] { "zone", "abigail", "theta", "form",
                                                                "libe", "zas" }, -2),
                                                "Sixth test case"),
                                () -> assertEquals("ixoyx3452zzzzzzzzzzzz",
                                                ConsecutiveStrings
                                                                .longestConsec(new String[] { "it", "wkppv", "ixoyx",
                                                                                "3452", "zzzzzzzzzzzz" },
                                                                                3),
                                                "Seventh test case"),
                                () -> assertEquals("",
                                                ConsecutiveStrings
                                                                .longestConsec(new String[] { "it", "wkppv", "ixoyx",
                                                                                "3452", "zzzzzzzzzzzz" },
                                                                                15),
                                                "Eights test case"),
                                () -> assertEquals("",
                                                ConsecutiveStrings
                                                                .longestConsec(new String[] { "it", "wkppv", "ixoyx",
                                                                                "3452", "zzzzzzzzzzzz" },
                                                                                0),
                                                "Ninth test case"));
        }

        @Test
        void testBreakCamelCase() {
                assertAll("Testin algorithm to break according camel case",
                                () -> assertEquals("camel Casing", BreakCamelCase.camelCase("camelCasing")),
                                () -> assertEquals("camel Casing Test", BreakCamelCase.camelCase("camelCasingTest")),
                                () -> assertEquals("camelcasingtest", BreakCamelCase.camelCase("camelcasingtest")),
                                () -> assertEquals("camel Casing", BreakCamelCase.camelCase2("camelCasing")),
                                () -> assertEquals("camel Casing Test", BreakCamelCase.camelCase2("camelCasingTest")),
                                () -> assertEquals("camelcasingtest", BreakCamelCase.camelCase2("camelcasingtest")));
        }

        @Test
        void testXbonaaci() {
                double precision = 1e-10;
                assertArrayEquals(new double[] { 1, 1, 1, 3, 5, 9, 17, 31, 57, 105 },
                                Xbonacci.tribonacci(new double[] { 1, 1, 1 }, 10), precision);
                assertArrayEquals(new double[] { 0, 0, 1, 1, 2, 4, 7, 13, 24, 44 },
                                Xbonacci.tribonacci(new double[] { 0, 0, 1 }, 10), precision);
                assertArrayEquals(new double[] { 0, 1, 1, 2, 4, 7, 13, 24, 44, 81 },
                                Xbonacci.tribonacci(new double[] { 0, 1, 1 }, 10), precision);
        }

        @Test
        void testFibonacciFriends() {
                double precision = 1e-10;
                assertArrayEquals(new double[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 },
                                FibonacciFriends.xbonacci(new double[] { 0, 1 }, 10));
                assertArrayEquals(new double[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 },
                                FibonacciFriends.xbonacci(new double[] { 1, 1 }, 10));
                assertArrayEquals(new double[] { 0, 0, 0, 0, 1, 1, 2, 4, 8, 16 },
                                FibonacciFriends.xbonacci(new double[] { 0, 0, 0, 0, 1 }, 10));
                assertArrayEquals(new double[] { 1, 0, 0, 0, 0, 0, 1, 2, 3, 6 },
                                FibonacciFriends.xbonacci(new double[] { 1, 0, 0, 0, 0, 0, 1 }, 10));
        }

        @Test
        void testExtendedForm() {
                assertEquals("10 + 2", ExtendedForm.expandedForm(12));
                assertEquals("40 + 2", ExtendedForm.expandedForm(42));
                assertEquals("70000 + 300 + 4", ExtendedForm.expandedForm(70304));
        }

        @Test
        @Disabled
        void testMeeting() {
                assertEquals(
                                "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)",
                                Meeting.meeting(
                                                "Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"));

                assertEquals(
                                "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)",
                                Meeting.meeting(
                                                "John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell"));

                assertEquals(
                                "(ARNO, ALEX)(ARNO, HALEY)(BELL, SARAH)(CORNWELL, ALISSA)(DORNY, PAUL)(DORRIES, ANDREW)(KERN, ANN)(KERN, MADISON)",
                                Meeting.meeting(
                                                "Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern"));
        }

        @Test
        void testCharacterSelection() {
                String[][] fighters = new String[][] {
                                new String[] { "Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega" },
                                new String[] { "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison" },
                };
                int[] position = new int[] { 0, 0 };
                assertAll("Testing cases for CharacterSelection",
                                () -> assertArrayEquals(new String[] {},
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] {}),
                                                "should Work With No Moves"),
                                () -> assertArrayEquals(new String[] { "Ryu", "Vega", "Ryu", "Vega", "Balrog" },
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] { "up", "left", "right", "left",
                                                                                "left" }),
                                                "should Work With Few Moves"),
                                () -> assertArrayEquals(
                                                new String[] { "Vega", "Balrog", "Guile", "Blanka", "E.Honda", "Ryu",
                                                                "Vega", "Balrog" },
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] { "left", "left", "left", "left", "left",
                                                                                "left", "left", "left" }),
                                                "should Work When Always Moving Left"),
                                () -> assertArrayEquals(
                                                new String[] { "E.Honda", "Blanka", "Guile", "Balrog", "Vega", "Ryu",
                                                                "E.Honda", "Blanka" },
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] { "right", "right", "right", "right",
                                                                                "right", "right", "right", "right" }),
                                                "should Work When Always Moving Right"),
                                () -> assertArrayEquals(
                                                new String[] { "Ryu", "Vega", "M.Bison", "Ken", "Ryu", "Vega",
                                                                "M.Bison", "Ken" },
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] { "up", "left", "down", "right", "up",
                                                                                "left", "down", "right" }),
                                                "should Use All 4 Directions Clockwise Twice"),
                                () -> assertArrayEquals(new String[] { "Ken", "Ken", "Ken", "Ken" },
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] { "down", "down", "down", "down" }),
                                                "should Work When Always Moving Down"),
                                () -> assertArrayEquals(new String[] { "Ryu", "Ryu", "Ryu", "Ryu" },
                                                CharacterSelection.streetFighterSelection(fighters, position,
                                                                new String[] { "up", "up", "up", "up" }),
                                                "should Work When Always Moving Up"));
        }

}
