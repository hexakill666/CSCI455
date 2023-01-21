package main.assignment3;

import java.util.Arrays;
import java.util.Random;

/**
    MineField
       class with locations of mines for a game.
       This class is mutable, because we sometimes need to change it once it's created.
       mutators: populateMineField, resetEmpty
       includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {

    /**
     * Representation invariants:
     * 1. mineData is either completely false, or numMines = the number of true locations in mineData
     */
    
    // <put instance variables here>
    // the number of rows
    private int numRows;
    // the number of columns
    private int numCols;
    // the number of mines
    private int numMines;
    // mine data
    private boolean[][] mineData;

    /**
       Create a minefield with same dimensions as the given array, and populate it with the mines in the array
       such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
       this minefield will corresponds to the number of 'true' values in mineData.
       @param mineData  the data for the mines; must have at least one row and one col,
                      and must be rectangular (i.e., every row is the same length)
    */
    public MineField(boolean[][] mineData) {
        numRows = mineData.length;
        numCols = mineData[0].length;
        this.mineData = new boolean[numRows][numCols];
        for(int row = 0; row < mineData.length; row++){
            for(int col = 0; col < mineData[row].length; col++){
                if(mineData[row][col]){
                    this.mineData[row][col] = mineData[row][col];
                    numMines++;
                }
            }
        }
    }

    /**
       Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once
       populateMineField is called on this object).  Until populateMineField is called on such a MineField,
       numMines() will not correspond to the number of mines currently in the MineField.
       @param numRows  number of rows this minefield will have, must be positive
       @param numCols  number of columns this minefield will have, must be positive
       @param numMines   number of mines this minefield will have,  once we populate it.
       PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations).
    */
    public MineField(int numRows, int numCols, int numMines) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.numMines = numMines;
        mineData = new boolean[numRows][numCols];
    }

    /**
       Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
       ensuring that no mine is placed at (row, col).
       @param row the row of the location to avoid placing a mine
       @param col the column of the location to avoid placing a mine
       PRE: inRange(row, col) and numMines() < (1/3 * numRows() * numCols())
    */
    public void populateMineField(int row, int col) {
        // reset mine data
        resetEmpty();
        int tempNumMines = numMines;
        // set initial mine field to true
        mineData[row][col] = true;
        Random random = new Random();
        // allocate mines until there are no available mines left
        while(tempNumMines > 0){
            // random row
            int tempRow = random.nextInt(numRows);
            // random column
            int tempCol = random.nextInt(numCols);
            // if the mine field has already been taken, then skip
            if(mineData[tempRow][tempCol]){
                continue;
            }
            // allocate mine
            mineData[tempRow][tempCol] = true;
            // decrease available mines
            tempNumMines--;
        }
        // set initial mine field to false
        mineData[row][col] = false;
    }

    /**
       Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
       Thus, after this call, the actual number of mines in the minefield does not match numMines().
       Note: This is the state a minefield created with the three-arg constructor is in
          at the beginning of a game.
    */
    public void resetEmpty() {
        for (boolean[] row : mineData) {
            Arrays.fill(row, false);
        }
    }

    /**
       Returns the number of mines adjacent to the specified mine location (not counting a possible
       mine at (row, col) itself).
       Diagonals are also considered adjacent, so the return value will be in the range [0,8]
       @param row  row of the location to check
       @param col  column of the location to check
       @return  the number of mines adjacent to the square at (row, col)
       PRE: inRange(row, col)
    */
    public int numAdjacentMines(int row, int col) {
        int numAdjacentMines = 0;
        // up
        if(inRange(row - 1, col) && mineData[row - 1][col]){
            numAdjacentMines++;
        }
        // down
        if(inRange(row + 1, col) && mineData[row + 1][col]){
            numAdjacentMines++;
        }
        // left
        if(inRange(row, col - 1) && mineData[row][col - 1]){
            numAdjacentMines++;
        }
        // right
        if(inRange(row, col + 1) && mineData[row][col + 1]){
            numAdjacentMines++;
        }
        // upper left
        if(inRange(row - 1, col - 1) && mineData[row - 1][col - 1]){
            numAdjacentMines++;
        }
        // upper right
        if(inRange(row - 1, col + 1) && mineData[row - 1][col + 1]){
            numAdjacentMines++;
        }
        // lower left
        if(inRange(row + 1, col - 1) && mineData[row + 1][col - 1]){
            numAdjacentMines++;
        }
        // lower right
        if(inRange(row + 1, col + 1) && mineData[row + 1][col + 1]){
            numAdjacentMines++;
        }
        return numAdjacentMines;
    }

    /**
       Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
       start from 0.
       @param row  row of the location to consider
       @param col  column of the location to consider
       @return whether (row, col) is a valid field location
    */
    public boolean inRange(int row, int col) {
        return 0 <= row && row < numRows && 0 <= col && col < numCols;
    }

    /**
       Returns whether there is a mine in this square
       @param row  row of the location to check
       @param col  column of the location to check
       @return whether there is a mine in this square
       PRE: inRange(row, col)
     */
    public boolean hasMine(int row, int col) {
        return mineData[row][col];
    }

    /**
       Returns the number of rows in the field.
       @return number of rows in the field
    */
    public int numRows() {
        return numRows;
    }

    /**
       Returns the number of columns in the field.
       @return number of columns in the field
    */
    public int numCols() {
        return numCols;
    }

    /**
       Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
       some of the time this value does not match the actual number of mines currently on the field.  See doc for that
       constructor, resetEmpty, and populateMineField for more details.
    *  @return
    */
    public int numMines() {
        return numMines;
    }

    // <put private methods here>

}