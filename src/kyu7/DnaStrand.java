package kyu7;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 * Complementary DNA
 * 
 * Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and
 * carries the "instructions" for the development and functioning of living
 * organisms.
 * 
 * If you want to know more: http://en.wikipedia.org/wiki/DNA
 * 
 * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and
 * "G". You function receives one side of the DNA (string, except for Haskell);
 * you need to return the other complementary side. DNA strand is never empty or
 * there is no DNA at all (again, except for Haskell).
 * 
 * More similar exercise are found here:
 * http://rosalind.info/problems/list-view/ (source)
 * 
 * Example: (input --> output)
 * 
 * "ATTGC" --> "TAACG"
 * "GTAT" --> "CATA"
 * 
 * dnaStrand [] `shouldBe` []
 * dnaStrand [A,T,G,C] `shouldBe` [T,A,C,G]
 * dnaStrand [G,T,A,T] `shouldBe` [C,A,T,A]
 * dnaStrand [A,A,A,A] `shouldBe` [T,T,T,T]
 * 
 * 
 */

public class DnaStrand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna = sc.nextLine();
        System.out.println(makeComplement(dna));
    }

    private static String makeComplement(String dna) {
        if (dna.isEmpty()) {
            return dna;
        }
        Map<String, String> map = new HashMap<>();
        map.put("A", "T");
        map.put("T", "A");
        map.put("G", "C");
        map.put("C", "G");
        StringBuilder sb = new StringBuilder();
        for (String s : dna.split("")) {
            sb.append(map.get(s));
        }
        return sb.toString();
    }
}
