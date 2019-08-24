package troubleShootSearch.visitors;

/**
 * @author Erwin Palani
 */

import troubleShootSearch.products.ProductOne;
import troubleShootSearch.products.ProductTwo;
import troubleShootSearch.products.ProductThree;
import troubleShootSearch.products.ProductFour;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExactMatch implements VisitorI{

	/**
	 * The ExactMatch class provides the implementation for performing an exact match search
	 * for each of the individual products and logs the results of the search into a data structure
	 */

	public ExactMatch(){

		/**
		 * Constructor
		 */

		MyLogger.writeMessage("Reached constructor of ExactMatch class",DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method contains the implementation of the Exact Match search algorithm for Product One
	 * <p>
	 * It scans throug the entire content available for Product One and searches to see if it can
	 * find the keyword. If it does, it logs the results into a data structure.
	 * @param productOneIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductOne productOneIn, String keywordIn, Results resIn){

		for(String sentence: productOneIn.getProductContent()){
			if(isContainExactKeyword(keywordIn, sentence)){
					resIn.storeNewResult("For Product 1, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
					MyLogger.writeMessage("For Product 1, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.EXACT);
					MyLogger.writeMessage("For Product 1, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			} // end of if
		} // end of for block
	}

	/**
	 * This method contains the implementation of the Exact Match search algorithm for Product Two
	 * <p>
	 * It scans throug the entire content available for Product Two and searches to see if it can
	 * find the keyword. If it does, it logs the results into a data structure.
	 * @param productTwoIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductTwo productTwoIn, String keywordIn, Results resIn){

		for(String sentence: productTwoIn.getProductContent()){
			if(isContainExactKeyword(keywordIn, sentence)){
					resIn.storeNewResult("For Product 2, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
					MyLogger.writeMessage("For Product 2, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.EXACT);
					MyLogger.writeMessage("For Product 2, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			} // end of if
		} // end of for block
	}

	/**
	 * This method contains the implementation of the Exact Match search algorithm for Product Three
	 * <p>
	 * It scans throug the entire content available for Product Three and searches to see if it can
	 * find the keyword. If it does, it logs the results into a data structure.
	 * @param productThreeIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductThree productThreeIn, String keywordIn, Results resIn){

		for(String sentence: productThreeIn.getProductContent()){
			if(isContainExactKeyword(keywordIn, sentence)){
					resIn.storeNewResult("For Product 3, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
					MyLogger.writeMessage("For Product 3, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.EXACT);
					MyLogger.writeMessage("For Product 3, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			} // end of if
		} // end of for block
	}

	/**
	 * This method contains the implementation of the Exact Match search algorithm for Product Four
	 * <p>
	 * It scans throug the entire content available for Product Four and searches to see if it can
	 * find the keyword. If it does, it logs the results into a data structure.
	 * @param productFourIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductFour productFourIn, String keywordIn, Results resIn){

		for(String sentence: productFourIn.getProductContent()){
			if(isContainExactKeyword(keywordIn, sentence)){
					resIn.storeNewResult("For Product 4, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
					MyLogger.writeMessage("For Product 4, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.EXACT);
					MyLogger.writeMessage("For Product 4, an Exact Match for the keyword - " 
						                 + "\'" + keywordIn + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			} // end of if
		} // end of for block
	}

	/**
	 * The isContainExactKeyword() method uses regex pattern to see if an exact match of the keyword 
	 * exists within the sentence or not
	 * <p>
	 * source url is as follows:
	 * https://stackoverflow.com/questions/5091057/how-to-find-a-whole-word-in-a-string-in-java/5091147
	 * @param keywordIn the keyword to be searched
	 * @param sentenceIn the sentence in which the keyword needs to be searched
	 * @return a boolean value which denotes if the keyword is present or not
	 */

	private static boolean isContainExactKeyword(String keywordIn, String sentenceIn){
		String pattern = "\\b" + keywordIn + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sentenceIn);
		return m.find();
	}
}