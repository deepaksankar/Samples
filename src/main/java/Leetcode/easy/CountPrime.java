package main.java.Leetcode.easy;

/**
 * Given a number, return the number of prime number that is within the number
 */
public class CountPrime {
  public static void main(String[] args) {
    int out = countPrimes(10);
    System.out.println(out);
  }

  static int countPrimes(int n) {
    int count = 0;
    boolean[] results = new boolean[n];
    for(int i = 0; i < n; i++) {
      results[i] = true;
    }

    for(int i = 2; i*i < n; i++) {
      if(results[i]) {
        for(int j = i; j*i < n; j++) {
          results[j*i] = false;
        }
      }
    }

    for(int i = 2; i < n; i++) {
      if(results[i])
        count++;
    }
    return count;
  }
}
