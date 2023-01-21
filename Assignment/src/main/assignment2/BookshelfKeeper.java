package main.assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

   /**
    * Representation invariant:
    * 1. the contained bookshelf should be in non-decreasing order
    * 2. total number of calls is larger or equal then zero
    * 3. the number of calls for last operation is larger or equal than zero
    */

   // last operation count
   private int lastOperation;
   // total operation count
   private int totalOperation;
   // bookshelf
   private Bookshelf bookshelf;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      lastOperation = 0;
      totalOperation = 0;
      bookshelf = new Bookshelf();
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      lastOperation = 0;
      totalOperation = 0;
      bookshelf = sortedBookshelf;
      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    */
   public int pickPos(int position) {
      // temporary bookshelf
      List<Integer> temp = new ArrayList<>();
      // if the position is close to left side
      if(position < getNumBooks() - 1 - position){
         // remove books from 0 to position - 1
         for(int a = 0; a < position; a++){
            temp.add(bookshelf.removeFront());
         }
         // remove the book on position
         bookshelf.removeFront();
         // add books back to bookshelf
         for(int a = temp.size() - 1; a >= 0; a--){
            bookshelf.addFront(temp.get(a));
         }
         // calculate operation
         lastOperation = (position + 1) * 2 - 1;
      }
      // if the position is close to right side
      else{
         int bookShelfSize = getNumBooks();
         // remove books from position + 1 to NumBooks - 1
         for(int a = getNumBooks() - 1; a > position; a--){
            temp.add(bookshelf.removeLast());
         }
         // remove the book on position
         bookshelf.removeLast();
         // add books back to bookshelf
         for(int a = temp.size() - 1; a >= 0; a--){
            bookshelf.addLast(temp.get(a));
         }
         // calculate operation
         lastOperation = (bookShelfSize - position) * 2 - 1;
      }
      // add last operation to total operation
      totalOperation += lastOperation;
      assert isValidBookshelfKeeper();
      return lastOperation;
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      // number of books to the inserted book from the left
      int leftBound = bookshelf.leftBound(height);
      // number of books to the inserted book from the right
      int rightBound = bookshelf.rightBound(height);
      // temporary bookshelf
      List<Integer> temp = new ArrayList<>();
      // if the inserted book is close to left side
      if(leftBound < rightBound){
         // remove books from 0 to the one before inserted book
         for(int a = 0; a < leftBound; a++){
            temp.add(bookshelf.removeFront());
         }
         // add the book to the shelf
         temp.add(height);
         // add books back to bookshelf
         for(int a = temp.size() - 1; a >= 0; a--){
            bookshelf.addFront(temp.get(a));
         }
         // calculate operation
         lastOperation = leftBound * 2 + 1;
      }
      // if the inserted book is close to right side
      else{
         // remove books from the one after inserted book to the end
         for(int a = 0; a < rightBound; a++){
            temp.add(bookshelf.removeLast());
         }
         // add the book to the shelf
         temp.add(height);
         // add books back to bookshelf
         for(int a = temp.size() - 1; a >= 0; a--){
            bookshelf.addLast(temp.get(a));
         }
         // calculate operation
         lastOperation = rightBound * 2 + 1;
      }
      // add last operation to total operation
      totalOperation += lastOperation;
      assert isValidBookshelfKeeper();
      return lastOperation;
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return totalOperation;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return bookshelf.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   @Override
   public String toString() {
      assert isValidBookshelfKeeper();
      return bookshelf.toString() + " " + lastOperation + " " + totalOperation;
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      return bookshelf.isSorted();
   }

}
