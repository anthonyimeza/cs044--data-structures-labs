import java.util.Comparator;

public class SimpleSorters {

    /**
     * Sorts an array using the optimized Bubble Sort algorithm.
     */
    public static <K> void bubbleSort(K[] S, Comparator comp) {
        int n = S.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            // TODO: Implement the inner loop j -> Finished
            //n - 1 to prevent Out-of-Bounds with S[j+1], n - 1 - i to also skip the elements at the end (elements are already "bubbled")
            for (int j = 0; j < n - 1 - i; j++) {
                // ...
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    // TODO: Swap S[j] and S[j+1] -> Finished
                    K temp = S[j];      //Temp created for swap, stores S[j]
                    S[j] = S[j+1];      // S[j] -> S[j + 1]
                    S[j+1] = temp;      // S[j+1] is now swapped with the stored S[j]
                    swapped = true;
                } // ... end inner loop ...
            }

            // TODO: Add check for early termination -> Finished
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array using the Insertion Sort algorithm.
     */
    public static <K> void insertionSort(K[] S, Comparator comp) {
        int n = S.length;
        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            S[j + 1] = cur;
        }
    }
}