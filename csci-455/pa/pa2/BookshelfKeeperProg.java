// Name: Chunho Lin
// USC NetID: 3226964170
// CSCI455 PA2
// Fall 2025

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class BookshelfKeeperProg
 *
 * Program to interactively test the BookshelfKeeper class.
 * Prompts user for initial arrangement of books (in non-decreasing order by
 * height),
 * then repeatedly prompts user for pick or put operations, displaying the
 * bookshelf after each
 * operation, until user types "end" to exit the program.
 *
 * If user input is invalid (e.g. initial arrangement not in sorted order, pick
 * position out of range,
 * put height not positive, invalid command), an error message is displayed and
 * the program exits.
 *
 * Commands are read from standard input (System.in) and results are written to
 * standard output
 * (System.out).
 *
 * To run this program, use the command:
 * java -ea BookshelfKeeperProg
 * The -ea option enables assertion checking, which should always be used when
 * running Java programs
 * that contain assertions.
 */
public class BookshelfKeeperProg {

   /**
    * Main method to run the BookshelfKeeperProg program.
    */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      System.out.println("Please enter initial arrangement of books followed by newline:");
      ArrayList<Integer> initialBooks = readInitialBooks(in);

      Bookshelf bookShelf = new Bookshelf(initialBooks);
      if (!bookShelf.isSorted()) {
         printErrorAndExit("Heights must be specified in non-decreasing order.", in);
      }

      BookshelfKeeper bk = new BookshelfKeeper(bookShelf);
      System.out.println(bk.toString());
      System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");

      while (in.hasNextLine()) {
         String commandLine = in.nextLine().trim();
         if (commandLine.isEmpty())
            continue;

         processCommand(commandLine, bk, in);
      }

      in.close();
   }

   /**
    * Reads the initial arrangement of books from input.
    * Each height must be a positive integer.
    * If any height is not positive, an error message is displayed and the program
    * exits.
    * 
    * @param in the Scanner to read input from
    * @return an ArrayList of integers representing the heights of the books on
    *         the bookshelf
    */
   private static ArrayList<Integer> readInitialBooks(Scanner in) {
      ArrayList<Integer> books = new ArrayList<>();
      String firstLine = in.nextLine().trim();

      if (!firstLine.isEmpty()) {
         Scanner lineScanner = new Scanner(firstLine);
         while (lineScanner.hasNextInt()) {
            int height = lineScanner.nextInt();
            if (!isValidHeight(height)) {
               printErrorAndExit("Height of a book must be positive.", lineScanner, in);
            }
            books.add(height);
         }
         lineScanner.close();
      }

      return books;
   }

   /**
    * Processes a single command line input.
    * Valid commands are:
    * - pick <index>: picks the book at the specified index
    * - put <height>: puts a book of the specified height
    * - end: exits the program
    * If the command is invalid or if the parameters are out of range, an error
    * message is displayed and the program exits.
    * 
    * @param commandLine the command line input to process
    * @param bk          the BookshelfKeeper to operate on
    * @param in          the Scanner to read input from
    */
   private static void processCommand(String commandLine, BookshelfKeeper bk, Scanner in) {
      Scanner cmdScanner = new Scanner(commandLine);
      String cmd = cmdScanner.next();

      switch (cmd) {
         case "end":
            handleEnd(cmdScanner);
            break;

         case "put":
            handlePut(cmdScanner, bk, in);
            break;

         case "pick":
            handlePick(cmdScanner, bk, in);
            break;

         default:
            printErrorAndExit("Invalid command. Valid commands are pick, put, or end.", cmdScanner, in);
      }

      cmdScanner.close();
   }

   /**
    * Handles the "end" command to exit the program.
    * 
    * @param cmdScanner
    */
   private static void handleEnd(Scanner cmdScanner) {
      System.out.println("Exiting Program.");
      cmdScanner.close();
      System.exit(0);
   }

   /**
    * Handles the "put" command to put a book of specified height.
    * If the height is not a positive integer, an error message is displayed and
    * the program exits.
    * 
    * @param cmdScanner
    * @param bk
    * @param in
    */
   private static void handlePut(Scanner cmdScanner, BookshelfKeeper bk, Scanner in) {
      if (cmdScanner.hasNextInt()) {
         int height = cmdScanner.nextInt();
         if (!isValidHeight(height)) {
            printErrorAndExit("Height of a book must be positive.", cmdScanner, in);
         }
         bk.putHeight(height);
         System.out.println(bk.toString());
      } else {
         printErrorAndExit("Missing height for put command.", cmdScanner, in);
      }
   }

   /**
    * Handles the "pick" command to pick a book at specified index.
    * If the index is out of range, an error message is displayed and the program
    * exits.
    * 
    * @param cmdScanner
    * @param bk
    * @param in
    */
   private static void handlePick(Scanner cmdScanner, BookshelfKeeper bk, Scanner in) {
      if (cmdScanner.hasNextInt()) {
         int pos = cmdScanner.nextInt();
         if (!isValidPick(bk, pos)) {
            printErrorAndExit("Entered pick operation is invalid on this shelf.", cmdScanner, in);
         }
         bk.pickPos(pos);
         System.out.println(bk.toString());
      } else {
         printErrorAndExit("Missing index for pick command.", cmdScanner, in);
      }
   }

   /**
    * Returns true if height is a valid book height (greater than 0).
    */
   private static boolean isValidHeight(int height) {
      return height > 0;
   }

   /**
    * Returns true if pos is a valid pick position on the given BookshelfKeeper.
    */
   private static boolean isValidPick(BookshelfKeeper bk, int pos) {
      return pos >= 0 && pos < bk.getNumBooks();
   }

   /**
    * Prints an error message and exits the program.
    * Closes any provided scanners before exiting.
    * 
    * @param message  the error message to print
    * @param scanners optional scanners to close before exiting
    */
   private static void printErrorAndExit(String message, Scanner... scanners) {
      System.out.println("ERROR: " + message);
      System.out.println("Exiting Program.");
      for (Scanner sc : scanners) {
         if (sc != null)
            sc.close();
      }
      System.exit(1);
   }
}
