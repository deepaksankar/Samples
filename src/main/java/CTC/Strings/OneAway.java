package main.java.CTC.Strings;

public class OneAway {
  public static void main(String[] args) {
    String s1 = "pale";
    String s2 = "baled";
    if(oneAway(s1, s2)) {
      System.out.println("Two strings are one distance away");
    } else {
      System.out.println("Nope");
    }
  }

  static boolean oneAway(String first, String second) {
    if(Math.abs(first.length()-second.length()) > 1) {
      return false;
    }
    String Longer = first.length() < second.length() ? second : first;
    String shorter = first.length() < second.length() ? first : second;

    int index1 = 0; int index2 = 0;
    boolean foundDiff = false;

    while(index1 < Longer.length() && index2 < shorter.length()) {
      if(shorter.charAt(index2) != Longer.charAt(index1)) {
        if(foundDiff) {
          return false;
        }
        foundDiff = true;
        if(Longer.length() == shorter.length()) {
          index2++;
        }
      } else {
        index2++;
      }
      index1++;
    }
    return true;
  }
}
