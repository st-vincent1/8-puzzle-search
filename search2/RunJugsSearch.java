

import sheffield.*;
import java.util.*;


public class RunJugsSearch {

public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    JugsSearch searcher = new JugsSearch(7,4,3);
    SearchState initState = (SearchState) new JugsState(0,0);

	//change from search1 - specify strategy
    //String resb = searcher.runSearch(initState, "breadthFirst");
    //screen.println(resb);
    String resd = searcher.runSearch(initState, "depthFirst");
    screen.println(resd);

}
}
