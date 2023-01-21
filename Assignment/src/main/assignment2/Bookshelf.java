package main.assignment2;

import java.util.List;
import java.util.ArrayList;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {

   /**
    * Representation invariant:
    * 1. Books on the bookshelf should be all positive.
    * <put rep. invar. comment here>
    */

   // bookshelf list
   private List<Integer> bookShelfList;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      bookShelfList = new ArrayList<>();
      assert isValidBookshelf();
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      bookShelfList = new ArrayList<>(pileOfBooks);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      bookShelfList.add(0, height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      bookShelfList.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      assert isValidBookshelf();
      return bookShelfList.remove(0);
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      assert isValidBookshelf();
      return bookShelfList.remove(bookShelfList.size() - 1);
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      assert isValidBookshelf();
      return bookShelfList.get(position);
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      assert isValidBookshelf();
      return bookShelfList.size();
   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   @Override
   public String toString() {
      return bookShelfList.toString();
   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      for(int a = 0; a < bookShelfList.size() - 1; a++){
         if(bookShelfList.get(a) > bookShelfList.get(a + 1)){
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
      for(int i : bookShelfList){
         if(i < 1){
            return false;
         }
      }
      return true;
   }

   /**
    * count the number of books whose height is smaller than the input height
    * @param height
    * @return count number
    */
   public int leftBound(int height) {
      int count = 0;
      for(int a = 0; a < bookShelfList.size(); a++){
         // if meet a book whose height is larger than the input height, then break;
         if(height <= bookShelfList.get(a)){
            break;
         }
         count++;
      }
      assert isValidBookshelf();
      return count;
   }

   /**
    * count the number of books whose height is larger than the input height
    * @param height
    * @return count number
    */
   public int rightBound(int height) {
      int count = 0;
      for(int a = bookShelfList.size() - 1; a >= 0; a--){
         // if meet a book whose height is smaller than the input height, then break;
         if(bookShelfList.get(a) <= height){
            break;
         }
         count++;
      }
      assert isValidBookshelf();
      return count;
   }

}
