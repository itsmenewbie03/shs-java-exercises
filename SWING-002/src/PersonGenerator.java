import java.time.LocalDate;
import java.util.Random;

public class PersonGenerator {
	private Random rand;
	private static String[][] firstnames = {
			{"Ashley","f"}, {"Norman","m"}, {"Shane","f"},
			{"Vilma","f"}, {"Tom","m"}, {"Sheila","f"},
			{"Angel","f"}, {"Steve","m"}, {"Jane","f"},
			{"John","m"}, {"Mark","m"}, {"Zaira","f"},
			{"Rowie","m"}, {"Rico","m"}, {"Rica","f"},
			{"Jay","m"}, {"Joey","m"}, {"Irene","f"},
			{"Irish","f"}, {"Trisha","f"}, {"Cheryl","f"},
			{"Sharlene","f"}, {"Sarah","f"}, {"Mayrel","f"},
			{"May","f"}, {"Joseph","m"}, {"Christopher","m"},
			{"Venus","f"}, {"Saramie","f"}, {"Judy","f"},
			{"Anne","f"}, {"Michelle","f"}, {"Catherine","f"},
			{"Karl","m"}, {"Charles","m"}, {"George","m"},
			{"Mike","m"}, {"Michael","m"}, {"Princess","f"},
			{"Hans","m"}, {"Jennifer","f"}, {"Sam","m"},
			{"Sandra","f"}, {"Phoebe","f"}, {"Chloe","f"},
			{"Samantha","f"}, {"Megan","f"}, {"William","m"},
	};
	
	private static String[] lastnames = {
			"Merida", "Salana", "Bautista",
			"Dino", "Ligayao", "Pacaldo",
			"Balutic", "Encabo", "Banganan",
			"Cruz", "Santos", "Carejo",
			"Sabanal", "Yandog", "Tocmohan",
			"Dino", "Salilo", "Libres",
			"Racasa", "de los Reyes", "Paglinawan",
			"Doe", "Smith", "Padilla",
			"de Leon", "Villaluz", "Vicente",
			"Salvador", "Quijano", "Tolentino",
			"Chan", "Palacio", "Polanski",
			"Wick", "Herbert", "Asuncion",		
	};
	public PersonGenerator() {
		rand = new Random();
	}
	public Person next() {
		Person person = new Person();
		int[] monthdays = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		int i = rand.nextInt(firstnames.length);
		String first = firstnames[i][0];
		Sex sex = firstnames[i][1].matches("m")? Sex.MALE  : Sex.FEMALE;
		
		person.setFirst(first);
		person.setMiddle(lastnames[rand.nextInt(lastnames.length)]);
		person.setLast(lastnames[rand.nextInt(lastnames.length)]);
		
		person.setSex(sex);
		
		int month = rand.nextInt(12)+1;
		int day = rand.nextInt(monthdays[month-1])+1;
		int year = rand.nextInt(2020-1900)+1900;
		
		try{
			LocalDate dob = LocalDate.of(year, month, month);
			person.setDob(dob);
		} catch(Exception e) {
			System.out.println("Invalid Date: " + year+"-"+month+"-"+day);
			person.setDob(LocalDate.now());
		}
		return person;
	}
}
