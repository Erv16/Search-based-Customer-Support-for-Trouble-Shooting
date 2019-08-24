package troubleShootSearch.products;

/**
 * @author Erwin Palani
 */

import troubleShootSearch.visitors.VisitorI;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class ProductOne implements DSeaGateI{

	/**
	 * It is one among the four dSeaGate Products and therefore provides the implementation for the dSeaGate interface's methods 
	 * <p> 
	 * It is used for storing content relevant to this product and for invoking the required searches.
	 */

	private ArrayList<String> prodOneResponses = null;
	String temp ="";

	public ProductOne(){

		/**
		 * Constructor
		 * <p>
		 * It reads in the content specific to this product from the respective hardcoded input file.
		 * source url is as follows:
		 * https://stackoverflow.com/questions/24709769/java-using-system-getpropertyuser-dir-to-get-the-home-directory
		 */

		MyLogger.writeMessage("Reached constructor of Product One",DebugLevel.CONSTRUCTOR);
		try{	
			FileProcessor fp = new FileProcessor(System.getProperty("user.dir")+"/src/troubleShootSearch/products/Repository1.txt");
			prodOneResponses = new ArrayList<String>();
				while((temp = fp.readLine()) != null){
					prodOneResponses.add(temp);
				} // end of while block
		} // end of try block
		catch(IOException ioe){
			System.err.println("Error: Unable to parse file Repository1.txt");
			ioe.printStackTrace();
			System.exit(1);
		} // end of catch block
	}

	/**
	 * The setProductContent() method helps in setting up the data structure for storing the required content
	 * @param prodOneResponsesIn the data structure that needs to be set
	 */

	public void setProductContent(ArrayList<String> prodOneResponsesIn){
		prodOneResponses = prodOneResponsesIn;
	}

	/**
	 * The getProductContent() method helps in returning the content specific to this product on which the search
	 * needs to be performed.
	 * @return a data structure containing the data to be searched against
	 */

	public ArrayList<String> getProductContent(){
		return prodOneResponses;
	}

	/**
	 * The accept() method is used for accepting the visitor, or the required search type that needs to be performed,
	 * and further invoking the search.
	 * @param visitorIn the type of search that needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance of results to which the output needs to be recorded
	 */

	@Override
	public void accept(VisitorI visitorIn, String keywordIn, Results resIn){
		visitorIn.visit(this,keywordIn,resIn);
	}
}