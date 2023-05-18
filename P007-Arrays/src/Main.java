import java.lang.reflect.Array;

/****************************************************************************
 * PROBLEM:		Write a Java program that can input a maximum of 
 * 				100 integers or less. The user can stop the input at
 *				any time by typing "quit". The program should
 *				output the greatest value and the sum of all the
 *				values entered.
 * 				
 * AUTHOR:		Salvador, 1 M.Ligayao
 * DATE:		5/25/2021
 * VERSION:		1.0
 * 
 * 
 * PROJECT:		P006-Operators
 ****************************************************************************/
/*
 * For programs requiring a lot of input, ARRAYS should be utilized
 * to accommodate the values for processing.
 * 
 * ARRAYS are contiguous memory locations of homogeneous  values.
 * These locations contain similar or the same type of variables
 * (integers, bytes, floats, doubles, Strings, etc.)
 * 
 * ARRAYS are also indexed by integers values. Each element is
 * accessed via the index. This makes the ARRAY very convenient
 * for processing large data sets
 * 
 * ARRAYS are typically STATIC data structures; once the size is
 * allocated, this will remain fixed throughout the running of
 * the program.
 * 
 * */
public class Main {

	public static void main(String[] args) {
		// declare an integer array of 100 elements
		int values[] = new int[100];
		String strings[] = new String[10];
		
		strings[3] = "Hello";
		strings[7] = "world";
		
		// input counter
		int max_input = 0;
		// Get class from
		//		P004-Nested_Decision --> add the class in
		//		the class path of this project
		//		Code re-use!!!!
		Get in = new Get();
		
		while (max_input<100) {
			in.getValue("Please type an integer or \"quit\" " + 
						" to stop and press ENTER");
			if(in.toString().matches("quit")) {
				// stop the loop
				break;
			}
			// copy the input value as an integer to current index;
			// and increment the index
			values[max_input++] = in.toInteger();
  		}
		try {
			// output will show the Strong or object array
			// elements are initially NULL
			showValues(strings);
			// output will show that integer array elements are
			// initialized to ZER0
			showValues(values);
			System.out.println("Total Sum: " + sumArray(values));
			System.out.println(" Greatest: " + findGreatestValue(values));
			
		} catch(Exception e) {
			System.out.println("Error processing the array");
		}
	}
	
	// Generic array iterator showing the values of array elements.
	// This can be adapted to show any type of array element.
	public static void showValues(Object values) {
		// check if parameter is indeed an ARRAY
		if(values.getClass().isArray()) {
			for(int i=0;i<Array.getLength(values); i++) {
				// check if array element is NULL
				if(Array.get(values, i)==null) {
					System.out.println(i+": " + "null");
				}
				// check if array element is String
				else if(Array.get(values, i).getClass()==String.class) {
					System.out.println(i+": " + (String)Array.get(values, i));
				}
				// check if array element is an Integer
				else if(Array.get(values, i).getClass()==Integer.class) {
					System.out.println(i+": " + (Integer)Array.get(values, i));
				}
			}
		}
	}
	
	// This method traverses the integer array and does a
	// running sum while visiting each element
	public static int sumArray(int data[]) throws Exception{
		// throw an exception if the array is null
		if(data==null) throw new Exception("No data to process");
		
		// set sum to zero initially
		int sum =  0;
		for(int i = 0; i<data.length; i++) {
			// add current element value to sum
			sum += data[i];
		}
		return sum;
	}
	
	// method traverses the entire integer array (linear search)
	// to look for the greatest values
	public static int findGreatestValue(int data[]) throws Exception{
		int greatest = -1;
		if(data==null) throw new
			IllegalArgumentException("No data to process!");
		
		greatest = data[0];
		for(int i = 1; i<data.length; i++) {
			if (greatest<data[i]) {
				//change to new greatest value
				greatest = data[i];
			}
		}
		return greatest;
	}
}


