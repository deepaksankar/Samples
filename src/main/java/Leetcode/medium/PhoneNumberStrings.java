package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numbers from mobile phone as input string print all combinations of alphabets
 * Eg - Input = 23
 *  Output = "ad, ae, af, bd, be, bf, cd, ce, cf
 */
public class PhoneNumberStrings {
    public static void main(String[] args) {
        String digits = "23";

        String[] mapping = {
                "", //0 does not contain any digits
                "", //0 does not contain any digits
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxys"
        };

        List<String> results = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return;
        }

        phoneNumbersRecursive(results, digits, "", 0, mapping);

        System.out.println("Done");
    }

    static void phoneNumbersRecursive(List<String> results, String digits, String current, int index, String[] mapping) {
        if (index == digits.length()) {
            results.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            phoneNumbersRecursive(results, digits, current + letters.charAt(i), index+1, mapping);
        }

    }
}
