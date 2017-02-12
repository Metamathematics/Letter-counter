package LetterCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetterCounter {
	public static void main (String args[]) throws IOException{
		String text = extractStringFromFile(readNameOfAFile());
		printCount(counter(text));
	}
	
	public static String readNameOfAFile () throws IOException{
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Write the path to the directory:");
		return reader.readLine();
		
		//return "C:\\Users\\Sergio\\Desktop\\CounterText.txt";
	}
	
	public static String extractStringFromFile (String fileName) throws IOException{
		String s = "";
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    
	    do{
	      s += br.readLine();
	    }while (s != null);
	    br.close();
		
	    return s;
	}
	
	
	public static int[] counter (String text){
		
		int[] count = new int[26];
		text = text.toUpperCase().replace(" ", "");
		//System.out.println(text);
		char c;
		
		for (int i = 0; i < text.length();++i){
			c = text.charAt(i);
			if (c >= 65 && c <= 90) ++count[c-65];	
		}
		
		return count;
	}
	
	public static void printCount (int [] count){
		for (short i = 0; count.length > i; ++i){
			System.out.println("" + (char)(i+65) + " = " + count[i]);
		}
	}
}
