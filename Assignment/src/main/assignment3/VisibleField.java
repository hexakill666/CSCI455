package main.assignment3;

import java.util.Arrays;

/**
   VisibleField class
   This is the data that's being displayed at any one point in the game (i.e., visible field, because it's what the
   user can see about the minefield). Client can call getStatus(row, col) for any square.
   It actually has data about the whole current state of the game, including
   the underlying mine field (getMineField()).  Other accessors related to game status: numMinesLeft(), isGameOver().
   It also has mutators related to actions the player could do (resetGameDisplay(), cycleGuess(), uncover()),
   and changes the game state accordingly.

   It, along with the MineField (accessible in mineField instance variable), forms
   the Model for the game application, whereas GameBoardPanel is the View and Controller, in the MVC design pattern.
   It contains the MineField that it's partially displaying.  That MineField can be accessed (or modified) from
   outside this class via the getMineField accessor.
 */
public class VisibleField {
   // ----------------------------------------------------------   
   // The following public constants (plus numbers mentioned in comments below) are the possible states of one
   // location (a "square") in the visible field (all are values that can be returned by public method 
   // getStatus(row, col)).
   
   // The following are the covered states (all negative values):
   public static final int COVERED = -1;   // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // The following are the uncovered states (all non-negative values):
   
   // values in the range [0,8] corresponds to number of mines adjacent to this square
   
   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------

   /**
    * Representation invariants:
    * 1. mineField and statusField have the same dimensions
    * 2. numNonMinesLeft/numGuessMinesLeft is >= 0 and <= mineField.numRows() * mineField.numCols()
    */

   // <put instance variables here>
   // the number of non-mine squares left
   private int numNonMinesLeft;
   // the number of mines left to guess
   private int numGuessMinesLeft;
   // mine field
   private MineField mineField;
   // status field
   private int[][] statusField;

   /**
      Create a visible field that has the given underlying mineField.
      The initial state will have all the mines covered up, no mines guessed, and the game
      not over.
      @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.mineField = mineField;
      statusField = new int[mineField.numRows()][mineField.numCols()];
      resetGameDisplay();
   }
   
   /**
      Reset the object to its initial state (see constructor comments), using the same underlying
      MineField.
   */
   public void resetGameDisplay() {
      numGuessMinesLeft = mineField.numMines();
      numNonMinesLeft = mineField.numRows() * mineField.numCols() - mineField.numMines();
      for(int[] row : statusField){
         Arrays.fill(row, COVERED);
      }
   }
   
   /**
      Returns a reference to the mineField that this VisibleField "covers"
      @return the minefield
    */
   public MineField getMineField() {
      return mineField;
   }
   
   /**
      Returns the visible status of the square indicated.
      @param row  row of the square
      @param col  col of the square
      @return the status of the square at location (row, col).  See the public constants at the beginning of the class
      for the possible values that may be returned, and their meanings.
      PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      return statusField[row][col];
   }
   
   /**
      Returns the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
      or not.  Just gives the user an indication of how many more mines the user might want to guess.  This value can
      be negative, if they have guessed more than the number of mines in the minefield.     
      @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      return numGuessMinesLeft;
   }
   
   /**
      Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
      changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
      changes it to COVERED again; call on an uncovered square has no effect.  
      @param row  row of the square
      @param col  col of the square
      PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
      // if the square is uncovered, then return
      if(isUncovered(row, col)){
         return;
      }
      // if current status is covered
      if(getStatus(row, col) == COVERED){
         statusField[row][col]--;
         numGuessMinesLeft--;
      }
      // if current status is mine_guess
      else if(getStatus(row, col) == MINE_GUESS){
         statusField[row][col]--;
         numGuessMinesLeft++;
      }
      // if current status is question
      else{
         statusField[row][col] = COVERED;
      }
   }

   /**
      Uncovers this square and returns false iff you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      Note: this action may cause the game to end: either in a win (opened all the non-mine squares)
      or a loss (opened a mine).
      @param row  of the square
      @param col  of the square
      @return false   iff you uncover a mine at (row, col)
      PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      // if the square has a mine, then game over
      if(mineField.hasMine(row, col)){
         statusField[row][col] = EXPLODED_MINE;
         setGameOverViews();
         return false;
      }
      // uncover the square
      uncoverR(row, col);
      // if game is over, then set game over view
      if(isGameOver()){
         setGameOverViews();
      }
      return true;
   }

   /**
    * recursively uncover adjacent square
    * @param row
    * @param col
    */
   private void uncoverR(int row, int col){
      // if the square is uncover or mine_guess, then stop
      if(isUncovered(row, col) || getStatus(row, col) == MINE_GUESS){
         return;
      }
      // count the number of adjacent mines
      int numAdjacentMines = mineField.numAdjacentMines(row, col);
      statusField[row][col] = numAdjacentMines;
      numNonMinesLeft--;
      // if there are no adjacent mines, then keep uncovering
      if(numAdjacentMines == 0){
         // up
         if(mineField.inRange(row - 1, col)){
            uncoverR(row - 1, col);
         }
         // down
         if(mineField.inRange(row + 1, col)){
            uncoverR(row + 1, col);
         }
         // left
         if(mineField.inRange(row, col - 1)){
            uncoverR(row, col - 1);
         }
         // right
         if(mineField.inRange(row, col + 1)){
            uncoverR(row, col + 1);
         }
         // upper left
         if(mineField.inRange(row - 1, col - 1)){
            uncoverR(row - 1, col - 1);
         }
         // upper right
         if(mineField.inRange(row - 1, col + 1)){
            uncoverR(row - 1, col + 1);
         }
         // lower left
         if(mineField.inRange(row + 1, col - 1)){
            uncoverR(row + 1, col - 1);
         }
         // lower right
         if(mineField.inRange(row + 1, col + 1)){
            uncoverR(row + 1, col + 1);
         }
      }
   }

   /**
      Returns whether the game is over.
      (Note: This is not a mutator.)
      @return whether game over
    */
   public boolean isGameOver() {
      // win
      if(numNonMinesLeft < 1){
         return true;
      }
      // lose
      for (int[] row : statusField) {
         for (int col : row) {
            if (col > 8) {
               return true;
            }
         }
      }
      return false;
   }

   /**
    * set square view when the game is over
    */
   private void setGameOverViews(){
      for(int row = 0; row < statusField.length; row++){
         for(int col = 0; col < statusField[row].length; col++){
            // if win, then set the view of mine square to mine_guess
            if(numNonMinesLeft < 1 && mineField.hasMine(row, col)){
               statusField[row][col] = MINE_GUESS;
            }
            // if lose, then set the view of square which has mine_guess but has no mine to incorrect_guess
            else if(getStatus(row, col) == MINE_GUESS && !mineField.hasMine(row, col)){
               statusField[row][col] = INCORRECT_GUESS;
            }
            // if lose, then set the view of square which has mine and is covered or question to mine
            else if((getStatus(row, col) == COVERED || getStatus(row, col) == QUESTION) && mineField.hasMine(row, col)){
               statusField[row][col] = MINE;
            }
         }
      }
   }

   /**
      Returns whether this square has been uncovered.  (i.e., is in any one of the uncovered states, 
      vs. any one of the covered states).
      @param row of the square
      @param col of the square
      @return whether the square is uncovered
      PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      return statusField[row][col] > -1;
   }

   // <put private methods here>
   
}
