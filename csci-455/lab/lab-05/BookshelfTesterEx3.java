// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 Lab 5
// Fall 2025

import java.util.ArrayList;

public class BookshelfTesterEx3 {
   public static void main(String[] args) {
      BookshelfTesterEx3 tester = new BookshelfTesterEx3();

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
}
