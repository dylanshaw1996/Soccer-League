package application;

public class Name {
	
	public String firstname;
	public String middlename;
	public String lastname;
	
	
	/**
	 * 
	 * @return the first name of the person 
	 */
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * 
	 * @return the middle name of the person 
	 */
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	/**
	 * 
	 * @return the last name of the person 
	 */
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Name [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + "]";
	}

}
