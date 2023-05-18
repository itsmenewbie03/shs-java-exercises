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
public class Person {
	// attributes
	private String firstname, middlename, lastname;
	private Date dob;
	private float height, weight;
	private Sex sex;
	private Bloodtype bloodtype;
	
	// constructors
	public Person() {
		super();
		this.firstname = "No First";
		this.middlename = "No Middle";
		this.lastname = "No Last";
		this.sex = Sex.UNKNOWN;
		this.dob = new Date();
		this.bloodtype = Bloodtype.UNKNOWN;
		this.height = 0;
		this.weight = 0;
	}
	
	public Person(
			String firstname,
			String middlename,
			String lastname,
			Sex sex)
	{
		super();
		//enforce no blank names
		if(firstname.trim().length()>0)
			this.firstname = firstname;
		else
			this.firstname = "No First";
		
		if(middlename.trim().length()>0)
			this.middlename = middlename;
		else
			this.middlename = "No Middle";
		
		if(lastname.trim().length()>0)
			this.lastname = lastname;
		else
			this.lastname = "No Last";
		
		this.sex = sex;
		this.dob = new Date();
		this.bloodtype = Bloodtype.UNKNOWN;
		this.height = 0;
		this.weight = 0;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		if(firstname.trim().length()>0) this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		if(middlename.trim().length()>0) this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		if(lastname.trim().length()>0) this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		if(height>0) this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		if(weight>0) this.weight = weight;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Bloodtype getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(Bloodtype bloodtype) {
		this.bloodtype = bloodtype;
	}

	@Override
	public String toString() {
		return this.lastname + ", " + this.firstname + " " + this.middlename.toUpperCase().charAt(0)+".";
	}
	
	
}
