// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 PA2
// Fall 2025

import java.util.ArrayList;

/**
 * TestAssert program to demonstrate assertion behavior with valid and invalid
 * Bookshelf constructor calls.
 */
public class TestAssert {

   public static void main(String[] args) {
      TestAssert tester = new TestAssert();

      System.out.println("\n=== Exercise 5 (1 checkoff point) ===");

      System.out.println("\n=== Testing Bookshelf Constructor with Valid Data ===");
      tester.testValidBookshelf();

      System.out.println("\n=== Testing Bookshelf Constructor with Invalid Data ===");
      tester.testInvalidBookshelf();

      System.out.println("\nTest completed successfully!");
   }

   /**
    * Tests the Bookshelf constructor with valid data that satisfies the
    * precondition.
    * This should always succeed.
    */
   private void testValidBookshelf() {
      ArrayList<Integer> validBooks = new ArrayList<>();
      validBooks.add(5);
      validBooks.add(10);
      validBooks.add(15);
      validBooks.add(20);

      Bookshelf validShelf = new Bookshelf(validBooks);
      System.out.println("Valid bookshelf created: " + validShelf.toString());
   }

   /**
    * Tests the Bookshelf constructor with invalid data that violates the
    * precondition.
    * This should fail when assertions are enabled (-ea flag).
    */
   private void testInvalidBookshelf() {
      ArrayList<Integer> invalidBooks = new ArrayList<>();
      invalidBooks.add(5);
      invalidBooks.add(-3); // Invalid: negative height
      invalidBooks.add(10);
      invalidBooks.add(0); // Invalid: zero height

      System.out.println("Attempting to create bookshelf with invalid data: " + invalidBooks);

      // This will trigger an assertion failure when -ea is enabled
      // because the precondition check (book > 0) will fail
      Bookshelf invalidShelf = new Bookshelf(invalidBooks);
      System.out.println("Invalid bookshelf created: " + invalidShelf.toString());
   }
}
