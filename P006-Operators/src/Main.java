/****************************************************************************
 * PROBLEM:		Demonstration program showing the use of Java operators
 * 
 * AUTHOR:		Salvador, 1 M.Ligayao
 * DATE:		5/25/2021
 * VERSION:		1.0
 * REVISED:		5/25/2021
 * 
 * 
 * PROJECT:		P006-Operators
 ****************************************************************************/
public class Main {

	public static void main(String[] args) {
		// declare variables
		int a = 10,  b = 20, c = 30;
		String str1 = "China Crisis", str2 = "elemental";
		pl("INITIAL VALUES");
		pl("a: " + a);
		pl("b: " + b);
		pl("c: " + c);
		pl("str1: " + str1);
		pl("str2: " + str2);
		pl();
		pl("ASSIGNMENT OPERATORS");
		pl("---------------------------------------------------------------------");
		pl("ASSIGNMENT:                         =");
		pl("ADDITION ASSIGNMENT:               +=");
		pl("SUBTRACTION ASSIGNMENT:            -=");
		pl("MULTIPLICATION ASSIGNMENT:         *=");
		pl("DIVISION ASSIGNMENT:               /=");
		pl("MODULUS ASSIGNMENT:                %=");
		pl();
		pl("---------------------------------------------------------------------");
		pl("INCREMENT: ++");
		pl("---------------------------------------------------------------------");
		pl("POSTFIX: Value is incremented after use");
		pl("a++(result: " + (a++) + ")");
		pl("PREFIX: Value is incremented before use");
		pl("++a(result: " + (++a) + ")");
		pl();
		pl("---------------------------------------------------------------------");
		pl("DECREMENT: --");
		pl("---------------------------------------------------------------------");
		pl("POSTFIX: Value is decremented after use");
		pl("a--(result: " + (a--) + ")");
		pl("PREFIX: Value is decremented before use");
		pl("--a(result: " + (--a) + ")");
		pl();
		
		pl("a = c");
		pl("a: " + (a=c));
		pl();
		pl("a += 2");
		pl("a: " + (a+=2));
		pl();
		pl("a *= 2");
		pl("a: " + (a*=2));
		pl();
		pl("a -= 2");
		pl("a: " + (a-=2));
		pl();
		pl("a /= 2");
		pl("a: " + (a/=2));
		pl();
		
		pl("str1 = str1 = str2");
		str1 = str1+str2;
		pl("str1: " + str1);
		pl("str2: " + str2);
		pl("---------------------------------------------------------------------");
		pl("ARITHMETIC OPERATORS:");
		pl("---------------------------------------------------------------------");
		pl("ADD:                         +");
		pl("SUBTRACT:                    -");
		pl("MULTIPLY:                    *");
		pl("DIVIDE:                      /");
		pl("MODULUS:                     %");
		pl();
	
		pl("a: " + a);
		pl("b: " + b);
		pl("c: " + c);
		pl("a + b: " + (a+b));
		pl("a - b: " + (a-b));
		pl("a * b: " + (a*b));
		pl("a / b: " + (a/b));
		pl("a % b: " + (a%b));
		pl("---------------------------------------------------------------------");
		pl();
		
		pl("---------------------------------------------------------------------");
		pl("BITWISE OPERATORS:");
		pl("---------------------------------------------------------------------");
		pl("BITWISE UNARY NOT:                                ~");
		pl("BITWISE AND:                                      &");
		pl("BITWISE OR:                                       |");
		pl("BITWISE EXCLUSIVE OR:                             ^");
		pl("BITWISE SHIFT RIGHT:                             >>");
		pl("BITWISE SHIFT RIGHT ZERO FILL:                  >>>");
		pl("BITWISE SHIFT LEFT:                              <<");
		pl("BITWISE AND ASSIGNMENT:                          &=");
		pl("BITWISE OR ASSIGNMENT:                           |=");
		pl("BITWISE SHIFT RIGHT ASSIGNMENT:                 >>=");
		pl("BITWISE SHIFT RIGHT ZERO FILL ASSIGNMENT: 	  >>>=&");
		pl("BITWISE SHIFT LEFT ASSIGNMENT:            		<<=");
		pl();
		
		pl("a: "+a+" in binary: "+byteToBin((byte)a));
		pl("b: "+b+" in binary: "+byteToBin((byte)b));
		pl("c: "+c+" in binary: "+byteToBin((byte)c));
		pl();
		pl("~a: "+a+" in binary: "+byteToBin((byte)~a));
		pl();
		pl("    a: in binary: "+byteToBin((byte)a));
		pl("    b: in binary: "+byteToBin((byte)b));
		pl("a & b: in binary: "+byteToBin((byte)(a&b)));
		pl();
		pl("    a: in binary: "+byteToBin((byte)a));
		pl("    c: in binary: "+byteToBin((byte)c));
		pl("a | c: in binary: "+byteToBin((byte)(a|c)));
		pl();
		pl("    a: in binary: "+byteToBin((byte)a));
		pl("    c: in binary: "+byteToBin((byte)c));
		pl("a ^ c: in binary: "+byteToBin((byte)(a^c)));
		pl();
		a = -8;
		pl("       a: in binary: "+byteToBin((byte)a)		    + " in decimal: " + a);
		pl("    a>>1: in binary: "+byteToBin((byte)(a>>1))		+ " in decimal: " + (a>>1));
		pl();
		pl("        a: in binary: "+byteToBin((byte)a)		    + " in decimal: " + a);
		pl("    a>>>2: in binary: "+byteToBin((byte)(a>>>2))    + " in decimal: " + (byte)(a>>>2));
		pl();
		pl("       a: in binary: "+byteToBin((byte)a)		    + " in decimal: " + a);
		pl("    a>>1: in binary: "+byteToBin((byte)(a>>1))		+ " in decimal: " + (a>>1));
		pl();
		pl("       b: in binary: "+byteToBin((byte)b)		    + " in decimal: " + b);
		pl("    b<<1: in binary: "+byteToBin((byte)(b<<1))		+ " in decimal: " + (b<<1));
		pl();
		
		pl("---------------------------------------------------------------------");
		pl("RELATIONAL OPERATORS: results in TRUE or FALSE");
		pl("---------------------------------------------------------------------");
		pl("EQUAL TO:                          ==");
		pl("NOT EQUAL TO:                      !=");
		pl("GREATER THAN:                       >");
		pl("LESS THAN:                          <");
		pl("GREATER THAN OR EQUAL TO:          >=");
		pl("LESS THAN OR EQUAL TO:             <=");
		pl();
		a = 50;
		pl("a: " + a);
		pl("b: " + b);
		pl("c: " + c);
		pl("a==b (result:"+(a==b)+")");
		pl("a==c (result:"+(a==c)+")");
		pl("a>b (result:"+(a>b)+")");
		pl("a<c (result:"+(a<c)+")");
		pl("a>=b (result:"+(a>=b)+")");
		pl("a!=c (result:"+(a!=c)+")");
		pl();
		pl("---------------------------------------------------------------------");
		pl("BOOLEAN LOGICAL OPERATORS");
		pl("---------------------------------------------------------------------");
		pl("LOGICAL AND:                        &");
		pl("LOGICAL OR:                         |");
		pl("LOGICAL XOR:                        ^");
		pl("SHORT-CIRCUIT OR:                  ||");
		pl("SHORT-CIRCUIT AND:                 &&");
		pl("LOGICAL UNARY NOT:                  !");
		pl("AND ASSIGNMENT:                    &=");
		pl("OR ASSIGNMENT:                     |=");
		pl("XOR ASSIGNMENT:                    ^=");
		pl("EQUAL TO:                          ==");
		pl("NOT EQUAL TO:                      !=");
		pl("TENARY IF-THEN-ELSE:               ?;");
		pl();
		/*
		 * TRUTH TABLES
		 * -------------------------------------------------------------------
		 * A		B		A & B	A | B	A ^ B
		 * TRUE		TRUE	TRUE	TRUE	FALSE
		 * TRUE		FLASE	FALSE	TRUE	TRUE
		 * FALSE	TRUE	FALSE	TRUE	TRUE
		 * FALSE	FALSE	FALSE	FALSE	FALSE
		 * 1		1		1		1		0
		 * 1		0		0		1		1
		 * 0		1		0		1		1
		 * 0		0		0		0		0
		 * -------------------------------------------------------------------
		 * A			!A
		 * TRUE			FALSE
		 * FLASE		TRUE
		 * 
		 * 
		 */
		pl("a: " + a);
		pl("b: " + b);
		pl("c: " + c);
		pl("(a>b) && (a>c) (result:"+((a>b) && (a>c))+")");
		pl("(a>b) && (a==c) (result:"+((a>b) && (a==c))+")");
		pl("(a!=b) || (a<c) (result:"+((a!=b) || (a<c))+")");
		pl("(a==b) || (a==c) (result:"+((a==b) || (a==c))+")");
		pl("(a==b) ? \"wow\":\"oh,my\" (result:"+((a==b)?"wow":"oh,my") +")");
		
		for (byte i = -128; i<=126; i++) {
			pl(String.format("%4d", i)+" = "+byteToBin(i));
		}
		pl(String.format("%4d", 127)+" = "+byteToBin((byte)127));
		pl();
		for(int i =-10; i<=10;i++) {
			pl(String.format("%4d", i)+" = "+intToBin(i));
		}
		pl();
		
		pl("2 raise to 0 = " + String.format("%4d", power(2,0)));
		pl("2 raise to 1 = " + String.format("%4d", power(2,1)));
		pl("2 raise to 2 = " + String.format("%4d", power(2,2)));
		pl("2 raise to 3 = " + String.format("%4d", power(2,3)));
		pl("2 raise to 4 = " + String.format("%4d", power(2,4)));
		pl("2 raise to 5 = " + String.format("%4d", power(2,5)));
		pl("2 raise to 6 = " + String.format("%4d", power(2,6)));
		pl("2 raise to 8 = " + String.format("%4d", power(2,8)));
		pl("2 raise to 9 = " + String.format("%4d", power(2,9)));
		pl("2 raise to 10 = " + String.format("%4d", power(2,10)));
		pl();
		
		for (int i=0;i<=16;i++) {
			pl("16 raise to "+String.format("%2d", i)+" = "+
				String.format("%1.1f", //using the comma flag
				power((double)16,i)) );
		}
		
		
		
		
	}
	
