/********************************************************************
 * 	PROBLEM:	Simple user-defined DATE class
 *  
 *  AUTHOR:		Salvador, 1 M. Ligayao
 *  DATE:		5/17/2021
 *  VERSION: 	1.0
 *  
 *  PROJECT:	P004-Person_Class
 *
 ********************************************************************/
public class Date {
	// attributes or properties
	private byte month, day;
	private int year;
	
	// days each month
	@SuppressWarnings("unused")
	private static final int MONTH_DAYS[] = {31, 28, 31, 30, 31, 31, 30 , 31, 30, 31};
	
	@SuppressWarnings("unused")
	private static final String MONTH_NAMES[][] = {
			{"January", "JAN"},
			{"February", "FEB"},
			{"March", "MAR"},
			{"April", "APR"},
			{"May", "MAY"},
			{"June", "JUN"},
			{"July", "JUL"},
			{"August", "AUG"},
			{"September", "SEP"},
			{"October", "OCT"},
			{"November", "NOV"},
			{"December", "DEC"}		
	};
	// methods
	
	// constructor
	Date(){
		this.month = 1;
		this.day = 1;
		this.year = 1980;
	}
	
	Date(byte day, byte month, int year){
		this.month = month;
		this.day = day;
		this.year = year;
	}
	Date(int day, int month, int year){
		this.month = (byte)month;
		this.day = (byte)day;
		this.year = year;
	}
	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		if((month>0) && (month<=12) ) {
			this.month = month;
		}
	}

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		if((day>0) && (day<=31)){
			this.day = day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	// count years
	public double yearsFrom(Date date) {
		return date.getYear() -  this.year;
	}
	//count months
	public double monthsFrom(Date date) {
		double years =  yearsFrom(date);
		int months = date.getMonth()-this.month;
		return months+(years*12);
	}
	// count days
	public double daysFrom(Date date) {
		double months =  monthsFrom(date);
		return (months*30)+(date.getDay()-this.day);
	}
	
	@Override
	public String toString() {
		return this.day + "-" + this.month + "-" + this.year;
	}
	
}
