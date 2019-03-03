package main.java.GFG;

public class AddBinaryDigits {
    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        String out = addBinary(a,b);
        System.out.println(out);
    }

    static String addBinary(String a, String b)
    {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Travers both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Compute sum of last digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (s % 2 == 0 ? "0" : "1" ) + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }
}
