package main.java.Leetcode.medium;

public class FlipGameII {
    public static void main(String[] args) {
        String input = "++++";
        if(flip(input)) {
            System.out.println("You won");
        }
    }

    static boolean flip(String input) {
        if(input == null || input.length() < 2) {
            return false;
        }

        for(int i = 0; i < input.length()-1; i++) {
            if(input.charAt(i) == '+' && input.charAt(i+1) == '+') {
                String newStr = input.substring(0,i) + "--" + input.substring(i+2);
                if(!flip(newStr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
