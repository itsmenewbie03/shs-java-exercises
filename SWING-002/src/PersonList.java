import java.util.ArrayList;

public class PersonList {
	private ArrayList<Person> persons;
	
	protected boolean validIndex(int index) {
		return ((index>=0) && (index<this.count()));
	}
	
	public PersonList() {
		this.persons = new ArrayList<Person>();
	}
	
	public void add(Person person) {
		this.persons.add(person);
	}
	
	public void add(String first, String middle, String last) {
		this.persons.add(new Person(first, middle, last));
	}
	
	public Person get(int index) {
		Person result = null;
		if(validIndex(index)) {
			result = this.persons.get(index);
		}
		return result;
	}
	
	public boolean delete(int index) {
		boolean result = false;
		if(validIndex(index)) {
			this.persons.remove(index);
		}
		return result;
	}
	
	public int count() {
		return this.persons.size();
	}
	
	public ArrayList<Person> getPersons(){
		return persons;
	}
	
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "PersonList [persons=" + persons + "]";
	}
	
	public String[][] toStrLines(){
		String[][] result = new String[this.count()][];
		 int index = 0;
		 for(Person person:this.persons) {
			 result[index++] = person.toStrLines();
		 }
		 return result;
	}
	
}
