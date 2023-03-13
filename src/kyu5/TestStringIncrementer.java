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
                                Arrays.toString(new long[] { 4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39,
                                                46, 49, 51,
                                                55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95 }),
                                Arrays.toString(kPrimes.countKPrimes(2, 0, 100)));
                assertEquals(
                                Arrays.toString(new long[] { 8, 12, 18, 20, 27, 28, 30, 42, 44, 45, 50, 52, 63, 66, 68,
                                                70, 75, 76,
                                                78, 92, 98, 99 }),
                                Arrays.toString(kPrimes.countKPrimes(3, 0, 100)));
                assertEquals(
                                Arrays.toString(new long[] { 1020, 1026, 1032, 1044, 1050, 1053, 1064, 1072, 1092,
                                                1100 }),
                                Arrays.toString(kPrimes.countKPrimes(5, 1000, 1100)));
                assertEquals(
                                Arrays.toString(new long[] { 500, 520, 552, 567, 588, 592, 594 }),
                                Arrays.toString(kPrimes.countKPrimes(5, 500, 600)));

                assertEquals(
                                Arrays.toString(new long[] { 4, 6, 9, 10, 14, 15, 21, 22, 25, 26, 33, 34, 35, 38, 39,
                                                46, 49, 51,
                                                55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95 }),
                                Arrays.toString(kPrimes.countKPrimes2(2, 0, 100)));
                assertEquals(
                                Arrays.toString(new long[] { 8, 12, 18, 20, 27, 28, 30, 42, 44, 45, 50, 52, 63, 66, 68,
                                                70, 75, 76,
                                                78, 92, 98, 99 }),
                                Arrays.toString(kPrimes.countKPrimes2(3, 0, 100)));
                assertEquals(
                                Arrays.toString(new long[] { 1020, 1026, 1032, 1044, 1050, 1053, 1064, 1072, 1092,
                                                1100 }),
                                Arrays.toString(kPrimes.countKPrimes2(5, 1000, 1100)));
                assertEquals(
                                Arrays.toString(new long[] { 500, 520, 552, 567, 588, 592, 594 }),
                                Arrays.toString(kPrimes.countKPrimes2(5, 500, 600)));
        }

        @Test
        public void exampleTests() {
                SnakesLadders game = new SnakesLadders();
                assertEquals("Player 1 is on square 38", game.play(1, 1));
                assertEquals("Player 1 is on square 44", game.play(1, 5));
                assertEquals("Player 2 is on square 31", game.play(6, 2));
                assertEquals("Player 1 is on square 25", game.play(1, 1));
        }

        @Test
        public void phoneDirectory() {
                String dr = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
                                + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
                                + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
                                + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
                                + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
                                + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
                                + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
                                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
                                + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
                                + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
                                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"
                                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n";

                assertEquals(
                                "Phone => 48-421-674-8974, Name => Anastasia, Address => Via Quirinal Roma",
                                PhoneDirectory.phone(dr, "48-421-674-8974"));
                assertEquals(
                                "Phone => 1-921-512-2222, Name => Wilfrid Stevens, Address => Wild Street AA-67209",
                                PhoneDirectory.phone(dr, "1-921-512-2222"));
                assertEquals(
                                "Phone => 1-908-512-2222, Name => Peter O'Brien, Address => High Street CC-47209",
                                PhoneDirectory.phone(dr, "1-908-512-2222"));
                assertEquals(
                                "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St.",
                                PhoneDirectory.phone(dr, "1-541-754-3010"));
                assertEquals(
                                "Phone => 1-121-504-8974, Name => Arthur Clarke, Address => San Antonio TT-45120",
                                PhoneDirectory.phone(dr, "1-121-504-8974"));
                assertEquals(
                                "Phone => 1-498-512-2222, Name => Bernard Deltheil, Address => Mount Av. Eldorado",
                                PhoneDirectory.phone(dr, "1-498-512-2222"));
                assertEquals("Error => Too many people: 1-098-512-2222", PhoneDirectory.phone(dr, "1-098-512-2222"));
                assertEquals("Error => Not found: 5-555-555-5555", PhoneDirectory.phone(dr, "5-555-555-5555"));
        }

}