	// short-hand print method
	// !!! adds execution ahead !!!
	public static void p(String message) {
		System.out.print(message);
	}
	
	// short-hand print line method
	// !!! adds execution ahead !!!
	public static void pl(String message) {
		System.out.println(message);
	}
	
	// short-hand empty print line method
	// !!! adds execution ahead !!!
	public static void pl() {
		System.out.println();
	}
	
	// int to binary string method
	public static String intToBin(int i) {
		int mask = 0x80000000;
		String result = "";
		String temp;
		
		while(mask!=0) {
			if((i & mask) != 0) {
				result+="1";
			} else {
				result+="0";
			}
			// debug
			//temp = Integer.toString(mask);
			//pl(temp);
			
			mask >>>= 1;
		}
		return result;
	}
	
	// byte to binary string method
	public static String byteToBin(byte i) {
		int mask = 0x80;
		String result = "";
		String temp;
		
		while(mask!=0) {
			if((i & mask) != 0) {
				result+="1";
			} else {
				result+="0";
			}
			// debug
			//temp = Integer.toString(mask);
			//pl(temp);
			
			mask >>>= 1;
		}
		return result;
	}
	
	// overloaded power method - returns int
	public static int power(int base, int exponent) {
		int result = 1;
		
		// if exponent is less than or equal to zero just return with 1
		if (exponent <=0 ) return 1;
		
		// multiply result with base from 1 to exponent times
		for(int i = 1; i<=exponent; i++) {
			result *= base;
		}
		return result;
	}
	
	// overloaded power method - returns long
	public static long power(long base, int exponent) {
		long result = 1;
		
		// if exponent is less than or equal to zero just return with 1
		if (exponent <=0 ) return 1;
		
		// multiply result with base from 1 to exponent times
		for(int i = 1; i<=exponent; i++) {
			result *= base;
		}
		return result;
	}
	
	// overloaded power method - returns double
	public static double power(double base, int exponent) {
		double result = 1;
		
		// if exponent is less than or equal to zero just return with 1
		if (exponent <=0 ) return 1;
		
		// multiply result with base from 1 to exponent times
		for(int i = 1; i<=exponent; i++) {
			result *= base;
		}
		return result;
	}
}
