/**
 * MM
 * Project 1
 */

import java.util.*;

public class Project1 {

	public static void main(String[] args) { 
		TextFileInput input = new TextFileInput("fileinput.txt");
		ArrayList<String> sA2 = new ArrayList<String>();
		ArrayList<String> sA3 = new ArrayList<String>();
		
		String[] stringArray = new String[100];
		
	//	stringTokenize(input, stringArray);
		stringTokenize(input, sA2);
		
		String[] condensedArray = condenseArray(stringArray);
		
		for (String contents : sA2) {
			System.out.println(contents);
		}
		
		for (int i = 0; i < sA2.size(); i++) {
			sA3.add(sA2.get(i));
		}
		
		Collections.sort(sA3);
		
		DateGUI.initialize(sA2, sA3);
		
		SelectionSort(condensedArray);

	//	DateGUI.initialize(stringArray, condensedArray);
	}
	/*
	 * stringTokenize takes TextFileInput and reads line by line
	 * separating tokens by commas in this case.
	 * loops while there are still more tokens on a line.
	 * loops while line is not equal to null.
	 * Prints invalid entries to the console
	 */
	public static String[] stringTokenize(TextFileInput input, String[] stringArray) {
		int validCount = 0;
		String line = input.readLine();
		while (line != null) {								// continues to loop until line == null
			StringTokenizer st = new StringTokenizer(line);	// use StringTokenizer on line of file to check for commas
			while (st.hasMoreTokens()) {					// continues while there are still more tokens
				String token = st.nextToken(",");
				if (isValidDate(token)) {					// checks for validity
					stringArray[validCount++] = token;		// if valid, token is added to stringArray
				}											// and validCount is incremented
				else System.out.println(token); // if not valid, prints invalid entry to console
			}
			line = input.readLine();	// if there are no remaining tokens, moves to next line of input
		}
		return stringArray;
	}
	
	public static ArrayList<String> stringTokenize(TextFileInput input, ArrayList<String> al) {
		String line = input.readLine();
		while(line != null) {
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				String token = st.nextToken(",");
				if (isValidDate(token)) {
					al.add(token);
				}
				else System.out.println(token);
			}
			line = input.readLine();
		}
		return al;
	}
	/*
	 * Takes a String array that contains null values
	 * at the end and returns one without them
	 */
	public static String[] condenseArray(String[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) count++;
			else break; // breaks if null value is found
		}	// in this case, finding a null value means all remaining values are also null
		String[] condensedArray = new String[count];
		for (int j = 0; j < count; j++) {
			condensedArray[j] = array[j];
		}
		return condensedArray;
	}
	/*
	 * Checks for the validity of the date by ensuring string
	 * isn't null, is the proper length, that the month starts
	 * with a 1 or a 0, and contains all digits.
	 */
	public static boolean isValidDate(String s) {
		if (s == null)
				return (false);
		if (s.length() != 8)		// check for proper length
				return (false);
		if (s.charAt(4) != '0' && s.charAt(4) != '1') // check that month starts with 0 or 1
				return (false);
		for (int i = 0; i < 8; i++) {
			if (! Character.isDigit(s.charAt(i))) // check for digits
				return (false);
		}
		return (true);
	}
	/*
	 * Compares i'th element to n'th element and swaps
	 * if necessary to sort in descending order
	 */
	public static void SelectionSort (String[] dates) {
		for (int i = 1; i < dates.length; i++) {
			if (dates[i] == null) break;
			int n = i-1;
			for (int j = i; j < dates.length; j++) {
				if (dates[j].compareTo(dates[n]) > 0) {
					n = j;
				}
			}
			String temp = dates[i-1];
			dates[i-1] = dates[n];
			dates[n] = temp;
		}
	}
	
	/*
	 * Simply prints the String array as long as the
	 * value is not null
	 */
	public static void printArray(String[] sArray) {
		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i] != null) {
				System.out.println(sArray[i]);
			}
		}
	}
}
