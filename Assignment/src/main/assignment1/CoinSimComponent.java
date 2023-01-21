package main.assignment1;

import javax.swing.*;
import java.awt.*;

/**
 * CoinSimComponent class
 *
 * Draws a component, which contains all kinds of graph parameters and coin toss simulation statistics, when the window changes.
 *
 */
public class CoinSimComponent extends JComponent {

    private CoinTossSimulator coinTossSimulator;

    public CoinSimComponent() {
        coinTossSimulator = new CoinTossSimulator();
    }

    public void runSimulator(int numTrials) {
        coinTossSimulator.run(numTrials);
    }

    /**
     * This method is called when the window changes.
     * @param g Graph object
     */
    @Override
    public void paintComponent(Graphics g) {
        // the distance between the mid of each bar
        int xDistance = getWidth() / 4;
        // the pixel for one application unit
        double scale = (getHeight() - 2.0 * GraphConstant.VERTICAL_BUFFER) / coinTossSimulator.getNumTrials();

        // calculate each situation's percentage
        int twoHeadsPercentage = (int)Math.round(coinTossSimulator.getTwoHeads() * 100.0 / coinTossSimulator.getNumTrials());
        int twoTailsPercentage = (int)Math.round(coinTossSimulator.getTwoTails() * 100.0 / coinTossSimulator.getNumTrials());
        int headTailsPercentage = (int)Math.round(coinTossSimulator.getHeadTails() * 100.0 / coinTossSimulator.getNumTrials());

        // generate each situation's label
        String twoHeadsLabel = "Two Heads: " + coinTossSimulator.getTwoHeads() + "(" + twoHeadsPercentage + "%)";
        String twoTailsLabel = "Two Tails: " + coinTossSimulator.getTwoTails() + "(" + twoTailsPercentage + "%)";
        String headTailsLabel = "Head Tails: " + coinTossSimulator.getHeadTails() + "(" + headTailsPercentage + "%)";

        // create each situation's bar
        Bar twoHeadsBar = new Bar(getHeight() - GraphConstant.VERTICAL_BUFFER, xDistance - GraphConstant.BAR_WIDTH / 2, GraphConstant.BAR_WIDTH, coinTossSimulator.getTwoHeads(), scale, Color.RED, twoHeadsLabel);
        Bar headTailsBar = new Bar(getHeight() - GraphConstant.VERTICAL_BUFFER, 2 * xDistance - GraphConstant.BAR_WIDTH / 2, GraphConstant.BAR_WIDTH, coinTossSimulator.getHeadTails(), scale, Color.GREEN, headTailsLabel);
        Bar twoTailsBar = new Bar(getHeight() - GraphConstant.VERTICAL_BUFFER, 3 * xDistance - GraphConstant.BAR_WIDTH / 2, GraphConstant.BAR_WIDTH, coinTossSimulator.getTwoTails(), scale, Color.BLUE, twoTailsLabel);

        // draw each situation's bar
        Graphics2D g2 = (Graphics2D) g;
        twoHeadsBar.draw(g2);
        headTailsBar.draw(g2);
        twoTailsBar.draw(g2);
    }

}
