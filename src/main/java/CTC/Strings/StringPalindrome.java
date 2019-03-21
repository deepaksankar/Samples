package main.java.CTC.Strings;

public class StringPalindrome {
    public static void main(String[] args) {
        String input = "aabcc";
        if(canBeAPalindrome(input)) {
            System.out.println(input + " can be a palindrome");
        } else {
            System.out.println(input + " cannot be a palindrome");
        }
    }

    static boolean canBeAPalindrome(String in) {
        if(in == null)
            return false;
        if(in.length() < 2) {
            return true;
        }
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        int count = 0;
        for(char c : in.toCharArray()) {
            int val = getCharNumber(c);
            if(val !=-1) {
                table[val]++;
                if(table[val] %2 == 1) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count <= 1;
    }

    static int getCharNumber(char c) {
        int value = Character.getNumericValue(c);
        if(c >= Character.getNumericValue('a') && c <= Character.getNumericValue('z')) {
            return value-Character.getNumericValue('a');
        }
        return -1;
    }
}
