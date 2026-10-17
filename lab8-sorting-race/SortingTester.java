import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        //Arrays Sizes
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            //Average Case - Data is random
            System.out.println("\n[Average Case - Random]");
            int[] randomArr = generateRandomArray(n);
            runAndTimAllSorts(randomArr);

            //Best Case - Data is already sorted
            System.out.println("\n[Best Case - Sorted]");
            int[] sortedArr = generateSortedArray(n);
            runAndTimAllSorts(sortedArr);


            //Worst Case - Data is sorted in reverse order
            System.out.println("\n[Worst Case - Reverse Sorted]");
            int[] reverseArr = generateReverseSortedArray(n);
            runAndTimAllSorts(reverseArr);

        }
    }
    //Clones and runs each sorting algorithm, measuring i milliseconds
    public static void runAndTimAllSorts(int[] originalArr) {
        //Selection Sort
        int[] arr1 = originalArr.clone();
        long start1 = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long end1 = System.nanoTime();
        System.out.printf("Selection Sort: %.3f ms\n", (end1 - start1) / 1e6);

        //Insertion Sort
        int[] arr2 = originalArr.clone();
        long start2 = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        long end2 = System.nanoTime();
        System.out.printf("Insertion Sort: %.3f ms\n", (end2 - start2) / 1e6);


        //Merge sort
        int[] arr3 = originalArr.clone();
        long start3 = System.nanoTime();
        int[] temp = new int[arr3.length];
        SortingAlgorithms.mergeSortRecursive(arr3, temp, 0, arr3.length - 1);
        long end3 = System.nanoTime();
        System.out.printf("Merge Sort: %.3f ms\n", (end3 - start3) / 1e6);

    }
    //Generates array with random integers
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[]arr = new int [size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }
        return arr;
    }
    //Generates sorted array
    public static int[] generateSortedArray(int size) {
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
    //Generates reverse sorted array
    public static int[] generateReverseSortedArray(int size) {
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}