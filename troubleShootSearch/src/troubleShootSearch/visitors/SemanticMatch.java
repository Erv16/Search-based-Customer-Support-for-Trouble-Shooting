package troubleShootSearch.visitors;

/**
 * @author Erwin Palani
 */

import troubleShootSearch.products.ProductOne;
import troubleShootSearch.products.ProductTwo;
import troubleShootSearch.products.ProductThree;
import troubleShootSearch.products.ProductFour;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class SemanticMatch implements VisitorI{

	/**
	 * The SemanticMatch class provides the implementation for performing a semantic match search
	 * for each of the individual products and logs the results of the search into a data structure
	 */

	HashMap<String, ArrayList<String>> synonymMap = new HashMap<String, ArrayList<String>>();

	public SemanticMatch(){

		/**
		 * Constructor
		 * <p>
		 * It helps in initializing the hashmap data structure which is used to storing the association 
		 * between the keyword and its corresponding synonym
		 */

		MyLogger.writeMessage("Reached the constructor of SemanticMatch class",DebugLevel.CONSTRUCTOR);

		try{
			FileProcessor fp = new FileProcessor(System.getProperty("user.dir") + "/src/troubleShootSearch/visitors/synonym.txt");
			String line = "";
			while((line = fp.readLine()) != null){
				String str[] = line.split(":");
				if(synonymMap.containsKey(str[0])){
					synonymMap.get(str[0]).add(str[1]);
				} // end of if
				else if(synonymMap.containsKey(str[1])){
					synonymMap.get(str[1]).add(str[0]);
				} // end of if
				else{
					ArrayList<String> synonym1 = new ArrayList<String>();
					synonym1.add(str[1]);
					synonymMap.put(str[0],synonym1);
					ArrayList<String> synonym2 = new ArrayList<String>();
					synonym2.add(str[0]);
					synonymMap.put(str[1],synonym2);
				} // end of else	
			} // end of while block
		} // end of try block
		catch(IOException ioe){
			System.err.println("Error: Unable to parse synonym.txt file");
			MyLogger.writeMessage("Error: Unable to parse synonym.txt file",DebugLevel.NONE);
			MyLogger.writeMessage("Error: Unable to parse synonym.txt file",DebugLevel.FILE_PROCESSOR);
			ioe.printStackTrace();
			System.exit(1);
		} // end of catch block
	}

	/**
	 * This method contains the implementation of the Semantic Match search algorithm for Product One
	 * <p>
	 * It scans throug the entire content available for Product One and searches to see if it can
	 * find the synonym of its respective keyword. If it does, it logs the results into a data structure.
	 * <p> 
	 * If the keyword consists of multiple words, the last word of the keyword is used and its corresponding
	 * synonym is searched for in the sentence. If the keyword is a single word, then the synonym of the 
	 * keyword itself is searched for.
	 * @param productOneIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductOne productOneIn, String keywordIn, Results resIn){

		String keyword[] = keywordIn.split(" ");
		
		if(synonymMap.containsKey(keyword[keyword.length-1])){
			
			ArrayList<String> keySpecSynonym = synonymMap.get(keyword[keyword.length-1]);

			if(keySpecSynonym != null){
				keywordIn = "";
				for(String word: keySpecSynonym){
					if(keyword.length == 1){
						keywordIn = word;	
					}
					else{
						keywordIn = keyword[0] + " " + word;
					}
					for(String sentence: productOneIn.getProductContent()){
						if(isContainExactKeyword(keywordIn,sentence)){
						resIn.storeNewResult("For Product 1, a Semantic Match is found for the synonym "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence + "\r\n");
						MyLogger.writeMessage("For Product 1, a Semantic Match is found for the synonym "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEMANTIC);
						MyLogger.writeMessage("For Product 1, a Semantic Match is found for the synonym "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEARCH);
						}
					}
				}
			}	
		}	
	}

	/**
	 * This method contains the implementation of the Semantic Match search algorithm for Product Two
	 * <p>
	 * It scans throug the entire content available for Product Two and searches to see if it can
	 * find the synonym of its respective keyword. If it does, it logs the results into a data structure.
	 * <p> 
	 * If the keyword consists of multiple words, the last word of the keyword is used and its corresponding
	 * synonym is searched for in the sentence. If the keyword is a single word, then the synonym of the 
	 * keyword itself is searched for.
	 * @param productTwoIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductTwo productTwoIn, String keywordIn, Results resIn){

		String keyword[] = keywordIn.split(" ");

		if(synonymMap.containsKey(keyword[keyword.length-1])){

			ArrayList<String> keySpecSynonym = synonymMap.get(keyword[keyword.length-1]);

			if(keySpecSynonym != null){
				keywordIn = "";
				for(String word: keySpecSynonym){
					if(keyword.length == 1){
						keywordIn = word;
					}
					else{
						keywordIn = keyword[0] + " " + word;
					}
					for(String sentence: productTwoIn.getProductContent()){
						if(isContainExactKeyword(keywordIn,sentence)){
						resIn.storeNewResult("For Product 2, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence + "\r\n");
						MyLogger.writeMessage("For Product 2, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEMANTIC);
						MyLogger.writeMessage("For Product 2, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEARCH);
						}
					}
				}
			}	
		}
	}

	/**
	 * This method contains the implementation of the Semantic Match search algorithm for Product Three
	 * <p>
	 * It scans throug the entire content available for Product Three and searches to see if it can
	 * find the synonym of its respective keyword. If it does, it logs the results into a data structure.
	 * <p> 
	 * If the keyword consists of multiple words, the last word of the keyword is used and its corresponding
	 * synonym is searched for in the sentence. If the keyword is a single word, then the synonym of the 
	 * keyword itself is searched for.
	 * @param productThreeIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductThree productThreeIn, String keywordIn, Results resIn){

		String keyword[] = keywordIn.split(" ");

		if(synonymMap.containsKey(keyword[keyword.length-1])){
			
			ArrayList<String> keySpecSynonym = synonymMap.get(keyword[keyword.length-1]);

			if(keySpecSynonym != null){
				keywordIn = "";
				for(String word: keySpecSynonym){
					if(keyword.length == 1){
						keywordIn = word;
					}
					else{
						keywordIn = keyword[0] + " " + word;
					}
					for(String sentence: productThreeIn.getProductContent()){
						if(isContainExactKeyword(keywordIn,sentence)){
						resIn.storeNewResult("For Product 3, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence + "\r\n");
						MyLogger.writeMessage("For Product 3, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEMANTIC);
						MyLogger.writeMessage("For Product 3, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEARCH);
						}
					}
				}
			}
		}		
	}

	/**
	 * This method contains the implementation of the Semantic Match search algorithm for Product Four
	 * <p>
	 * It scans throug the entire content available for Product Four and searches to see if it can
	 * find the synonym of its respective keyword. If it does, it logs the results into a data structure.
	 * <p> 
	 * If the keyword consists of multiple words, the last word of the keyword is used and its corresponding
	 * synonym is searched for in the sentence. If the keyword is a single word, then the synonym of the 
	 * keyword itself is searched for.
	 * @param productFourIn the product on which the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of the data structure to which the results need to be stored
	 */

	public void visit(ProductFour productFourIn, String keywordIn, Results resIn){

		String keyword[] = keywordIn.split(" ");

		if(synonymMap.containsKey(keyword[keyword.length-1])){
			
			ArrayList<String> keySpecSynonym = synonymMap.get(keyword[keyword.length-1]);

			if(keySpecSynonym != null){
				keywordIn = "";
				for(String word: keySpecSynonym){
					if(keyword.length == 1){
						keywordIn = word;
					}
					else{
						keywordIn = keyword[0] + " " + word;
					}
					for(String sentence: productFourIn.getProductContent()){
						if(isContainExactKeyword(keywordIn,sentence)){
						resIn.storeNewResult("For Product 4, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence + "\r\n");
						MyLogger.writeMessage("For Product 4, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEMANTIC);
						MyLogger.writeMessage("For Product 4, a Semantic Match is found for the synonym - "
											 + "*" + keywordIn + "*" + " of the keyword " 
							                 + "\'" + keyword[keyword.length-1] + "\'" + " in the following sentence: " 
							                 + sentence,DebugLevel.SEARCH);
						}
					}
				}
			}		
		}
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