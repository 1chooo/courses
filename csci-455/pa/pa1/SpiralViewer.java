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
    * Get the window width.
    * 
    * @return the window width
    */
   public int getWindowWidth() {
      return windowWidth;
   }

   /**
    * Get the window height.
    * 
    * @return the window height
    */
   public int getWindowHeight() {
      return windowHeight;
   }

   /**
    * Get the unit length of the spiral segments.
    * 
    * @return the unit length
    */
   public int getUnitLength() {
      return unitLength;
   }

   /**
    * Get the number of segments in the spiral.
    * 
    * @return the number of segments
    */
   public int getNumSegments() {
      return numSegments;
   }

   /**
    * Sets the window width, ensuring it is positive.
    * If the provided width is not positive, it defaults to DEFAULT_WINDOW_WIDTH.
    */
   private void setWindowWidth(int width) {
      this.windowWidth = (width > 0) ? width : DEFAULT_WINDOW_WIDTH;
   }

   /**
    * Sets the window height, ensuring it is positive.
    * If the provided height is not positive, it defaults to DEFAULT_WINDOW_HEIGHT.
    */
   private void setWindowHeight(int height) {
      this.windowHeight = (height > 0) ? height : DEFAULT_WINDOW_HEIGHT;
   }

   /**
    * Sets the unit length of the spiral segments,
    * ensuring it is at least MIN_SEGMENT_LENGTH.
    * If the provided length is less than MIN_SEGMENT_LENGTH,
    * it prints an error message and
    * does not change the current unit length.
    */
   private void setUnitLength(int length) {
      if (length >= MIN_SEGMENT_LENGTH) {
         this.unitLength = length;
      } else {
         System.out.println("ERROR: Segment length must be >= " + MIN_SEGMENT_LENGTH);
      }
   }

   /**
    * Sets the number of segments in the spiral,
    * ensuring it is at least MIN_NUMBER_OF_SEGMENTS.
    * If the provided number is less than MIN_NUMBER_OF_SEGMENTS,
    * it prints an error message and
    * does not change the current number of segments.
    */
   private void setNumSegments(int num) {
      if (num >= MIN_NUMBER_OF_SEGMENTS) {
         this.numSegments = num;
      } else {
         System.out.println("ERROR: Number of segments must be >= " + MIN_NUMBER_OF_SEGMENTS);
      }
   }

   /**
    * Prompts the user for spiral configuration parameters:
    * window width, window height, initial segment length, and number of segments.
    * Validates the inputs to ensure they meet the minimum requirements.
    */
   private void promptForSpiralConfig() {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter width: ");
      setWindowWidth(scanner.nextInt());

      System.out.print("Enter height: ");
      setWindowHeight(scanner.nextInt());

      while (true) {
         System.out.print("Enter length of initial segment: ");
         int length = scanner.nextInt();
         setUnitLength(length);
         if (length >= MIN_SEGMENT_LENGTH)
            break;
      }

      while (true) {
         System.out.print("Enter number of segments: ");
         int num = scanner.nextInt();
         setNumSegments(num);
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
