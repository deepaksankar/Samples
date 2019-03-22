package main.java.GFG;

/**
 * Input array - {-6, -3, -1, 2, 4, 5}
 * Output Array - {1, 4, 9, 16, 25, 36}
 */
public class SumOfSquaresArray {
    public static void main(String[] args) {
        int[] input = {-6, -3, -1, 2, 4, 5};

        SumOfSquaresArray sosa = new SumOfSquaresArray();

        int[] output = sosa.sortedSquareArray(input);

        for(int k = 0; k < output.length; k++) {
            System.out.print(output[k] + " ");
        }
    }

    int[] sortedSquareArray(int[] input) {
        int[] result = new int[input.length];
        int i;
        for(i = 0; i < input.length; i++) {
            if(input[i] >= 0) {
                break;
            }
        } //Can use binary search to make this step faster

        int negEnd = i-1;
        int posBeg = i;

        int ind = 0;

        while(negEnd >= 0 && posBeg < input.length) {
            if(input[negEnd]*input[negEnd] < input[posBeg]*input[posBeg]) {
                result[ind] = input[negEnd]*input[negEnd];
                negEnd--;
            } else {
                result[ind] = input[posBeg]*input[posBeg];
                posBeg++;
            }
            ind++;
        }

        while(negEnd >= 0) {
            result[ind++] = input[negEnd]*input[negEnd];
            negEnd--;
        }

        while(posBeg < input.length) {
            result[ind++] = input[posBeg]*input[posBeg];
            posBeg++;
        }

        return result;
    }
}
