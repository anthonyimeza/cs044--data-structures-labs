
import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] arr = generateRandomArrayWithNegatives(n);

            //Brute-force Approach
            long start1 = System.nanoTime();
            int result1 = MaxSubarraySolver.bruteForceMaxSum(arr);
            long end1 = System.nanoTime();
            System.out.printf("Brute-Force Approach - O(n^2):    %.3f ms (Result: %d)\n", (end1 - start1) / 1e6, result1);

            //Kadane's Algorithm Approach
            long start2 = System.nanoTime();
            int result2 = MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            long end2 = System.nanoTime();
            System.out.printf("Kadane's Algorithm - O(n):  %.3f ms (Result: %d)\n", (end2 - start2) / 1e6, result2);

        }
    }

    //Generate random array with both positive and negative integers (-100 and 100)
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random random = new Random();
        int[]arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100; //Range is between -100 and 100
        }
        return arr;
    }
}