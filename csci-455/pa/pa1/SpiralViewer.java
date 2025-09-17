// Name: Chunho Lin
// USC NetID: 3226964170
// CS 455 PA1
// Fall 2025

import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.Point;

/**
 * A class that creates a window to display a spiral using the SpiralComponent.
 * The spiral starts from the center of the window,
 * with the first segment pointing to the right.
 * The user is prompted to input the window dimensions,
 * initial segment length, and number of segments to draw.
 * The spiral is drawn using SpiralComponent classes.
 */
public class SpiralViewer {

   private static final int DEFAULT_WINDOW_WIDTH = 1200;
   private static final int DEFAULT_WINDOW_HEIGHT = 600;
   private static final int MIN_SEGMENT_LENGTH = 1;
   private static final int MIN_NUMBER_OF_SEGMENTS = 1;
   private static final int CENTER_POSITION_DIVISOR = 2;

   private int windowWidth;
   private int windowHeight;
   private int unitLength;
   private int numSegments;

   /*
    * Constructs a SpiralViewer with default parameters.
    */
   public SpiralViewer() {
      this.windowWidth = DEFAULT_WINDOW_WIDTH;
      this.windowHeight = DEFAULT_WINDOW_HEIGHT;
      this.unitLength = MIN_SEGMENT_LENGTH;
      this.numSegments = MIN_NUMBER_OF_SEGMENTS;
   }

   /**
    * Prompts the user for spiral configuration parameters:
    * window width, window height, initial segment length, and number of segments.
    * Validates the inputs to ensure they meet the minimum requirements.
    */
   private void promptForSpiralConfig() {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter width: ");
      this.windowWidth = scanner.nextInt();

      System.out.print("Enter height: ");
      this.windowHeight = scanner.nextInt();

      while (true) {
         System.out.print("Enter length of initial segment: ");
         int length = scanner.nextInt();
         if (length >= MIN_SEGMENT_LENGTH) {
            this.unitLength = length;
         } else {
            System.out.println("ERROR: Segment length must be >= " + MIN_SEGMENT_LENGTH);
         }
         if (length >= MIN_SEGMENT_LENGTH)
            break;
      }

      while (true) {
         System.out.print("Enter number of segments: ");
         int num = scanner.nextInt();
         if (num >= MIN_NUMBER_OF_SEGMENTS) {
            this.numSegments = num;
         } else {
            System.out.println("ERROR: Number of segments must be >= " + MIN_NUMBER_OF_SEGMENTS);
         }
         if (num >= MIN_NUMBER_OF_SEGMENTS)
            break;
      }

      scanner.close();
   }

   /**
    * Creates and displays the JFrame window containing the SpiralComponent.
    * The spiral starts from the center of the window.
    */
   private void run() {
      JFrame frame = new JFrame();

      frame.setSize(windowWidth, windowHeight);
      frame.setTitle("Spiral");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Point startPosition = new Point(windowWidth / CENTER_POSITION_DIVISOR,
            windowHeight / CENTER_POSITION_DIVISOR);

      SpiralComponent spiralComponent = new SpiralComponent(startPosition, unitLength, numSegments);
      frame.add(spiralComponent);

      frame.setVisible(true);
   }

   /**
    * The main method to run the SpiralViewer program.
    * It creates a SpiralViewer instance, prompts for configuration,
    * and runs the viewer to display the spiral.
    * 
    * @param args command line arguments (not used)
    */
   public static void main(String[] args) {
      SpiralViewer viewer = new SpiralViewer();
      viewer.promptForSpiralConfig();
      viewer.run();
   }
}
