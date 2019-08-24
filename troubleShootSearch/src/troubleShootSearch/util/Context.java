package troubleShootSearch.util;

/**
 * @author Eriwn Palani
 */ 

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Results;
import troubleShootSearch.products.ProductOne;
import troubleShootSearch.products.ProductTwo;
import troubleShootSearch.products.ProductThree;
import troubleShootSearch.products.ProductFour;
import troubleShootSearch.visitors.VisitorI;
import troubleShootSearch.visitors.ExactMatch;
import troubleShootSearch.visitors.NaiveStemmingMatch;
import troubleShootSearch.visitors.SemanticMatch;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

import java.io.File;
import java.util.ArrayList;

public class Context{

	/**
	 * The Context class is an intermediary class that helps create and instantiate the required objects,
	 * kick off the different searches to be performed for the keywords.
	 */

	Results res = null;
	ProductOne productOne;
	ProductTwo productTwo;
	ProductThree productThree;
	ProductFour productFour;
	ExactMatch exactMatch;
	NaiveStemmingMatch naiveMatch;
	SemanticMatch semanticMatch;
	ArrayList<String> keywords;

	public Context(Results resIn, ArrayList<String> keywordsIn){

		/**
		* A parameterized constructor.
		* @param resIn an instance of results to record the output
		* @param keywordsIn a data structure containing the list of keywords
		*/

		MyLogger.writeMessage("Reached constructor of class Context",DebugLevel.CONSTRUCTOR);
		exactMatch = new ExactMatch();
		naiveMatch = new NaiveStemmingMatch();
		semanticMatch = new SemanticMatch();

		productOne = new ProductOne();
		productTwo = new ProductTwo();
		productThree = new ProductThree();
		productFour = new ProductFour();

		res = resIn;
		keywords = keywordsIn;
	}

	public void initializeSearch(){

		/**
		 * The initializeSearch() invokes the different searches to be performed on all the products
		 * contents using the keywords provided.
		 */

		int counter = 1;

		res.storeNewResult("Please find the following hits for all queries below:");

			for(String searchKeyword: keywords){
				res.storeNewResult("\r\n" + (counter++) + "." + "Query: " + searchKeyword + "\r\n");
				productOne.accept(exactMatch,searchKeyword,res);
				productOne.accept(naiveMatch,searchKeyword,res);
				productOne.accept(semanticMatch,searchKeyword,res);

				productTwo.accept(exactMatch,searchKeyword,res);
				productTwo.accept(naiveMatch,searchKeyword,res);
				productTwo.accept(semanticMatch,searchKeyword,res);

				productThree.accept(exactMatch,searchKeyword,res);
				productThree.accept(naiveMatch,searchKeyword,res);
				productThree.accept(semanticMatch,searchKeyword,res);

				productFour.accept(exactMatch,searchKeyword,res);
				productFour.accept(naiveMatch,searchKeyword,res);
				productFour.accept(semanticMatch,searchKeyword,res);
			}
	}

}