package main.assignment1;

import java.util.Random;

/**
 * CoinTossSimulatorTester class
 *
 * Checks the functionality of CoinTossSimulator class.
 *
 */
public class CoinTossSimulatorTester {

    private CoinTossSimulator coinTossSimulator;

    /**
     * creates a coinTossSimulator
     */
    public CoinTossSimulatorTester() {
        coinTossSimulator = new CoinTossSimulator();
        System.out.println("After constructor: ");
        printResult();
    }

    /**
     * prints the coin toss simulation result.
     */
    public void printResult() {
        int expect = coinTossSimulator.getTwoHeads() + coinTossSimulator.getTwoTails() + coinTossSimulator.getHeadTails();
        System.out.println("Number of trials [exp:" + expect + "]: " + coinTossSimulator.getNumTrials());
        System.out.println("Two-head tosses: " + coinTossSimulator.getTwoHeads());
        System.out.println("Tow-tail tosses: " + coinTossSimulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + coinTossSimulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + (coinTossSimulator.getNumTrials() == expect));
    }

    /**
     * simulates the coin toss
     */
    public void test() {
        for(int a = 0; a < 5; a++){
            coinTossSimulator.run(new Random().nextInt(1000000));
            System.out.println();
            printResult();
        }
    }

    /**
     * resets the coin toss simulation result
     */
    public void reset() {
        coinTossSimulator.reset();
        System.out.println();
        System.out.println("After reset: ");
        printResult();
    }

    /**
     * main method to run the CoinTossSimulatorTester
     * @param args
     */
    public static void main(String[] args) {
        CoinTossSimulatorTester coinTossSimulatorTester = new CoinTossSimulatorTester();
        coinTossSimulatorTester.test();
        coinTossSimulatorTester.reset();
        coinTossSimulatorTester.test();
    }

}
