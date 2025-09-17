// Name: Chunho Lin
// USC NetID: 3226964170
// CS 455 PA1
// Fall 2025

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * A component that draws a spiral using the SpiralGenerator.
 * The spiral is drawn based on the specified starting position,
 * unit length, and number of segments.
 */
public class SpiralComponent extends JComponent {

   /**
    * List to store the segments of the spiral for drawing.
    */
   private List<Line2D> segments;

   /**
    * Constructs a SpiralComponent that will draw a spiral with the given
    * parameters.
    * 
    * @param startPosition the starting position of the spiral (center point)
    * @param unitLength    the length of the first segment and the increment for
    *                      subsequent segments
    * @param numSegments   the total number of segments to be drawn in the spiral
    */
   public SpiralComponent(Point startPosition, int unitLength, int numSegments) {
      this.segments = new ArrayList<>();
      SpiralGenerator generator = new SpiralGenerator(startPosition, unitLength);

      // Generate all segments once and store them
      for (int i = 0; i < numSegments; i++) {
         Line2D segment = generator.nextSegment();
         segments.add(segment);
      }
   }

   /**
    * Overrides the paintComponent method to draw the spiral segments.
    * 
    * @param g the graphics context used for drawing
    */
   @Override
   public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;

      for (int i = 0; i < segments.size(); i++) {
         Line2D segment = segments.get(i);
         g2.draw(segment);
         System.out.println("Drawing segment " + i + " from " + segment.getP1() + " to " + segment.getP2());
      }
   }
}
