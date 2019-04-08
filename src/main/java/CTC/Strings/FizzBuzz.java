package main.java.CTC.Strings;

/**
 * Given a number, print Fizz for all multiples of 3 and Buzz for all multiples of 5, FizzBuzz if it a multiple of both and the numbers itself for other cases
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int N = 50;

        for(int i = 1; i <= N; i++) {
            if((i % (3*5)) == 0) {
                System.out.println("FizzBuzz");
            } else if (i%3 == 0) {
                System.out.println("Fizz");
            } else if (i%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
