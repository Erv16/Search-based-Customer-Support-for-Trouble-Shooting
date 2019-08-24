package troubleShootSearch.driver;

/**
 * @author Erwin Palani
 */

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.Context;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

import java.io.File;
import java.util.ArrayList;

public class Driver{

	/**
	 * The Driver class is responsible for forwarding/invoking all the necessary required operations or methods.
	 * <p>
	 * The Driver class is responsible for validating command line arguments, reading in the required keywords
	 * to perform the search, triggering the search and writing the results to the output file.
	 */

	/**
    	 * Returns a parsed Integer value. 
    	 * <p>
    	 * Parsing a String to an Integer value directly raises a NumberFormatException and terminates
		 * the execution of the program. To avoid this default exception from being raised, have created 
		 * the tryParseInt method that parses the String to an Integer value and returns the Integer value 
		 * everytime it reads an input from the file.
		 * <p>
		 * Source url is as follows:
		 * https://codereview.stackexchange.com/questions/19773/convert-string-to-integer-with-default-value
    	 * @param str the string value that needs to be parsed 
		 *            into an Integer value
		 * @return the parsed Integer value
    	 */

    	public static Integer tryParseInt(String str){
	    	try{
	    		return Integer.parseInt(str);
	    	} // end of try block
	    	catch(NumberFormatException nfe){
	    		return null;
	    	} // end of catch block
	    }

	public static void main(String[] args){

		/**
		 * A validation is put in place to check if a valid command line argument is passed.
		 */

		try{
			if(args.length != 1 || args[0].equals("${arg0}")){
				System.err.println("Error: Incorrext number of arguments. Program requires 1 argument." + "\n" +
					                "Try the following command: " + "\n" +
					                "ant -buildfile src/build.xml run -Darg0=<Debug Value>");
				System.exit(1);
			}

			int debugValue = tryParseInt(args[0]);

			/**
			 * A simple validation is put in place to check if the debug value provided is within the 
			 * required range.
			 */

			if(debugValue < 0 || debugValue > 6){
				System.err.println("Error: Debug value is out of scope." + 
								   "Please provide a debug value in the range of 0 - 6 and try again.\n" +
								   "6 - Prints the results of Semantic. Writes the results to the output file.\n" +
      							   "5 - Prints the results of Naive Match. Writes the results to the output file.\n" +
								   "4 - Prints the results of Exact Match. Writes the results to the output file.\n" +
								   "3 - Prints everytime a constructor is called. Writes the results to the output file.\n" +
								   "2 [Prints the updates on FileProcessor and the lines being read from the input file. Writes the results to the output file.\n" +
								   "1 [Only the search results are printed. Writes the results to the output file.\n" +
								   "0 [No output is printed. Only error messages are printed. Writes the results to the output file.\n"
								   );
				System.exit(1);
			}

			MyLogger.setDebugValue(debugValue);

			File userInputFile = new File("userInputs.txt");

			/**
			 * The getAbsolutePath() method gives the absolute path of the file
			 * source url is as follows:
			 * https://www.journaldev.com/848/java-file-path-absolute-canonical
			 */

			FileProcessor fp = new FileProcessor(userInputFile.getAbsolutePath());
			Results res = new Results();

			ArrayList<String> keywords = new ArrayList<String>();
			String temp = "";
			while((temp = fp.readLine()) != null){
				keywords.add(temp);
			}

			/**
			 * Creating an instance of the Context class for invoking the searches.
			 */

			Context ctx = new Context(res,keywords);
			ctx.initializeSearch();

			/**
			 * Writing results of the searches to the output file
			 */

			res.writeToFile("output.txt");

		}
		catch(Exception e){
			System.err.println("Error: Unable to parse Keywords");
			e.printStackTrace();
			System.exit(1);
		}
	}
}