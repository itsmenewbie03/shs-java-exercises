import java.time.LocalDate;

public class Person {
	private String first, middle, last;
	private LocalDate dob;
	private Sex sex;
	
	protected boolean validName(String value) {
		return ((value!=null) && (value.trim().length()>0));
	}
	
	public Person() {
		super();
		
		this.first = "No First";
		this.middle = "No Middle";
		this.last = "No Last";
		
		this.dob = LocalDate.now();
		this.sex = Sex.UNKNOWN;
	}

	public Person(String first, String middle, String last) {
		super();
		setFirst(first);
		setMiddle(middle);
		setLast(last);
		
		this.dob = LocalDate.now();
		this.sex = sex.UNKNOWN;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		if(validName(first)) {
			this.first = first;
		} else this.first = "No First";
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		if(validName(middle)) {
			this.middle = middle;
		} else this.middle = "No Middle";
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		if(validName(last)) {
			this.last = last;
		} else this.last = "No Last";
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [first=" + first + ", middle=" + middle + ", last=" + last + ", dob=" + dob + ", sex=" + sex
				+ "]";
	}
	
	public String[] toStrLines() {
		String[] result = {
				"[PERSON]",
				this.first,
				this.middle,
				this.last,
				this.dob.getYear()+"-"+
				String.format("%02d", this.dob.getMonthValue())+"-"+
				String.format("%02d", this.dob.getDayOfMonth()),
				this.sex.toString(),
				"[END]",
		};
		return result;
	}
}
