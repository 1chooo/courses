// Name: Chunho Lin
// USC NetID: 3226964170
// CS 455 PA1
// Fall 2025

import java.awt.Point;
import java.awt.geom.Line2D;

/**
 * A class that generates the segments of a spiral.
 */
public class SpiralGenerator {

   /**
    * SEGMENTS_PER_LENGTH_INCREASE: Number of segments after which the segment
    * length
    */
   private static final int SEGMENTS_PER_LENGTH_INCREASE = 2;
   private static final int TOTAL_DIRECTIONS = 4;
   private Point current;
   private int unitLength;
   private int stepLength;
   private Dir direction;
   private int stepCount;

   /**
    * Enum representing the four directions in the spiral.
    * Each direction has a delta (dx, dy).
    */
   private enum Dir {
      RIGHT(1, 0),
      UP(0, -1),
      LEFT(-1, 0),
      DOWN(0, 1);

      final int dx, dy;

      /**
       * Constructor for direction with its delta values.
       * 
       * @param dx
       * @param dy
       */
      Dir(int dx, int dy) {
         this.dx = dx;
         this.dy = dy;
      }

      /**
       * Returns the next direction in clockwise order.
       * 
       * @return the next direction
       */
      Dir next() {
         return values()[(this.ordinal() + 1) % TOTAL_DIRECTIONS];
      }
   }

   /**
    * Creates a SpiralGenerator starting at startPosition,
    * with length of first segment and distance between
    * "layers" both given as unitLength.
    * 
    * @param startPosition starting point of the spiral
    * @param unitLength    initial segment length and step increment, must be > 0
    */
   public SpiralGenerator(Point startPosition, int unitLength) {
      this.current = startPosition;
      this.unitLength = unitLength;
      this.stepLength = unitLength;
      this.direction = Dir.RIGHT; // start moving right
      this.stepCount = 0;
   }

   /**
    * A method that returns the next segment of the spiral
    * as a Line2D object. Each call to this method
    * updates the internal state of the generator so that
    * the next call will return the subsequent segment.
    */
   public Line2D nextSegment() {
      double x1 = current.getX();
      double y1 = current.getY();
      double x2 = x1 + direction.dx * stepLength;
      double y2 = y1 + direction.dy * stepLength;

      Line2D line = new Line2D.Double(x1, y1, x2, y2);

      // Update state for the next call
      current = new Point((int) x2, (int) y2);
      direction = direction.next();
      stepCount++;

      // Increase length after every two segments
      if (stepCount % SEGMENTS_PER_LENGTH_INCREASE == 0) {
         stepLength += unitLength;
      }

      return line;
   }
}
