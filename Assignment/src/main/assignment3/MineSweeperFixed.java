package main.assignment3;

import javax.swing.JFrame;

public class MineSweeperFixed {
   
   // You can  modify this program so it uses a different one of the hardcoded mines below, 
   // or add a new one, for testing purposes:
   
   private static boolean[][] smallMineField = 
      {{false, false, false, false}, 
       {true, false, false, false}, 
       {false, true, true, false},
       {false, true, false, true}};
   
   private static boolean[][] emptyMineField = 
      {{false, false, false, false}, 
       {false, false, false, false}, 
       {false, false, false, false},
       {false, false, false, false}};
   
   private static boolean[][] almostEmptyMineField = 
      {{false, false, false, false}, 
       {false, false, false, false}, 
       {false, false, false, false},
       {false, true, false, false}};

   private static boolean[][] oneLengthMineField =
      {{false}
       };

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 425;
      

   public static void main(String[] args) {

      JFrame frame = new JFrame();

      frame.setTitle("Minesweeper");

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

      GameBoardPanel gameBoard = new GameBoardPanel(new VisibleField(new MineField(smallMineField)));

//      GameBoardPanel gameBoard = new GameBoardPanel(new VisibleField(new MineField(1, 1, 0)));
//      GameBoardPanel gameBoard = new GameBoardPanel(new VisibleField(new MineField(4, 4, 5)));

//      MineField mineField1 = new MineField(4, 4, 5);
//      mineField1.populateMineField(0, 0);
//      GameBoardPanel gameBoard = new GameBoardPanel(new VisibleField(mineField1));

//      MineField mineField2 = new MineField(9, 9, 20);
//      mineField2.populateMineField(0, 0);
//      GameBoardPanel gameBoard = new GameBoardPanel(new VisibleField(mineField2));

      frame.add(gameBoard);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.setVisible(true);

   }

}

