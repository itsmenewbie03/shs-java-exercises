import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class PersonFile {
	private static final String DATAFILE = "persons.txt";
	private File infile, outfile;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public PersonFile() throws IOException{
		infile = new File(DATAFILE);
		outfile = new File(DATAFILE);
		
		if(!infile.exists()) {
			infile.createNewFile();
		}
	}
	
	public boolean load(PersonList persons) {
		boolean result = false;
		String line = "";
		Person person;
		
		boolean start_of_data = false;
		
		try {
			reader = new BufferedReader(new FileReader(infile));
			do {
				line = reader.readLine();
				if (line!=null) {
					start_of_data = line.contains("[PERSON]");
					if(start_of_data) {
						person = new Person();
						
						person.setFirst(reader.readLine());
						person.setMiddle(reader.readLine());
						person.setLast(reader.readLine());
						person.setDob(LocalDate.parse(reader.readLine()));
						person.setSex(Sex.valueOf(reader.readLine()));
						
						persons.add(person);
					}
				}
			} while(line!=null);
		} catch(IOException e) {
			System.out.println("Error reader data. Records read: " + persons.count());
			result = false;
		}
		result = persons.count()>0;
		System.out.println("Records read: " + persons.count());
		
		return result;
	}
	
	public boolean save(PersonList persons) {
		boolean result = false;
		int count = 0;
		String[] lines;
		String no_mod = "";
		try {
			writer = new BufferedWriter(new FileWriter(outfile));
			
			for(Person person:persons.getPersons()) {
				lines = person.toStrLines();
				for(int i = 0; i<lines.length;i++) {
					writer.write(lines[i]+"\n");
				};
				no_mod = String.format("%08d", (count + 1))+"**** DO NOT MODIFY I WILL KILL YOU **** \n";
				writer.write(no_mod);
				
				count++;
			}
			writer.close();
		} catch(IOException e) {
			System.out.println("Error reader data. Records read: " + persons.count());
			result = false;
		}
		result = persons.count()>0;
		System.out.println("Records read: " + persons.count());
		
		return result;
	}
}
