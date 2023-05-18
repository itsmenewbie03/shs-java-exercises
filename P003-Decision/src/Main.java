/********************************************************************
 * PROBLEM:   Write a Java program that inputs a peson's
 * 			  age and display their eligibility to vote
 * 			  Only 18 years old and above are able to vote
 * 
 * AUTHOR:    Salvador, 1 M. Ligayao
 * DATE:      5/3/2021
 * VERSION:   1.0 (with Exception Handling)
 *
 *******************************************************************/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// variables
		String name;
		int age;
		name = Main.getString("Please type your name and press ENTER");
		age = Main.getInt("Please type your age and press ENTER");
		if(age>=18) {
			System.out.println("CONGRATULATIONS, you are able to vote");
		} else {
			System.out.println((18-age)+" more year(s) and you will be able to VOTE");
		}
		
	}
	public static int getInt(String prompt) {
		Scanner in = new Scanner(System.in);
		boolean getOK = false;
		int value = 0;
		do {
			try {	
				System.out.print(prompt+": ");
				value = in.nextInt();
				getOK = true;
			} catch(Exception e) {
				System.out.println("Input Error. Please try again...");
				getOK = false;
				in.nextLine(); //flush
			}
		} while(!getOK);
		
		return value;
	}
	public static String getString(String prompt) {
		Scanner in = new Scanner(System.in);
		String value = "";
		
		System.out.print(prompt+": ");
		value = in.nextLine();
		
		return value;
	}
}
