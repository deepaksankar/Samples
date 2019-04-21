package main.java.gomi;

public class InputArray {
    public static void main(String[] args) {
        System.out.println("Enter input\n");
        String test = args[0];
        String[] it = test.split(" ");

        double[] n = new double[args.length-2];
        for(int i = 2; i < args.length; i++) {
            n[i-2] = Double.parseDouble(args[i]);
            System.out.print(n[i] + " ");
        }
//        double in = Double.parseDouble(args[0]);
    }
}
