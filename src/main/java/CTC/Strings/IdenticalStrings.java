package main.java.CTC.Strings;

public class IdenticalStrings {
  public static void main(String[] args) {
    String s1 = "Sample";
    String s2 = "amples";
    if(isPermutation(s1,s2)) {
      System.out.println("Given strings are identical");
    } else {
      System.out.println("Not identical");
    }
  }

  static boolean isPermutation(String s1, String s2) {
    int[] set = new int[128];
    if(s1.length() != s2.length()) {
      return false;
    }
    for(int i = 0; i < s1.length(); i++) {
      set[s1.charAt(i)]++;
    }

    for(int j = 0; j < s2.length(); j++) {
      set[s2.charAt(j)]--;
      if(set[s2.charAt(j)] < 0) {
        return false;
      }
    }
    return true;
  }
}
