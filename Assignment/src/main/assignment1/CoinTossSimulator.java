package main.assignment1;

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {

   private int trials;
   private int twoHeads;
   private int twoTails;
   private int headTails;
   private Random random;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      trials = 0;
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;
      random = new Random();
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      int down = 0;
      int up = 1;
      for(int a = 0; a < numTrials; a++){
         int res1 = random.nextInt(up + 1);
         int res2 = random.nextInt(up + 1);
         if(res1 == down && res2 == down){
            twoTails++;
         }
         else if(res1 == up && res2 == up){
            twoHeads++;
         }
         else{
            headTails++;
         }
      }
      trials += numTrials;
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return trials;
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTails;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      trials = 0;
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;
   }

}
