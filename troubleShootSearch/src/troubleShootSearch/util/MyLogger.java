package troubleShootSearch.util;

/**
 * @author Erwin Joshua Palani
 */

public class MyLogger{

    /*
      DEBUG_VALUE=6 [Prints the results of Semantic. Writes the results to the output file.]
      DEBUG_VALUE=5 [Prints the results of Naive Match. Writes the results to the output file.]
      DEBUG_VALUE=4 [Prints the results of Exact Match. Writes the results to the output file.]
      DEBUG_VALUE=3 [Prints everytime a constructor is called. Writes the results to the output file.]
      DEBUG_VALUE=2 [Prints the updates on FileProcessor and the lines being read from the input file. Writes the results to the output file.]
      DEBUG_VALUE=1 [Only the search results are printed. Writes the results to the output file.]
      DEBUG_VALUE=0 [No output is printed. Only error messages are printed. Writes the results to the output file.]
    */

    public static enum DebugLevel {NONE, SEARCH, FILE_PROCESSOR, CONSTRUCTOR, EXACT, NAIVE, SEMANTIC
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
    case 6: debugLevel = DebugLevel.SEMANTIC; break;
    case 5: debugLevel = DebugLevel.NAIVE; break;
    case 4: debugLevel = DebugLevel.EXACT; break;
	  case 3: debugLevel = DebugLevel.CONSTRUCTOR; break;
    case 2: debugLevel = DebugLevel.FILE_PROCESSOR; break;
    case 1: debugLevel = DebugLevel.SEARCH; break;
	  case 0: debugLevel = DebugLevel.NONE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {

      /**
       * The setDebugValue is used for identifying which debug case
       * should be invoked based on the argument value.
       * @param levelIn the debug level value
       */

	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {

      /**
       * The writeMessage method writes all of the debugging messages
       * associated with a particular debug level onto the console.
       * @param message the actual message that needs to be written
       * @param levelIn the associated debug level
       */

	if (levelIn == debugLevel)
	    System.out.println(message);
    } // end of if

    /**
	 * @return String
	 */
    public String toString() {

      /**
       * A toString method to print the debug level
       */ 
      
	return "Debug Level is " + debugLevel;
    }
}
