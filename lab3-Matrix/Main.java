

public class Main {
    public static void main(String[] args) {

        Matrix m1 = new Matrix(2,3);
        Matrix m2 = new Matrix(2,3);
        Matrix m3 = new Matrix(3,2);
        Matrix errM4 = new Matrix(4,4);

        m1.populateRandom();
        m2.populateRandom();
        m3.populateRandom();
        errM4.populateRandom();

        System.out.println("Matrix 1 (2x3)-\n" + m1);
        System.out.println("Matrix 2 (2x3)-\n" + m2);

        System.out.println("Addition #1 (Should pass)");

        try {
            Matrix sumResult  = m1.add(m2);
            System.out.println("Result:\n" + sumResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Matrix dimensions do not match, cannot continue with addition.");
        }

        System.out.println("Addition #2 (Should fail)");

        try {
            Matrix sumResult  = m1.add(errM4);
            System.out.println("Result:\n" + sumResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected Error: Matrix dimensions do not match, cannot continue with addition.\n");
        }


        System.out.println("Multiplication #1 (Should pass)");

        System.out.println("Matrix 1 (2x3)-\n" + m1);
        System.out.println("Matrix 3 (3x2)-\n" + m3);

        try {
            Matrix multResult = m1.multiply(m3);
            System.out.println("Result:\n" + multResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Matrix 1 columns must match rows of matrix 2.");
        }


        System.out.println("Multiplication #2 (Should fail)");
        try {
            Matrix multResult = m1.multiply(errM4);
            System.out.println("Result:\n" + multResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected Error: Multiplication failed because of dimension mismatch.");
        }

    }
}
