
import java.util.Random;

class Matrix {

    private int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

// data.length is the row and data[0] is the column
    public Matrix(int[][] data) {
        this.data = new int[data.length][data[0].length];

            for (int r = 0; r < data.length; r++) {
                for (int c = 0; c < data[r].length; c++){
                    this.data[r][c] = data [r][c];
                }
        }


    }


/*
* Populates both the row (variable - r) and column (variable - c) with random numbers
* Random is limited to 1-10 (added +1 to prevent 0 from appearing)
 */
    public void populateRandom() {
        Random random = new Random();
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                data[r][c] = random.nextInt(10) + 1;
            }
        }
    }

// Checks of Matrix 1 and Matrix 2 (other) are the same size, if not throws the error (catch will be in Main)
    public Matrix add(Matrix other) {
        if (other.data.length != data.length || other.data[0].length != data[0].length) {
            throw new IllegalArgumentException();
        }

// Creates a new Result Matrix that is empty, but has the same size as the previous.
        Matrix result = new Matrix(data.length, data[0].length);

/*
* For loops scan the matrices rows and columns (i.e. R1-C1, R2-C1.)
* It then grabs the numbers and adds them for the sum to be added to results matrix.
 */
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                result.data[r][c] = data[r][c] + other.data[r][c];
            }
        }

        return result;

    }





// Checks if columns match number of rows.
    public Matrix multiply(Matrix other) {
        if (data[0].length != other.data.length) {
            throw new IllegalArgumentException();
        }

        Matrix result = new Matrix(data.length, other.data[0].length);

/*
* Similar For loop as above, but with the addition of variable k (step counter for the multiplication)
* K ensures the entire row in matrix gets multiplied by the column of the other matrix
 */
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < other.data[0].length; c++) {
                for (int k = 0; k < data[0].length; k++)
                    result.data[r][c] += data[r][k] * other.data[k][c];
            }
        }

        return result;
    }

/*
* StringBuilder used for convenience
* Essentially loops through the row and columns printing them.
*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                sb.append(data[r][c]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}

