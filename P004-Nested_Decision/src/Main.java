/********************************************************************
 * 	PROBLEM:	Write a Java program that prints inputs three values
 * 				and outputs the greatest value
 *  
 *  AUTHOR:		Salvador, 1 M. Ligayao
 *  DATE:		5/7/2021
 *  VERSION: 	1.0(with Get Class)
 *  
 *  PROJECT:	P004-Nested_Decision
 *
 ********************************************************************/
public class Main {

	public static void main(String[] args) {
		//declare variables
		Get in = new Get();
		
		double first, second, third;
		
		//get values
		in.getValue("Enter first value");
		first = in.toDouble();
		
		in.getValue("Enter second value");
		second = in.toDouble();
		
		in.getValue("Enter third value");
		third = in.toDouble();
		
		//compare values
		if(first>second) {
			if (first>third) {
				System.out.print(first);
			} else {
				System.out.print(third);
			}
		} else {
			if(second>third) {
				System.out.print(second);
			} else {
				System.out.print(third);
			}
		}
		System.out.println(" is the greatest value");
	}

}
