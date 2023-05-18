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
import java.util.Scanner;

public class Get {
	String value;
	
	Get(){
		this.value = "";
	}
	
	@SuppressWarnings("resource")
	public void getValue(String prompt) {
		System.out.print(prompt+": ");
		this.value = new Scanner(System.in).nextLine();
	}
	
	public byte toByte() {
		byte result = 0;
		try {
			result = Byte.parseByte(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Byte Value (Set to Zero)");
		}
		return result;
	}
	
	public short toShort() {
		short result = 0;
		try {
			result = Short.parseShort(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Short Value (Set to Zero)");
		}
		return result;
	}
	
	public int toInteger() {
		int result = 0;
		try {
			result = Integer.parseInt(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Integer Value (Set to Zero)");
		}
		return result;
	}
	
	public long toLong() {
		long result = 0;
		try {
			result = Long.parseLong(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Long Integer Value (Set to Zero)");
		}
		return result;
	}
	
	public float toFloat() {
		float result = (float) 0.0;
		try {
			result = Float.parseFloat(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Float Value (Set to Zero)");
		}
		return result;
	}
	
	public double toDouble() {
		double result = 0.0;
		try {
			result = Double.parseDouble(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Double Value (Set to Zero)");
		}
		return result;
	}
	
	public char toCharacter() {
		char result = 0x00;
		try {;
			if(this.value.length()>0) result = this.value.charAt(0);
		} catch(Exception e) {
			System.out.println("Invalid Character Value (Set to Null Character)");
		}
		return result;
	}
	
	public boolean toBoolean() {
		boolean result = false;
		try {
			result = Boolean.parseBoolean(this.value);
		} catch(Exception e) {
			System.out.println("Invalid Boolean Value (Set to False)");
		}
		return result;
	}
	
	public String toString() {
		return this.value;
	}
}
