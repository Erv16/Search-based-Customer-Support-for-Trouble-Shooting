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

public class NaiveStemmingMatch implements VisitorI{

	/**
	 * The NaiveStemmingMatch class provides the implementation for performing a naive match search
	 * for each of the individual products and logs the results of the search into a data structure
	 * <p>
	 * If the keyword consists of multiple words, it checks to see if the first word of the keyword 
	 * is present as a substring of a word within the sentence. If the keyword is a single word, then
	 * it checks to see if the keyword is either present as a substring of a word or as the entire word itself
	 */

	public NaiveStemmingMatch(){

		/**
		 * Constructor
		 */

		MyLogger.writeMessage("Reached the constructor of NaiveStemmingMatch class",DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method contains the implementation of the Naive Match search algorithm for Product One
	 * <p>
	 * It scans throug the entire content available for Product One and searches to see if it can
	 * find the keyword (either as a substring of a word or the word itself). 
	 * <p>
	 * If it does, it logs the results into a data structure.
	 * @param productOneIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductOne productOneIn, String keywordIn, Results resIn){

		String keywordSubstr[] = keywordIn.split(" ");
		for(String sentence: productOneIn.getProductContent()){
			if(isContainKeyword(keywordSubstr[0],sentence)){//if(sentence.contains(keywordSubstr[0])){
				resIn.storeNewResult("For Product 1, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
				MyLogger.writeMessage("For Product 1, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.NAIVE);
				MyLogger.writeMessage("For Product 1, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			}
		}
	}

	/**
	 * This method contains the implementation of the Naive Match search algorithm for Product Two
	 * <p>
	 * It scans throug the entire content available for Product Two and searches to see if it can
	 * find the keyword (either as a substring of a word or the word itself). 
	 * <p>
	 * If it does, it logs the results into a data structure.
	 * @param productTwoIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductTwo productTwoIn, String keywordIn, Results resIn){

		String keywordSubstr[] = keywordIn.split(" ");
		for(String sentence: productTwoIn.getProductContent()){
			if(isContainKeyword(keywordSubstr[0],sentence)){//if(sentence.contains(keywordSubstr[0])){
				resIn.storeNewResult("For Product 2, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
				MyLogger.writeMessage("For Product 2, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.NAIVE);
				MyLogger.writeMessage("For Product 2, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			}
		}
	}

	/**
	 * This method contains the implementation of the Naive Match search algorithm for Product Three
	 * <p>
	 * It scans throug the entire content available for Product Three and searches to see if it can
	 * find the keyword (either as a substring of a word or the word itself). 
	 * <p>
	 * If it does, it logs the results into a data structure.
	 * @param productThreeIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductThree productThreeIn, String keywordIn, Results resIn){

		String keywordSubstr[] = keywordIn.split(" ");
		for(String sentence: productThreeIn.getProductContent()){
			if(isContainKeyword(keywordSubstr[0],sentence)){//if(sentence.contains(keywordSubstr[0])){
				resIn.storeNewResult("For Product 3, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence +"\r\n");
				MyLogger.writeMessage("For Product 3, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.NAIVE);
				MyLogger.writeMessage("For Product 3, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following: " 
						                 + sentence,DebugLevel.SEARCH);
			}
		}
	}

	/**
	 * This method contains the implementation of the Naive Match search algorithm for Product Four
	 * <p>
	 * It scans throug the entire content available for Product Four and searches to see if it can
	 * find the keyword (either as a substring of a word or the word itself). 
	 * <p>
	 * If it does, it logs the results into a data structure.
	 * @param productFourIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductFour productFourIn, String keywordIn, Results resIn){

		String keywordSubstr[] = keywordIn.split(" ");
		for(String sentence: productFourIn.getProductContent()){
			if(isContainKeyword(keywordSubstr[0],sentence)){//if(sentence.contains(keywordSubstr[0])){
				resIn.storeNewResult("For Product 4, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following:s " 
						                 + sentence +"\r\n");
				MyLogger.writeMessage("For Product 4, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following:s " 
						                 + sentence,DebugLevel.NAIVE);
				MyLogger.writeMessage("For Product 4, a close Naive Match for the keyword - " 
						                 + "\'" + keywordSubstr[0] + "\'" + " is present in the following:s " 
						                 + sentence,DebugLevel.SEARCH);
			}
		}
	}

	/**
	 * The isContainKeyword() method uses regex pattern to see if an exact match of the keyword 
	 * exists within the sentence or not
	 * <p>
	 * source url is as follows:
	 * https://stackoverflow.com/questions/17134773/to-check-if-string-contains-particular-word
	 * @param keywordIn the keyword to be searched
	 * @param sentenceIn the sentence in which the keyword needs to be searched
	 * @return a boolean value which denotes if the keyword is present or not
	 */

	private static boolean isContainKeyword(String keywordIn, String sentenceIn){
		String pattern = ".*" + keywordIn + ".*";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sentenceIn);
		return m.find();
	}
}