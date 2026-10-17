
public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        //Check for empty/only one value
        if (arr == null || arr.length <= 1) {
            return;
        }

        //Sets baseline for loop for it to begin, waits for inner loops to finish before advancing
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //Scans the rest of the array to check for smaller values
            for (int j =  i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; //Updates minIndex if smaller value is found
                }
            }

            int temp = arr[i];  //Temp stores the first minimum element found
            arr[i] = arr[minIndex]; //Assigns absolute minimum
            arr[minIndex] = temp; //Then changes out minIndex for the first minimum element found (swapping places basically)

        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        //Check for empty/only one value
        if (arr == null || arr.length <= 1) {
            return;
        }
        //Assumes Index 0 is sorted already, starts at index 1
        for (int i = 1; i < arr.length; i++) {

            int current = arr[i]; //Stores variable in current
            int j = i - 1; //Look at index bef  ore i

            //Check for if within array bounds and if arr[j]
            while (j >= 0 && arr[j] > current) {
                if (arr[j] > current) {
                    arr[j + 1] = arr[j]; //Shifts larger element to right
                    j--; //Move pointer to left
                }
            }
            arr[j + 1] = current; //the value saved is now dropped into the index again
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {

        //Base Case
        if (left >= right) {
            return;
        }

        //Finds the mid-point
        int mid = left + (right - left) / 2;

        //Recursive sort for left
        mergeSortRecursive(arr, temp, left, mid);
        //Recursive sort for right
        mergeSortRecursive(arr, temp, mid + 1, right);
        //Merge both parts together
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {

        int i = left; //Left sub-array pointer
        int j = mid + 1; //Right sub-array pointer
        int k = left; //Temp array pointer

        //Compares and merges smaller elements into the temp aray
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++; //Move left pointer forward
            } else {
                temp[k] = arr[j];
                j++; //Move mid-pointer forward
            }
            k++; //Move temp pointer forward
        }
        //If left half has leftovers
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        //If right half has leftovers
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        //Copies everything from the temp array back to original array
        for (int l = left; l <= right; l++) {
            arr[l] = temp[l];
        }

    }
}
