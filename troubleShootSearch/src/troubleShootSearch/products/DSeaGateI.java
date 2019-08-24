package troubleShootSearch.products;

/**
 * @author Erwin Palani
 */

import troubleShootSearch.visitors.VisitorI;
import troubleShootSearch.util.Results;

import java.util.ArrayList;

public interface DSeaGateI{

	/**
	 * The DSeaGateI is an interface which provides the method declarations for accepting visitors,
	 * more specifically the searches to be performed, storing and returning the content related to
	 * a particular product
	 */

	/**
	 * The accept() method is used for accepting visitors, more specifically the search type that needs to be 
	 * visited for performing the search for a given query.
	 * @param visitorIn the visitor/search
	 * @param keywordIn the query
	 * @param resIn the instance of results to which the output needs to be recorded
	 */

	public void accept(VisitorI visitorIn, String keywordIn, Results resIn);

	/**
	 * The getProductContent() is used for retrieving the content specific to a product on which the 
	 * search needs to be performed
	 * @return a data structure containing the sentences/content to be searched 
	 */

	public ArrayList<String> getProductContent();
}