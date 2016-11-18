package mainPkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piyush Bhatt
 * CWID:11763478
 * Course: CS 5313  Formal Language Theory
 * Programming Assignment Number:1 Part:2
 */
public class DFSMBuilder {
/**
 * @param args
 * @throws IOException
 * This is the main function which checks the given string pattern and creates the transition table.
 */
public static void main(String[] args) throws IOException {
	String inputString = null;
	String fileName = null;
	//Error condition if no arguments are passed.
	if(args.length==0){
		System.out.println("Error detected. Please provide arguments to run the application");
		System.exit(0);
	}
	//Error condition if filename is missing
	if(args[0].length()==0){
		System.out.println("Error detected. File Name missing. PLease provide a file name to provide the output");
		System.exit(0);
	} else {
	fileName = args[0];
	}
	//Error condition if input String is missing is missing
	if(args[1].length()==0){
		System.out.println("Error detected. Input String missing. Please provide an input string.");
		System.exit(0);
	} else {
		inputString = args[1];
	}
	//inputString = inputString.trim();
	Pattern pattern = Pattern.compile("[a-z]*");
    Matcher matcher = pattern.matcher(inputString);
    //Error condition if the input string is invalid or the order of input is wrong.
    if(!matcher.matches()){
		System.out.println("Error detected. Invalid String. Please check the order of input. File Name should be provided before the input String");
		System.exit(0);
	}
	//String inputString = "aabaaab";
	int valueOf11 = 0;
	int valueOf12 = 0;
	int valueOf1Before = 0;
	int valueOf2Before = 0;
	int valueOf21 = 0;
	int valueOf22 = 0;
	int numberOfStates = inputString.length() + 1;
	/*File creation: Starts*/
	File file = new File(fileName);
	 FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
	/*File creation: Ends*/
	/*Extracting the input alphabets from the input string: Starts*/	
	char[] inputStringArray = inputString. toCharArray();
	 Set<Character> resultSet = new HashSet<Character>();

     for (int i = 0; i < inputStringArray.length; i++) {
         resultSet.add(new Character(inputStringArray[i]));
     }
     String alphabet1=resultSet.toArray()[0].toString();
     String alphabet2=resultSet.toArray()[1].toString();
     /*Extracting the input alphabets from the input string: Ends*/
     //Write the alphabets to the file
     bw.write(alphabet1+ " " + alphabet2);
     bw.newLine();
	/*Creation of transition table based on the input string provided: Starts*/	
     for(int i=0;i<numberOfStates;i++){
    	 if(inputString.length()>0){
    			String checkLetter = inputString.substring(0,1);
    			if(checkLetter.equals(alphabet1)){
    				if(i==0){
    				bw.write(i+2 + " " + (i+1));
    				valueOf11 = i+2;
    				valueOf12 = i+1;
    				bw.newLine();
    				} else {
    					//valueOf1Before = ;
    					bw.write(i+2 + " " + valueOf12);
    					if(i+2!=valueOf11){
    					valueOf11 = i+2;
    					}
        				
        				bw.newLine();
    				}
    			}
    			if(checkLetter.equals(alphabet2)){
    				if(i==0){
    					bw.write(i+1 + " " + (i+2));
    				valueOf21 = i+1;
    				valueOf22 = i+2;
    				bw.newLine();
    				} else {
    					bw.write(valueOf11 + " " + (i+2));
    					
        				bw.newLine();
    				}
    			}
    				StringBuilder sb = new StringBuilder(inputString);
    				sb.deleteCharAt(0);
    				inputString = sb.toString();
    		}
    	 
     }
     /*Creation of transition table based on the input string provided: Ends*/
     bw.close();
		
	 

}


}
