package lab.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
public class Nums {

   private List<Integer> numList;

   /**
      Create an empty sequence of nums.
   */
   public Nums () {
      numList = new ArrayList<>();
   }

   public Nums(List<Integer> list){
      numList = list;
   }

   /**
      Add a value to the end of the sequence.
   */
   public void add(int value) {
      numList.add(value);
   }


   /**
      Return the minimum value in the sequence.
      If the sequence is empty, returns Integer.MAX_VALUE
   */
   public int minVal() {
      return numList.isEmpty() ? Integer.MAX_VALUE : Collections.min(numList);
   }

   /**
      Prints out the sequence of values as a space-separated list 
      on one line surrounded by parentheses.
      Does not print a newline.
      E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
   */
   public void printVals() {
      StringBuilder sb = new StringBuilder();
      sb.append("(");
      for(int a = 0; a < numList.size(); a++){
         sb.append(numList.get(a));
         if(a != numList.size() - 1){
            sb.append(" ");
         }
      }
      sb.append(")");
      System.out.print(sb.toString());
   }

   /**
      Returns a new Nums object with all the values from this Nums
      object that are above the given threshold.  The values in the
      new object are in the same order as in this one.
      E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
      returns      (19 21 19)
      myNums after call:  (3 7 19 4 21 19 10)
      The method does not modify the object the method is called on.
   */
   public Nums valuesGT(int threshold) {
      List<Integer> temp = new ArrayList<>();
      for(Integer i : numList){
         if(i > threshold){
            temp.add(i);
         }
      }
      return new Nums(temp);
   }

}
