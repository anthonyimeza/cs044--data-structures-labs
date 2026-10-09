
import javax.swing.*;
import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Start the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // TODO: Implement the recursive logic here.

        // 1. Base Case (Stopping Condition)
        // If depth is 0, stop the recursion.

        if (depth == 0) { //Check for depth
            return; //Stops the rest of code from running further
        }

        // 2. Recursive Step
        // Calculate the length of the current branch (it should get smaller with depth).
        // Calculate the end point (x2, y2) of the branch using trigonometry.
        // Hint: x2 = x1 + length * cos(angle_in_radians)
        //       y2 = y1 + length * sin(angle_in_radians)
        // Remember to convert the angle to radians: Math.toRadians(angle)

            int length = depth * 10; //Length calculation

            double angle_in_radians = Math.toRadians(angle); //Angle conversion to RAD
            //Cast to int, since cos & sin are both double (Can use Math.round for more accuracy, but read that it doesn't make too much of a difference for graphics)
            int x2 = (int) (x1 + length * cos(angle_in_radians));
            int y2 = (int) (y1 + length * sin(angle_in_radians));

            g.drawLine(x1,y1,x2,y2); //Draws the line using coordinates

        // Draw the line for the current branch.

        // Make two recursive calls for the left and right sub-branches.
        // - Branch left by subtracting from the angle (e.g., angle - 20).

        drawTree(g, x2, y2, angle - 20, depth - 1);//Uses previous ending coordinates as base and subtract from angle for left branches

        // - Branch right by adding to the angle (e.g., angle + 30).
        // - Decrease the depth for both calls (depth - 1).

        drawTree(g, x2, y2, angle + 30, depth - 1); //Uses previous ending coordinates as base and adds to angle for right branches

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}