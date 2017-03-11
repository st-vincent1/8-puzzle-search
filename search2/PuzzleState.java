/**
* PuzzleState.java
* State in a 8-puzzle problem
* 2017 version
*/

import java.util.*;

public class PuzzleState extends SearchState {

  private int[][] currentBoard;
  private int zeroX, zeroY;
  final int BOARD_SIZE = 3;
  
  /**
  * constructor
  * @param setting the setting of tiles on the board
  */
  public PuzzleState(int[][] setting) {

    currentBoard = new int[3][3];
    for(int i=0; i<BOARD_SIZE; i++) {
      for(int j=0; j<BOARD_SIZE; j++) {
        currentBoard[i][j] = setting[i][j];
        // checking for empty tile
        if(setting[i][j] == 0) {
          // setting up empty tile coordinates
          zeroX = i;
          zeroY = j;
        }
      }
    }
  }

  /**
  * accessor for content of jug1
  */

  public int[][] getBoard() {
    return currentBoard;
  }
  public int getX() {
    return zeroX;
  }
  public int getY() {
    return zeroY;
  }
  public int getPointerAt(int x, int y) {
    return currentBoard[x][y];
  }

  /**
  * goalP
  * @param searcher - the current search
  */

  public boolean goalP(Search searcher) {
    PuzzleSearch psearcher = (PuzzleSearch) searcher;
    int[][] target = psearcher.getTarget();
    for(int i=0; i<BOARD_SIZE; i++) {
      for(int j=0; j<BOARD_SIZE; j++) {
        if(currentBoard[i][j] != target[i][j]) return false;
      }
    }
    return true;
  }

  /**
  * makeMove moves the empty tile in direction given by parameters, adds the new state to the list
  * and then moves it back to its original place
  * @param tX transformation in rows
  * @param tY transformation in columns
  * @param x the list of puzzle states
  */
  private void makeMove(int tX, int tY, ArrayList<PuzzleState> x) {
    int temp = getPointerAt(zeroX+tX, zeroY+tY);
    currentBoard[zeroX+tX][zeroY+tY]=0;
    currentBoard[zeroX][zeroY]=temp;
    x.add(new PuzzleState(currentBoard));
    currentBoard[zeroX+tX][zeroY+tY]=temp;
    currentBoard[zeroX][zeroY]=0;
  }
   /**
  * getSuccessors
  * @param searcher - the current search
  */
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    PuzzleSearch psearcher = (PuzzleSearch) searcher;


    ArrayList<PuzzleState> pslis=new ArrayList<PuzzleState>(); // the list of puzzle states
    ArrayList<SearchState> slis=new ArrayList<SearchState>();

    if(zeroX>0) {
      makeMove(-1, 0, pslis);
    }
    if(zeroX<2) {
      makeMove(1, 0, pslis);
    }
    if(zeroY>0) {
      makeMove(0, -1, pslis);
    }
    if(zeroY<2) {
      makeMove(0, 1, pslis);
    }
    // cast the jugs states as search states in slis

    for(PuzzleState ps: pslis) {
      slis.add((SearchState)ps);
    }


    return slis;
  }

  /**
  * sameState - do 2 JugsSearchNodes have the same state?
  * @param s2 second state
  */

  public boolean sameState(SearchState s2) {
    PuzzleState p2 = (PuzzleState) s2;

    int[][] checker = p2.getBoard();
    for(int i=0; i<BOARD_SIZE; i++) {
      for(int j=0; j<BOARD_SIZE; j++) {
        if(currentBoard[i][j] != checker[i][j]) return false;
      }
    }
    return true;
  }


  /**
  * toString
  */
  public String toString () {
    String x="\nPuzzle State:\n";
    for(int i=0; i<BOARD_SIZE; i++) {
      x+="\n---------\n";
      for(int j=0; j<BOARD_SIZE; j++) {
        x+="|";
        x+=currentBoard[i][j];
        x+="|";
      }
    }
    x+="\n---------\n";
    x+="Zero on place: ("+zeroX+", "+zeroY+")\n";
    return x;
  }



}



