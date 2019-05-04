package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)
 *
 * Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.
 */
public class PatternMatching {
  public static void main(String[] args) {
    String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
    String pattern = "FB";
    List<Boolean> results = camelCase(queries, pattern);
    System.out.println(results);
  }

  private static List<Boolean> camelCase(String[] queries, String pattern) {
    List<Boolean> results = new ArrayList<>();
    char[] patternArr = pattern.toCharArray();
    for(String query : queries) {
      results.add(helper(query.toCharArray(), patternArr));
    }

    return results;
  }

  private static Boolean helper(char[] query, char[] pattern) {

    int j = 0;

    for(int i = 0; i < query.length; i++) {
      if(j < pattern.length && query[i] == pattern[j]) {
        j++;
      } else if(query[i] >= 'A' && query[i] < 'Z') {
        return false;
      }
    }

    return j == pattern.length;
  }
}
