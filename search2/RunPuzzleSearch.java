/**
*   RunPuzzleSearch.java
*   Sebastian Ksiazczyk
*
*
*/

import sheffield.*;
import java.util.*;


public class RunPuzzleSearch {

public static void main(String[] arg) {

    // create an EasyWriter
    EasyWriter screen = new EasyWriter();


    int[][] startBoard = {{1,0,3},{4,2,6},{7,5,8}}; // P1
    // int[][] startBoard = {{4,1,3},{7,2,5},{0,8,6}}; // P2
    // int[][] startBoard = {{2,3,6},{1,5,8},{4,7,0}}; // P3

    int[][] target = {{1,2,3},{4,5,6},{7,8,0}}; // target board with all tiles in their correct places
    PuzzleSearch searcher = new PuzzleSearch(target);
    SearchState initState = (SearchState) new PuzzleState(startBoard);

	//change from search1 - specify strategy
    String resb = searcher.runSearch(initState, "breadthFirst");
    screen.println(resb);


    // String resd = searcher.runSearch(initState, "depthFirst");
    // screen.println(resd);

}
}
