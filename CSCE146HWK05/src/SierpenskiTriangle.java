/*
 * the goal of this program is to generate and display Sierpinski's Triangle using recursion.
 * Lily Deller
 */

// importing necessary libraries
import javax.swing.*;
import java.awt.*;

// class named SierpinskiTriangle that extends JPanel (GUI component)
public class SierpenskiTriangle extends JPanel {

    // recursive method to draw Sierpinski's Triangle
    private void drawSierpinskiTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int limit) {
        // base case: stop when the pixel limit is reached
        if (limit <= 4) {
            int[] xPoints = {x1, x2, x3}; // array to hold x-coordinates of triangle vertices
            int[] yPoints = {y1, y2, y3}; // array to hold y-coordinates of triangle vertices
            g.setColor(Color.BLUE); // set color for drawing
            g.fillPolygon(xPoints, yPoints, 3); // draw filled triangle
        } else {
            // calculate midpoints of triangle sides
            int midX1 = (x1 + x2) / 2;
            int midY1 = (y1 + y2) / 2;
            int midX2 = (x2 + x3) / 2;
            int midY2 = (y2 + y3) / 2;
            int midX3 = (x1 + x3) / 2;
            int midY3 = (y1 + y3) / 2;

            // recursively draw smaller triangles
            drawSierpinskiTriangle(g, x1, y1, midX1, midY1, midX3, midY3, limit / 2);
            drawSierpinskiTriangle(g, midX1, midY1, x2, y2, midX2, midY2, limit / 2);
            drawSierpinskiTriangle(g, midX3, midY3, midX2, midY2, x3, y3, limit / 2);
        }
    }

    // method to draw on JPanel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // define coordinates of the outer triangle
        int x1 = getWidth() / 2;
        int y1 = 10;
        int x2 = 10;
        int y2 = getHeight() - 10;
        int x3 = getWidth() - 10;
        int y3 = getHeight() - 10;

        // draw Sierpinski's Triangle
        drawSierpinskiTriangle(g, x1, y1, x2, y2, x3, y3, getWidth());
    }

    // main method to create JFrame and display Sierpinski's Triangle
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski's Triangle"); // create a JFrame with title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close operation
        frame.setSize(600, 600); // set frame size
        frame.add(new SierpenskiTriangle()); // add SierpinskiTriangle object to frame
        frame.setVisible(true); // make frame visible
    }
}
