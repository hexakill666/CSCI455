package main.assignment1;

import javax.swing.*;

/**
 * CoinSimViewer class
 *
 * Draws the window.
 *
 */
public class CoinSimViewer{

    public static void main(String[] args) {
        // create JFrame
        JFrame frame = new JFrame();

        // set up JFrame's parameters
        frame.setSize(GraphConstant.WINDOW_WIDTH, GraphConstant.WINDOW_HEIGHT);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create CoinSimComponent
        CoinSimComponent coinSimComponent = new CoinSimComponent();
        // run coinTossSimulator and get the user's input
        coinSimComponent.runSimulator(new InputCheck().checkAndGetInput());

        // add the CoinSimComponent to the frame
        frame.add(coinSimComponent);
        // set the CoinSimComponent to visible
        frame.setVisible(true);
    }

}
