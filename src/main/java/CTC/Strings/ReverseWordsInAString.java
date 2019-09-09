package main.java.CTC.Strings;

/**
 * Given a sentence, reverse all word occurrence in the sentence.
 * Eg: "hi there" becomes "there hi"
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "abc def";
        String out = reverseWords(s);
        System.out.println(out);
    }

    static String reverseWords(String s) {
        String reverse = reverse(s);
        String result = "";
        String[] words = reverse.split(" ");
        for(String word : words) {
            result += reverse(word);
            result += " ";
        }
        return result.substring(0, result.length()-1);
    }

    static String reverse(String s) {
        String reverse = "";
        for(int i = s.length()-1; i > -1; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }
}
