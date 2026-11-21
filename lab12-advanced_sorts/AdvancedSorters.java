import java.util.Arrays;
import java.util.Comparator;

public class AdvancedSorters {

    // --- MergeSort ---
    public static <K> void mergeSort(K[] S, Comparator comp) {
        int n = S.length;
        if (n < 2) return; // Base case

        // TODO: Divide -> Finished
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        // TODO: Conquer (recursive calls) -> Finished
        mergeSort(S1, comp);
        mergeSort(S2, comp);

        // TODO: Combine -> Finished
        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator comp) {
        int i = 0, j = 0;   //Trackers for S1 and S2
        int k = 0;          //Tracker for the write-in slot for S
        // TODO: Implement the merge logic from the lecture -> Finished
        // while (i < S1.length && j < S2.length) ...
        while (i < S1.length && j < S2.length) {

            if (comp.compare(S1[i], S2[j]) <= 0) {      //If S1[i] is less than or equal to S2[j]...
                S[k] = S1[i];                           //Picks smaller element and writes it in
                i++;
            } else {
                S[k] = S2[j];
                j++;
            }
            k++;
        }
        // TODO: Copy remaining elements of S1 or S2 -> Finished
        while (i < S1.length) {
            S[k] = S1[i];
            i++;
            k++;
        }
        while (j < S2.length) {
            S[k] = S2[j];
            j++;
            k++;
        }
    }

    // --- QuickSort ---
    public static <K> void quickSort(K[] S, Comparator comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator comp, int a, int b) {
        if (a >= b) return; // Base case

        // TODO: Divide
        int j = partition(S, comp, a, b);

        // TODO: Conquer (recursive calls) -> Finished
        quickSort(S, comp, a, j);
        quickSort(S, comp, j + 1    , b);
    }

    private static <K> int partition(K[] S, Comparator comp, int a, int b) {
        // TODO: Implement partition logic (e.g., Hoare's from lecture) -> Finished, used Hoare's Algorithm
        // 1. Choose a pivot (e.g., S[a])
        K pivot = S[a];
        // 2. Set up 'left' and 'right' pointers
        int i = a - 1;
        int j = b + 1;

        // 3. Loop and swap elements
        while (true) {
            do {    //Find element larger than left pivot
                i++;
            } while (i <= b && comp.compare(S[i], pivot) < 0);

            do {    //Find element smaller than right pivot
                j--;
            } while (j >= a && comp.compare(S[j], pivot) > 0);

            // 4. Return the final index of the pivot
            if (i >= j) {
                return j;
            }

            K temp = S[i];
            S[i] = S[j];
            S[j] = temp;
        }
    }
}