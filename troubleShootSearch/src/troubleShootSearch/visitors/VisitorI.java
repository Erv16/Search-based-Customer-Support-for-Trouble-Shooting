package troubleShootSearch.visitors;

/**
 * @author Erwin Palani
 */

import troubleShootSearch.products.DSeaGateI;
import troubleShootSearch.products.ProductOne;
import troubleShootSearch.products.ProductTwo;
import troubleShootSearch.products.ProductThree;
import troubleShootSearch.products.ProductFour;
import troubleShootSearch.util.Results;

public interface VisitorI{

	/** 
	 * The VisitorI interface contains method declarations for different searches based on the type of search
	 * invoking it and also depending on the product type
	 * source url for visitor pattern is as follows:
	 * https://www.tutorialspoint.com/design_pattern/visitor_pattern
	 */

	/**
	 * The visit method specific for Product One
	 * @param productOneIn the specific product on whose content the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance to which the output needs to be recorded
	 */

	public void visit(ProductOne productOneIn, String keywordIn, Results resIN);

	/**
	 * The visit method specific for Product Two
	 * @param productTwoIn the specific product on whose content the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance to which the output needs to be recorded
	 */

	public void visit(ProductTwo productTwoIn, String keywordIn, Results resIN);

	/**
	 * The visit method specific for Product Three
	 * @param productThreeIn the specific product on whose content the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance to which the output needs to be recorded
	 */

	public void visit(ProductThree productThreeIn, String keywordIn, Results resIn);

	/**
	 * The visit method specific for Product Four
	 * @param productFourIn the specific product on whose content the search needs to be performed
	 * @param keywordIn the keyword that needs to be searched
	 * @param resIn the instance to which the output needs to be recorded
	 */

	public void visit(ProductFour productFourIn, String keywordIn, Results resIn);
}