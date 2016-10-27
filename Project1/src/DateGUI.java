/**
 * Michael Magoulis
 * Project 1
 * Professor Kenneth Lord
 * Lab Instructor Di Wu
 * Section 11A
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DateGUI  {
	
	static JFrame frame;
	static Container cPane;
	static TextArea dates, sorted;
	
	public static void initialize(ArrayList<String> datesArray, ArrayList<String> sortedArray) {
		frame = new JFrame();
		frame.setSize(500, 300);		// Sets length and width of JFrame
		frame.setLocation(200, 200);	// Location where JFrame appears
		frame.setTitle("Dates");		// Sets title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,2));	/* Sets layout for 1 row, 2 columns
		 *
		 * Create 2 TextAreas, one for raw data ("dates", left column)
		 * and one for sorted data ("sorted", right column)
		 */
		dates = new TextArea();
		sorted = new TextArea();
		// add TextAreas to cPane
		cPane = frame.getContentPane();
		cPane.add(dates);
		cPane.add(sorted);
		
		frame.setVisible(true);
		dates.append("Unsorted\n");
		sorted.append("Sorted\n");
		int x = sortedArray.size();
// variable x represents the length of the condensed array (no null values)
// appends each element of datesArray and moves to a new line to the dates TextArea
		for (int i = 0; i < x; i++) {
			dates.append(datesArray.get(i) + "\n");
		}
// appends each element of sortedArray and moves to a new line for the sorted TextArea
		for (int i = 0; i < x; i++) {
			sorted.append(sortedArray.get(i) + "\n");
		}
		
	}

}
