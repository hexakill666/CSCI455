package main.assignment2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class InputCheck
 *
 * 1. reads input books
 * 2. checks input books
 * 3. checks the arguments of put operation
 * 4. checks the arguments of pick operation
 */
public class InputCheck {

    /**
     * read books from the input into a list
     * @param scanner
     * @return bookshelf list
     */
    public ArrayList<Integer> readList(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        return list;
    }

    /**
     * check if input books are positive
     * @param bookShelfList
     */
    public boolean checkPositive(ArrayList<Integer> bookShelfList) {
        for(int i : bookShelfList){
            if(i < 1){
                System.out.println("ERROR: Height of a book must be positive.");
                System.out.println("Exiting Program.");
                return false;
            }
        }
        return true;
    }

    /**
     * check if input books are sorted
     * @param bookshelf
     */
    public boolean checkSorted(Bookshelf bookshelf) {
        if(!bookshelf.isSorted()){
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
            System.out.println("Exiting Program.");
            return false;
        }
        return true;
    }

    /**
     * check the argument of put operation. If it fails, then exit. If it succeeds, then return argument
     * @param scanner
     * @return put argument
     */
    public int checkPut(Scanner scanner) {
        int argument = scanner.nextInt();
        if(argument < 1){
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return -1;
        }
        return argument;
    }

    /**
     * check the argument of pick operation. If it fails, then exit. If it succeeds, then return argument
     * @param scanner
     * @param numBooks
     * @return pick argument
     */
    public int checkPick(Scanner scanner, int numBooks) {
        int argument = scanner.nextInt();
        if(argument < 0 || argument >= numBooks){
            System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
            System.out.println("Exiting Program.");
            return -1;
        }
        return argument;
    }

    /**
     * check and get a valid bookshelf keeper
     * @param scanner
     * @return a valid bookshelf keeper
     */
    public BookshelfKeeper getValidBookshelfKeeper(Scanner scanner) {
        ArrayList<Integer> bookshelfList = readList(scanner);
        if(!checkPositive(bookshelfList)){
            return null;
        }
        Bookshelf bookshelf = new Bookshelf(bookshelfList);
        if(!checkSorted(bookshelf)){
            return null;
        }
        return new BookshelfKeeper(bookshelf);
    }

}
