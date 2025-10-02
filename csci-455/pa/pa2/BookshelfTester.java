// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 PA2
// Fall 2025

import java.util.ArrayList;

public class BookshelfTester {
   public static void main(String[] args) {
      BookshelfTester tester = new BookshelfTester();

      System.out.println("\n=== Exercise 2 (1 checkoff point) ===");

      System.out.println("\n=== 1. Testing Empty Bookshelf ===");
      tester.testEmptyBookshelf();

      System.out.println("\n=== 2. Testing Constructor with Initial Books ===");
      tester.testConstructorWithInitialBooks();

      System.out.println("\n=== Exercise 3 (1 checkoff point) ===");

      System.out.println("\n=== 3. Testing addFront method ===");
      tester.testAddFront();

      System.out.println("\n=== 4. Testing addLast method ===");
      tester.testAddLast();

      System.out.println("\n=== 5. Testing removeFront method ===");
      tester.testRemoveFront();

      System.out.println("\n=== 6. Testing removeLast method ===");
      tester.testRemoveLast();

      System.out.println("\n=== Exercise 4 (1 checkoff point) ===");

      System.out.println("\n=== 7. Testing getHeight method ===");
      tester.testGetHeight();

      System.out.println("\n=== 8. Testing size method ===");
      tester.testSize();

      System.out.println("\n=== 9. Testing toString method ===");
      tester.testToString();
   }

   private void testEmptyBookshelf() {
      Bookshelf empty = new Bookshelf();
      System.out.println("Expected: []");
      System.out.println("Actual:   " + empty.toString());
   }

   private void testConstructorWithInitialBooks() {
      ArrayList<Integer> init = new ArrayList<>();
      init.add(2);
      init.add(4);
      init.add(6);
      Bookshelf shelf = new Bookshelf(init);
      System.out.println("Expected: [2, 4, 6]");
      System.out.println("Actual:   " + shelf.toString());
   }

   private void testAddFront() {
      Bookshelf shelf = new Bookshelf();
      shelf.addFront(5);
      System.out.println("After addFront(5): " + shelf.toString() + " (Expected: [5])");
      shelf.addFront(3);
      System.out.println("After addFront(3): " + shelf.toString() + " (Expected: [3, 5])");
      shelf.addFront(7);
      System.out.println("After addFront(7): " + shelf.toString() + " (Expected: [7, 3, 5])");
   }

   private void testAddLast() {
      Bookshelf shelf = new Bookshelf();
      shelf.addLast(5);
      System.out.println("After addLast(5): " + shelf.toString() + " (Expected: [5])");
      shelf.addLast(3);
      System.out.println("After addLast(3): " + shelf.toString() + " (Expected: [5, 3])");
      shelf.addLast(7);
      System.out.println("After addLast(7): " + shelf.toString() + " (Expected: [5, 3, 7])");
   }

   private void testRemoveFront() {
      Bookshelf shelf = new Bookshelf();
      shelf.addLast(10);
      shelf.addLast(20);
      shelf.addLast(30);
      System.out.println("Initial shelf: " + shelf.toString()); // Expected: [10, 20, 30]
      int removed = shelf.removeFront();
      System.out.println("Removed from front: " + removed + " (Expected: 10)");
      System.out.println("Shelf after removeFront: " + shelf.toString() + " (Expected: [20, 30])");
   }

   private void testRemoveLast() {
      Bookshelf shelf = new Bookshelf();
      shelf.addLast(10);
      shelf.addLast(20);
      shelf.addLast(30);
      System.out.println("Initial shelf: " + shelf.toString()); // Expected: [10, 20, 30]
      int removed = shelf.removeLast();
      System.out.println("Removed from last: " + removed + " (Expected: 30)");
      System.out.println("Shelf after removeLast: " + shelf.toString() + " (Expected: [10, 20])");
   }

   private void testGetHeight() {
      Bookshelf shelf = new Bookshelf();
      shelf.addLast(15);
      shelf.addLast(25);
      shelf.addLast(35);
      System.out.println("Shelf: " + shelf.toString()); // Expected: [15, 25, 35]
      for (int i = 0; i < shelf.size(); i++) {
         int height = shelf.getHeight(i);
         System.out.println("Height at position " + i + ": " + height + " (Expected: " + (15 + i * 10) + ")");
      }
   }

   private void testSize() {
      Bookshelf shelf = new Bookshelf();
      System.out.println("Initial size: " + shelf.size() + " (Expected: 0)");
      shelf.addLast(10);
      System.out.println("Size after adding one book: " + shelf.size() + " (Expected: 1)");
      shelf.addLast(20);
      System.out.println("Size after adding second book: " + shelf.size() + " (Expected: 2)");
      shelf.removeFront();
      System.out.println("Size after removing one book: " + shelf.size() + " (Expected: 1)");
      shelf.removeLast();
      System.out.println("Size after removing last book: " + shelf.size() + " (Expected: 0)");
   }

   private void testToString() {
      Bookshelf shelf = new Bookshelf();
      System.out.println("Empty shelf: " + shelf.toString() + " (Expected: [])");
      shelf.addLast(12);
      shelf.addLast(22);
      System.out.println("Shelf with books: " + shelf.toString() + " (Expected: [12, 22])");
   }
}
