package kyu6;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        @Test
        void testDataReverse() {
                assertAll("testing the task data reverse",
                                () -> assertArrayEquals(
                                                new int[] { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0,
                                                                0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                                                DataReverse.dataReverse(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,
                                                                0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1,
                                                                0 }),
                                                "test with length 32 bits"),
                                () -> assertArrayEquals(new int[] { 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0 },
                                                DataReverse.dataReverse(new int[] { 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0,
                                                                1, 0, 0, 1 }),
                                                "test with length 16 bits"),
                                () -> assertArrayEquals(new int[] { 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0 },
                                                DataReverse.dataReverse(new int[] { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0,
                                                                0, 0, 1, 1 }),
                                                "failed tests"));
        }

        @Test
        void testStatistics() {
                assertAll("Statistics for an Athletic Association ",
                                () -> assertEquals("Range: 01|01|18 Average: 01|38|05 Median: 01|32|34",
                                                Stat.stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17")),
                                () -> assertEquals("Range: 00|31|17 Average: 02|26|18 Median: 02|22|00", Stat.stat(
                                                "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41")));
        }

        @Test
        void testLastSurvivors() {
                assertAll("Testing last survivors kata",
                                () -> assertEquals("ac", LastSurvivors.lastSurvivors("abaa")),
                                () -> assertEquals("c", LastSurvivors.lastSurvivors("zzab")),
                                () -> assertEquals("", LastSurvivors.lastSurvivors("")),
                                () -> assertEquals("acdeghlmnqrvyz", LastSurvivors.lastSurvivors(
                                                "xsdlafqpcmjytoikojsecamgdkehrqqgfknlhoudqygkbxftivfbpxhxtqgpkvsrfflpgrlhkbfnyftwkdebwfidmpauoteahyh")));

        }

        @Test
        void testLastSurvivorsEp2() {
                assertEquals("", LastSurvivorsEp3.lastSurvivors(new String[] { " ", "z" }, new int[] { 1 }));
                assertEquals("a", LastSurvivorsEp3.lastSurvivors(new String[] { "abc", "   ", " a " },
                                new int[] { 0, 4, 1 }));
                assertEquals("jj", LastSurvivorsEp3.lastSurvivors(new String[] { "zj", "zj" }, new int[] { 9, 0 }));
                assertEquals("", LastSurvivorsEp3.lastSurvivors(new String[] { "d", " ", " ", " ", " " },
                                new int[] { 1 }));
                assertEquals("eeeiu", LastSurvivorsEp3.lastSurvivors(new String[] { "help us we are dying" },
                                new int[] { 2, 0, 2, 1, 2, 0, 2, 1, 2, 0, 2, 1, 2, 0, 2, 1, 2, 0, 2, 1 }));
                assertEquals("ail",
                                LastSurvivorsEp3.lastSurvivors(
                                                new String[] { "to   ", "  tal", "it   ", "  ari", "an   ", "  ism" },
                                                new int[] { 7, 6, 4, 2, 1 }));
                assertEquals("", LastSurvivorsEp3.lastSurvivors(new String[] { " ", " " }, new int[] { 0 }));
                assertEquals("", LastSurvivorsEp3.lastSurvivors(new String[] {}, new int[] { 1, 2, 3, 4 }));
                assertEquals("", LastSurvivorsEp3.lastSurvivors(new String[] { "", "", "", "" }, new int[] {}));
                assertEquals("", LastSurvivorsEp3.lastSurvivors(new String[] {}, new int[] { 1, 2, 3 }));
                assertEquals("bbdefhilnoqrrsuvvvwy", LastSurvivorsEp3.lastSurvivors(
                                new String[] {
                                                "w bby   n d  r   s v",
                                                " ff  i vd     s     ",
                                                " e   glv          s ",
                                                "ug k  ob  am   t   a",
                                                " pmalfiih hw     ku ",
                                                "oj   w    w  rbe n  ",
                                                "d   q   iq  i k    y",
                                                "jn     g xn  b      ",
                                                "     navd   w      q"
                                },
                                new int[] { 2, 4, 4, 2, 1, 4, 7, 4, 2, 1, 7, 6, 7, 0, 2, 5, 0, 5, 6, 3 }));
        }

        @Test
        void SurvivorsEp4() {
                assertArrayEquals(new int[] {}, SurvivorsEp4.survivors(new int[] { 0 }, new int[][] { { 0 } }),
                                "length one");
                assertArrayEquals(new int[] {}, SurvivorsEp4.survivors(new int[] { 0 }, new int[][] { { 9 } }),
                                "length one");
                assertArrayEquals(new int[] { 0 }, SurvivorsEp4.survivors(new int[] { 2 }, new int[][] { { 0 } }),
                                "length one");
                assertArrayEquals(new int[] {}, SurvivorsEp4.survivors(new int[] { 2 }, new int[][] { { 0, 0 } }),
                                "length one");
                assertArrayEquals(new int[] {}, SurvivorsEp4.survivors(new int[] { 1 }, new int[][] { { 0, 3 } }),
                                "length one");
                assertArrayEquals(new int[] { 0 },
                                SurvivorsEp4.survivors(new int[] { 5 },
                                                new int[][] { { 0, 0, 0, 0, 4, 0, 0, 0, 8, 0, 0, 0, 0 } }),
                                "length one");

                assertArrayEquals(new int[] { 0 }, SurvivorsEp4.survivors(new int[] { 1 }, new int[][] { {} }),
                                "empty cases");
                assertArrayEquals(new int[] {}, SurvivorsEp4.survivors(new int[] { 0 }, new int[][] { {} }),
                                "empty cases");

                assertArrayEquals(new int[] { 0 }, SurvivorsEp4.survivors(new int[] { 3, 2, 1, 0 },
                                new int[][] { { 1, 0, 0 }, { 0, 2, 0, 0 }, { 0, 9 }, { 8, 8 } }), "multiple length");
                assertArrayEquals(new int[] { 0, 3 },
                                SurvivorsEp4.survivors(new int[] { 5, 1, 1, 1, 0 },
                                                new int[][] { { 0, 0, 0, 0, 4, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 3 },
                                                                { 0, 9, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
                                                                { 0, 2, 0, 0, 6, 0 } }),
                                "multiple length");
                assertArrayEquals(new int[] { 1, 2, 3, 4, 6 },
                                SurvivorsEp4.survivors(new int[] { 1, 1, 9, 3, 4, 0, 3 },
                                                new int[][] { { 2, 0, 2, 0, 0 }, { 9, 9 }, { 4 }, { 6, 6, 6 },
                                                                { 2, 0, 2, 1 }, { 1, 3 }, { 0, 0 } }),
                                "multiple length");
                assertArrayEquals(new int[] { 0, 1, 2, 4 }, SurvivorsEp4.survivors(new int[] { 9, 9, 8, 2, 6 },
                                new int[][] { {}, { 0, 0, 0, 5, 1 }, {}, { 0, 0, 0, 0 }, { 0 } }), "multiple length");

                assertArrayEquals(new int[] { 0, 1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 15, 16, 17 },
                                SurvivorsEp4.survivors(
                                                new int[] { 1, 1, 5, 7, 2, 5, 6, 2, 6, 3, 2, 6, 8, 6, 9, 2, 8, 7 },
                                                new int[][] { {}, { 3, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0 }, { 0, 3, 0 },
                                                                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0 },
                                                                {}, { 0 }, { 0, 0, 0, 0, 0, 7, 0 }, { 0 },
                                                                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0 }, { 0 },
                                                                { 5, 0, 0, 0, 0, 7 }, { 0 },
                                                                { 0, 0, 1, 0, 0, 1, 0 } }),
                                "new edge");
        }

}
