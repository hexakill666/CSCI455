package main.assignment2;

import java.util.Scanner;

/**
 * Class BookshelfKeeperProg
 *
 * This is the main class to run the program
 */
public class BookshelfKeeperProg {

    public static void main(String[] args) {
        // preparation
        Scanner scanner = new Scanner(System.in);
        InputCheck inputCheck = new InputCheck();

        System.out.println("Please enter initial arrangement of books followed by newline:");
        // get a valid bookshelf keeper
        BookshelfKeeper bookshelfKeeper = inputCheck.getValidBookshelfKeeper(scanner);
        if(bookshelfKeeper == null){
            return;
        }

        System.out.println(bookshelfKeeper);
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");

        // continuously read the input
        while(scanner.hasNext()){
            // get operation
            String command = scanner.next();
            // execute operation based on command
            switch(command){
                // put operation
                case "put":
                    int putArgument = inputCheck.checkPut(scanner);
                    if(putArgument < 0){
                        return;
                    }
                    bookshelfKeeper.putHeight(putArgument);
                    System.out.println(bookshelfKeeper);
                    break;

                // pick operation
                case "pick":
                    int pickArgument = inputCheck.checkPick(scanner, bookshelfKeeper.getNumBooks());
                    if(pickArgument < 0){
                        return;
                    }
                    bookshelfKeeper.pickPos(pickArgument);
                    System.out.println(bookshelfKeeper);
                    break;

                // exit
                case "end":
                    System.out.println("Exiting Program.");
                    return;

                // invalid command
                default:
                    System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
                    System.out.println("Exiting Program.");
                    return;
            }
        }
    }

}
