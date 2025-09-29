// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 Lab 5
// Fall 2025

import java.util.ArrayList;

public class BookshelfTesterEx2 {
   public static void main(String[] args) {
      BookshelfTesterEx2 tester = new BookshelfTesterEx2();

      System.out.println("\n=== Exercise 2 (1 checkoff point) ===");

      System.out.println("\n=== Testing Empty Bookshelf ===");
      tester.testEmptyBookshelf();

      System.out.println("\n=== Testing Constructor with Initial Books ===");
      tester.testConstructorWithInitialBooks();
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
}
