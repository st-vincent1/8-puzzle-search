/**
* PuzzleState.java
* State in a 8-puzzle problem
* 2017 version
*/

import java.util.*;

public class PuzzleState extends SearchState{

  private int[][] currentBoard;
  private int zeroX, zeroY;
  final int BOARD_SIZE = 3;
  /**
  * constructor
  * @param j1c content of jug 1
  * @param j2c content of jug2
  */

  public PuzzleState(int[][] setting) {
    currentBoard = new int[3][3];
    for(int i=0; i<BOARD_SIZE; i++) {
      for(int j=0; j<BOARD_SIZE; j++) {
        currentBoard[i][j] = setting[i][j];
        if(setting[i][j] == 0) {
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
  // SHOULD BE OK
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
  * getSuccessors
  * @param searcher - the current search
  */

  public ArrayList<SearchState> getSuccessors (Search searcher) {
    PuzzleSearch psearcher = (PuzzleSearch) searcher;
    int[][] setting = psearcher.getBoard();
    int zX = psearcher.getX();
    int zY = psearcher.getY();
    for(int i=0; i<BOARD_SIZE; i++) {
      for(int j=0; j<BOARD_SIZE; j++) {
        System.out.printf(" %d ", setting[i][j]);
      }
      System.out.printf("\n");
    }

    System.out.printf("(%d, %d)\n", zX, zY);
    System.out.println("I'm going crazy\n\n");
    ArrayList<PuzzleState> pslis=new ArrayList<PuzzleState>(); // the list of puzzle states
    ArrayList<SearchState> slis=new ArrayList<SearchState>();


//checkpoint
    // int temp;
    if(zX>0) {

      /////////////////////
      System.out.println("CONTROL CHECK\n\n");
      for(int i=0; i<BOARD_SIZE; i++) {
        for(int j=0; j<BOARD_SIZE; j++) {
         System.out.printf(" %d ", setting[i][j]);
        }
        System.out.printf("\n");
      }

      System.out.printf("(%d, %d)\n", zX, zY);
      
//////////////////////////////////////

      int temp = getPointerAt(zX-1, zY);
      setting[zX-1][zY]=0;
      setting[zX][zY]=temp;
      pslis.add(new PuzzleState(setting));

//////////////////////////////////////

      System.out.println("CONTROL CHECK PART 2\n\n");
      for(int i=0; i<BOARD_SIZE; i++) {
        for(int j=0; j<BOARD_SIZE; j++) {
         System.out.printf(" %d ", setting[i][j]);
        }
        System.out.printf("\n");
      }

      System.out.printf("(%d, %d)\n", zX, zY);

/////////////////////////////////////

      setting[zX-1][zY]=temp;
      setting[zX][zY]=0;

      ////////////////////////
      System.out.println("CONTROL CHECK PART 3\n\n");
      for(int i=0; i<BOARD_SIZE; i++) {
        for(int j=0; j<BOARD_SIZE; j++) {
         System.out.printf(" %d ", setting[i][j]);
        }
        System.out.printf("\n");
      }

      System.out.printf("(%d, %d)\n", zX, zY);


      /////////////////////////////
    }
    if(zX<2) {
      int temp = getPointerAt(zX+1, zY);
      setting[zX+1][zY]=0;
      setting[zX][zY]=temp;
      pslis.add(new PuzzleState(setting));
      setting[zX+1][zY]=temp;
      setting[zX][zY]=0;
    }
    if(zY>0) {
      int temp = getPointerAt(zX, zY-1);
      setting[zX][zY-1]=0;
      setting[zX][zY]=temp;
      pslis.add(new PuzzleState(setting));
      setting[zX][zY-1]=temp;
      setting[zX][zY]=0;
    }
    if(zY<2) {
      int temp = getPointerAt(zX, zY+1);
      setting[zX][zY+1]=0;
      setting[zX][zY]=temp;
      pslis.add(new PuzzleState(setting));
      setting[zX][zY+1]=temp;
      setting[zX][zY]=0;
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
        if(getPointerAt(i, j) != checker[i][j]) return false;
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



