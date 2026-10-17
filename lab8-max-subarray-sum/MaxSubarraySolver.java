

public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        //Check for empty/one value
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //Initialize maxSum to first element
        int maxSum = arr[0];

        //Picks starting index
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            //Picks ending index
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j]; //Add next element to subarray/Extends subarray

                if (currentSum > maxSum) {
                    maxSum = currentSum; // Updates the global maxSum if there is a bigger sum
                }
            }


        }
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        //Check for empty/one value
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxSoFar = arr[0];
        int currentSum = arr[0];

        //Single loop compared to the 2 loops the brute-force method uses
        //Every action within the loop takes O(1) time
        for (int i = 1; i < arr.length; i++) {
            //Extends old running sum or start new subarray
            currentSum = Math.max(currentSum + arr[i], arr[i]);

            //Updates the overall maximum found
            maxSoFar = Math.max(maxSoFar, currentSum);

        }
        return maxSoFar;
    }
}