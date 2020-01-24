# Search-based-Customer-Support-for-Trouble-Shooting

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in troubleShootSearch/src folder.
Note: Assuming you are in the erwin_palani_assign_5/troubleShootSearch folder
Instruction to clean:
####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.

Instruction to compile:
####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

Instruction to run:
####Command: ant -buildfile src/build.xml run -Darg0=

Example:

ant -buildfile troubleShootSearch/src/build.xml run -Darg0=0

6 - Prints the results of Semantic. Writes the results to the output file.

5 - Prints the results of Naive Match. Writes the results to the output file.

4 - Prints the results of Exact Match. Writes the results to the output file.

3 - Prints everytime a constructor is called. Writes the results to the output file.

2 - Prints the updates on FileProcessor and the lines being read from the input file. Writes the results to the output file.

1 - Only the search results are printed. Writes the results to the output file.

0 - No output is printed. Only error messages are printed. Writes the results to the output file.

Description:
The objective of the assignment is to design a search engine for portable Drive vendor using the Visitor Pattern.

The vendor has four distinct products each. The engine is provided with certain user given keywords to carry out the searches amongst these products and the results of these searches have to be written to an output file. The keywords can be found in a text file called 'userInputs.txt'. The contents of the file are read into a data structure. The file name and path is hardcoded.

Each of the products have their own content which are read from their respective text files (whose names and paths are hardcoded) and are stored in a data structure.

The three different search algorithms to be performed are namely Exact Match, Naive Match and Semantic Match.

i. Exact match does a simple check to see if it can find an exact word to word, case to case match of the keyword in the sentence for a respective product. The results stored display the query/keyword, which product's sentence it was found in along with the sentence itself and the search used for finding it.

ii. Naive match functions slightly differently. In the first scenario, if Naive Match receives a single keyword, it will search for the keyword either as it is or as a substring of a word in the sentence. In the second scenario, if Naive Match receives a keyword consisting of multiple words, it will check to see if the first word of the keyword is present as is or as a substring of a word.The results stored display the query/keyword, which product's sentence it was found in along with the sentence itself and the search used for finding it.

iii. Semantic search makes use of synonyms (the synonym pairs are stored in a file called synonym.txt). It reads in a keyword, finds its corresponding synonym and then checks to see if an exact match of the synonym is present within a sentence or not. The results stored display the synonym along with it's respective query/keyword, which product's sentence it was found in along with the sentence itself and the search used for finding it.

The searches are basically the different Visitors in this scenario. Each of the products accept the visitors (search objects) and using these objects visit the corresponding search algorithm to be performed.

The Driver file delegates the task of invoking the searches to the Context file (which is placed in the util directory).

Files used for this assignment:

userInputs.txt - keywords
Repository1.txt - sentences related to Product 1
Repository2.txt - sentences related to Product 2
Repository3.txt - sentences related to Product 3
Repository4.txt - sentences related to Product 4
synonym.txt - contains the synonym mappings
output.txt - contains the results of the searches.
