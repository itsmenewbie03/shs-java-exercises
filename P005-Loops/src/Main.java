/********************************************************************
 * 	PROBLEM:	Write a Java program that prints all integers
 * 				from 1 to 50 using loops
 *  
 *  AUTHOR:		Salvador, 1 M. Ligayao
 *  DATE:		5/7/2021
 *  VERSION: 	1.0
 *
 ********************************************************************/
public class Main {

	public static void main(String[] args) {
		// declare variables
		int count = 0;
		
		// FOR LOOPS execute 0 to n times
		// The loop condition is at the top or beginning of
		// the block, that is why the FOR LOOP block may
		// never be executed at all.
		
		System.out.println("==== FOR LOOP ===============================");
		for(int counter =  1; counter<=50; counter++) {
			System.out.println(counter);
		}
		System.out.println();
		
		// WHILE LOOPS also execute 0 to n times similar to
		// for loops since the condition is at the top or
		// beginning of the block
		// The WHILE LOOP block may not be executed at all
		
		System.out.println("==== WHILE LOOPS=============================");
		count = 1;
		while (count<=50) {
			System.out.println(count);
			count++;
		}
		System.out.println();
		
		// DO LOOPS execute least 1 to n times because the
		// condition is at the bottom or end of the block.
		// The DO LOOP block will execute at least once.
		
		System.out.println("==== DO LOOP ================================");
		count = 1;
		do {
			System.out.println(count);
			count++;
		} while(count<=50);
	}
}
