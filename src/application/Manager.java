package application;

public class Manager extends Person{
	
	public String DOB;
	public int rating;
	
	
	/**
	 * 
	 * @return the DOB of the manager 
	 */
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	/**
	 * 
	 * @return the managers rating 
	 */
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	@Override
	public String toString() {
		return "Manager [DOB=" + DOB + ", rating=" + rating + "]";
	} 
	
	

}
