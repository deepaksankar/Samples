package main.java.GFG;

public class ReverseString {
  public static void main(String[] args) {
    String S1 = "Geeks for geeks";
    ReverseString rs = new ReverseString();
    rs.reverseIteratively(S1);
    rs.reverseRecursively(S1);
  }

  void reverseRecursively(String in) {
    if(in == null || in.length() <= 1) {
      System.out.print(in);
      return;
    }
    System.out.print(in.charAt(in.length()-1));
    reverseRecursively(in.substring(0, in.length()-1));
  }

  void reverseIteratively(String in) {
    StringBuilder sb = new StringBuilder();
    for(int i = in.length()-1; i >= 0; i--) {
      sb.append(in.charAt(i));
    }
    System.out.println(sb.toString());
  }
}
