package lab.lab10;
/*
 * Contains hasOnePeak method and
 * tests it on a bunch of hardcoded test cases, printing out test
 * data, actual results, and a FAILED message if actual results don't
 * match expected results.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PeakTester {

   /*
    * see lab assgt for specification of hasOnePeak method.
    */

   public static boolean hasOnePeak(LinkedList<Integer> list) {
      if(list.size() < 3 || list.get(0) > list.get(1)){
         return false;
      }
      Iterator<Integer> iterator = list.iterator();
      int peak = Integer.MIN_VALUE;
      int pre = iterator.next();
      while(iterator.hasNext()){
         int cur = iterator.next();
         if(pre > cur){
            peak = pre;
            break;
         }
         pre = cur;
      }
      while(iterator.hasNext()){
         int cur = iterator.next();
         if(pre < cur){
            return false;
         }
         pre = cur;
      }
      return peak != Integer.MIN_VALUE;
   }

   public static void main(String args[]) {
      testPeak("", false);
      testPeak("3", false);
      testPeak("3 4", false);
      testPeak("4 2", false);
      testPeak("3 4 5", false);
      testPeak("5 4 3", false);
      testPeak("3 4 5 3", true);
      testPeak("3 4 5 3 2", true);
      testPeak("3 7 9 11 8 4 3 1", true);
      testPeak("3 5 4", true);
      testPeak("4 3 5", false);
      testPeak("2 4 3 5", false);
      testPeak("5 2 4 3 5", false);
      testPeak("5 2 4 3", false);
      testPeak("2 4 3 5 2", false);
   }

   /*  Assumes the following format for listString parameter, shown by example
    * (first one is empty list):
    *   "", "3", "3 4", "3 4 5", etc.
    */
   private static LinkedList<Integer> makeList(String listString) {
      Scanner strscan = new Scanner(listString);

      LinkedList<Integer> list = new LinkedList<Integer>();

      while (strscan.hasNextInt()) {
         list.add(strscan.nextInt());
      }

      return list;
   }

   /* Test hasOnePeak method on a list form of input given in listString
    * Prints test data, result, and whether result matched expectedResult
    *
    * listString is a string form of a list given as a space separated
    * sequence of ints.  E.g.,
    *  "" (empty string), "3" (1 elmt string), "2 4" (2 elmt string), etc.
    *
    */
   private static void testPeak(String listString, boolean expectedResult) {
      LinkedList<Integer> list = makeList(listString);

      boolean result = hasOnePeak(list);
      System.out.print("List: " + list
                       + " hasOnePeak? " + result);
      if (result != expectedResult) {
         System.out.print("...hasOnePeak FAILED");
      }
      System.out.println();
   }

}
