package troubleShootSearch.util;

/**
 * @author Erwin Joshua Palani
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	/**
	 * The Results class contains the implementation of the private data structure that stores strings.
	 * It implements the FileDisplayInterface and StdoutDisplayInterface.
	 */

	private ArrayList<String> result = null;

	public Results(){

		/**
		 * A non-parameterized constructor that instantiates a Results instance.
		 * It is also used for debugging.
		 */

		result = new ArrayList<String>();
		MyLogger.writeMessage("Reached the constructor of Results Class",DebugLevel.CONSTRUCTOR);
	}


	public void storeNewResult(String s){

		/**
		 *
		 * This method adds the string values to the Result data structure 
		 * @param s a string value passed to be added to the Results 
		 *          data structure
		 */

		result.add(s);
	}

	public void writeToFile(String outputFile){

		/**
	 	 * This method helps write the output to the file. 
	 	 * Write to file is implemented using BufferedWriter. 
	 	 * The source url is as follows: 
	 	 * https://stackoverflow.com/questions/6548157/how-to-write-an-arraylist-of-strings-into-a-text-file
	 	 * @param outputFile the name of the output file to be written to.        
	 	 */

		BufferedWriter output = null;

		try{
			File file = new File(outputFile);
			try{
				if(!file.exists())
					file.createNewFile();
			} // end of inner try block
			catch(IOException ioe1){
				MyLogger.writeMessage("Error: Could not create an output file",DebugLevel.FILE_PROCESSOR);
				System.err.println("Error: Could not create an output file");
				ioe1.printStackTrace();
				System.exit(1);
			} // end of inner catch block
			output = new BufferedWriter(new FileWriter(file));
			
			for(String str: result){
				output.write(str);
			} // end of for block
		} // end of outer try block
		catch(IOException ioe2){
			MyLogger.writeMessage("Error: Could not write to output file",DebugLevel.FILE_PROCESSOR);
			System.err.println("Error: Could not write to output file");
			ioe2.printStackTrace();
			System.exit(1);
		} // end of catch block
		finally{
			if(output != null){
				try{
					output.close();
				} // end of try block
				catch(IOException ioe3){
					MyLogger.writeMessage("Error: Could not close output file",DebugLevel.FILE_PROCESSOR);
					System.err.println("Error: Could not close output file");
					ioe3.printStackTrace();
					System.exit(1);
				} // end of catch block
			} // end of if
		} // end of finally block
	}

	public void writeToStdout(String str){

			/**
			 * This method accepts String as a parameter and prints the value 
			 * of the parameter directly onto the console.
			 * @param str a string value that is to be displayed directly onto 
			 *            the console.
			 */

			System.out.println(str);
	}


	@Override
	public String toString(){

		/**
		 * This method helps print all the elements of the Results List.
		 * @return a string containing the final output    
		 */

		System.out.println("The elements in the Result List are as follows:");
		for(String s: result)
			System.out.println(s);
		return null;
	}
}
