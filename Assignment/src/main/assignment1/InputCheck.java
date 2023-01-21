package main.assignment1;

import java.util.Scanner;

/**
 * InputCheck class
 *
 * Checks the user's input and provides a valid input for the program.
 *
 */
public class InputCheck {

    /**
     * get the user's input until the user enter a positive number.
     * @return number of trials
     */
    public int checkAndGetInput() {
        System.out.println("Enter number of trials: ");
        Scanner scanner = new Scanner(System.in);
        int trials;
        // check the user's input util the user enters a positive number
        while((trials = scanner.nextInt()) <= 0){
            System.out.println("ERROR: Number entered must be greater than 0");
            System.out.println("Enter number of trials: ");
        }
        return trials;
    }

}
