
public class MazeSolver {

    public char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Public wrapper method to start the maze-solving process.
     * It should find the starting 'S' position and initiate the recursive search.
     * @return true if a path is found, false otherwise.
     */
    public boolean solve() {
        // TODO: Find the starting row and column of 'S'
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    return solve(i,j); //Updated check for the starting row & column
                }
            }
        }
        return false; //Return false if 'S' is never found
    }

    /**
     * The core recursive method to solve the maze.
     * @param row The current row position.
     * @param col The current column position.
     * @return true if this position leads to a solution, false otherwise.
     */
    private boolean solve(int row, int col) {
        // TODO: Implement the recursive logic with backtracking here.

        // 1. Base Case (Stopping Conditions)
        // Check if out of bounds, a wall, or already visited.
        // Check if the current cell is the finish ('F').

        if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) { //Check for OoB
            return false;
        } else if (maze[row][col] == '#' || maze[row][col] == '.') { //Check for wall/previously explored
            return false;
        } else if (maze[row][col] == 'F') { //Check if it's the Exit
            return true;
        }


        // 2. Recursive Step
        // Mark the current cell as part of the path.
        // Try moving North, East, South, West.
        // If any direction returns true, then you've found a path, return true.

        char temp = maze[row][col]; //Saves the explored tile for backtracking
        maze[row][col] = '.'; //Marks current cell as explored

        if (solve(row - 1, col) || solve(row + 1, col) || //Recursive movement (tries all directions)
            solve(row, col - 1) || solve(row, col + 1)) {  //If available cell is found, goes that way
            return true;
        }


        // 3. Backtracking
        // If no direction works, un-mark the cell and return false.

        maze[row][col] = temp; //Resets the previously explored cell ('.') to blank (' ') to try to find new path.
        return false; //Path failed
    }



    public static void main(String[] args) {
        char[][] mazeToSolve = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver.printMaze();
    }
}