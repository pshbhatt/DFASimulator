package mainPkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piyush Bhatt
 * CWID:11763478
 * Course: CS 5313  Formal Language Theory
 * Programming Assignment Number:1 Part:1
 *
 */
public class SimDFSM {
/**
 * This is the main function which performs all the functions for DFSM Simulator
 * @param args
 * @throws IOException
 */
public static void main(String[] args) throws IOException {
	/*String checkString = null;
	String fileName = null;
	//Error condition if no arguments are passed.
	if(args.length==0){
		System.out.println("Error detected: Please provide arguments to run the application");
		System.exit(0);
	}
	//Error condition if filename is missing
	if(args[0].length()==0){
		System.out.println("Error detected: File Name missing. PLease provide a file name to provide the output");
		System.exit(0);
	} else {
	fileName = args[0];
	}
	//Error condition if input String is missing is missing
	if(args[1].length()==0){
		System.out.println("Error detected: Input String missing. Please provide an input string.");
		System.exit(0);
	} else {
	checkString = args[1];
	}
	Pattern pattern = Pattern.compile("[a-z]*");
    Matcher matcher = pattern.matcher(checkString);

	checkString = checkString.trim();
	//Error condition if the input string is invalid or the order of input is wrong.
	if(!matcher.matches()){
		System.out.println("Error detected: Invalid String. Please check the order of input. File Name should be provided before the input String");
		System.exit(0);
	}*/
	String checkString = "bbaa";
	String fileName = "table.txt";
	StringBuilder sb = new StringBuilder(checkString);
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	String sCurrentLine;
	String alphabets = "";
	String alphabet1 = "";
	String alphabet2 = "";
	String wholeText = "";
	String checkState2 = "";
	String checkState1 = "";
	String checkLetter2 = "";
	String checkLetter1 = "";
	//String currentRow;
	String result = "";
	String[] parts = null;
	int i=0;
	
	while ((sCurrentLine = br.readLine()) != null) {
		//Error condition if file contains empty lines.
		if(sCurrentLine.isEmpty()){
			System.out.println("Error detected: The file contains empty rows.");
			System.exit(0);
		}
	/*Extraction of alphabets from the file: Starts*/ 	
		if(i==0){
			alphabets=sCurrentLine;
			alphabets = alphabets.trim();
		}
		parts = alphabets.split(" ");
		if(parts.length==2){
		 alphabet1 = parts[0];
		 alphabet2 = parts[1];
		}
		/*Extraction of alphabets from the file: Ends*/
		 i++;
		 wholeText = wholeText+sCurrentLine;
	}
	char[] inputStringArray = checkString. toCharArray();
	 Set<Character> resultSet = new HashSet<Character>();

    for (int l = 0; l < inputStringArray.length; l++) {
        resultSet.add(new Character(inputStringArray[l]));
    }
    //Error condition if the input alphabets mismatch.
    if(parts.length!=resultSet.size()){
    	System.out.println("Error detected: Number of alphabets differ in file and input string");
    	System.exit(0);
    }
   
	
	wholeText = wholeText.replace(alphabet1 + " " + alphabet2, "");
	
	wholeText = wholeText.replace(" ", "");
	String[] rows =wholeText.split("(?<=\\G..)");
	/*Checking if the input string can be created by the transition table: Starts*/
	for(int k=0;k<rows.length;k++){
		
		String result1 = "";
		if(sb.toString().length()>0){
			result="";
		String checkLetter = sb.toString().substring(0,1);
		checkLetter1 = sb.toString().substring(0,1);
		String checkState = rows[k].substring(0, 1);
		checkState1 = rows[k].substring(0, 1);
		if(k+1<=Integer.parseInt(checkState)||k+1>Integer.parseInt(checkState)){
		if(checkLetter.equals(alphabet1)){
				result1 = "true";
			}
		/*if (checkLetter.equals(alphabet2)){
			result = "true";
		} */
		} 
		
		sb.deleteCharAt(0);
		if(sb.toString().length()>0){
		checkLetter = sb.toString().substring(0,1);
		checkLetter2 = sb.toString().substring(0,1);
		rows[k]=rows[k].replace(checkState, "");
		checkState = rows[k].substring(0, 1);
		if(k+1<=Integer.parseInt(checkState)||k+1>Integer.parseInt(checkState)){
			/*if(checkLetter.equals(alphabet1)){
				result = "true";
			}*/
			if (checkLetter.equals(alphabet2)){
				result = "true";
			} 
		}  
		checkState = rows[k].substring(0, 1);
		checkState2 = rows[k].substring(0, 1);
		sb.deleteCharAt(0);
		}
		if(Integer.parseInt(checkState1)>Integer.parseInt(checkState2)){
			if(checkLetter2.equals(alphabet1)){
				result="true";
			}
			if(checkLetter1.equals(alphabet2)){
				result="true";
			}
		}
		if(!result1.equals("true") && Integer.parseInt(checkState2)>Integer.parseInt(checkState1)){
			System.out.println("No");
			System.exit(0);
			}
		if(!result.equals("true")){
		System.out.println("No");
		System.exit(0);
		}
	}
	}
	/*Checking if the input string can be created by the transition table: Starts*/
	if(result.equals("true")){
		System.out.println("Yes");
	}
	br.close();
}

}
