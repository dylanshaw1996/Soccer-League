package application;
public class Person extends Name{
	
	public Name name;
	public String phone; 
	public String email;
	
	/**
	 * 
	 * @return the name of the person
	 */
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	/**
	 * 
	 * @return the persons phone number 
	 */
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 
	 * @return the persons email  
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	

}
