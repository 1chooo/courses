// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 PA2
// Fall 2025

import java.util.ArrayList;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf. Books on a bookshelf
 * can only be accessed in a specific way so books don't fall down; You can add
 * or remove a book only when it's on one of the ends of the shelf. However, you
 * can look at any book on
 * a shelf by giving its location (starting at 0). Books are identified only by
 * their height;
 * two books of the same height can be thought of as two copies of the same
 * book.
 */
public class Bookshelf {

   /**
    * Representation invariant:
    * 
    * books != null &&
    * for all i, 0 <= i < books.size(), books.get(i) != null && books.get(i) > 0
    * 
    * That is, the ArrayList books is not null, and all books in the collection
    * have positive heights (no null or non-positive heights allowed).
    */

   /*
    * books is the list of heights of books on this Bookshelf.
    */
   private ArrayList<Integer> books;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      books = new ArrayList<>();
      assert isValidBookshelf(); // sample assert statement (you will be adding more of these calls)
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    * 
    * @param pileOfBooks an ArrayList of Integer heights of books to be placed on
    *                    the Bookshelf (in the given order)
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      assert pileOfBooks != null;
      for (Integer book : pileOfBooks) {
         assert book != null && book > 0;
      }
      books = new ArrayList<>(pileOfBooks);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    * 
    * @param height the height of the book to be added
    */
   public void addFront(int height) {
      assert height > 0;
      books.add(0, height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    *
    * @param height the height of the book to be added
    */
   public void addLast(int height) {
      assert height > 0;
      books.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      assert size() > 0;
      int removed = books.remove(0);
      assert isValidBookshelf();
      return removed;
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      assert size() > 0;
      int removed = books.remove(books.size() - 1);
      assert isValidBookshelf();
      return removed;
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    * 
    * @param position the position of the book whose height is being requested
    */
   public int getHeight(int position) {
      assert 0 <= position && position < size();
      return books.get(position);
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      assert isValidBookshelf();
      return books.size();
   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the
    * height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the
    * format shown
    * by example here: "[7, 33, 5, 4, 3]"
    */
   public String toString() {
      assert isValidBookshelf();
      return books.toString();
   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      assert isValidBookshelf();
      for (int i = 1; i < books.size(); i++) {
         if (books.get(i) < books.get(i - 1)) {
            return false;
         }
      }
      return true;
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      if (books == null) {
         return false;
      }
      for (Integer book : books) {
         if (book == null || book <= 0) {
            return false;
         }
      }
      return true;
   }
}
