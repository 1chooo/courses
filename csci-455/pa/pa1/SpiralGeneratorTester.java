// Name: Chunho Lin
// USC NetID: 3226964170
// CS 455 PA1
// Fall 2025

import java.awt.Point;
import java.awt.geom.Line2D;

public class SpiralGeneratorTester {

   /**
    * Main method that runs multiple test cases for the SpiralGenerator.
    * Tests spirals with different starting positions, unit lengths, and segment
    * counts
    * to ensure the generator works correctly across various configurations.
    * 
    * @param args command line arguments (not used)
    */
   public static void main(String[] args) {
      SpiralGeneratorTester tester = new SpiralGeneratorTester();

      tester.testSpiral(new Point(200, 300), 5, 10);
      tester.testSpiral(new Point(0, 0), 3, 8);
      tester.testSpiral(new Point(50, 50), 1, 6);
   }

   /**
    * Tests the SpiralGenerator by generating a spiral and printing segment
    * details.
    * It checks that each segment is either horizontal or vertical, that
    * consecutive
    * segments are connected, and that they are perpendicular to each other.
    * 
    * @param start       the starting point of the spiral
    * @param unitLength  the length of the first segment
    * @param numSegments the total number of segments to generate
    */
   private void testSpiral(Point start, int unitLength, int numSegments) {
      System.out.println("Making a spiral starting from " + start);
      System.out.println("with a unit length of " + unitLength + ", and made up of " + numSegments + " segments:");

      SpiralGenerator spiral = new SpiralGenerator(start, unitLength);
      Line2D prevSegment = null;

      for (int i = 1; i <= numSegments; i++) {
         Line2D seg = spiral.nextSegment();

         System.out.printf(
               "Segment #%d: Point2D.Double[%.1f, %.1f] Point2D.Double[%.1f, %.1f]%n",
               i, seg.getX1(), seg.getY1(), seg.getX2(), seg.getY2());

         if (!isHorizontal(seg) && !isVertical(seg)) {
            System.out.println("FAILED: segment is not horizontal or vertical. Skipping pair tests.");
         } else if (prevSegment != null) {
            if (!isConnected(prevSegment, seg)) {
               System.out.println("FAILED: last two segments are not connected");
            }

            if (!isPerpendicular(prevSegment, seg)) {
               System.out.println("FAILED: last two segments are not perpendicular");
            }
         }

         prevSegment = seg;
      }

      System.out.println();
   }

   /**
    * Helper method to check if a segment is horizontal.
    * 
    * @param seg the segment to check
    * 
    * @return true if the segment is horizontal, false otherwise
    */
   private boolean isHorizontal(Line2D seg) {
      return seg.getY1() == seg.getY2();
   }

   /**
    * Helper method to check if a segment is vertical.
    * 
    * @param seg the segment to check
    * 
    * @return true if the segment is vertical, false otherwise
    */
   private boolean isVertical(Line2D seg) {
      return seg.getX1() == seg.getX2();
   }

   /*
    * Helper method to check if two segments are connected.
    *
    * @param seg1 the first segment
    * 
    * @param seg2 the second segment
    * 
    * @return true if the segments are connected, false otherwise
    */
   private boolean isConnected(Line2D seg1, Line2D seg2) {
      return seg1.getX2() == seg2.getX1() &&
            seg1.getY2() == seg2.getY1();
   }

   /*
    * Helper method to check if two segments are perpendicular.
    * 
    * @param seg1 the first segment
    * 
    * @param seg2 the second segment
    * 
    * @return true if the segments are perpendicular, false otherwise
    */
   private boolean isPerpendicular(Line2D seg1, Line2D seg2) {
      boolean seg1Horizontal = seg1.getY1() == seg1.getY2();
      boolean seg1Vertical = seg1.getX1() == seg1.getX2();
      boolean seg2Horizontal = seg2.getY1() == seg2.getY2();
      boolean seg2Vertical = seg2.getX1() == seg2.getX2();

      return (seg1Horizontal && seg2Vertical) ||
            (seg1Vertical && seg2Horizontal);
   }
}
