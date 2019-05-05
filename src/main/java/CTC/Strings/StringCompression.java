package main.java.CTC.Strings;

public class StringCompression {
  public static void main(String[] args) {
    String input = "aaabbccccd";
    String compress = compressedString(input);
    System.out.println(compress);
  }

  static String compressedString(String input) {
    if(input.length() < 1) {
      return "";
    }
    int continuous = 0;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < input.length(); i++) {
      continuous++;
      if(i+1 == input.length() || input.charAt(i) != input.charAt(i+1)) {
        sb.append(input.charAt(i));
        sb.append(continuous);
        continuous = 0;
      }
    }
    return sb.toString();
  }
}
