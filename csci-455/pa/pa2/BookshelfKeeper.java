// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 PA2
// Fall 2025

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient putPos or pickHeight operation on a
 * bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can
 * only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher
 * level pick or put
 * operation. Pick or put operations are performed with minimum number of such
 * adds or removes.
 */
public class BookshelfKeeper {

   /**
    * Representation invariant:
    * bookShelf != null && // The contained bookshelf is not null.
    * bookShelf.isSorted() is true && // The books on the shelf are always in
    * non-decreasing order by height.
    * totalOperations >= 0 && // The total number of mutator operations is
    * non-negative.
    * lastOperationCount >= 0 // The number of mutator operations for the last
    * pick/put is non-negative.
    */

   /**
    * bookShelf is the bookshelf being kept sorted by this BookshelfKeeper.
    */
   private Bookshelf bookShelf;
   /**
    * totalOperations is the total number of mutator operations so far on
    * the contained bookshelf to perform all pick or put operations requested
    * so far.
    */
   private int totalOperations;
   /**
    * lastOperationCount is the number of mutator operations used to perform
    * the last pick or put operation requested.
    */
   private int lastOperationCount;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      bookShelf = new Bookshelf();
      totalOperations = 0;
      lastOperationCount = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    * 
    * @param sortedBookshelf the initial sorted bookshelf to be managed by this
    *                        BookshelfKeeper
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      bookShelf = sortedBookshelf;
      totalOperations = 0;
      lastOperationCount = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in
    * the bookshelf and keeps bookshelf sorted after
    * picking up the book.
    * 
    * Returns the number of calls to mutators on
    * the contained bookshelf used to complete
    * this operation. This must be the
    * minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    * 
    * @param position the position of the book to be picked
    */
   public int pickPos(int position) {
      assert isValidBookshelfKeeper();
      assert 0 <= position && position < getNumBooks();

      Bookshelf tempPile = new Bookshelf();
      int originalSize = bookShelf.size();

      lastOperationCount = 0;

      if (position < originalSize / 2) {
         for (int i = 0; i < position; i++) {
            int moved = bookShelf.removeFront();
            tempPile.addLast(moved);
            lastOperationCount++;
         }
         bookShelf.removeFront();
         lastOperationCount++; // removing target
         while (tempPile.size() > 0) {
            int movedBack = tempPile.removeLast();
            bookShelf.addFront(movedBack);
            lastOperationCount++;
         }
      } else {
         for (int i = originalSize - 1; i > position; i--) {
            int moved = bookShelf.removeLast();
            tempPile.addLast(moved);
            lastOperationCount++;
         }
         bookShelf.removeLast();
         lastOperationCount++; // removing target
         while (tempPile.size() > 0) {
            int movedBack = tempPile.removeLast();
            bookShelf.addLast(movedBack);
            lastOperationCount++;
         }
      }
      totalOperations += lastOperationCount;
      assert isValidBookshelfKeeper();

      return lastOperationCount;
   }

   /**
    * Inserts book with specified height into the shelf. Keeps the contained
    * bookshelf sorted
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to
    * complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    * 
    * @param height the height of the book to be added
    */
   public int putHeight(int height) {
      assert isValidBookshelfKeeper();
      assert height > 0;

      Bookshelf tempPile = new Bookshelf();

      lastOperationCount = 0;

      if (bookShelf.size() == 0) {
         bookShelf.addLast(height);
         lastOperationCount = 1;
      } else {
         int position = 0;
         while (position < bookShelf.size() && bookShelf.getHeight(position) < height) {
            position++;
         }

         if (position < bookShelf.size() / 2) {
            for (int i = 0; i < position; i++) {
               int moved = bookShelf.removeFront();
               tempPile.addLast(moved);
               lastOperationCount++;
            }
            bookShelf.addFront(height);
            lastOperationCount++;
            while (tempPile.size() > 0) {
               int movedBack = tempPile.removeLast();
               bookShelf.addFront(movedBack);
               lastOperationCount++;
            }
         } else {
            for (int i = bookShelf.size() - 1; i >= position; i--) {
               int moved = bookShelf.removeLast();
               tempPile.addLast(moved);
               lastOperationCount++;
            }
            bookShelf.addLast(height);
            lastOperationCount++;
            while (tempPile.size() > 0) {
               int movedBack = tempPile.removeLast();
               bookShelf.addLast(movedBack);
               lastOperationCount++;
            }
         }
      }

      totalOperations += lastOperationCount;
      assert isValidBookshelfKeeper();
      return lastOperationCount;
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return totalOperations;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return bookShelf.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String
    * containing height
    * of all books present in the bookshelf in the order they are on the bookshelf,
    * followed
    * by the number of bookshelf mutator calls made to perform the last pick or put
    * operation,
    * followed by the total number of such calls made since we created this
    * BookshelfKeeper.
    * 
    * Example return string showing required format: "[1, 3, 5, 7, 33] 4 10"
    * 
    */
   public String toString() {
      assert isValidBookshelfKeeper();
      return bookShelf.toString() + " " + lastOperationCount + " " + totalOperations;

   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      if (!bookShelf.isSorted() ||
            !(totalOperations >= 0) ||
            !(lastOperationCount >= 0)) {
         return false;
      } else {
         return true;
      }
   }

   // add any other private methods here

}
