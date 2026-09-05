
import java.util.Arrays;
import java.util.Random;

public class DotProduct {
    public static void main(String[] args) {

        int n = 5;

        int [] a = new int[n];
        int [] b = new int[n];
        int [] c = new int[n];

        Random rngArray = new Random();

        for (int i = 0; i < n; i++){

            a[i] = rngArray.nextInt(25) + 1;
            b[i] = rngArray.nextInt(25) + 1;
            c[i] = a[i] * b[i] ;
        }

        System.out.println("Array A: " + Arrays.toString(a));
        System.out.println("Array B: " + Arrays.toString(b));
        System.out.println("Array C: " + Arrays.toString(c));



    }
}