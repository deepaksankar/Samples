package main.java.Leetcode.hard;

public class NumberToWords {
    static String[] onesDigits = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] tensDigits = new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] tenMultiples = new String[] {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static String[] tenPowers = new String[] {"hundred", "thousand"};

    public static void main(String[] args) {
        String out = numberToWords(-123);
        System.out.println(out);
    }

    static String numberToWords(int num) {
        String out = "";
        if(num < 0) {
            return "Negative " + numberToWords(num*-1);
        }
        if(num == 0) {
            return "zero";
        }

        while(num > 0) {
            if(num >= 1000 && num <= 999999) {
                int tempNum = num/1000;
                out += numberToWords(tempNum) + " " + tenPowers[1];
                num %= 1000;
                if(num < 100) {
                    out += " and ";
                }
            } else if(num >= 100 && num < 1000) {
                int digit = num/100;
                if(digit > 0) {
                    out += " " + onesDigits[digit] + " " + tenPowers[0];
                }
                num %= 100;
                if(num > 0) {
                    out += " and ";
                }
            } else if(num >= 20 && num < 100) {
                out += tenMultiples[num/10];
                num %= 10;
                if (num > 0) {
                    out += " ";
                }
            } else if(num >= 10 && num < 20) {
                out += tensDigits[num%10];
                num /= 20;
            } else if (num < 10) {
                out += onesDigits[num];
                num /= 10;
            }
        }
        return out;
    }
}
