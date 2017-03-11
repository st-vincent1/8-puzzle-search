/**
*	PuzzleSearch.java
*
*	search for puzzle problems
*   2017 version!!!! *rawr*
*/

import java.util.*;

public class PuzzleSearch extends Search {

    final int BOARD_SIZE = 3;
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int[][] target = {{1,2,3},{4,5,6},{7,8,0}};
    private int zeroX, zeroY; // empty tile coordinates

    /** constructor  takes board
    * @param setting initial setting of the board
    */
    public PuzzleSearch (int[][] setting) {
	    for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                board[i][j] = setting[i][j];
                if(board[i][j]==0) {
                    zeroX=i;
                    zeroY=j;
                }
                // System.out.printf("%d\n", board[i][j]);
            }
        }
    }

    /**
    * accessor for board
    */
    public int[][] getBoard(){
	   return board;
    }
    /**
    * accessor for target setting
    */
    public int[][] getTarget(){
	   return target;
    }
    /**
    * accessors for the empty tile coordinates
    */
    public int getX() {
        return zeroX;
    }
    public int getY() {
        return zeroY;
    }
}










