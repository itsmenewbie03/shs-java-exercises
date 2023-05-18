/********************************************************************
 * 	PROBLEM:	Create a Person and a Date Class in Java.
 * 				Add enumerations as necessary to make the classes
 * 				robust
 *  
 *  AUTHOR:		Salvador, 1 M. Ligayao
 *  DATE:		5/17/2021
 *  VERSION: 	1.0
 *  
 *  PROJECT:	P004-Person_Class
 *
 ********************************************************************/
public class Main {

	public static void main(String[] args) {
		Person person = new Person("Juan", "de la", "Cruz", Sex.MALE);
		person.setDob(new Date( (byte)14, (byte)2, 1972) );
		System.out.println("Name: " + person);
		System.out.println("DOB: " + person.getDob());
		System.out.println("Sex: " + person.getSex());
		System.out.println("Age: " + person.getDob().yearsFrom(new Date( 17, 5, 2021) ) );
		System.out.println("Bloodtype: " + person.getBloodtype());
		System.out.println("Height(cm): " + person.getWeight());
		System.out.println("Weight(kg): " + person.getWeight());
		
		Date date = new Date(25,5,2000);
		System.out.println(date.daysFrom(new Date(31,5,2000)));
		System.out.println(date.daysFrom(new Date(25,6,2000)));
		System.out.println(date.monthsFrom(new Date(25,9,2001)));
		
	}

}