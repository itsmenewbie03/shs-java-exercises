/********************************************************************
 * PROBLEM:   Demo program using Java Primitive Data Types
 * 
 * AUTHOR:    Salvador, 1 M. Ligayao
 * DATE:      5/3/2021
 * VERSION:   1.0
 *
 *******************************************************************/
public class Main {

	public static void main(String[] args) {
		//declare variables
		byte abyte;
		short ashort;
		int anint;
		long along;
		float afloat;
		double adouble;
		char achar;
		boolean aboolean;
		
		//byte
		abyte = Byte.MAX_VALUE;
		System.out.println("BYTE data type");
		System.out.println("Min Value: " + Byte.MIN_VALUE);
		System.out.println("Max Value: " + abyte);
		// shows what will happen when an overflow occurs
		// note the wrap-around of the value
		abyte = (byte) (abyte+1);
		System.out.println(abyte);
		
		System.out.println("===================================");
		
		//Short
		ashort = Short.MAX_VALUE;
		System.out.println("SHORT data type");
		System.out.println("Min Value: " + Short.MIN_VALUE);
		System.out.println("Max Value: " + ashort);
		
		System.out.println("===================================");
		
		//Int
		anint = Integer.MAX_VALUE;
		System.out.println("INT data type");
		System.out.println("Min Value: " + Integer.MIN_VALUE);
		System.out.println("Max Value: " + anint);
		
		System.out.println("===================================");
		
		//Long
		along = Long.MAX_VALUE;
		System.out.println("LONG data type");
		System.out.println("Min Value: " + Long.MIN_VALUE);
		System.out.println("Max Value: " + along);
		
		System.out.println("===================================");
		
		//Float
		afloat = Float.MAX_VALUE;
		System.out.println("FLOAT data type");
		System.out.println("Min Value: " + Float.MIN_VALUE);
		System.out.println("Max Value: " + afloat);
		
		System.out.println("===================================");
		
		//Double
		adouble = Double.MAX_VALUE;
		System.out.println("DOUBLE data type");
		System.out.println("Min Value: " + Double.MIN_VALUE);
		System.out.println("Max Value: " + adouble);
		
		System.out.println("===================================");
		
		//Char
		achar = Character.MAX_VALUE;
		System.out.println("CHARACTER data type");
		System.out.println("Min Value: " + ((int)Character.MIN_VALUE));
		System.out.println("Max Value: " + ((int)achar));
		
		System.out.println("===================================");
		
		//Boolean
		aboolean = Boolean.TRUE;
		System.out.println("BOOLEAN data type");
		System.out.println("Min Value: "+Boolean.FALSE);
		System.out.println("Max Value: "+ aboolean);
	}

}
