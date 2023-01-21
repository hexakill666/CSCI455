package lab.lab10;

import java.util.Stack;
import java.util.Scanner;


public class RemoveEvens {

   public static void main(String[] args) {
      doOneTest(createStack("1 2 3 2 4 5"));
      doOneTest(createStack(""));
      doOneTest(createStack("0"));
      doOneTest(createStack("-1"));
      doOneTest(createStack("-10 -2 -3 -8 -5 -9 -6 -7 0 10 2 3 8 5 9 6 7"));
      doOneTest(createStack("-2 -3 -2 -3 -3 -1 0 3 3 3 0 2 2 1"));
   }

   private static void testCreate() {
      printStack(createStack(""));
      printStack(createStack("1"));
      printStack(createStack("1 3"));
      printStack(createStack("1 3 4 7"));
   }

   // removes the even values from theStack.
   // afterwards, theStack will have all the same odd values as before, in the
   // same relative order as before.  E.g.,
   //    before, theStack contains: [1, 2, 3, 2, 4, 5] <-- top
   //    after, theStack contains: [1, 3, 5] <-- top
   public static void removeEvens(Stack<Integer> theStack){
      Stack<Integer> odd = new Stack<>();
      while(!theStack.isEmpty()){
         if((theStack.peek() & 1) == 1){
            odd.push(theStack.peek());
         }
         theStack.pop();
      }
      while(!odd.isEmpty()){
         theStack.push(odd.pop());
      }
   }

   // creates and returns a Stack of Integers from a String of space-separated
   // integers, pushing them from left to right.  i.e., the last integer in
   // the string ends up at the top of the stack.
   // PRE: the string must consist only of integers and whitespace to separate
   //     them.
   public static Stack<Integer> createStack(String str) {
      Stack<Integer> result = new Stack<>();
      Scanner strScanner = new Scanner(str);
      while (strScanner.hasNext()) {
         result.push(new Integer(strScanner.next()));
      }
      return result;
   }

   // prints a stack of integers on one line followed by a newline, using
   // toString format, but also indicating where the top of the stack is
   public static void printStack(Stack<Integer> theStack) {
      System.out.println(theStack.toString() + " <-- top");
   }

   // Tests removeEvens on theStack, printing out its contents before and after.
   private static void doOneTest(Stack<Integer> theStack) {
      System.out.print("Stack before: ");
      printStack(theStack);

      removeEvens(theStack);
      
      System.out.print("Stack after removeEvens: ");
      printStack(theStack);

      System.out.println();
   }

}
